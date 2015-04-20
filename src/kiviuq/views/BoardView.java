package kiviuq.views;

import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JPanel;

import kiviuq.controllers.SelectTileController;
import kiviuq.entities.Board;
import kiviuq.entities.Tile;
import kiviuq.util.Constants;

public class BoardView extends JPanel {
	/**
	 * auto-generated by Eclipse
	 */
	private static final long serialVersionUID = 1L;
	
	Board board;
	LevelScreen levelScreen;
	TileView[][] tvs;
	public BoardView(Board board, LevelScreen levelScreen) {
		super();
		this.board = board;
		this.levelScreen = levelScreen;
		tvs = new TileView[Constants.BOARD_LENGTH][Constants.BOARD_WIDTH];
		setLayout(new GridLayout(Constants.BOARD_LENGTH, Constants.BOARD_WIDTH, 10, 10));
		Tile[][] grid = board.getGrid();
		for (int x = 0; x < Constants.BOARD_LENGTH; x++) {
			for (int y = 0; y < Constants.BOARD_WIDTH; y++) {
				int X = x;
				int Y = y;
				tvs[x][y] = new TileView(grid[x][y]);
				tvs[x][y].addMouseListener(new SelectTileController(levelScreen, BoardView.this, X, Y));
				add(tvs[x][y]);
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Tile[][] grid = board.getGrid();
		for (int x = 0; x < Constants.BOARD_LENGTH; x++) {
			for (int y = 0; y < Constants.BOARD_WIDTH; y++) {
				tvs[x][y].setTile(grid[x][y]);
			}
		}
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public void repaintTiles() {
		for (TileView[] r : tvs) 
			for (TileView t : r) {
				t.repaint();
			}
				
	}
}
