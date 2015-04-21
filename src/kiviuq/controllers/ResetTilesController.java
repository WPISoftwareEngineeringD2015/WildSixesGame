package kiviuq.controllers;

import java.awt.event.ActionEvent;

import kiviuq.entities.Board;
import kiviuq.views.LevelScreen;

public class ResetTilesController extends AbstractMoveController{
	
	public ResetTilesController(Board board, LevelScreen levelScreen) {
		super(board, levelScreen);
	}

	@Override
	public boolean handleMove(ActionEvent e) {
		// TODO Auto-generated method stub
		return true;
	}

}
