package kiviuq.views;

import java.awt.event.WindowEvent;

import development.Templates;
import junit.framework.TestCase;
import kiviuq.controllers.SwapTileController;
import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.Tile;
import kiviuq.views.LevelScreen;

public class TestRestartLevel extends TestCase {
	LevelScreen lvlScreen;
	
	protected void setUp() throws Exception {
		LevelTemplate template = Templates.getExampleTemplateElimination();
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template, null), null);
		lvlScreen.setVisible(true);
	}

	protected void tearDown() throws Exception {
		lvlScreen.dispatchEvent(new WindowEvent(lvlScreen, WindowEvent.WINDOW_CLOSING));
		super.tearDown();
	}
	
	public void testRestartLevel(){
		Tile initTile1 = lvlScreen.boardView.tvs[0][0].tile;
		Tile initTile2 = lvlScreen.boardView.tvs[0][1].tile;
		SwapTileController stc = new SwapTileController(initTile1, initTile2, lvlScreen.board, lvlScreen);
		stc.handleMove(null);
		lvlScreen.restart.doClick();
		
		//assertTrue(lvlScreen.restart
		
		//swap tiles tests
		//assertEquals(initTile1.getNumber(), lvlScreen.boardView.tvs[0][0].tile.getNumber());
		//assertEquals(initTile2.getNumber(), lvlScreen.boardView.tvs[0][1].tile.getNumber());
	}
}
