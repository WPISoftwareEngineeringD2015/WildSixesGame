package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.Score;
import kiviuq.views.LevelScreen;

public class FinishLevelController implements ActionListener {

	Board board;
	LevelScreen levelScreen;
	String name;
	LevelTemplate template;

	public FinishLevelController(Board board, LevelScreen levelScreen) {
		this.board = board;
		this.levelScreen = levelScreen;
		this.name = board.getName();
		this.template = board.getTemplate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int oldHighScorePoints = template.getHighScorePoints();
		Score currentScore = board.getScore();
		int currentScorePoints = currentScore.getPoints();
		if (currentScorePoints > oldHighScorePoints) {
			template.setHighScorePoints(currentScorePoints);
			template.setHighScoreRating(currentScore.getRating());
		}

		// this block of code looks crazy, but it seems to be
		// necessary for relative class path to work
		File file = 
				new File(getClass().getClassLoader()
						.getResource("LevelTemplates/" + name).toString().replaceAll("%20", " "));
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
	}
	
	
}
