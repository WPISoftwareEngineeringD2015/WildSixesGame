package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kiviuq.entities.Board;
import kiviuq.views.BoardView;

public class RestartLevelController extends AbstractMoveController {
	
	public RestartLevelController(Board board, BoardView boardView) {
		super(board, boardView);
	}

	@Override
	public boolean handleMove(ActionEvent e) {
		Board newBoard = new Board(boardView.getBoard().getTemplate());
		board.setGrid(newBoard.getGrid());
		board.resetPoints();
		return true;
	}
}
