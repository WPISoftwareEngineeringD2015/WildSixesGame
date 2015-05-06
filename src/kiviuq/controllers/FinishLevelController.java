package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import kiviuq.entities.Board;
import kiviuq.views.LevelScreen;

public class FinishLevelController implements ActionListener {

	/** top level entity object */
	Board board;
	/** top level boundary object */
	LevelScreen levelScreen;

	/**
	 * Stores the model and view into this class.
	 * 
	 * @param board
	 *            top level entity object
	 * @param levelScreen
	 *            top level boundary object
	 */
	public FinishLevelController(Board board, LevelScreen levelScreen) {
		this.board = board;
		this.levelScreen = levelScreen;
	}

	/**
	 * Will attempt to save the score to disk.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		levelScreen.exitGame();
	}

}
