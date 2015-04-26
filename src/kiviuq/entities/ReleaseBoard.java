package kiviuq.entities;

public class ReleaseBoard extends Board{
	
	protected ReleaseBoard(LevelTemplate template) {
		super(template);
	}

	@Override
	public boolean hasWon() {
		for (Tile[] row: grid)
			for (Tile t : row)
				if (t.type == TileType.Release) {
					return false;
				}
		return true;
	}
}
