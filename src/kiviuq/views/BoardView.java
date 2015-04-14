package kiviuq.views;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import kiviuq.entities.Board;
import kiviuq.entities.Tile;
import kiviuq.util.Constants;

public class BoardView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Board board;
	
	public BoardView(Board board) {
		super();
		this.board = board;
		setLayout(new GridLayout(Constants.BOARD_LENGTH, Constants.BOARD_WIDTH, 3, 3));
		Tile[][] grid = board.getGrid();
		for (Tile[] rows : grid) {
			for (Tile t : rows) {
				add(new TileView(t));
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
}
