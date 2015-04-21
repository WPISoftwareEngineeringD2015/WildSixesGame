package kiviuq.entities;

import java.util.Random;

import kiviuq.util.Constants;

public class Board {
	LevelTemplate template;
	Tile[][] grid;
	boolean[][] eliminatedTiles;
	int movesMade;
	int moveLimit;
	int timePassed;
	int points;
	StarCriteria starCriteira;
	GameMode mode;

	int tileSum;
	int tileCount;
	MoveType moveType = MoveType.Normal;
	
	boolean isMousePressed;
	int lastX = -1;
	int lastY = -1;
	int r1,r2,r3,r4,r5;
	public Board(LevelTemplate template) {
		this.setTemplate(template);
		moveLimit = template.moveLimit;
		mode = template.mode;
		grid = new Tile[Constants.BOARD_LENGTH][Constants.BOARD_WIDTH];
		eliminatedTiles = new boolean[Constants.BOARD_LENGTH][Constants.BOARD_WIDTH];
		starCriteira = template.getStarCriteria();
		TileType[][] gridTemplate = template.getGridTemplate();
		
		int mult = template.probConst;
		r1 = 40 - mult/4;
		r2 = 25 - mult/10;
		r3 = 15 + mult/20;
		r4 = 10 + mult/10;
		r5 = 5 + mult/10;
		
		for (int x = 0; x < Constants.BOARD_LENGTH; x++) {
			for (int y = 0; y < Constants.BOARD_WIDTH; y++) {
				TileType type = gridTemplate[x][y];
				Tile t;
				if (type == TileType.Number)
					t = getNextTile();
				else
					t = new Tile(type); // it's a null or release tile
				grid[x][y] = t;
			}
		}
		// insertNullsForTesting();
	}

	@SuppressWarnings("unused")
	// TODO delete this when we are confident we don't need it anymore
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
		timePassed++;
	}

	public void resetTimePassed() {
		timePassed = 0;
	}

	public int getMovesMade() {
		return movesMade;
	}

	public void increaseMovesMade() {
		movesMade++;
	}

	public void resetMovesMade() {
		movesMade = 0;
	}

	public boolean emptyTilesOnBoard() {
		for (Tile[] r : grid)
			for (Tile t : r)
				if (t == null)
					return true;
		return false;
	}

	public Tile getNextTile() {
		Random x = new Random();
		int result = x.nextInt(99) + 1;
		if(result < r1) {
			return new Tile(1);
		} else if (result <= (r1 + r2)) {
			return new Tile(2);
		} else if (result <= (r1 + r2 + r3)) {
			return new Tile(3);
		} else if (result <= (r1 + r2 + r3 + r4)) {
			return new Tile(4);
		} else if (result <= (r1 + r2+ r3 + r4 + r5)) {
			return new Tile(5);
		} else if(mode == GameMode.Release) {
			return new Tile(1);
		} else {
			return new Tile(6);
	}
		
		
	//	return new Tile(Math.random() > 0.5 ? 1 : 2);
		// for now just give us a Tile valued 1 or 2
	}

	public LevelTemplate getTemplate() {
		return template;
	}

	public void setTemplate(LevelTemplate template) {
		this.template = template;
	}

	public void addTileSum(int n) {
		tileSum += n;
	}

	public void resetTileSum() {
		tileSum = 0;
	}
	
	public int getTileSum() {
		return tileSum;
	}
	
	public void increaseTileCount() {
		tileCount++;
	}
	
	public void resetTileCount() {
		tileCount = 0;
	}
	
	public int getTileCount() {
		return tileCount;
	}
	
	public void resetTiles() {
		for (Tile[] r : grid)
			for (Tile t : r) {
				t.unSelect();
			}

	}

	public void setMoveType(MoveType moveType) {
		this.moveType = moveType;
	}

	public MoveType getMoveType() {
		return moveType;
	}
	
	public int getLastX() {
		return lastX;
	}
	
	public void setLastX(int lastX) {
		this.lastX = lastX;
	}

	public int getLastY() {
		return lastY;
	}
	
	public void setLastY(int lastY) {
		this.lastY = lastY;
	}
	
	public void pressMouse() {
		isMousePressed = true;
	}
	
	public void releaseMouse() {
		isMousePressed = false;
	}
	
	public boolean isMousePressed() {
		return isMousePressed;
	}
	
	public int getMoveLimit() {
		return moveLimit;
	}
	
	public GameMode getMode() {
		return mode;
	}
	
	public void resetBoard() {
		Board newBoard = new Board(this.getTemplate());
		this.setGrid(newBoard.getGrid());
		resetPoints();
		resetTimePassed();
		resetMovesMade();
		resetTileSum();
		resetTileCount();
		resetTiles();
	}

}
