package kiviuq.views;

import development.Templates;
import junit.framework.TestCase;
import kiviuq.controllers.RemoveTileController;
import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.Tile;

public class TestRemoveTileController extends TestCase {
	LevelScreen lvlScreen;

	protected void setUp() throws Exception {
		LevelTemplate template = Templates.getExampleTemplate();
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template), null);
		lvlScreen.setVisible(true);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public void testRemoveTile() throws InterruptedException{
		Tile initTile1 = lvlScreen.boardView.tvs[1][0].tile;
		Tile initTile2 = lvlScreen.boardView.tvs[0][0].tile;
		RemoveTileController rtc = new RemoveTileController(lvlScreen.board, initTile1, lvlScreen);
		rtc.handleMove(null);
		Thread.sleep(500);
		assertEquals(lvlScreen.boardView.tvs[1][0].tile.getNumber(), initTile2.getNumber());
		assertEquals(lvlScreen.boardView.tvs[1][0].tile.getMultiplier(), initTile2.getMultiplier());
	}

}
