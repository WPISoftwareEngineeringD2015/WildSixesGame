package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kiviuq.entities.Board;
import kiviuq.entities.Tile;
import kiviuq.entities.TileType;
import kiviuq.util.Constants;
import kiviuq.views.BoardView;

public class ReleaseTileController implements ActionListener{

	Board board;
	BoardView boardView;
	
	public ReleaseTileController(Board board, BoardView boardView) {
		this.board = board;
		this.boardView = boardView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Tile[][] grid = board.getGrid();
		boolean gridChanged = false;
		for (int x = 0; x < Constants.BOARD_LENGTH; x++) {
			for (int y = 0; y < Constants.BOARD_WIDTH; y++) {
				Tile current = grid[x][y];
				if (current.isBlock() && x < grid.length - 1) {
					Tile below = grid[x+1][y];
					if (below.getType() == TileType.Release) {
						gridChanged = true;
						grid[x][y] = null;
						grid[x+1][y] = new Tile(TileType.Null);
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
