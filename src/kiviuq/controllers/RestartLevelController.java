package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kiviuq.entities.Board;
import kiviuq.entities.ReleaseBoard;
import kiviuq.views.LevelScreen;

/**
 * This controller is responsible for completely restarting and clearing your
 * unsaved progress in a level.
 * 
 * @author Gabe Bell
 *
 */
public class RestartLevelController implements ActionListener {
	/** top level entity object */
	Board board;
	/** top level boundary object */
	LevelScreen levelScreen;

	/**
	 * Stores model and view
	 * 
	 * @param board
	 *            model
	 * @param levelScreen
	 *            view
	 */
	public RestartLevelController(Board board, LevelScreen levelScreen) {
		this.board = board;
		this.levelScreen = levelScreen;
	}

	/**
	 * Will scramble the level.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		board.resetBoard();
		levelScreen.getSpecialButtonsView().setEnabled(true);
		// after the level has been randomly generated
		if (board instanceof ReleaseBoard)
			new ReleaseTileController(board, levelScreen.getBoardView())
					.actionPerformed(e);
		levelScreen.refreshMoves();
	}
}