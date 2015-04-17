package kiviuq.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import kiviuq.controllers.GravityController;
import kiviuq.entities.Board;

public class LevelScreen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Board board;
	JButton back;
	BoardView boardView;
	JFrame previousScreen;

	public LevelScreen(Board board, final JFrame previousScreen) {
		super();
		this.previousScreen = previousScreen;
		setTitle("Example Level Screen");
		setBounds(100, 100, 867, 715);
		setLocationRelativeTo(null);
		this.board = board;
		getContentPane().setLayout(null);

		JPanel panelTop = new JPanel();
		panelTop.setBounds(7, 6, 855, 82);
		getContentPane().add(panelTop);
		panelTop.setLayout(new GridLayout(1, 4, 5, 0));

		StarCriteriaView starCriteria = new StarCriteriaView(
				board.getStarCriteria());
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
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				previousScreen.setVisible(true);
				LevelScreen.this.dispose();
			}
		});

		boardView = new BoardView(board);
		panelGrid.add(boardView, BorderLayout.CENTER);
		JButton gravityTest = new JButton("gravity... test");
		gravityTest.addActionListener(new GravityController(board, boardView));
		panelTop.add(gravityTest);
		panelTop.add(back);

	}

}
