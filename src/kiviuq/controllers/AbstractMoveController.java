package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kiviuq.entities.Board;
import kiviuq.views.LevelScreen;

public abstract class AbstractMoveController implements ActionListener {

	protected Board board;
	protected LevelScreen levelScreen;

	public AbstractMoveController(Board board, LevelScreen levelScreen) {
		this.board = board;
		this.levelScreen = levelScreen;
	}

	@Override
	public final void actionPerformed(ActionEvent e) {
		if (handleMove(e)) {
			board.increaseMovesMade();
			levelScreen.getBoardView().repaint();
			levelScreen.getScoreView().repaint();
		}
	}

	public abstract boolean handleMove(ActionEvent e);

}
