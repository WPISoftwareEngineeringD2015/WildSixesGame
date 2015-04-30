package kiviuq.views;

import development.Templates;
import junit.framework.TestCase;
import kiviuq.controllers.RemoveTileController;
import kiviuq.controllers.SwapTileController;
import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.MoveType;
import kiviuq.entities.Tile;
import kiviuq.entities.TileType;

public class TestSwapTileController extends TestCase {
	LevelScreen lvlScreen;

	protected void setUp() throws Exception {
		LevelTemplate template = Templates.getExampleTemplate();
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template), null);
		lvlScreen.setVisible(true);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testSwapTile() throws InterruptedException{
		Tile tile1 = new Tile(1, 1, TileType.Number);
		Tile tile2 = new Tile(1, 1, TileType.Number);
		Tile[][] grid = lvlScreen.board.getGrid();
		grid[0][0] = tile1;
		grid[1][0] = tile2;
		lvlScreen.board.setGrid(grid);		
		SwapTileController stc = new SwapTileController(tile1, tile2, lvlScreen.board, lvlScreen);
		lvlScreen.board.setMoveType(MoveType.Swap);
		stc.handleMove(null);
		Thread.sleep(500);
		assertEquals(lvlScreen.board.getGrid()[0][0].getNumber(), tile2.getNumber());
		assertEquals(lvlScreen.board.getGrid()[0][0].getMultiplier(), tile1.getMultiplier());
		assertEquals(lvlScreen.board.getGrid()[1][0].getNumber(), tile1.getNumber());
		assertEquals(lvlScreen.board.getGrid()[1][0].getMultiplier(), tile1.getMultiplier());
	}
}
