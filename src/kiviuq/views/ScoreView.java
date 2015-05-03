package kiviuq.views;

import java.awt.Graphics;

import javax.swing.JPanel;

import kiviuq.entities.Board;
import javax.swing.JLabel;

public class ScoreView extends JPanel{

	/**
	 * auto-generated by eclipse
	 */
	private static final long serialVersionUID = 1L;
	Board board;
	JLabel lblScoreDisplay;
	public ScoreView(Board board) {
		super();
		this.board = board;
		
		JLabel lblScore = new JLabel("Score:");
		add(lblScore);
		
		this.lblScoreDisplay = new JLabel("Score Display");
		add(lblScoreDisplay);
	}

	/**
	 * Properly paints component to display updated score.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.lblScoreDisplay.setText("" + board.getPoints());
	}
	
}
