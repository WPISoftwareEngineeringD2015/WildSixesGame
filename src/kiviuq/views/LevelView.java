package kiviuq.views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import kiviuq.entities.Board;

public class LevelView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Board board;

	public LevelView(Board board) {
		super();
		this.board = board;
		
		JPanel grid = new BoardView(board);
		JPanel starCriteria = new StarCriteriaView(board.getStarCriteria());
		getContentPane().add(starCriteria, BorderLayout.NORTH);
		getContentPane().add(grid, BorderLayout.CENTER);
	}
	
	
}
