package kiviuq.views;

import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;

import development.Templates;
import junit.framework.TestCase;
import kiviuq.controllers.NextLevelController;
import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;

public class TestNextLevelScreen extends TestCase {

	LevelScreen lvlScreen;

	protected void setUp() throws Exception {
		LevelTemplate template = Templates.getExampleTemplateElimination();
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template, "puzzle1"), null);
		lvlScreen.setVisible(true);
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
		lvlScreen.dispatchEvent(new WindowEvent(lvlScreen, WindowEvent.WINDOW_CLOSING));
	}
	
	public void testNextLevel() throws FileNotFoundException {
		NextLevelController nlc = new NextLevelController(lvlScreen.board.getName(), lvlScreen);
		nlc.actionPerformed(null);
		
		assertTrue(!lvlScreen.isVisible());
		
	}

}
