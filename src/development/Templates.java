package development;

import java.util.Random;

import kiviuq.entities.GameMode;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.StarCriteria;
import kiviuq.entities.TileType;
import kiviuq.util.Constants;

public class Templates {
	private static LevelTemplate elimTemp = null; // TODO
	private static LevelTemplate lightTemp = null;
	private static LevelTemplate puzzleTemp = null;
	private static LevelTemplate releaseTemp = null; 

	public static LevelTemplate getExampleTemplateElimination() {
		if (elimTemp == null) {
			StarCriteria sc = new StarCriteria(50, 100, 300, 4, 6, 8); 
			elimTemp = new LevelTemplate(0, GameMode.Elimination, 5, 30, 50, 60, sc);
			Random r = new Random();
			// throw some random null tiles in there
			for (int i = 0; i < 5; i++) {
				int x = r.nextInt(Constants.BOARD_LENGTH);
				int y = r.nextInt(Constants.BOARD_WIDTH);
				elimTemp.setTileTypeAtPosition(x, y, TileType.Null);
			}
			// throw some random release tiles in there
			for (int i = 0; i < 2; i++) {
				int x = r.nextInt(Constants.BOARD_LENGTH);
				int y = r.nextInt(Constants.BOARD_WIDTH);
				elimTemp.setTileTypeAtPosition(x, y, TileType.Release);
			}
			elimTemp = new LevelTemplate(0, GameMode.Elimination, 60, 30, 50, 60, sc);
		}
		return elimTemp;
	}

	public static LevelTemplate getExampleTemplateLightning() {
		if (lightTemp == null) {
			StarCriteria sc = new StarCriteria(0, 0, 50, 100, 300, 4); 
			lightTemp = new LevelTemplate(1, GameMode.Lightning, 60, 30, 50, 60, sc);
		}
		return lightTemp;
	}

	public static LevelTemplate getExampleTemplatePuzzle() {
		if (puzzleTemp == null) {
			StarCriteria sc = new StarCriteria(0, 0, 50, 100, 300, 4); 
			puzzleTemp = new LevelTemplate(2, GameMode.Puzzle, 60, 30, 50, 60, sc);
		}
		return puzzleTemp;
	}

	public static LevelTemplate getExampleTemplateRelease() {
		if (releaseTemp == null) {
			StarCriteria sc = new StarCriteria(0, 0, 50, 100, 300, 4); 
			releaseTemp = new LevelTemplate(3, GameMode.Release, 60, 30, 50, 60, sc);

			releaseTemp.setTileTypeAtPosition(8, 0, TileType.Null);
			releaseTemp.setTileTypeAtPosition(8, 1, TileType.Null);
			releaseTemp.setTileTypeAtPosition(8, 3, TileType.Null);
			releaseTemp.setTileTypeAtPosition(8, 5, TileType.Null);
			releaseTemp.setTileTypeAtPosition(8, 7, TileType.Null);
			releaseTemp.setTileTypeAtPosition(8, 8, TileType.Null);

			releaseTemp.setTileTypeAtPosition(0, 2, TileType.Block);
			releaseTemp.setTileTypeAtPosition(0, 4, TileType.Block);
			releaseTemp.setTileTypeAtPosition(0, 6, TileType.Block);
			
			releaseTemp.setTileTypeAtPosition(8, 2, TileType.Release);
			releaseTemp.setTileTypeAtPosition(8, 4, TileType.Release);
			releaseTemp.setTileTypeAtPosition(8, 6, TileType.Release);
		}
		return releaseTemp;
	}
}

