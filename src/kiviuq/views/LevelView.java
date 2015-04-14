package kiviuq.views;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import kiviuq.entities.Board;

public class LevelView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Board board;
	JButton back;
	public LevelView(Board board) {
		super();
		setTitle("Example Level Screen");
		setBounds(100, 100, 867, 715);
		setLocationRelativeTo(null);
		this.board = board;
		
		// TODO figure out the needed layout for this...
		
		JPanel grid = new BoardView(board);
		JPanel starCriteria = new StarCriteriaView(board.getStarCriteria());
		JPanel scoreView = new ScoreView(board);
		back = new JButton("Back");
		back.setSize(76, 65);
		getContentPane().add(starCriteria, BorderLayout.NORTH);
		getContentPane().add(grid, BorderLayout.CENTER);
/*
		getContentPane().add(scoreView);
		getContentPane().add(back);
*/
	}
	
	
}
