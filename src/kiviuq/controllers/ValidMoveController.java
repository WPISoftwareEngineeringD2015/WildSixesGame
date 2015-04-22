package kiviuq.controllers;

import java.awt.event.ActionEvent;
import kiviuq.entities.Board;
import kiviuq.entities.Tile;
import kiviuq.util.Constants;
import kiviuq.views.LevelScreen;

public class ValidMoveController extends AbstractMoveController{
	
	public ValidMoveController(Board board, LevelScreen levelScreen) {
		super(board, levelScreen);
	}

	@Override
	public boolean handleMove(ActionEvent e) {
		Tile[][] grid = board.getGrid();
		for (int x = 0; x < Constants.BOARD_LENGTH; x++) {
			for (int y = 0; y < Constants.BOARD_WIDTH; y++) {
				if (grid[x][y].isSelected()) {
					board.removeTile(x, y);
				}
			}
		}
		// board is in an inconsistent state with a tile set to 'null'
		new GravityController(board, levelScreen.getBoardView()).actionPerformed(e);
		return true;
	}

}
