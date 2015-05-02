package kiviuq.entities;

import kiviuq.util.Constants;

public class ReleaseBoard extends Board {

	protected ReleaseBoard(LevelTemplate template) {
		super(template);
	}

	@Override
	public boolean hasWon() {
		// check to see if there are any release tiles left
		for (Tile[] row : grid)
			for (Tile t : row)
				if (t.getType() == TileType.Release)
					return false;
		return true;
	}
	
	@Override
	public void resetGrid() {
		for (int x = 0; x < Constants.BOARD_LENGTH; x++) {
			for (int y = 0; y < Constants.BOARD_WIDTH; y++) {
				Tile t = this.getGrid()[x][y];
				if (t.getType() == TileType.Number && t.getNumber() != 6) {
					this.getGrid()[x][y] = getNextTile();
				}
			}
		}
	}
	
}
