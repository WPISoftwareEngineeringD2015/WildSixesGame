package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kiviuq.entities.Board;
import kiviuq.entities.Tile;
import kiviuq.entities.TileType;
import kiviuq.views.BoardView;

/**
 * Controller to see if there are any Block Tiles above a Release Tile and to
 * make them drop to return the game back into a consistent discrete state.
 * 
 * @author Evin Ugur
 *
 */
public class ReleaseTileController implements ActionListener {

	/** Current instance of the game */
	Board board;
	/** Current instance of the game view */
	BoardView boardView;

	public ReleaseTileController(Board board, BoardView boardView) {
		this.board = board;
		this.boardView = boardView;
	}

	/**
	 * Iterate through the grid and if there any 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Tile[][] grid = board.getGrid();
		boolean gridChanged = false;
		for (int x = 0; x < Board.BOARD_LENGTH; x++) {
			for (int y = 0; y < Board.BOARD_WIDTH; y++) {
				Tile current = grid[x][y];
				if (current.isBlock() && x < grid.length - 1) {
					Tile below = grid[x + 1][y];
					if (below.getType() == TileType.Release) {
						gridChanged = true;
						grid[x][y] = null;
						grid[x + 1][y] = new Tile(TileType.Null);
					}
				}
			}
		}
		if (gridChanged) {
			board.setGrid(grid);
			// apply gravity
			new GravityController(board, boardView).actionPerformed(e);
		}
	}

}
