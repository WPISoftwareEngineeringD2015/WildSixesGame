package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kiviuq.entities.Board;
import kiviuq.views.BoardView;

public class RestartLevelController implements ActionListener {
	Board board;
	BoardView boardView;

	public RestartLevelController(Board board, BoardView boardView) {
		this.board = board;
		this.boardView = boardView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Board newBoard = new Board(boardView.getBoard().getTemplate());
		board.setGrid(newBoard.getGrid());
		board.increaseMovesMade();
		board.resetPoints();
		boardView.setBoard(board);
		boardView.repaint();
		}
}
