package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kiviuq.entities.Board;
import kiviuq.entities.Tile;
import kiviuq.entities.TileType;
import kiviuq.util.Constants;
import kiviuq.views.BoardView;

public class GravityController implements ActionListener {

	Board board;
	BoardView boardView;

	public GravityController(Board board, BoardView boardView) {
		this.board = board;
		this.boardView = boardView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Tile[][] grid = board.getGrid();
		while (board.emptyTilesOnBoard()) {
			for (int x = 0; x < Constants.BOARD_LENGTH; x++) {
				for (int y = 0; y < Constants.BOARD_WIDTH; y++) {
					Tile current = grid[x][y];
					if (current == null) {
						// we can bubble up
						if (x > 0) {
							Tile above = grid[x - 1][y];
							if (above.getType() == TileType.Number) {
								grid[x][y] = above;
								grid[x - 1][y] = null;
							} else {
								// can't move around Nulls or Releases...
								grid[x][y] = board.getNextTile();
							}
						}
						// we can't, just load a tile
						else {
							grid[x][y] = board.getNextTile();
						}
					}
				}
			}
		}
		board.setGrid(grid);
		boardView.repaint();
	}
}
