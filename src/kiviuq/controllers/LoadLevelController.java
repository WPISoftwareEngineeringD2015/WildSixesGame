package kiviuq.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;

import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import kiviuq.entities.Score;
import kiviuq.views.LevelScreen;
import kiviuq.views.SelectScreen;

public class LoadLevelController extends MouseAdapter{
	private LevelTemplate template = new LevelTemplate();
	private LevelScreen lvlScreen;
	private JFrame selectScreen;
	private String name;
	private JLabel label;
	private ObjectInputStream menuInput;
	private Score highScore;


	public LoadLevelController(String name, JFrame selectScreen) throws FileNotFoundException {
		this.selectScreen = (SelectScreen) selectScreen;
		this.name = name;
		this.menuInput = null;

		switch(name) {
		case "puzzle1":
			label = ((SelectScreen) this.selectScreen).puzzle1Label;
			menuInput = ((SelectScreen) this.selectScreen).puzzle1Input;
			break;
		case "puzzle2":
			label = ((SelectScreen) this.selectScreen).puzzle2Label;
			menuInput = ((SelectScreen) this.selectScreen).puzzle2Input;
			break;
		case "puzzle3":
			label = ((SelectScreen) this.selectScreen).puzzle3Label;
			menuInput = ((SelectScreen) this.selectScreen).puzzle3Input;
			break;
		case "puzzle4":
			label = ((SelectScreen) this.selectScreen).puzzle4Label;
			menuInput = ((SelectScreen) this.selectScreen).puzzle4Input;
			break;
		case "puzzle5":
			label = ((SelectScreen) this.selectScreen).puzzle5Label;
			menuInput = ((SelectScreen) this.selectScreen).puzzle5Input;
			break;
		case "elimination1":
			label = ((SelectScreen) this.selectScreen).elimination1Label;
			menuInput = ((SelectScreen) this.selectScreen).elimination1Input;
			break;
		case "elimination2":
			label = ((SelectScreen) this.selectScreen).elimination2Label;
			menuInput = ((SelectScreen) this.selectScreen).elimination2Input;
			break;
		case "elimination3":
			label = ((SelectScreen) this.selectScreen).elimination3Label;
			menuInput = ((SelectScreen) this.selectScreen).elimination3Input;
			break;
		case "elimination4":
			label = ((SelectScreen) this.selectScreen).elimination4Label;
			menuInput = ((SelectScreen) this.selectScreen).elimination4Input;
			break;
		case "elimination5":
			label = ((SelectScreen) this.selectScreen).elimination5Label;
			menuInput = ((SelectScreen) this.selectScreen).elimination5Input;
			break;
		case "lightning1":
			label = ((SelectScreen) this.selectScreen).lightning1Label;
			menuInput = ((SelectScreen) this.selectScreen).lightning1Input;
			break;
		case "lightning2":
			label = ((SelectScreen) this.selectScreen).lightning2Label;
			menuInput = ((SelectScreen) this.selectScreen).lightning2Input;
			break;
		case "lightning3":
			label = ((SelectScreen) this.selectScreen).lightning3Label;
			menuInput = ((SelectScreen) this.selectScreen).lightning3Input;
			break;
		case "lightning4":
			label = ((SelectScreen) this.selectScreen).lightning4Label;
			menuInput = ((SelectScreen) this.selectScreen).lightning4Input;
			break;
		case "lightning5":
			label = ((SelectScreen) this.selectScreen).lightning5Label;
			menuInput = ((SelectScreen) this.selectScreen).lightning5Input;
			break;
		case "release1":
			label = ((SelectScreen) this.selectScreen).release1Label;
			menuInput = ((SelectScreen) this.selectScreen).release1Input;
			break;
		case "release2":
			label = ((SelectScreen) this.selectScreen).release2Label;
			menuInput = ((SelectScreen) this.selectScreen).release2Input;
			break;
		case "release3":
			label = ((SelectScreen) this.selectScreen).release3Label;
			menuInput = ((SelectScreen) this.selectScreen).release3Input;
			break;
		case "release4":
			label = ((SelectScreen) this.selectScreen).release4Label;
			menuInput = ((SelectScreen) this.selectScreen).release4Input;
			break;
		case "release5":
			label = ((SelectScreen) this.selectScreen).release5Label;
			menuInput = ((SelectScreen) this.selectScreen).release5Input;
			break;
		}

		// this block of code looks crazy, but it seems to be
		// necessary for relative class path to work
		File file = new File(getClass().getClassLoader()
				.getResource("LevelTemplates/" + name).toString().replaceAll("%20", " "));
		String[] tempString;
		String fileString = file.toString();
		tempString = fileString.split(":", 2);
		FileInputStream fileInput = new FileInputStream(tempString[1]);

		try {
			ObjectInputStream in = new ObjectInputStream(fileInput);
//			((SelectScreen) selectScreen).setObjectInputStream(menuInput, in);
			template = (LevelTemplate) in.readObject();
			in.close();
			//			fileInput.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ClassNotFoundException");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IOException");
		}

		highScore = new Score(template.getHighScorePoints(), template.getHighScoreRating());
		label.setText(highScore.getHighScoreText());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template, name), selectScreen);
		lvlScreen.setVisible(true);
		selectScreen.setVisible(false);
		System.out.println(name);
	}
}
