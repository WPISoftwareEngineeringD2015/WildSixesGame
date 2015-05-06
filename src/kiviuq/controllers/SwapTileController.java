package kiviuq.controllers;

import java.awt.event.ActionEvent;

import kiviuq.entities.Board;
import kiviuq.entities.Tile;
import kiviuq.entities.TileType;
import kiviuq.views.LevelScreen;

/**
 * This controller can swap two tiles. It is an {@link AbstractMoveController}
 * so common logic will occur after the {@link Tile}s are swapped.
 * 
 * @author Evin Ugur
 */
public class SwapTileController extends AbstractMoveController {
	/** A Tile Object to be switched with b */
	Tile a;
	/** A Tile Object to be switched with a */
	Tile b;

	/**
	 * @param a
	 *            tile to be switched
	 * @param b
	 *            another tile to be switched
	 * @param board
	 *            top level entity
	 * @param levelScreen
	 *            boundary object
	 */
	public SwapTileController(Tile a, Tile b, Board board,
			LevelScreen levelScreen) {
		super(board, levelScreen);
		this.a = a;
		this.b = b;
	}

	/**
	 * Will swap the two tiles if they are valid to be swapped.
	 */
	@Override
	public boolean handleMove(ActionEvent e) {
		if (a.getType() != TileType.Number || b.getType() != TileType.Number)
			return false;
		// find x,y position of a
		Tile[][] grid = board.getGrid();
		int ax = -1, ay = -1; // position of a
		for (int x = 0; x < Board.BOARD_LENGTH; x++) {
			for (int y = 0; y < Board.BOARD_WIDTH; y++) {
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
			return false; // A isn't in the grid!
		boolean nextTo = false;
		for (int x = ax - 1; x < ax + 2; x++) {
			for (int y = ay - 1; y < ay + 2; y++) {
				if (x >= 0 && y >= 0 && x < Board.BOARD_LENGTH
						&& y < Board.BOARD_WIDTH) {
					Tile possibleB = grid[x][y];
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
		return true;
	}
}
