package kiviuq.entities;

import java.util.Random;

import kiviuq.util.Constants;

public abstract class Board {

	LevelTemplate template;

	Tile[][] grid;
	int movesMade;
	int moveLimit;
	int timePassed;
	int points;
	StarCriteria starCriteria;
	GameMode mode;

	int tileSum;
	int tileCount;
	MoveType moveType = MoveType.Normal;

	boolean isMousePressed;
	int lastX = -1;
	int lastY = -1;
	int r1, r2, r3, r4, r5;
	int m1, m2;

	public static Board MakeBoardFromTemplate(LevelTemplate template) {
		GameMode mode = template.getGameMode();
		switch (mode) {
		case Puzzle:
			return new PuzzleBoard(template);
		case Lightning:
			return new LightningBoard(template);
		case Release:
			return new ReleaseBoard(template);
		case Elimination:
			return new EliminationBoard(template);
		default:
			break;
		}
		return null;
	}

	protected Board(LevelTemplate template) {
		this.setTemplate(template);
		moveLimit = template.moveLimit;
		mode = template.mode;
		grid = new Tile[Constants.BOARD_LENGTH][Constants.BOARD_WIDTH];
		starCriteria = template.getStarCriteria();
		TileType[][] gridTemplate = template.getGridTemplate();

		int pMult = template.probConst;
		r1 = 40 - pMult / 4;
		r2 = 25 - pMult / 10;
		r3 = 15 + pMult / 20;
		r4 = 10 + pMult / 10;
		r5 = 5 + pMult / 10;
		
		int mMult = template.multConst;
		m1 = 100 - mMult;
		m2 = (mMult*2)/3;

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
		return starCriteria;
	}

	public Tile[][] getGrid() {
		return grid;
	}

	public void setGrid(Tile[][] grid) {
		this.grid = grid;
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
		if (result < r1) {
			return getNextTileHelper(1);
		} else if (result <= (r1 + r2)) {
			return getNextTileHelper(2);
		} else if (result <= (r1 + r2 + r3)) {
			return getNextTileHelper(3);
		} else if (result <= (r1 + r2 + r3 + r4)) {
			return getNextTileHelper(4);
		} else if (result <= (r1 + r2 + r3 + r4 + r5)) {
			return getNextTileHelper(5);
		} else if (mode == GameMode.Release) {
			return getNextTileHelper(1);
		} else {
			return new Tile(6, 1);
		}
	}
	
	public Tile getNextTileHelper(int number) {
		Random y = new Random();
		int rand = y.nextInt(99) + 1;
		if (rand <= m1) {
			return new Tile(number, 1);
		} else if(rand <= (m1 + m2)) {
			return new Tile(number, 2);
		} else {
			return new Tile(number, 3);
		}
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

	public void resetGrid() {
		Board newBoard = Board.MakeBoardFromTemplate(template);
		this.setGrid(newBoard.getGrid());
	}

	public void resetBoard() {
		resetGrid();
		resetPoints();
		resetTimePassed();
		resetMovesMade();
		resetTileSum();
		resetTileCount();
		resetTiles();
	}
	
	public StarRating checkCriteria() {
		if (this.points >= this.starCriteria.points3) return StarRating.ThreeStars;
		else if (this.points >= this.starCriteria.points2) return StarRating.TwoStars;
		else if (this.points >= this.starCriteria.points1) return StarRating.OneStar;
		return StarRating.NoStars;
	}

	/**
	 * Removes a Tile at the given location.
	 * 
	 * This function leaves the Board in an inconsistent state.
	 * 
	 * This function may be overridden, <b>however</b> it is the responsibility
	 * of the subclass to call the parent function to ensure all functionality
	 * still occurs.
	 * 
	 * @param x
	 * @param y
	 */
	public void removeTile(int x, int y) {
		grid[x][y] = null;
	}

	/**
	 * 
	 * Specific Board implementations must override this method and make it
	 * return true if that variation of SixesWild has been won, and false
	 * otherwise.
	 * 
	 * @return true if a winning condition has been established on this Board.
	 */
	public abstract boolean hasWon();

}
