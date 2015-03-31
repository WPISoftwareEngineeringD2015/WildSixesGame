package kiviuq.entities;
import kiviuq.util.Constants;;
public class LevelTemplate {
	int levelNumber;
	GameMode mode;
	TileType[][] grid = new TileType[Constants.BOARD_LENGTH][Constants.BOARD_WIDTH];
	int timeLimit;
	int moveLimit;
	int random1, random2, random3, random4, random5;
	StarCriteria starCriteria;
}
