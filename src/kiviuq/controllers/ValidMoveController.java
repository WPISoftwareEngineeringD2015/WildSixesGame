package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import kiviuq.entities.Board;
import kiviuq.entities.Tile;
import kiviuq.views.LevelScreen;

public class ValidMoveController extends AbstractMoveController{
	
	public ValidMoveController(Board board, LevelScreen levelScreen) {
		super(board, levelScreen);
	}

	@Override
	public boolean handleMove(ActionEvent e) {
		int count = 0;
		List<Integer> multipliers = new ArrayList<Integer>();
		Tile[][] grid = board.getGrid();
		for (int x = 0; x < Board.BOARD_LENGTH; x++) {
			for (int y = 0; y < Board.BOARD_WIDTH; y++) {
				if (grid[x][y].isSelected()) {
					multipliers.add(grid[x][y].getMultiplier());
					board.removeTile(x, y);
					count ++;
				}
			}
		}
		int score = 10 * count;
		for (Integer mult : multipliers) score *= mult;
		board.addPoints(score);
		// board is in an inconsistent state with a tile set to 'null'
		new GravityController(board, levelScreen.getBoardView()).actionPerformed(e);
		return true;
	}

}
