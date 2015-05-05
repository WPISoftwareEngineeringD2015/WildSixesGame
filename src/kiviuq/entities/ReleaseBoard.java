package kiviuq.entities;

public class ReleaseBoard extends Board {

	/**
	 * Constructs a new ReleaseBoard from the template.
	 * 
	 * @param template
	 *            the LevelTemplate to pass into {@link Board}'s constructor.
	 */
	protected ReleaseBoard(LevelTemplate template) {
		super(template);
	}

	/**
	 * Checks to see if all Release Tiles are gone from the board.
	 * 
	 * @return true: if all release tiles are gone
	 */
	@Override
	public boolean hasWon() {
		// check to see if there are any release tiles left
		for (Tile[] row : grid)
			for (Tile t : row)
				if (t.getType() == TileType.Release)
					return false;
		return true;
	}

	/**
	 * Resets the grid by changing Number Tiles.
	 */
	@Override
	public void resetGrid() {
		for (int x = 0; x < Board.BOARD_LENGTH; x++) {
			for (int y = 0; y < Board.BOARD_WIDTH; y++) {
				Tile t = this.getGrid()[x][y];
				if (t.getType() == TileType.Number && t.getNumber() != 6) {
					this.getGrid()[x][y] = getNextTile();
				}
			}
		}
	}

}
