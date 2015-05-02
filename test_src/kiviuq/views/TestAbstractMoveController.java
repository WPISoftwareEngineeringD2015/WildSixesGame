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

public class TestAbstractMoveController extends TestCase {
	LevelScreen lvlScreen;

	protected void setUp() throws Exception {
		LevelTemplate template = Templates.getExampleTemplateElimination();
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template), null);
		lvlScreen.setVisible(true);
	}

	protected void tearDown() throws Exception {
		lvlScreen.dispatchEvent(new WindowEvent(lvlScreen, WindowEvent.WINDOW_CLOSING));
		super.tearDown();
	}
	
	public void testMoveAtMaxMoves() throws InterruptedException{
		int maxMoves = lvlScreen.boardView.getBoard().getMoveLimit();
		for(int i = 0; i < maxMoves +5; i++){
			lvlScreen.boardView.getBoard().increaseMovesMade();
		}
		
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
		assertEquals(lvlScreen.board.getGrid()[5][0].getNumber(), tile2.getNumber());
		assertEquals(lvlScreen.board.getGrid()[5][0].getMultiplier(), tile2.getMultiplier());
	}
	
	
	public void testMoveBelowMaxMoves() throws InterruptedException{
		int maxMoves = lvlScreen.boardView.getBoard().getMoveLimit();
		for(int i = 0; i < maxMoves -3; i++){
			lvlScreen.boardView.getBoard().increaseMovesMade();
		}
		
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
	

}
