package kiviuq.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import kiviuq.controllers.FinishLevelController;
import kiviuq.controllers.ResetTilesController;
import kiviuq.controllers.RestartLevelController;
import kiviuq.controllers.SelectRemoveController;
import kiviuq.controllers.SelectSwapController;
import kiviuq.entities.Board;
import kiviuq.entities.EliminationBoard;
import kiviuq.entities.LightningBoard;
import kiviuq.entities.Score;
import kiviuq.entities.StarRating;

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
	/** Button used to navigate to the previous window */
	JButton back;
	/** Button used to completely restart the level */
	JButton restart;
	/** Button used to complete a level a document the current score */
	JButton finish;
	/** Reference to the boundary class that visualizes a {@link Board}'s Tiles. */
	BoardView boardView;
	/** Reference to the entity object that represents the game state */
	Board board;
	/** Reference to the previous screen. */
	JFrame previousScreen;
	/**
	 * Label used to display the amount of time left when using a
	 * {@link LightningBoard}.
	 */
	JLabel timeLeft;
	/** Component used to represent a {@link Board}'s score */
	ScoreView scoreView;
	/** Label used to display the amount of moves left */
	JLabel movesLeft;
	/** Label used to display the amount of moves made */
	JLabel movesMade;
	
	JLabel highScoreLabel;
	/**
	 * Component used to contain a pre-formatted View that lets the user invoke
	 * Special Moves
	 */
	SpecialButtonsView sbv;
	/** The amount of time played. */
	int time;
	/** A Timer object to keep track of time when needed */
	Timer timer;

	/**
	 * Constructs a new LevelScreen.
	 * 
	 * @param board
	 *            the entity object that represents game state
	 * @param previousScreen
	 *            the Screen that {@link LevelScreen#back} will display when
	 *            clicked
	 */
	public LevelScreen(Board board, final JFrame previousScreen) {
		super();
		boardView = new BoardView(board, this);
		this.previousScreen = previousScreen;
		setTitle("Example Level Screen");
		setBounds(100, 100, 972, 715);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		JPanel panelTop = new JPanel();
		panelTop.setBounds(7, 6, 950, 82);
		getContentPane().add(panelTop);
		int panelTopCol = 4;
		if (board instanceof LightningBoard) {
			panelTopCol++;
			timer = new Timer(1000, new ActionListener() {
				// Executes code per second
				public void actionPerformed(ActionEvent e) {
					if (LevelScreen.this.board.getTimePassed() < LevelScreen.this.board
							.getTimeLimit()) {
						LevelScreen.this.board.increaseTimePassed();
						LevelScreen.this.refreshTime();
					} else {
						LevelScreen.this.board.stopMovement();
						LevelScreen.this.timer.stop();
					}
				}
			});
			timer.setInitialDelay(1000);
			timer.start();
			timeLeft = new JLabel("Timer: "
					+ (board.getTimeLimit() - board.getTimePassed()));
		}
		panelTop.setLayout(new GridLayout(1, panelTopCol, 5, 0));

		StarCriteriaView starCriteria = new StarCriteriaView(
				board.getStarCriteria());
		panelTop.add(starCriteria);

		scoreView = new ScoreView(board);
		panelTop.add(scoreView);

		if (board instanceof LightningBoard)
			panelTop.add(timeLeft);

		sbv = new SpecialButtonsView(new ResetTilesController(board, this),
				new SelectSwapController(board), new SelectRemoveController(
						board));
		panelTop.add(sbv);

		if (board instanceof EliminationBoard) {
			movesLeft = new JLabel("Moves Left: " + board.getMoveLimit());
			panelTop.add(movesLeft);
		} else {
			movesMade = new JLabel("Moves Made: " + board.getMovesMade());
			panelTop.add(movesMade);
		}

		JPanel panelGrid = new JPanel();
		panelGrid.setBounds(6, 89, 950, 585);
		getContentPane().add(panelGrid);
		panelGrid.setLayout(new BorderLayout(0, 0));
		
		this.finish = new JButton("Finish Level");
		this.finish.setEnabled(false);
		finish.addActionListener(new FinishLevelController(board, this));
		
		this.restart = new JButton("Restart Level");
		restart.addActionListener(new RestartLevelController(board, this));

		this.back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LevelScreen.this.exitGame();
			}
		});

		int highScorePoints = board.getTemplate().getHighScorePoints();
		StarRating highScoreRating = board.getTemplate().getHighScoreRating();
		Score highScore = new Score(highScorePoints, highScoreRating);
		highScoreLabel = new JLabel(highScore.getHighScoreText());
		
		panelGrid.add(boardView, BorderLayout.CENTER);
		panelTop.add(finish);
		panelTop.add(restart);
		panelTop.add(back);
		panelTop.add(highScoreLabel);
		

		this.board = board;
	}

	/**
	 * Returns the screen the game was previously on.
	 * 
	 * @return previous screen
	 */
	public JFrame getPreviousScreen() {
		return previousScreen;
	}

	/**
	 * Retrieves the ScoreView of this LevelScreen
	 * 
	 * @return ScoreView
	 */
	public ScoreView getScoreView() {
		return scoreView;
	}

	/**
	 * Returns the Timer Label
	 * 
	 * @return timeLeftLabel
	 */
	public JLabel getTimeLeftLabel() {
		return timeLeft;
	}

	/**
	 * Returns the BoardView
	 * 
	 * @return BoardView
	 */
	public BoardView getBoardView() {
		return boardView;
	}

	/**
	 * Returns the views for the Special Buttons
	 * 
	 * @return SpecialButtonsView
	 */
	public SpecialButtonsView getSpecialButtonsView() {
		return sbv;
	}

	/**
	 * Updates screen to show current number of Moves
	 */
	public void refreshMoves() {
		if (board instanceof EliminationBoard)
			movesLeft.setText("Moves Left: "
					+ (board.getMoveLimit() - board.getMovesMade()));
		else {
			movesMade.setText("Moves Made: " + board.getMovesMade());
		}
		repaint();
	}

	/**
	 * Updates screen to show proper amount of time left. Automatically called
	 * every second on Lightning levels.
	 */
	public void refreshTime() {
		if (board instanceof LightningBoard) {
			timeLeft.setText("Timer: "
					+ (board.getTimeLimit() - board.getTimePassed()));
		}
	}

	/**
	 * Refreshes the BoardView.
	 */
	public void refreshBoardView() {
		boardView = new BoardView(board, this);
	}

	/**
	 * Exits the LevelScreen and returns to previous screen.
	 */
	public void exitGame() {
		previousScreen.setVisible(true);
		// TODO probably save some stuff here
		this.dispose();
	}
	
	public JButton getFinishButton() {
		return this.finish;
	}

}
