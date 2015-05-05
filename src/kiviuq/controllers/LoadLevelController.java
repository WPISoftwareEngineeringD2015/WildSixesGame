package kiviuq.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;

import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import kiviuq.views.LevelScreen;
import kiviuq.views.SelectScreen;

public class LoadLevelController extends MouseAdapter{
	private LevelTemplate template = new LevelTemplate();
	private LevelScreen lvlScreen;
	private JFrame selectScreen;
	private String name;

	public LoadLevelController(String name, JFrame selectScreen) throws FileNotFoundException {
		this.selectScreen = (SelectScreen) selectScreen;
		this.name = name;

		// this block of code looks crazy, but it seems to be
		// necessary for relative class path to work
	    File file = 
	    		new File(getClass().getClassLoader()
	    				.getResource("LevelTemplates/" + name).toString().replaceAll("%20", " "));
		String[] tempString;
		String fileString = file.toString();
		tempString = fileString.split(":", 2);
		FileInputStream fileInput = new FileInputStream(tempString[1]);

		try {
			ObjectInputStream in;
			in = new ObjectInputStream(fileInput);
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
		
//		((SelectScreen) this.selectScreen).puzzle1Label.setText(template...);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		lvlScreen = new LevelScreen(Board.MakeBoardFromTemplate(template, name), selectScreen);
		lvlScreen.setVisible(true);
		selectScreen.setVisible(false);
		System.out.println(name);
	}
}
