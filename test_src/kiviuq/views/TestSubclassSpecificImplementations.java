package kiviuq.views;

import java.io.FileNotFoundException;

import junit.framework.TestCase;
import kiviuq.entities.Board;
import kiviuq.entities.EliminationBoard;
import kiviuq.entities.LightningBoard;
import kiviuq.entities.PuzzleBoard;
import kiviuq.entities.ReleaseBoard;
import kiviuq.entities.Tile;
import kiviuq.entities.TileType;
import development.Templates;

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
		assertFalse(lb.hasWon());
		assertFalse(pb.hasWon());
		for (int i = 0; i < pb.getMoveLimit(); i++) {
			pb.increaseMovesMade();
		}
		assertTrue(pb.hasWon());
		
		for (int i = 0; i < lb.getTimeLimit(); i++) {
			lb.increaseTimePassed();;
		}
		assertTrue(lb.hasWon());
		
		Tile[][] grid = rb.getGrid();
		for (int x = 0; x < Board.BOARD_LENGTH; x++) {
			for (int y = 0; y < Board.BOARD_WIDTH; y++) {
				if (grid[x][y].getType() == TileType.Release) 
					grid[x][y] = new Tile(TileType.Null);
			}
		}
		rb.setGrid(grid);
		assertTrue(rb.hasWon());
		rb.resetGrid();
		assertTrue(rb.hasWon());
	}
	
	public void testTimeControlsOnEntity() {
		int time = lb.getTimePassed();
		lb.increaseTimePassed();
		assertEquals(time + 1, lb.getTimePassed());
	}
	
	public void testLightningBoardView() {
		// lightning boards have time left labels
		LevelScreen ls = null;
		try {
			ls = new LevelScreen(lb, null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(ls.getTimeLeftLabel());
		try {
			ls = new LevelScreen(eb, null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// other boards do not
		assertNull(ls.getTimeLeftLabel());
	}
	
}
