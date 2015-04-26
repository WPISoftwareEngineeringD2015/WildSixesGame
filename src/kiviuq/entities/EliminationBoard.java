package kiviuq.entities;

import kiviuq.util.Constants;

public class EliminationBoard extends Board{

	boolean[][] eliminatedTiles;
	
	protected EliminationBoard(LevelTemplate template) {
		super(template);
		eliminatedTiles = new boolean[Constants.BOARD_LENGTH][Constants.BOARD_WIDTH];
		// set non-number Tiles to already be considered for Elimination
		for (int x = 0; x < Constants.BOARD_LENGTH; x++) 
			for (int y = 0; y < Constants.BOARD_WIDTH; y++)
				eliminatedTiles[x][y] = grid[x][y].getType() != TileType.Number;
	}
	
	@Override
	public boolean hasWon() {
		for (boolean[] row: eliminatedTiles) {
			for (boolean b : row) {
				if (!b) { return false; }
			}
		}
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
	
	public void resetEliminated() {
		for (int x = 0; x <= 8; x++) {
			for (int y = 0; y <= 8; y++) {
				this.eliminatedTiles[x][y] = false;
			}
		}
	}
	
	@Override
	public void resetBoard() {
		resetEliminated();
		super.resetBoard();
	}
	
}
