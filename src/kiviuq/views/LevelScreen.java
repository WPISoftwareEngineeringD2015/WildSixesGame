package kiviuq.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kiviuq.controllers.ResetTilesController;
import kiviuq.controllers.RestartLevelController;
import kiviuq.controllers.SelectRemoveController;
import kiviuq.controllers.SelectSwapController;
import kiviuq.entities.Board;
import kiviuq.entities.GameMode;

/**
 * View class that is the main screen for a game of Sixes Wild. Contains Swing
 * controls, and a BoardView which is a custom component used to visibly
 * represent the game controls.
 * 
 * @author Evin Ugur
 */
public class LevelScreen extends JFrame {
	/**
	 * eclipse warning silencer
	 */
	private static final long serialVersionUID = 1L;
	JButton back;
	JButton restart;
	BoardView boardView;
	Board board;
	JFrame previousScreen;
	ScoreView scoreView;
	JLabel movesLeft;
	JLabel movesMade;
	SpecialButtonsView sbv;

	
	public LevelScreen(Board board, final JFrame previousScreen) {
		super();
		boardView = new BoardView(board, this);
		this.previousScreen = previousScreen;
		setTitle("Example Level Screen");
		setBounds(100, 100, 880, 715);
		setLocationRelativeTo(null);
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

		sbv = new SpecialButtonsView(new ResetTilesController(board, this),
				new SelectSwapController(board), new SelectRemoveController(
						board));
		panelTop.add(sbv);

		if (board.getMode() == GameMode.Elimination) {
			movesLeft = new JLabel("Moves Left: " + board.getMoveLimit());
			panelTop.add(movesLeft);
		} else {
			movesMade = new JLabel("Moves Made: " + board.getMovesMade());
			panelTop.add(movesMade);
		}

		JPanel panelGrid = new JPanel();
		panelGrid.setBounds(6, 89, 855, 585);
		getContentPane().add(panelGrid);
		panelGrid.setLayout(new BorderLayout(0, 0));

		this.restart = new JButton("Restart Level");
		restart.addActionListener(new RestartLevelController(board, this));

		this.back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				previousScreen.setVisible(true);
				LevelScreen.this.dispose();
			}
		});

		panelGrid.add(boardView, BorderLayout.CENTER);
		panelTop.add(restart);
		panelTop.add(back);

		this.board = board;
	}

	public ScoreView getScoreView() {
		return scoreView;
	}

	public BoardView getBoardView() {
		return boardView;
	}

	public SpecialButtonsView getSpecialButtonsView() {
		return sbv;
	}

	public void refreshMoves() {
		if (board.getMode() == GameMode.Elimination)
			movesLeft.setText("Moves Left: "
					+ (board.getMoveLimit() - board.getMovesMade()));
		else
			movesMade.setText("Moves Made: " + board.getMovesMade());
		repaint();
	}
}
