package kiviuq.views;

import development.Templates;
import junit.framework.TestCase;
import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;

public class TestResetTilesController extends TestCase {
	LevelScreen lvlScreen;

	protected void setUp() throws Exception {
		LevelTemplate template = Templates.getExampleTemplate();
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template), null);
		lvlScreen.setVisible(true);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testResetTiles(){
		lvlScreen.boardView.getBoard().addPoints(50);
		lvlScreen.boardView.getBoard().increaseMovesMade();
		lvlScreen.boardView.getBoard().resetTiles();
		assertEquals(lvlScreen.boardView.getBoard().getPoints(), 50);
		assertEquals(lvlScreen.boardView.getBoard().getMovesMade(), 1);
	}
}