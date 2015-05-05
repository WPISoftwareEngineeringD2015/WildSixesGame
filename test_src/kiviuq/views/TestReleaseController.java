package kiviuq.views;

import java.awt.event.WindowEvent;

import junit.framework.TestCase;
import kiviuq.controllers.RemoveTileController;
import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.MoveType;
import kiviuq.entities.ReleaseBoard;
import kiviuq.entities.Tile;
import kiviuq.entities.TileType;
import development.Templates;

public class TestReleaseController extends TestCase {
	LevelScreen lvlScreen;
	ReleaseBoard board;

	protected void setUp() throws Exception {
		LevelTemplate template = Templates.getExampleTemplateRelease();
		// have to case because ecl emma isn't smart enough to look in ReleaseBoard.java
		board = (ReleaseBoard)Board.MakeBoardFromTemplate(template, null);
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template, null), null);
		lvlScreen.setVisible(true);
	}

	protected void tearDown() throws Exception {
		lvlScreen.dispatchEvent(new WindowEvent(lvlScreen, WindowEvent.WINDOW_CLOSING));
		super.tearDown();
	}
	
	public void testActionPerformed() throws InterruptedException{
		Tile tile1 = new Tile(3, 3, TileType.Number);
		Tile tile2 = new Tile(6, 1, TileType.Number);
		Tile tile3 = new Tile(2, 1, TileType.Number);
		Tile tile4 = new Tile(TileType.Release);
		Tile[][] grid = lvlScreen.board.getGrid();
		grid[0][0] = tile1;
		grid[1][0] = tile2;
		grid[2][0] = tile3;
		grid[3][0] = tile4;
		lvlScreen.board.setGrid(grid);	
		lvlScreen.getBoardView().repaint();
		
		RemoveTileController rtc = new RemoveTileController(lvlScreen.board, tile3, lvlScreen);
		lvlScreen.board.setMoveType(MoveType.Remove);
		rtc.handleMove(null);
		Thread.sleep(500);
		
		assertEquals(lvlScreen.board.getGrid()[2][0].getNumber(), tile1.getNumber());
		assertEquals(lvlScreen.board.getGrid()[2][0].getMultiplier(), tile1.getMultiplier());	
	}
	
	public void testInitalLost() {
		assertFalse(lvlScreen.board.hasWon());
	}
	
	
}
