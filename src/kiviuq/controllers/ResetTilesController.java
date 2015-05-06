package kiviuq.controllers;

import java.awt.event.ActionEvent;

import kiviuq.entities.Board;
import kiviuq.views.LevelScreen;

/**
 * This controller will scramble number tiles for when players get stuck. Since
 * it abides to {@link AbstractMoveController}, it only has to implement
 * controller specific logic.
 * 
 * @author Gabe Bell
 *
 */
public class ResetTilesController extends AbstractMoveController {

	/**
	 * Passes in model and view to {@link AbstractMoveController}
	 * 
	 * @param board
	 *            model
	 * @param levelScreen
	 *            view
	 */
	public ResetTilesController(Board board, LevelScreen levelScreen) {
		super(board, levelScreen);
	}

	/**
	 * Resets grid
	 * 
	 * @return this function will always return true, the grid can never not be
	 *         reset!
	 */
	@Override
	public boolean handleMove(ActionEvent e) {
		board.resetGrid();
		return true;
	}

}
