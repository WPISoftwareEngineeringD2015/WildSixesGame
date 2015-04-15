package kiviuq.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kiviuq.entities.Board;

public class LevelScreen extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Board board;
	JButton back;
	JFrame previousScreen;
	public LevelScreen(Board board) {
		super();
		setTitle("Example Level Screen");
		setBounds(100, 100, 867, 715);
		setLocationRelativeTo(null);
		this.board = board;
		getContentPane().setLayout(null);
		
		JPanel panelTop = new JPanel();
		panelTop.setBounds(6, 6, 855, 82);
		getContentPane().add(panelTop); 
		panelTop.setLayout(new GridLayout(1, 4, 5, 0));
		
		StarCriteriaView starCriteria = new StarCriteriaView(board.getStarCriteria());
		panelTop.add(starCriteria);
		
		ScoreView scoreView = new ScoreView(board);
		panelTop.add(scoreView);
		
		SpecialButtonsView sbv = new SpecialButtonsView();
		panelTop.add(sbv);
		
		JPanel panelGrid = new JPanel();
		panelGrid.setBounds(6, 89, 855, 585);
		getContentPane().add(panelGrid);
		panelGrid.setLayout(new BorderLayout(0, 0));

		

		this.back = new JButton("Back");
		panelTop.add(back);
		
		
		
		BoardView boardView = new BoardView(board);
		panelGrid.add(boardView, BorderLayout.CENTER); 
		
		
		// TODO figure out the needed layout for this...
/*	
		JPanel grid = new BoardView(board);
		JPanel starCriteria = new StarCriteriaView(board.getStarCriteria());
		JPanel scoreView = new ScoreView(board);
		
		getContentPane().add(starCriteria, BorderLayout.NORTH);
		getContentPane().add(grid, BorderLayout.CENTER);

		getContentPane().add(scoreView);
		getContentPane().add(back);
*/
	}
}
