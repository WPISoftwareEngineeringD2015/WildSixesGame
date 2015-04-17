package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kiviuq.entities.Board;
import kiviuq.entities.Tile;
import kiviuq.entities.TileType;
import kiviuq.util.Constants;
import kiviuq.views.BoardView;

public class RemoveTileController implements ActionListener{
	Board board;
	Tile tileToBeRemoved;
	BoardView boardView;
	
	public RemoveTileController(Board board, Tile tileToBeRemoved, BoardView boardView) {
		this.board = board;
		this.tileToBeRemoved = tileToBeRemoved;
		this.boardView = boardView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (tileToBeRemoved.getType() != TileType.Number) return;
		Tile[][] grid = board.getGrid();
		boolean stopLooping = false;
		for (int x = 0; x < Constants.BOARD_LENGTH; x++) {
			for (int y = 0; y < Constants.BOARD_WIDTH; y++) {
				Tile t = grid[x][y];
				if (t == tileToBeRemoved) {
					grid[x][y] = null;
					stopLooping = true;
					break;
				}
			}
			if (stopLooping) break;
		}
		board.setGrid(grid);
		// board is in an inconsistent state with a tile set to 'null'
		new GravityController(board, boardView).actionPerformed(e); 
	}

}
