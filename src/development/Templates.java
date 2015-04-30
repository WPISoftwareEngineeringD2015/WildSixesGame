package development;

import kiviuq.entities.GameMode;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.StarCriteria;
import kiviuq.entities.TileType;

public class Templates {
	private static LevelTemplate temp = null; // TODO

	public static LevelTemplate getExampleTemplateElimination() {
		if (temp == null) {
			StarCriteria sc = new StarCriteria(0, 0, 50, 100, 300, 4); 
			temp = new LevelTemplate(0, GameMode.Elimination, 60, 30, 50, 60, sc);
		}
		return temp;
	}

	public static LevelTemplate getExampleTemplateLightning() {
		if (temp == null) {
			StarCriteria sc = new StarCriteria(0, 0, 50, 100, 300, 4); 
			temp = new LevelTemplate(1, GameMode.Lightning, 60, 30, 50, 60, sc);
		}
		return temp;
	}

	public static LevelTemplate getExampleTemplatePuzzle() {
		if (temp == null) {
			StarCriteria sc = new StarCriteria(0, 0, 50, 100, 300, 4); 
			temp = new LevelTemplate(2, GameMode.Puzzle, 60, 30, 50, 60, sc);
		}
		return temp;
	}

	public static LevelTemplate getExampleTemplateRelease() {
		if (temp == null) {
			StarCriteria sc = new StarCriteria(0, 0, 50, 100, 300, 4); 
			temp = new LevelTemplate(3, GameMode.Release, 60, 30, 50, 60, sc);

			temp.setTileTypeAtPosition(8, 0, TileType.Null);
			temp.setTileTypeAtPosition(8, 1, TileType.Null);
			temp.setTileTypeAtPosition(8, 3, TileType.Null);
			temp.setTileTypeAtPosition(8, 5, TileType.Null);
			temp.setTileTypeAtPosition(8, 7, TileType.Null);
			temp.setTileTypeAtPosition(8, 8, TileType.Null);

			temp.setTileTypeAtPosition(8, 2, TileType.Release);
			temp.setTileTypeAtPosition(8, 4, TileType.Release);
			temp.setTileTypeAtPosition(8, 6, TileType.Release);
		}
		return temp;
	}
}

