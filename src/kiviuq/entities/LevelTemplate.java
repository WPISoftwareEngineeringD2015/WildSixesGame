package kiviuq.entities;
import kiviuq.util.Constants;
public class LevelTemplate {
	int levelNumber;
	GameMode mode;
	TileType[][] grid;
	int timeLimit;
	int moveLimit;
	int probConst;
	int multConst;
	StarCriteria starCriteria;
	
	public LevelTemplate(int levelNumber, GameMode mode, int timeLimit, int moveLimit, int probConst,
			int multConst, StarCriteria starCriteria) {
		this.levelNumber = levelNumber;
		this.mode = mode;
		this.timeLimit = timeLimit;
		this.moveLimit = moveLimit;
		this.probConst = probConst;
		this.multConst = multConst;
		this.starCriteria = starCriteria;
		grid = new TileType[Constants.BOARD_LENGTH][Constants.BOARD_WIDTH];	
		for (int x = 0; x < Constants.BOARD_LENGTH; x++) {
			for (int y = 0; y < Constants.BOARD_WIDTH; y++) {
				grid[x][y] = TileType.Number;
			}
		}
	}
	
	public GameMode getGameMode() {
		return mode;
	}
	
	public StarCriteria getStarCriteria() {
		return starCriteria;
	}
	
	public TileType[][] getGridTemplate() {
		return grid;
	}
	
	public void setTileTypeAtPosition(int x, int y, TileType tt) {
		grid[x][y] = tt ;
	}
	
}
