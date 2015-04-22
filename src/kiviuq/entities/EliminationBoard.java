package kiviuq.entities;

import kiviuq.util.Constants;

public class EliminationBoard extends Board{

	boolean[][] eliminatedTiles;
	
	protected EliminationBoard(LevelTemplate template) {
		super(template);
		eliminatedTiles = new boolean[Constants.BOARD_LENGTH][Constants.BOARD_WIDTH];
	}
	
	@Override
	public boolean hasWon() {
		for (boolean[] row: eliminatedTiles)
			for (boolean b : row)
				if (!b) return false;
		return true;
	}
	
	@Override 
	public void removeTile(int x, int y) {
		super.removeTile(x, y);
		eliminatedTiles[x][y] = true;
	}
	
	public boolean[][] getEliminatedTiles() {
		return eliminatedTiles;
	}
	
}
