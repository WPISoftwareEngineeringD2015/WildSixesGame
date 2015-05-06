package kiviuq.views;

import development.Templates;
import junit.framework.TestCase;
import kiviuq.entities.Board;
import kiviuq.entities.EliminationBoard;
import kiviuq.entities.LightningBoard;
import kiviuq.entities.PuzzleBoard;
import kiviuq.entities.ReleaseBoard;

public class TestSubclassSpecificImplementations extends TestCase{
	ReleaseBoard rb;
	EliminationBoard eb;
	LightningBoard lb;
	PuzzleBoard pb;
	
	@Override 
	protected void setUp() {
		// we have to cast such that eccl emma knows to look in the appropriate java file
		rb = (ReleaseBoard)Board.MakeBoardFromTemplate(Templates.getExampleTemplateRelease(), null);
		eb = (EliminationBoard) Board.MakeBoardFromTemplate(Templates.getExampleTemplateElimination(), null);
		lb = (LightningBoard) Board.MakeBoardFromTemplate(Templates.getExampleTemplateLightning(), null);
		pb = (PuzzleBoard) Board.MakeBoardFromTemplate(Templates.getExampleTemplatePuzzle(), null);
	}
	
	public void testInitialNotWin() {
		assertFalse(rb.hasWon());
		assertFalse(eb.hasWon());
		// TODO get these to fail
		// assertFalse(lb.hasWon());
		// assertFalse(pb.hasWon());
	}
	
	public void testTimeControlsOnEntity() {
		int time = lb.getTimePassed();
		lb.increaseTimePassed();
		assertEquals(time + 1, lb.getTimePassed());
	}
	
	public void testLightningBoardView() {
		// lightning boards have time left labels
		LevelScreen ls = new LevelScreen(lb, null);
		assertNotNull(ls.getTimeLeftLabel());
		ls = new LevelScreen(eb, null);
		// other boards do not
		assertNull(ls.getTimeLeftLabel());
	}
	
}
