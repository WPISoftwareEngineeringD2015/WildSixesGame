package development;

import kiviuq.entities.GameMode;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.StarCriteria;
import kiviuq.entities.TileType;

public class Templates {
	private static LevelTemplate elimTemp = null; // TODO
	private static LevelTemplate lightTemp = null;
	private static LevelTemplate puzzleTemp = null;
	private static LevelTemplate releaseTemp = null; 

	public static LevelTemplate getExampleTemplateElimination() {
		if (elimTemp == null) {
			StarCriteria sc = new StarCriteria(50, 100, 300); 
			elimTemp = new LevelTemplate(0, GameMode.Elimination, 60, 30, 50, 60, sc);
		}
		return elimTemp;
	}

	public static LevelTemplate getExampleTemplateLightning() {
		if (lightTemp == null) {
			StarCriteria sc = new StarCriteria(0, 0, 50); 
			lightTemp = new LevelTemplate(1, GameMode.Lightning, 60, 30, 50, 60, sc);
		}
		return lightTemp;
	}

	public static LevelTemplate getExampleTemplatePuzzle() {
		if (puzzleTemp == null) {
			StarCriteria sc = new StarCriteria(0, 0, 50); 
			puzzleTemp = new LevelTemplate(2, GameMode.Puzzle, 60, 30, 50, 60, sc);
		}
		return puzzleTemp;
	}

	public static LevelTemplate getExampleTemplateRelease() {
		if (releaseTemp == null) {
			StarCriteria sc = new StarCriteria(0, 0, 50); 
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