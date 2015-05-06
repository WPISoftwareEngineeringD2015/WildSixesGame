package kiviuq.views;

import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;

import development.Templates;
import junit.framework.TestCase;
import kiviuq.controllers.RemoveTileController;
import kiviuq.controllers.SelectRemoveController;
import kiviuq.controllers.SelectTileController;
import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.MoveType;
import kiviuq.entities.StarRating;
import kiviuq.entities.Tile;
import kiviuq.entities.TileType;

public class TestRemoveTileController extends TestCase {
	LevelScreen lvlScreen;

	protected void setUp() throws Exception {
		LevelTemplate template = Templates.getExampleTemplateElimination();
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template, null), null);
		lvlScreen.setVisible(true);
	}

	protected void tearDown() throws Exception {
		lvlScreen.dispatchEvent(new WindowEvent(lvlScreen, WindowEvent.WINDOW_CLOSING));
		super.tearDown();
	}
	
	
	public void testRemoveTileToWinHighScore() throws InterruptedException, FileNotFoundException{
		Tile tile1 = new Tile(1, 1, TileType.Number);
		Tile tile2 = new Tile(1, 1, TileType.Number);
		LevelTemplate template = Templates.getExampleTemplatePuzzle();
		template.setHighScorePoints(0);
		template.setHighScoreRating(StarRating.NoStars);
		
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template, "puzzle1"), null);		
		Tile[][] grid = lvlScreen.board.getGrid();
		grid[4][0] = tile1;
		grid[5][0] = tile2;
		lvlScreen.board.setGrid(grid);		
		
		SelectRemoveController rtc = new SelectRemoveController(lvlScreen.board);
		rtc.actionPerformed(null);
		assertEquals(MoveType.Remove, lvlScreen.board.getMoveType());
		
		for (int i = 0; i < 29; i++) {
			lvlScreen.board.increaseMovesMade();
		}
		
		lvlScreen.board.addPoints(10000);
		
		SelectTileController stc = new SelectTileController(lvlScreen, lvlScreen.boardView, 0, 0);
		MouseEvent click = new MouseEvent(lvlScreen.boardView.tvs[5][0], 0, 0, 0, 0, 0, 1, false);
		stc.mouseClicked(click);
		
//		RemoveTileController rtc = new RemoveTileController(lvlScreen.board, tile2, lvlScreen);
//		lvlScreen.board.setMoveType(MoveType.Remove);
//		rtc.handleMove(null);
		Thread.sleep(500);
		assertEquals(lvlScreen.board.getGrid()[5][0].getNumber(), tile1.getNumber());
		assertEquals(lvlScreen.board.getGrid()[5][0].getMultiplier(), tile1.getMultiplier());
	}
	
	public void testRemoveTileToWinNotHighScore() throws InterruptedException, FileNotFoundException{
		Tile tile1 = new Tile(1, 1, TileType.Number);
		Tile tile2 = new Tile(1, 1, TileType.Number);
		LevelTemplate template = Templates.getExampleTemplatePuzzle();
		template.setHighScorePoints(11000);
		template.setHighScoreRating(StarRating.ThreeStars);
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template, "puzzle1"), null);		
		Tile[][] grid = lvlScreen.board.getGrid();
		grid[4][0] = tile1;
		grid[5][0] = tile2;
		lvlScreen.board.setGrid(grid);		
		
		SelectRemoveController rtc = new SelectRemoveController(lvlScreen.board);
		rtc.actionPerformed(null);
		assertEquals(MoveType.Remove, lvlScreen.board.getMoveType());
		
		for (int i = 0; i < 29; i++) {
			lvlScreen.board.increaseMovesMade();
		}
		
		lvlScreen.board.addPoints(10000);
		
		SelectTileController stc = new SelectTileController(lvlScreen, lvlScreen.boardView, 0, 0);
		MouseEvent click = new MouseEvent(lvlScreen.boardView.tvs[5][0], 0, 0, 0, 0, 0, 1, false);
		stc.mouseClicked(click);
		
//		RemoveTileController rtc = new RemoveTileController(lvlScreen.board, tile2, lvlScreen);
//		lvlScreen.board.setMoveType(MoveType.Remove);
//		rtc.handleMove(null);
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
