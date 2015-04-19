package kiviuq.entities;

import java.util.Random;

import kiviuq.util.Constants;

public class Board {
	LevelTemplate template;
	Tile[][] grid;
	boolean[][] eliminatedTiles;
	int movesMade;
	int timePassed; 
	int points;
	StarCriteria starCriteira; 
	public Board(LevelTemplate template) {
		this.setTemplate(template);
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
		// insertNullsForTesting(); 
	}
	
	@SuppressWarnings("unused") // TODO delete this when we are confident we don't need it anymore
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
	
	public void addPoints(int points) {
		this.points += points;
	}
	
	public void resetPoints() {
		points = 0;	
	}
	
	
	public StarCriteria getStarCriteria() {
		return starCriteira;
	}
	
	public Tile[][] getGrid() {
		return grid;
	}
	
	public void setGrid(Tile[][] grid) {
		this.grid = grid;
	}
	
	
	public boolean[][] getEliminatedTiles() {
		return eliminatedTiles;
	}
	
	public void increaseTimePassed() {
		// TODO 
	}
	
	public int getMovesMade() {
		return movesMade;
	}
	
	public void increaseMovesMade() {
		movesMade++;
	}
	
	public boolean emptyTilesOnBoard() {
		for (Tile[] r : grid) 
			for (Tile t : r) if (t == null) return true;
		return false;
	}
	
	public Tile getNextTile() {
		// TODO implement this with an actual randomly weighted tile
		return new Tile(Math.random() > 0.5 ? 1 : 2);
		// for now just give us a Tile valued 1 or 2
	}

	public LevelTemplate getTemplate() {
		return template;
	}

	public void setTemplate(LevelTemplate template) {
		this.template = template;
	}
	
	
}
