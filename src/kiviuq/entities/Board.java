package kiviuq.entities;

import java.util.Random;

import kiviuq.util.Constants;

public class Board {
	Tile[][] grid;
	boolean[][] eliminatedTiles;
	int movesMade;
	int timePassed; 
	int points;
	StarCriteria starCriteira; 
	public Board(LevelTemplate template) {
		grid = new Tile[Constants.BOARD_LENGTH][Constants.BOARD_WIDTH];
		eliminatedTiles = new boolean[Constants.BOARD_LENGTH][Constants.BOARD_WIDTH];
		starCriteira = template.getStarCriteria();
		TileType[][] gridTemplate = template.getGridTemplate();
		for (int x = 0; x < Constants.BOARD_LENGTH; x++) {
			for (int y = 0; y < Constants.BOARD_WIDTH; y++) {
				TileType type = gridTemplate[x][y];
				Tile t;
				if (type == TileType.Number) t = getNextTile();
				else t = new Tile(type); // it's a null or release tile
				grid[x][y] = t;
			}
		}
		insertNullsForTesting();
	}
	
	private void insertNullsForTesting() {
		for (int i = 0; i < 3; i++) {
			Random r = new Random();
			int x = r.nextInt(Constants.BOARD_LENGTH);
			int y = r.nextInt(Constants.BOARD_WIDTH);
			grid[x][y] = null;
		}
	}
	
	
	public int getPoints() {
		return points;
	}
	
	public StarCriteria getStarCriteria() {
		return starCriteira;
	}
	
	public Tile[][] getGrid() {
		return grid;
	}
	
	public boolean[][] getEliminatedTiles() {
		return eliminatedTiles;
	}
	
	public void increaseTimePassed() {
		// TODO 
	}
	
	public void increaseMovesMade() {
		movesMade++;
	}
	
	boolean emptyTilesOnBoard() {
		for (Tile[] r : grid) 
			for (Tile t : r) if (t == null) return true;
		return false;
	}
	
	public void gravity() {
		while (emptyTilesOnBoard()) { // keep going until the board is valid
			for (int x = 0; x < Constants.BOARD_LENGTH; x++) {
				for (int y = 0; y < Constants.BOARD_WIDTH; y++) {
					Tile current = grid[x][y];
					if (current == null) {
						// we can bubble up
						if (x > 0) {
							Tile above = grid[x-1][y];
							if (above.type == TileType.Number) {
								grid[x][y] = above;
								grid[x-1][y] = null;
							}
							else {
								// can't move around Nulls or Releases...
								grid[x][y] = getNextTile();
							}
						}
						// we can't, just load a tile
						else {
							grid[x][y] = getNextTile();
						}
					}
				}
			}
		}
	}
	
	
	public Tile getNextTile() {
		// TODO implement this with an actual randomly weighted tile
		return new Tile(Math.random() > 0.5 ? 1 : 2);
		// for now just give us a Tile valued 1 or 2
	}
	
	
}
