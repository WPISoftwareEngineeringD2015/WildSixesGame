package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kiviuq.entities.Board;
import kiviuq.views.BoardView;

public class RestartLevelController implements ActionListener {
	/*
	 * TODO ALSO RESET SCORE INFORMATION
	 */
	BoardView boardView;

	public RestartLevelController(BoardView boardView) {
		this.boardView = boardView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		    Board newBoard = new Board(boardView.getBoard().getTemplate());
			boardView.setBoard(newBoard);
			boardView.repaint();
		}
}
