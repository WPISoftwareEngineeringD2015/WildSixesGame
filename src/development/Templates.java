package development;

import java.util.Random;

import kiviuq.entities.GameMode;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.TileType;
import kiviuq.util.Constants;

public class Templates {
	private static LevelTemplate temp = null; // TODO
	public static LevelTemplate getExampleTemplate() {
		if (temp == null) {
			temp = new LevelTemplate(0, GameMode.Elimination, 60, 30, 10, 20, 20, 30, 20, null);
			Random r = new Random();
			// throw some random null tiles in there 
			for (int i = 0; i < 5; i++) {
				int x = r.nextInt(Constants.BOARD_LENGTH);
				int y = r.nextInt(Constants.BOARD_WIDTH);
				temp.setTileTypeAtPosition(x, y, TileType.Null);
			}
			// throw some random release tiles in there
			for (int i = 0; i < 2; i++) {
				int x = r.nextInt(Constants.BOARD_LENGTH);
				int y = r.nextInt(Constants.BOARD_WIDTH);
				temp.setTileTypeAtPosition(x, y, TileType.Relase);
			}
		}
		return temp;
	}
}
	