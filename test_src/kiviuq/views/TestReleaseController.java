package kiviuq.views;

import java.awt.event.WindowEvent;

import development.Templates;
import junit.framework.TestCase;
import kiviuq.controllers.RemoveTileController;
import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.MoveType;
import kiviuq.entities.Tile;
import kiviuq.entities.TileType;
import kiviuq.views.LevelScreen;

public class TestReleaseController extends TestCase {
	LevelScreen lvlScreen;

	protected void setUp() throws Exception {
		LevelTemplate template = Templates.getExampleTemplateRelease();
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template), null);
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
		
		RemoveTileController rtc = new RemoveTileController(lvlScreen.board, tile3, lvlScreen);
		lvlScreen.board.setMoveType(MoveType.Remove);
		rtc.handleMove(null);
		Thread.sleep(500);
		
		assertEquals(lvlScreen.board.getGrid()[2][0].getNumber(), tile1.getNumber());
		assertEquals(lvlScreen.board.getGrid()[2][0].getMultiplier(), tile1.getMultiplier());
		
	}

}
