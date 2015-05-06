package development;

import kiviuq.entities.GameMode;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.LightningBoard;
import kiviuq.entities.PuzzleBoard;
import kiviuq.entities.ReleaseBoard;
import kiviuq.entities.StarCriteria;
import kiviuq.entities.TileType;

/**
 * This file has static factories for {@link LevelTemplate}s used during testing
 * and development.
 * 
 * @author Evin Ugur
 */
public class Templates {
	/** reference to a template for an {@link EliminationBoard} */
	private static LevelTemplate elimTemp = null;
	/** reference to a template for an {@link LightningBoard} */
	private static LevelTemplate lightTemp = null;
	/** reference to a template for an {@link PuzzleBoard} */
	private static LevelTemplate puzzleTemp = null;
	/** reference to a template for an {@link ReleaseBoard} */
	private static LevelTemplate releaseTemp = null;

	/**
	 * @return template for an {@link EliminationBoard}
	 */
	public static LevelTemplate getExampleTemplateElimination() {
		if (elimTemp == null) {
			StarCriteria sc = new StarCriteria(50, 100, 300);
			elimTemp = new LevelTemplate(0, GameMode.Elimination, 60, 30, 50,
					60, sc);
		}
		return elimTemp;
	}

	/**
	 * @return template for an {@link LightningBoard}
	 */
	public static LevelTemplate getExampleTemplateLightning() {
		if (lightTemp == null) {
			StarCriteria sc = new StarCriteria(50, 100, 150);
			lightTemp = new LevelTemplate(1, GameMode.Lightning, 60, 30, 50,
					60, sc);
		}
		return lightTemp;
	}

	/**
	 * @return template for an {@link PuzzleBoard}
	 */
	public static LevelTemplate getExampleTemplatePuzzle() {
		if (puzzleTemp == null) {
			StarCriteria sc = new StarCriteria(50, 100, 150);
			puzzleTemp = new LevelTemplate(2, GameMode.Puzzle, 60, 30, 50, 60,
					sc);
		}
		return puzzleTemp;
	}

	/**
	 * @return template for an {@link ReleaseBoard}
	 */
	public static LevelTemplate getExampleTemplateRelease() {
		if (releaseTemp == null) {
			StarCriteria sc = new StarCriteria(0, 0, 50);
			releaseTemp = new LevelTemplate(3, GameMode.Release, 60, 30, 50,
					60, sc);

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