package kiviuq.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import development.Templates;
import kiviuq.entities.Board;
import kiviuq.entities.GameMode;
import kiviuq.entities.LevelTemplate;
import kiviuq.views.LevelScreen;
import kiviuq.views.SelectScreen;

public class LoadLevelController extends MouseAdapter{
	private LevelTemplate template = new LevelTemplate();
	private LevelScreen lvlScreen;
	private SelectScreen selectScreen;
	private String name;

	public LoadLevelController(String name, SelectScreen selectScreen) throws FileNotFoundException {
		this.selectScreen = selectScreen;
		this.name = name;

		// this block of code looks crazy, but it seems to be
		// necessary for relative class path to work
		File file = new File(getClass().getClassLoader().getResource("LevelTemplates/" + name).toString());
		String[] tempString;
		String fileString = file.toString();
		tempString = fileString.split(":", 2);
		FileInputStream fileInput = new FileInputStream(tempString[1]);

		try {
			ObjectInputStream in;
			in = new ObjectInputStream(fileInput);
			template = (LevelTemplate) in.readObject();
			//			template.setGameMode( ((LevelTemplate) in.readObject()).getGameMode() );
			//			template.setLevelNumber( ((LevelTemplate) in.readObject()).getLevelNumber() );
			//			template.setGrid( ((LevelTemplate) in.readObject()).getGridTemplate() );
			//			template.setTimeLimit( ((LevelTemplate) in.readObject()).getTimeLimit() );
			//			template.setMoveLimit( ((LevelTemplate) in.readObject()).getMoveLimit() );
			//			template.setStarCriteria( ((LevelTemplate) in.readObject()).getStarCriteria() );
			//			template.setProbConst( ((LevelTemplate) in.readObject()).getProbConst() );
			//			template.setMultConst( ((LevelTemplate) in.readObject()).getMultConst() );
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
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template), selectScreen);
		lvlScreen.setVisible(true);
		selectScreen.setVisible(false);
		System.out.println(name);
	}
}


/* OLD VERSION */
//public class LoadLevelController extends MouseAdapter{
//	private LevelTemplate template;
//	private LevelScreen lvlScreen;
//	private SelectScreen selectScreen;
//	private String name;
//
//	public LoadLevelController(String name, SelectScreen selectScreen) {
//		this.selectScreen = selectScreen;
//		this.name = name;
//
//		if(name == "puzzle 1") {
//			template = Templates.getExampleTemplatePuzzle();
//		}
//
//		else if(name == "elimination 1") {
//			template = Templates.getExampleTemplateElimination();
//		}
//
//		else if(name == "lightning 1") {
//			template = Templates.getExampleTemplateLightning();
//		}
//
//		else if(name == "release 1") {
//			template = Templates.getExampleTemplateRelease();
//		}
//
//		// THIS ELSE STATEMENT FOR TESTING ONLY
//		else {
//			template = Templates.getExampleTemplateLightning();
//		}
//	}
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template), selectScreen);
//		lvlScreen.setVisible(true);
//		selectScreen.setVisible(false);
//		System.out.println(name);
//	}
//}