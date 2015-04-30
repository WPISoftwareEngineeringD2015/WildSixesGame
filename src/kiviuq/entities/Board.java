package kiviuq.entities;

import java.util.Random;

import kiviuq.util.Constants;

/**
 * Abstract class that represents a Board. The Board class contains information
 * and functions pertaining to a given game of Sixes Wild. Some of its
 * functionality is delegated to subclasses which provide game specific
 * implementation functions for each variation of Sixes Wild.
 * 
 * @author Evin Ugur
 *
 */
public abstract class Board {

	/**
	 * The LevelTemplate which was was likely created in the Level Builder
	 * program
	 */
	LevelTemplate template;

	/**
	 * Tiles on the grid. Initialized to {@link Constants#BOARD_LENGTH} x
	 * {@link Constants#BOARD_WIDTH}.
	 */
	Tile[][] grid;

	/** Amount of moves made */
	int movesMade;
	/** Total amount of allowable moves */
	int moveLimit;
	/** Amount of time that's passed */
	int timePassed;
	/** Score for the game */
	int points;
	
	StarCriteria starCriteria;
	

	int tileSum;
	int tileCount;
	MoveType moveType = MoveType.Normal;

	boolean isMousePressed;
	int lastX = -1;
	int lastY = -1;
	int r1, r2, r3, r4, r5;
	int m1, m2;

	/**
	 * This function takes a LevelTemplate and will construct the appropriate
	 * Board object based off of that.
	 * <p>
	 * Since Board is abstract, and its subclasses have no available
	 * constructors, this is the only way to build boards. This is done
	 * partially to discourage people from ever maintaining objects of a Board
	 * subclass. That should only happen when specific code needs to be executed
	 * based on which kind of Board is being dealt with, however most of those
	 * cases are addressable simply by adding and then implementing abstract
	 * methods to this class.
	 * 
	 * @param template
	 *            the {@link LevelTemplate} template for the file.
	 * @return the proper subclass of {@link Board}
	 */
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

	/**
	 * Publicly unaccessible constructor to Board. Super classes invoke this
	 * constructor when they're called from
	 * {@link Board#MakeBoardFromTemplate(LevelTemplate)}.
	 * <p>
	 * This constructor initializes a Board's fields to proper values.
	 * 
	 * @param template
	 *            the LevelTemplate object used for building this Board.
	 */
	protected Board(LevelTemplate template) {
		this.setTemplate(template);
		moveLimit = template.moveLimit;
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
		m2 = (mMult * 2) / 3;

		for (int x = 0; x < Constants.BOARD_LENGTH; x++) {
			for (int y = 0; y < Constants.BOARD_WIDTH; y++) {
				TileType type = gridTemplate[x][y];
				Tile t;
				if (type == TileType.Number)
					t = getNextTile();
				else if (type == TileType.Block) // this will convert the Tile to be a number Tile.
					t = Tile.NewBlockTile();
				else
					t = new Tile(type); // it's a null or release tile
				grid[x][y] = t;
			}
		}
	}

	/**
	 * @return an integer representing the current score.
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Adds points to the current score
	 * 
	 * @param points
	 *            the amount of points to be added
	 */
	public void addPoints(int points) {
		this.points += points;
	}

	/**
	 * Sets the current score to zero.
	 */
	public void resetPoints() {
		points = 0;
	}

	/**
	 * @return the object that is used to represent the differnet criteria for
	 *         earning star(s) on this level.
	 */
	public StarCriteria getStarCriteria() {
		return starCriteria;
	}

	/**
	 * @return a two dimensional array that is used to represent the Tiles on
	 *         this appear. The order of the Tiles in this array is important
	 *         for game logic.
	 * 
	 */
	public Tile[][] getGrid() {
		return grid;
	}

	/**
	 * @param grid
	 *            An array used to set the Tiles on the grid.
	 * @see Board#getGrid()
	 */
	public void setGrid(Tile[][] grid) {
		this.grid = grid;
	}

	public void increaseTimePassed() {
		timePassed++;
	}

	public void resetTimePassed() {
		timePassed = 0;
	}

	/**
	 * @return an integer corresponding to the amount of moves made
	 */
	public int getMovesMade() {
		return movesMade;
	}

	/**
	 * Increases the amount of moves made by one.
	 */
	public void increaseMovesMade() {
		movesMade++;
	}

	public void resetMovesMade() {
		movesMade = 0;
	}

	/**
	 * Indicates if there are any 'empty' Tiles on this Board. Empty Tiles are
	 * denoted by having a null object reference.
	 * <p>
	 * There are only empty Tiles on a Board between discrete states.
	 * Controllers that handle game aspects such as gravity look for them and
	 * fix them between moves.
	 * 
	 * @return true if there are any 'empty' Tiles, false if otherwise.
	 */
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
		} else if (this instanceof ReleaseBoard || this instanceof EliminationBoard) {
			return getNextTileHelper(x.nextInt(5) + 1);
		} else {
			return new Tile(6, 1);
		}
	}

	public Tile getNextTileHelper(int number) {
		Random y = new Random();
		int rand = y.nextInt(99) + 1;
		if (rand <= m1) {
			return new Tile(number, 1);
		} else if (rand <= (m1 + m2)) {
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

	/**
	 * Deselects every Tile in this Board's grid. This is used when cleaning up
	 * after a Move.
	 */
	public void unselectTiles() {
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

	/**
	 * @return the move limit
	 */
	public int getMoveLimit() {
		return moveLimit;
	}

	/**
	 * Scrambles the Tiles in the grid.
	 */
	public void resetGrid() {
		Board newBoard = Board.MakeBoardFromTemplate(template);
		this.setGrid(newBoard.getGrid());
	}

	public int getTimeLimit() {
		return -1;
	}

	public int getTimePassed() {
		return this.timePassed;
	}

	/**
	 * Functionally resets everything about the level you are playing. This
	 * function is called when the Restart Level button is clicked on.
	 */
	public void resetBoard() {
		resetGrid();
		resetPoints();
		resetTimePassed();
		resetMovesMade();
		resetTileSum();
		resetTileCount();
		unselectTiles();
	}

	/**
	 * @return a {@link StarRating} for a Board based off of this Board's
	 *         {@link StarCriteria} objects.
	 */
	public StarRating checkCriteria() {
		if (this.points >= this.starCriteria.points3)
			return StarRating.ThreeStars;
		else if (this.points >= this.starCriteria.points2)
			return StarRating.TwoStars;
		else if (this.points >= this.starCriteria.points1)
			return StarRating.OneStar;
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

	public void stopMovement() {
		return;
	}

}
