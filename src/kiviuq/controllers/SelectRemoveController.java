package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kiviuq.entities.Board;
import kiviuq.entities.MoveType;

/**
 * This controller will set the {@link Board}'s {@link MoveType} to
 * {@link MoveType#Remove}.
 * 
 * @author Gabe Bell
 *
 */
public class SelectRemoveController implements ActionListener {
	/** entity object */
	Board board;

	/**
	 * Stores model. There's no view to update, so this controller only takes a
	 * reference to an entity.
	 * 
	 * @param board
	 *            the model
	 */
	public SelectRemoveController(Board board) {
		this.board = board;
	}

	/** 
	 * Sets the {@link MoveType}.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		board.setMoveType(MoveType.Remove);
	}

}
