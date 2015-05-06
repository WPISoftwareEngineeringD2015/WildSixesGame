package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.Score;
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
	/** used to store data to disk */
	LevelTemplate template;
	/** level name */
	String name;

	/**
	 * @param board
	 *            an entity object
	 * @param levelScreen
	 *            a boundary object
	 */
	public WinController(Board board, LevelScreen levelScreen) {
		this.board = board;
		this.levelScreen = levelScreen;
		this.template = board.getTemplate();
		this.name = board.getName();
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
			
			int oldHighScorePoints = template.getHighScorePoints();
			Score currentScore = board.getScore();
			int currentScorePoints = currentScore.getPoints();
			if (currentScorePoints > oldHighScorePoints) {
				template.setHighScorePoints(currentScorePoints);
				template.setHighScoreRating(currentScore.getRating());
				levelScreen.refreshHighScore();
			}

			// this block of code looks crazy, but it seems to be
			// necessary for relative class path to work
			File file = new File(getClass().getClassLoader()
					.getResource("LevelTemplates/" + name).toString()
					.replaceAll("%20", " "));
			String[] tempString;
			String fileString = file.toString();
			tempString = fileString.split(":", 2);
			FileOutputStream fileOutput;
			try {
				fileOutput = new FileOutputStream(tempString[1]);
				ObjectOutputStream templateOut;
				templateOut = new ObjectOutputStream(fileOutput);
				templateOut.writeObject(template);
				templateOut.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			levelScreen.getFinishButton().setEnabled(true);
			board.setWinFlag(false);

		}
	}

}
