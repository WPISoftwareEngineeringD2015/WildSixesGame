package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kiviuq.entities.Board;
import kiviuq.entities.MoveType;

public class SelectSwapController implements ActionListener {
	Board board;
	
	public SelectSwapController(Board board) {
		this.board = board;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		board.setMoveType(MoveType.Swap);
	}

}
