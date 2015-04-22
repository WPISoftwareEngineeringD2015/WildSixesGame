package kiviuq.controllers;

import java.awt.event.ActionEvent;

import kiviuq.entities.Board;
import kiviuq.entities.Tile;
import kiviuq.entities.TileType;
import kiviuq.util.Constants;
import kiviuq.views.LevelScreen;

public class RemoveTileController extends AbstractMoveController{
	Tile tileToBeRemoved;
	
	public RemoveTileController(Board board, Tile tileToBeRemoved, LevelScreen levelScreen) {
		super(board, levelScreen);
		this.tileToBeRemoved = tileToBeRemoved;
	}

	@Override
	public boolean handleMove(ActionEvent e) {
		if (tileToBeRemoved.getType() != TileType.Number) return false;
		Tile[][] grid = board.getGrid();
		boolean stopLooping = false;
		for (int x = 0; x < Constants.BOARD_LENGTH; x++) {
			for (int y = 0; y < Constants.BOARD_WIDTH; y++) {
				Tile t = grid[x][y];
				if (t == tileToBeRemoved) {
					board.removeTile(x, y);
					stopLooping = true;
					break;
				}
			}
			if (stopLooping) break;
		}
		// board is in an inconsistent state with a tile set to 'null'
		new GravityController(board, levelScreen.getBoardView()).actionPerformed(e);
		return true;
	}

}
