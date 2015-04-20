package kiviuq.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import kiviuq.controllers.RestartLevelController;
import kiviuq.controllers.SelectRemoveController;
import kiviuq.controllers.SelectSwapController;
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
	ScoreView scoreView;

	public LevelScreen(Board board, final JFrame previousScreen) {
		super();
		boardView = new BoardView(board, this);
		this.previousScreen = previousScreen;
		setTitle("Example Level Screen");
		setBounds(100, 100, 867, 715);
		setLocationRelativeTo(null);
		this.board = board;
		getContentPane().setLayout(null);

		JPanel panelTop = new JPanel();
		panelTop.setBounds(7, 6, 855, 82);
		getContentPane().add(panelTop);
		panelTop.setLayout(new GridLayout(1, 3, 5, 0));

		StarCriteriaView starCriteria = new StarCriteriaView(
				board.getStarCriteria());
		panelTop.add(starCriteria);

		scoreView = new ScoreView(board);
		panelTop.add(scoreView);

		SpecialButtonsView sbv = new SpecialButtonsView(
				new RestartLevelController(board, this),
				new SelectSwapController(board),
				new SelectRemoveController(board));
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

		
		panelGrid.add(boardView, BorderLayout.CENTER);
		panelTop.add(back);
	}
	
	public ScoreView getScoreView() {
		return scoreView;
	}
	
	public BoardView getBoardView() {
		return boardView;
	}

}
