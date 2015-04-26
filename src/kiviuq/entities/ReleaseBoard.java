package kiviuq.entities;

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
}
