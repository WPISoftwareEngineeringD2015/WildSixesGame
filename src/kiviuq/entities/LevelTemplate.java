package kiviuq.entities;

import java.io.Serializable;

/**
 * LevelTemplate class represents the information needed for Sixes Wild to construct a level
 * @author 
 * @author alyssagraham
 *
 */

public class LevelTemplate implements Serializable{
	/**
	 * Automatically included by Eclipse to prevent error.
	 */
	private static final long serialVersionUID = -9104499374831536471L;
	
	/** Integer representing the number of the level */
	private int levelNumber;
	
	/** Enumeration representing the type of level */
	GameMode mode;
	
	/** 2-D Array of all the tiles. */
	TileType[][] grid;
	
	/** The time limit used in Lightning levels */
	int timeLimit;
	
	/** The maximum amount of moves the user can do */
	int moveLimit;

	/** The ranking system associated with the level determining what star count is awarded */
	StarCriteria starCriteria;	
	
	/** Constant from 0 - 100 that helps determine the frequency of NumberTiles 1 through 6. */
	int probConst;
	
	/** Constant from 0 - 100 that helps determine the frequency of multipliers 1 through 3 */
	int multConst;
//	Score highScore;
	int highScorePoints;
	StarRating highScoreRating;
	
	/**
	 * Full constructor for LevelTemplate class
	 * @param levelNumber what number in a series of levels the level is
	 * @param mode what GameMode the level is (puzzle, lightning, elimination, release)
	 * @param timeLimit the time limit for lightning mode levels
	 * @param moveLimit the move limit for elimination mode levels
	 * @param probConst the constant determining tile number frequency
	 * @param multConst the constant determining tile multiplier frequency
	 * @param starCriteria the starCriteria for the level @see StarCriteria
	 */
	public LevelTemplate(int levelNumber, GameMode mode, int timeLimit, int moveLimit, int probConst,
			int multConst, StarCriteria starCriteria) {
		this.setLevelNumber(levelNumber);
		this.mode = mode;
		this.timeLimit = timeLimit;
		this.moveLimit = moveLimit;
		this.multConst = multConst;
		this.probConst = probConst;
		this.starCriteria = starCriteria;
//		this.highScore = new Score(0, StarRating.NoStars);
		this.highScorePoints = 0;
		this.highScoreRating = StarRating.NoStars;
		grid = new TileType[Board.BOARD_LENGTH][Board.BOARD_WIDTH];	
		for (int x = 0; x < Board.BOARD_LENGTH; x++) {
			for (int y = 0; y < Board.BOARD_WIDTH; y++) {
				grid[x][y] = TileType.Number;
			}
		}
	}
	
	// necessary to have a blank constructor for constructing fresh levels to edit
	/**
	 * null constructor for LevelTemplate 
	 * Sets defaults for a fresh level template used in the level builder
	 */
	public LevelTemplate() {
		this.timeLimit = 0;
		this.starCriteria = null;
		this.mode = GameMode.Puzzle;
		this.grid = new TileType[Board.BOARD_LENGTH][Board.BOARD_WIDTH];
		for (int x = 0; x < Board.BOARD_LENGTH; x++) {
			for (int y = 0; y < Board.BOARD_WIDTH; y++) {
				grid[x][y] = TileType.Null;
			}
		}
		this.moveLimit = 10;
		this.starCriteria = new StarCriteria();
//		this.highScore = new Score(0, StarRating.NoStars);
		this.highScorePoints = 0;
		this.highScoreRating = StarRating.NoStars;
	}
	
	/**
	 * get method for StarCriteria starCriteria
	 * @return StarCriteria starCriteria
	 */
	public StarCriteria getStarCriteria() {
		return starCriteria;
	}
	
//	/**
//	 * get method for Score highScore
//	 * @return Score highScore
//	 */
//	public Score getHighScore() {
//		return highScore;
//	}
//	
//	/**
//	 * set method for Score highScore
//	 * @return Score highScore
//	 */
//	public void setHighScore(Score newScore) {
//		highScore = newScore;
//	}
	
	/**
	 * get method for Score highScore
	 * @return Score highScore
	 */
	public int getHighScorePoints() {
		return highScorePoints;
	}
	
	/**
	 * set method for Score highScore
	 * @return Score highScore
	 */
	public void setHighScorePoints(int newPoints) {
		highScorePoints = newPoints;
	}
	
	/**
	 * get method for Score highScore
	 * @return Score highScore
	 */
	public StarRating getHighScoreRating() {
		return highScoreRating;
	}
	
	/**
	 * set method for Score highScore
	 * @return Score highScore
	 */
	public void setHighScoreRating(StarRating newRating) {
		highScoreRating = newRating;
	}
	
	/**
	 * get method for TileType[][] grid
	 * @return TileType[][] grid
	 */
	public TileType[][] getGridTemplate() {
		return grid;
	}
	
	/**
	 * set method for TileType[x][y] grid
	 * @param x x coordinate of TileType to change
	 * @param y y coordinate of TileType to change
	 * @param tt TileType to set at the above coordinates
	 */
	public void setTileTypeAtPosition(int x, int y, TileType tt) {
		grid[x][y] = tt ;
	}
	
	/**
	 * get method for GameMode mode
	 * @return GameMode mode
	 */
	public GameMode getGameMode() {
		return this.mode;
	}
	
	/**
	 * set method for GameMode mode
	 * @param m GameMode to set GameMode mode attribute to
	 */
	public void setGameMode(GameMode m) {
		this.mode = m;
	}
	
	/**
	 * set method for TileType[][] grid
	 * @param g TileType[][] to set TileType[][] grid attribute to
	 */
	public void setGrid(TileType[][] g) {
		this.grid = g;
	}
	
	/**
	 * get method for int moveLimit
	 * @return int moveLimit
	 */
	public int getMoveLimit() {
		return moveLimit;
	}
	
	/**
	 * set method for int moveLimit
	 * @param i int to set int moveLimit attribute to
	 */
	public void setMoveLimit(int i) {
		this.moveLimit = i;
	}
	
	/**
	 * get method for int timeLimit
	 * @return int timeLimit
	 */
	public int getTimeLimit() {
		return timeLimit;
	}
	
	/**
	 * set method for int timeLimit
	 * @param i int to set int timeLimit attribute to
	 */
	public void setTimeLimit(int i) {
		this.timeLimit = i;
	}

	/**
	 * get method for int levelNumber
	 * @return int levelNumber
	 */
	public int getLevelNumber() {
		return levelNumber;
	}

	/**
	 * set method for levelNumber
	 * @param levelNumber int to set levelNumber attribute to
	 */
	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}

	/**
	 * set method for starCriteria
	 * @param starCriteria2 StarCriteria for which to attribute to the template
	 */
	public void setStarCriteria(StarCriteria starCriteria2) {
		this.starCriteria = starCriteria2;
	}

	/**
	 * get method for probConst
	 * @return int probConst
	 */
	public int getProbConst() {
		return probConst;
	}
	
	/**
	 * set method for probConst
	 * @param newProb int for which to set int probConst
	 */
	public void setProbConst(int newProb) {
		probConst = newProb;
	}

	/**
	 * get method for multConst
	 * @return int multConst
	 */
	public int getMultConst() {
		return multConst;
	}
	
	/**
	 * set method for probConst
	 * @param newMult int for which to set int multConst
	 */
	public void setMultConst(int newMult) {
		multConst = newMult;
	}
	
}


//package kiviuq.entities;
//import kiviuq.util.Constants;
//public class LevelTemplate {
//	int levelNumber;
//	GameMode mode;
//	TileType[][] grid;
//	int timeLimit;
//	int moveLimit;
//	int probConst;
//	int multConst;
//	StarCriteria starCriteria;
//	
//	public LevelTemplate(int levelNumber, GameMode mode, int timeLimit, int moveLimit, int probConst,
//			int multConst, StarCriteria starCriteria) {
//		this.levelNumber = levelNumber;
//		this.mode = mode;
//		this.timeLimit = timeLimit;
//		this.moveLimit = moveLimit;
//		this.probConst = probConst;
//		this.multConst = multConst;
//		this.starCriteria = starCriteria;
//		grid = new TileType[Board.BOARD_LENGTH][Board.BOARD_WIDTH];	
//		for (int x = 0; x < Board.BOARD_LENGTH; x++) {
//			for (int y = 0; y < Board.BOARD_WIDTH; y++) {
//				grid[x][y] = TileType.Number;
//			}
//		}
//	}
//	
//	public GameMode getGameMode() {
//		return mode;
//	}
//	
//	public StarCriteria getStarCriteria() {
//		return starCriteria;
//	}
//	
//	public TileType[][] getGridTemplate() {
//		return grid;
//	}
//	
//	public void setTileTypeAtPosition(int x, int y, TileType tt) {
//		grid[x][y] = tt ;
//	}
//	
//}
