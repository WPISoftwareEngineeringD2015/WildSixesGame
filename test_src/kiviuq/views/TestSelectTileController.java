package kiviuq.views;

import java.awt.event.MouseEvent;

import development.Templates;
import junit.framework.TestCase;
import kiviuq.controllers.SelectTileController;
import kiviuq.controllers.SwapTileController;
import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.MoveType;
import kiviuq.entities.Tile;
import kiviuq.entities.TileType;

public class TestSelectTileController extends TestCase {

	LevelScreen lvlScreen;

	protected void setUp() throws Exception {
		LevelTemplate template = Templates.getExampleTemplate();
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template), null);
		lvlScreen.setVisible(true);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testSelectTileAdjacent() throws InterruptedException{
		Tile tile1 = new Tile(1, 1, TileType.Number);
		Tile tile2 = new Tile(2, 1, TileType.Number);
		Tile[][] grid = lvlScreen.board.getGrid();
		grid[0][0] = tile1;
		grid[1][0] = tile2;
		lvlScreen.board.setGrid(grid);	
		lvlScreen.boardView.tvs[0][0].repaint();
		lvlScreen.boardView.tvs[1][0].repaint();
		
		SelectTileController stc = new SelectTileController(lvlScreen, lvlScreen.boardView, 0, 0);
		MouseEvent click = new MouseEvent(lvlScreen.boardView.tvs[0][0], 0, 0, 0, 0, 0, 1, false);
		stc.mouseClicked(click);
		
		Thread.sleep(500);
		assertTrue(lvlScreen.board.getGrid()[0][0].isSelected());
		MouseEvent drag = new MouseEvent(lvlScreen.boardView.tvs[1][0], 0, 0, 0, 0, 0, 1, false);
		stc.mouseEntered(drag);
	
		Thread.sleep(500);

		assertTrue(lvlScreen.board.getGrid()[1][0].isSelected());
	}
}