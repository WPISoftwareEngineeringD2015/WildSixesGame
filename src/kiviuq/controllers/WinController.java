package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import kiviuq.entities.Board;
import kiviuq.views.LevelScreen;

public class WinController implements ActionListener {

	Board board;
	LevelScreen levelScreen;

	public WinController(Board board, LevelScreen levelScreen) {
		this.board = board;
		this.levelScreen = levelScreen;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (board.hasWon()) {
			JOptionPane.showConfirmDialog(levelScreen.getBoardView(), "Congratulations on Winning!");
			levelScreen.exitGame();
		}
	}

}
