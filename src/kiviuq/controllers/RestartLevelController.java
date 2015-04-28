package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kiviuq.entities.Board;
import kiviuq.entities.ReleaseBoard;
import kiviuq.views.LevelScreen;

public class RestartLevelController implements ActionListener {
	Board board;
	LevelScreen levelScreen;
	
	public RestartLevelController(Board board, LevelScreen levelScreen) {
		this.board = board;
		this.levelScreen = levelScreen;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		board.resetBoard();
		levelScreen.getSpecialButtonsView().setEnabled(true);
		// after the level has been randomly generated 
		if (board instanceof ReleaseBoard)
			new ReleaseTileController(board, levelScreen.getBoardView()).actionPerformed(e);
		levelScreen.refreshMoves();
	}
}