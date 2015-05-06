package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import kiviuq.entities.Board;
import kiviuq.views.LevelScreen;

/**
 * This provides a dialog for when you win a game. It is hooked into the game
 * logic via {@link AbstractMoveController#actionPerformed(ActionEvent)}.
 * 
 * @author Evin Ugur
 */
public class WinController implements ActionListener {

	/** Reference to an entity object */
	Board board;
	/** Reference to a boundary object */
	LevelScreen levelScreen;

	/**
	 * @param board
	 *            an entity object
	 * @param levelScreen
	 *            a boundary object
	 */
	public WinController(Board board, LevelScreen levelScreen) {
		this.board = board;
		this.levelScreen = levelScreen;
	}

	/**
	 * Displays a dialog and modifies the boundary to create a button for
	 * winning.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (board.hasWon() && board.getWinFlag()) {
			JOptionPane winPane = new JOptionPane("You beat the level!"
					+ " Click the 'Finish Level' button to record your score!",
					JOptionPane.PLAIN_MESSAGE);
			JDialog dialog = winPane.createDialog(levelScreen.getBoardView(),
					"Victory");
			dialog.setVisible(true);
			levelScreen.getFinishButton().setEnabled(true);
			board.setWinFlag(false);

		}
	}

}
