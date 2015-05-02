package kiviuq.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import development.Templates;
import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import kiviuq.views.LevelScreen;
import kiviuq.views.SelectScreen;

public class LoadLevelController extends MouseAdapter{
	private LevelTemplate template;
	private LevelScreen lvlScreen;
	private SelectScreen selectScreen;
	private String name;

	public LoadLevelController(String name, SelectScreen selectScreen) {
		this.selectScreen = selectScreen;
		this.name = name;

		if(name == "puzzle 1") {
			template = Templates.getExampleTemplatePuzzle();
		}

		else if(name == "elimination 1") {
			template = Templates.getExampleTemplateElimination();
		}

		else if(name == "lightning 1") {
			template = Templates.getExampleTemplateLightning();
		}

		else if(name == "release 1") {
			template = Templates.getExampleTemplateRelease();
		}

		// THIS ELSE STATEMENT FOR TESTING ONLY
		else {
			template = Templates.getExampleTemplateLightning();
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