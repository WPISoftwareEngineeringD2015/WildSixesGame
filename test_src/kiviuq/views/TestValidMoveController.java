package kiviuq.views;

import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;

import development.Templates;
import junit.framework.TestCase;
import kiviuq.controllers.SelectTileController;
import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.Tile;
import kiviuq.entities.TileType;

public class TestValidMoveController extends TestCase {
	LevelScreen lvlScreen;

	protected void setUp() throws Exception {
		LevelTemplate template = Templates.getExampleTemplatePuzzle();
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template, null), null);
		lvlScreen.setVisible(true);
	}

	protected void tearDown() throws Exception {
		lvlScreen.dispatchEvent(new WindowEvent(lvlScreen, WindowEvent.WINDOW_CLOSING));
		super.tearDown();
	}


	public void testValidMove() throws InterruptedException, FileNotFoundException{
		Tile tile1 = new Tile(1, 1, TileType.Number);
		Tile tile2 = new Tile(5, 1, TileType.Number);
		LevelTemplate template = Templates.getExampleTemplatePuzzle();
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template, "puzzle1"), null);		
		Tile[][] grid = lvlScreen.board.getGrid();
		grid[4][0] = tile1;
		grid[5][0] = tile2;
		lvlScreen.board.setGrid(grid);
		lvlScreen.refreshBoardView();

		SelectTileController stc = new SelectTileController(lvlScreen, lvlScreen.boardView, 4, 0);
		lvlScreen.boardView.tvs[4][0].addMouseListener(stc);
		MouseEvent click = new MouseEvent(lvlScreen.boardView.tvs[4][0], 0, 0, 0, 0, 0, 1, false);
		stc.mouseClicked(click);
//		lvlScreen

		SelectTileController stc2 = new SelectTileController(lvlScreen, lvlScreen.boardView, 5, 0);
		lvlScreen.boardView.tvs[5][0].addMouseListener(stc2);
		MouseEvent enter1 = new MouseEvent(lvlScreen.boardView.tvs[5][0], 1, 0, 0, 0, 0, 0, false);
		stc2.mouseEntered(enter1);

//		assertTrue(lvlScreen.board.getPoints() > 0 || lvlScreen.board.getMovesMade() == 0);
		assertTrue(lvlScreen.board.getPoints() > 0);
	}
}
