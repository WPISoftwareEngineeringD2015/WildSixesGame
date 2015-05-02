package kiviuq.views;

import java.awt.event.WindowEvent;

import development.Templates;
import junit.framework.TestCase;
import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;

public class TestLevelScreen extends TestCase {

	LevelScreen lvlScreen;

	protected void setUp() throws Exception {
		LevelTemplate template = Templates.getExampleTemplateElimination();
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template), null);
		lvlScreen.setVisible(true);
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
		lvlScreen.dispatchEvent(new WindowEvent(lvlScreen, WindowEvent.WINDOW_CLOSING));
	}
	
	public void testMovesMade(){
		lvlScreen.boardView.getBoard().increaseMovesMade();
		assertEquals(lvlScreen.boardView.getBoard().getMovesMade(), 1);
	}
	
	public void testScoreIncrease(){
		lvlScreen.boardView.getBoard().addPoints(50);
		assertEquals(lvlScreen.boardView.getBoard().getPoints(), 50);
	}

}
