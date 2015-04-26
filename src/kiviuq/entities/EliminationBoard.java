package kiviuq.entities;

import kiviuq.util.Constants;

public class EliminationBoard extends Board {

	/** Flags for whether or not a given Tile on this Board has been eliminated */
	boolean[][] eliminatedTiles;

	/**
	 * Invokes {@link Board#Board(LevelTemplate)}, and also initializes
	 * {@link #eliminatedTiles}.
	 * 
	 * @param template
	 */
	protected EliminationBoard(LevelTemplate template) {
		super(template);
		eliminatedTiles = new boolean[Constants.BOARD_LENGTH][Constants.BOARD_WIDTH];
		// set non-number Tiles to already be considered for Elimination
		for (int x = 0; x < Constants.BOARD_LENGTH; x++)
			for (int y = 0; y < Constants.BOARD_WIDTH; y++)
				eliminatedTiles[x][y] = grid[x][y].getType() != TileType.Number;
	}

	/**
	 * This implementation of {@link Board#hasWon()} determines if there are any
	 * un-eliminated Tiles on the Board and will report a win/lose accordingly.
	 * 
	 * @return true if all tiles have been 'eliminated'.
	 */
	@Override
	public boolean hasWon() {
		for (boolean[] row : eliminatedTiles)
			for (boolean b : row)
				if (!b)
					return false;
		return true;
	}

	/**
	 * Calls {@link Board#removeTile(int, int)} and also sets a corresponding
	 * boolean flag in {@link EliminationBoard#eliminatedTiles}.
	 */
	@Override
	public void removeTile(int x, int y) {
		super.removeTile(x, y);
		eliminatedTiles[x][y] = true;
	}

	/**
	 * Accessor function for {@link EliminationBoard#eliminatedTiles}.
	 * 
	 * @return a two dimensional boolean array that represents whether or not a
	 *         given Tile has been eliminated.
	 */
	public boolean[][] getEliminatedTiles() {
		return eliminatedTiles;
	}

}
