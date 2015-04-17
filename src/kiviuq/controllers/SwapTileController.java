package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kiviuq.entities.Board;
import kiviuq.entities.Tile;
import kiviuq.entities.TileType;
import kiviuq.util.Constants;
import kiviuq.views.BoardView;

public class SwapTileController implements ActionListener {
	Tile a, b;
	Board board;
	BoardView boardView;

	public SwapTileController(Tile a, Tile b, Board board, BoardView boardView) {
		this.a = a;
		this.b = b;
		this.board = board;
		this.boardView = boardView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (a.getType() != TileType.Number || b.getType() != TileType.Number)
			return;
		// find x,y position of a
		Tile[][] grid = board.getGrid();
		int ax = -1, ay = -1; // position of a
		for (int x = 0; x < Constants.BOARD_LENGTH; x++) {
			for (int y = 0; y < Constants.BOARD_WIDTH; y++) {
				if (grid[x][y] == a) {
					ax = x;
					ay = y;
					break;
				}
			}
			if (ax > 0)
				break;
		}
		if (ax < 0)
			return; // A isn't in the grid!
		boolean nextTo = false;
		for (int x = ax - 1; x < ax + 1; x++) {
			for (int y = ay - 1; y < ay + 1; y++) {
				if (ax >= 0 && ay >= 0 && ax < Constants.BOARD_LENGTH
						&& ay < Constants.BOARD_WIDTH) {
					Tile possibleB = grid[ax][ay];
					if (possibleB == b) {
						nextTo = true;
						grid[x][y] = a;
						grid[ax][ay] = b;
						break;
					}
				}
			}
			if (nextTo)
				break;
		}
		board.setGrid(grid);
		boardView.repaint();
	}

}
