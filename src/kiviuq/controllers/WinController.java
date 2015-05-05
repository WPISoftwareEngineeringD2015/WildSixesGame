package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JDialog;
import javax.swing.JOptionPane;

import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.Score;
import kiviuq.views.LevelScreen;

public class WinController implements ActionListener {

	Board board;
	LevelScreen levelScreen;
	String name;
	LevelTemplate template;

	public WinController(Board board, LevelScreen levelScreen) {
		this.board = board;
		this.levelScreen = levelScreen;
		this.name = board.getName();
		this.template = board.getTemplate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (board.hasWon() && board.getWinFlag()) {
			JOptionPane winPane = new JOptionPane
					("You beat the level!"
							+ " Click the 'Finish Level' button to record your score!", JOptionPane.PLAIN_MESSAGE);
			JDialog dialog = winPane.createDialog(levelScreen.getBoardView(), "Victory");
		    dialog.setVisible(true);
		    levelScreen.getFinishButton().setEnabled(true);
		    board.setWinFlag(false);			
			
			//JOptionPane.showConfirmDialog(levelScreen.getBoardView(), "Congratulations on Winning!");
			
		    // Old Code: Can be Deleted when necessary
		    /**
			template.setHighScorePoints(board.getScore().getPoints());
			template.setHighScoreRating(board.getScore().getRating());

			// this block of code looks crazy, but it seems to be
			// necessary for relative class path to work
			File file = new File(getClass().getClassLoader().getResource("LevelTemplates/" + name).toString());
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

			levelScreen.exitGame();
			*/
		}
	}

}
