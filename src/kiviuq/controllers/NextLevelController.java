package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import kiviuq.views.LevelScreen;

/**
 * 
 * Controller responsible for loading a Level from disk.
 * 
 * @author Gabe Bell
 *
 */
public class NextLevelController implements ActionListener {
	/**
	 * represents a level stored on disk, can be read by the LevelBuilder and
	 * converted to a {@link Board} for play.
	 */
	private LevelTemplate template = new LevelTemplate();
	/** top level boundary object */
	private LevelScreen lvlScreen;
	/** boundary object for the level select screen */
	private LevelScreen currentScreen;
	/** name of the level file */
	private String name;
	/** name of the level file */
	private String nextLevelName;

	/**
	 * 
	 * Stores values while loading the appropriate level from disk.
	 * 
	 * @param name
	 *            name of the level
	 * @param currentScreen
	 *            boundary object that corresponds to the level select screen
	 * @throws FileNotFoundException
	 *             if a level file was not on disk, this will be thrown
	 */
	public NextLevelController(String name, LevelScreen currentScreen)
			throws FileNotFoundException {
		this.currentScreen = currentScreen;
		this.name = name;

		switch (name) {
		case "puzzle1":
			nextLevelName = "puzzle2";
			break;
		case "puzzle2":
			nextLevelName = "puzzle3";
			break;
		case "puzzle3":
			nextLevelName = "puzzle4";
			break;
		case "puzzle4":
			nextLevelName = "puzzle5";
			break;
		case "puzzle5":
			nextLevelName = null;
			break;
		case "elimination1":
			nextLevelName = "elimination2";
			break;
		case "elimination2":
			nextLevelName = "elimination3";
			break;
		case "elimination3":
			nextLevelName = "elimination4";
			break;
		case "elimination4":
			nextLevelName = "elimination5";
			break;
		case "elimination5":
			nextLevelName = null;
			break;
		case "lightning1":
			nextLevelName = "lightning2";
			break;
		case "lightning2":
			nextLevelName = "lightning3";
			break;
		case "lightning3":
			nextLevelName = "lightning4";
			break;
		case "lightning4":
			nextLevelName = "lightning5";
			break;
		case "lightning5":
			nextLevelName = null;
			break;
		case "release1":
			nextLevelName = "release2";
			break;
		case "release2":
			nextLevelName = "release3";
			break;
		case "release3":
			nextLevelName = "release4";
			break;
		case "release4":
			nextLevelName = "release5";
			break;
		case "release5":
			nextLevelName = null;
			break;
		}


		if (nextLevelName != null) {
			// this block of code looks crazy, but it seems to be
			// necessary for relative class path to work
			File file = new File(getClass().getClassLoader()
					.getResource("LevelTemplates/" + nextLevelName).toString()
					.replaceAll("%20", " "));
			String[] tempString;
			String fileString = file.toString();
			tempString = fileString.split(":", 2);
			FileInputStream fileInput = new FileInputStream(tempString[1]);

			try {
				ObjectInputStream in = new ObjectInputStream(fileInput);
				// ((SelectScreen) selectScreen).setObjectInputStream(menuInput,
				// in);
				template = (LevelTemplate) in.readObject();
				in.close();
				// fileInput.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("ClassNotFoundException");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("IOException");
			}
		}
	}

	/**
	 * Creates a {@link LevelScreen} with valid data. Launches a game of Sixes
	 * Wild with the appropriate level.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (nextLevelName != null) {
			try {
				lvlScreen = new LevelScreen(
						Board.MakeBoardFromTemplate(template, nextLevelName), currentScreen.getPreviousScreen());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lvlScreen.setVisible(true);
			lvlScreen.setTitle(nextLevelName);
			currentScreen.setVisible(false);
			System.out.println(name);		
		}
	}
}