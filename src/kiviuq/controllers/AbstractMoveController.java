package kiviuq.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kiviuq.entities.Board;
import kiviuq.entities.ReleaseBoard;
import kiviuq.views.LevelScreen;

/**
 * This class is responsible for factoring out some functionality of Controller
 * classes that are associated to in-game moves.
 * 
 * Since this class is an ActionListener and is abstract, implementing the
 * appropriate method ({@link AbstractMoveController#handleMove(ActionEvent)})
 * will be all that is needed for subclasses of this class to do as all
 * Swing-work is handled in the implemented
 * {@link AbstractMoveController#actionPerformed(ActionEvent)} method.
 * 
 * This class allows subclasses to be less verbose as common game logic is
 * handled in the scope of this class.
 * 
 * @author Evin Ugur
 * 
 */
public abstract class AbstractMoveController implements ActionListener {

	/**
	 * Board entity object for subclasses to access as needed.
	 */
	protected Board board;
	/**
	 * LevelScreen boundary object for subclasses to access as needed.
	 */
	protected LevelScreen levelScreen;

	/**
	 * Stores needed objects for this controller. Since this is the only
	 * constructor subclasses are forced to supply them upwards.
	 * 
	 * @param board
	 *            Board entity object for subclasses to access as needed.
	 * @param levelScreen
	 *            boundary object for subclasses to access as needed.
	 */
	public AbstractMoveController(Board board, LevelScreen levelScreen) {
		this.board = board;
		this.levelScreen = levelScreen;
	}

	/**
	 * This function will call
	 * {@link AbstractMoveController#handleMove(ActionEvent)} and depending on
	 * that result, will update game information and redraw the needed view
	 * components.
	 */
	@Override
	public final void actionPerformed(ActionEvent e) {
		if(board.getMovesMade() < board.getMoveLimit()) {
			if (handleMove(e)) {
				if (board instanceof ReleaseBoard) 
					new ReleaseTileController(board, levelScreen.getBoardView()).actionPerformed(e);
				board.increaseMovesMade();
				levelScreen.refreshMoves();
				levelScreen.getBoardView().repaint();
				levelScreen.getScoreView().repaint();
				levelScreen.getSpecialButtonsView().setEnabled(true);
				levelScreen.repaint();
				new WinController(board, levelScreen).actionPerformed(e);
			}
		}
	}

	/**
	 * Subclasses are responsible for implementing this method which is
	 * essentially a proxy for ActionListener's actionPerformed(ActionEvent)
	 * 
	 * This function should never be called and is called in this class's
	 * actionPerformed implementation. This allows different moves in game to be
	 * performed without having to redundantly update views/increase moves being
	 * made, etc.
	 * 
	 * @param e
	 *            A reference to actionPerformed's ActionEvent in case the
	 *            subclass needs it
	 * @return true if the move was valid and is ready to be performed, false
	 *         otherwise.
	 */
	public abstract boolean handleMove(ActionEvent e);

}
