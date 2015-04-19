package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kiviuq.entities.Board;
import kiviuq.views.BoardView;

public abstract class AbstractMoveController implements ActionListener {

	protected Board board;
	protected BoardView boardView;

	public AbstractMoveController(Board board, BoardView boardView) {
		this.board = board;
		this.boardView = boardView;
	}

	@Override
	public final void actionPerformed(ActionEvent e) {
		if (handleMove(e)) {
			board.increaseMovesMade();
			boardView.repaint();
		}
	}

	public abstract boolean handleMove(ActionEvent e);

}
