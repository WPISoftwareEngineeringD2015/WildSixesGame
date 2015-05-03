package kiviuq.controllers;

import java.awt.event.ActionEvent;

import kiviuq.entities.Board;
import kiviuq.entities.Tile;
import kiviuq.entities.TileType;
import kiviuq.views.LevelScreen;

/**
 * Controller for removing a {@link Tile} from a {@link Board}/
 * 
 * @author Evin Ugur
 *
 */
public class RemoveTileController extends AbstractMoveController {
	/** The {@link Tile} that is to be removed */
	Tile tileToBeRemoved;

	/**
	 * @param board
	 *            the Board to be passed into {@link AbstractMoveController}
	 * @param tileToBeRemoved
	 *            the Tile to be removed
	 * @param levelScreen
	 *            the LevelScreen to be passed into
	 *            {@link AbstractMoveController}
	 */
	public RemoveTileController(Board board, Tile tileToBeRemoved,
			LevelScreen levelScreen) {
		super(board, levelScreen);
		this.tileToBeRemoved = tileToBeRemoved;
	}

	/**
	 * Loops through the Board until
	 * {@link RemoveTileController#tileToBeRemoved} is found and then removes
	 * it. If found, this controller will invoke a new instance of a
	 * {@link GravityController} in order to restore the game into the current
	 * state.
	 */
	@Override
	public boolean handleMove(ActionEvent e) {
		if (tileToBeRemoved.getType() != TileType.Number)
			return false;
		Tile[][] grid = board.getGrid();
		boolean stopLooping = false;
		for (int x = 0; x < Board.BOARD_LENGTH; x++) {
			for (int y = 0; y < Board.BOARD_WIDTH; y++) {
				Tile t = grid[x][y];
				if (t == tileToBeRemoved) {
					board.removeTile(x, y);
					stopLooping = true;
					break;
				}
			}
			if (stopLooping)
				break;
		}
		// board is in an inconsistent state with a tile set to 'null'
		new GravityController(board, levelScreen.getBoardView())
				.actionPerformed(e);
		return true;
	}

}
