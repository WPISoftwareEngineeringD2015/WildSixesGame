package kiviuq.views;

import development.Templates;
import junit.framework.TestCase;
import kiviuq.controllers.SwapTileController;
import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.Tile;
import kiviuq.views.LevelScreen;

public class TestAbstractMoveController extends TestCase {
	LevelScreen lvlScreen;

	protected void setUp() throws Exception {
		LevelTemplate template = Templates.getExampleTemplate();
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template), null);
		lvlScreen.setVisible(true);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testMoveAtMaxMoves(){
		int maxMoves = lvlScreen.boardView.getBoard().getMoveLimit();
		for(int i = 0; i < maxMoves +5; i++){
			lvlScreen.boardView.getBoard().increaseMovesMade();
		}
		
		Tile initTile1 = lvlScreen.boardView.tvs[0][0].tile;
		Tile initTile2 = lvlScreen.boardView.tvs[0][1].tile;
		SwapTileController stc = new SwapTileController(initTile1, initTile2, lvlScreen.board, lvlScreen);
		stc.actionPerformed(null);
		assertEquals(initTile1.getNumber(), lvlScreen.boardView.tvs[0][0].tile.getNumber());
		assertEquals(initTile2.getNumber(), lvlScreen.boardView.tvs[0][1].tile.getNumber());
	}
	
	
	public void testMoveBelowMaxMoves() throws InterruptedException{
		int maxMoves = lvlScreen.boardView.getBoard().getMoveLimit();
		for(int i = 0; i < maxMoves -3; i++){
			lvlScreen.boardView.getBoard().increaseMovesMade();
		}
		
		Tile initTile1 = lvlScreen.boardView.tvs[0][0].tile;
		Tile initTile2 = lvlScreen.boardView.tvs[0][1].tile;
		SwapTileController stc = new SwapTileController(initTile1, initTile2, lvlScreen.board, lvlScreen);
		stc.actionPerformed(null);
		Thread.sleep(500);
		assertEquals(initTile2.getNumber(), lvlScreen.boardView.tvs[0][0].tile.getNumber());
		assertEquals(initTile1.getNumber(), lvlScreen.boardView.tvs[0][1].tile.getNumber());
	}
	

}
