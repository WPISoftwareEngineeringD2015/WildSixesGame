package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kiviuq.entities.Board;
import kiviuq.entities.ReleaseBoard;
import kiviuq.entities.Tile;
import kiviuq.entities.TileType;
import kiviuq.views.BoardView;

/**
 * This controller is responsible for implementing "gravity" among the Tiles. It
 * takes a {@link Board} and checks to see if it is in an inconsistent state
 * (Tile values set to 'null') and will "bubble up" the bad Tiles and then
 * ultimately replace them with new ones until the Game is playable again.
 * 
 * @author Evin Ugur
 *
 */
public class GravityController implements ActionListener {
	/** Entity; the game Board */
	Board board;
	/** Boundary; the game Board view */
	BoardView boardView;

	/**
	 * @param board the game Board
	 * @param boardView the game Board view
	 */
	public GravityController(Board board, BoardView boardView) {
		this.board = board;
		this.boardView = boardView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Tile[][] grid = board.getGrid();
		while (board.emptyTilesOnBoard()) {
			for (int x = 0; x < Board.BOARD_LENGTH; x++) {
				for (int y = 0; y < Board.BOARD_WIDTH; y++) {
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
		if (board instanceof ReleaseBoard) {
			new ReleaseTileController(board, boardView).actionPerformed(e);
		}
		boardView.repaint();
	}
}
