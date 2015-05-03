package kiviuq.entities;

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
		eliminatedTiles = new boolean[Board.BOARD_LENGTH][Board.BOARD_WIDTH];
		// set non-number Tiles to already be considered for Elimination
		resetEliminated();
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

	/**
	 * Sets all Tiles to be un-eliminated. <i>Technically, Non-number Tiles
	 * (such as {@link TileType#Null}) are counted as eliminated.</i>
	 */
	public void resetEliminated() {
		for (int x = 0; x < Board.BOARD_LENGTH; x++) {
			for (int y = 0; y < Board.BOARD_WIDTH; y++) {
				this.eliminatedTiles[x][y] = grid[x][y].getType() != TileType.Number;
			}
		}
	}

	/**
	 * Behaves exactly like {@link Board#resetBoard()} but also calls
	 * {@link #resetEliminated()}
	 */
	@Override
	public void resetBoard() {
		resetEliminated();
		super.resetBoard();
	}

}
