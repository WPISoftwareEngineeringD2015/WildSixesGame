package kiviuq.views;

import development.Templates;
import junit.framework.TestCase;
import kiviuq.controllers.RemoveTileController;
import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.MoveType;
import kiviuq.entities.Tile;
import kiviuq.entities.TileType;

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
		Tile tile1 = new Tile(1, 1, TileType.Number);
		Tile tile2 = new Tile(1, 1, TileType.Number);
		Tile[][] grid = lvlScreen.board.getGrid();
		grid[4][0] = tile1;
		grid[5][0] = tile2;
		lvlScreen.board.setGrid(grid);		
		RemoveTileController rtc = new RemoveTileController(lvlScreen.board, tile2, lvlScreen);
		lvlScreen.board.setMoveType(MoveType.Remove);
		rtc.handleMove(null);
		Thread.sleep(500);
		assertEquals(lvlScreen.board.getGrid()[5][0].getNumber(), tile1.getNumber());
		assertEquals(lvlScreen.board.getGrid()[5][0].getMultiplier(), tile1.getMultiplier());
	}
	
	
	public void testSelectRemoveRelease() throws InterruptedException{
		Tile tile3 = new Tile(1, 1, TileType.Number);
		Tile tile4 = new Tile(1, 1, TileType.Release);
		Tile[][] grid = lvlScreen.board.getGrid();
		grid[4][1] = tile3;
		grid[5][1] = tile4;
		lvlScreen.board.setGrid(grid);		
		RemoveTileController rtc = new RemoveTileController(lvlScreen.board, tile4, lvlScreen);
		lvlScreen.board.setMoveType(MoveType.Remove);
		rtc.handleMove(null);
		Thread.sleep(500);
		assertEquals(lvlScreen.board.getGrid()[4][1].getNumber(), tile3.getNumber());
		assertEquals(lvlScreen.board.getGrid()[4][1].getMultiplier(), tile3.getMultiplier());
		assertEquals(lvlScreen.board.getGrid()[5][1].getType(), TileType.Release);
	}
}
