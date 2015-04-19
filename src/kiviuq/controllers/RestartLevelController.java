package kiviuq.controllers;

import java.awt.event.ActionEvent;

import kiviuq.entities.Board;
import kiviuq.views.LevelScreen;

public class RestartLevelController extends AbstractMoveController {
	
	public RestartLevelController(Board board, LevelScreen levelScreen) {
		super(board, levelScreen);
	}

	@Override
	public boolean handleMove(ActionEvent e) {
		Board newBoard = new Board(levelScreen.getBoardView().getBoard().getTemplate());
		board.setGrid(newBoard.getGrid());
		board.resetPoints();
		return true;
	}
}
