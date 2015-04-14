package kiviuq.views;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import kiviuq.entities.Tile;

public class TileView extends JPanel{

	/**
	 * Auto-generated by eclipse to suppress a warning
	 */
	private static final long serialVersionUID = 1L;
	Tile tile;
	JLabel lblValue;
	
	public TileView(Tile tile) {
		super();
		this.tile = tile;
		setSize(50,50);
		
		this.lblValue = new JLabel("VALUE");
		lblValue.setBounds(44, 42, 46, 14);
		add(lblValue);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		setBackground(getColor());
		lblValue.setText("" + tile.getNumber());
	}
	
	private final static Color[] NUMBER_COLORS = {Color.ORANGE, Color.CYAN, Color.GREEN, Color.RED, Color.YELLOW, Color.BLUE};
	
	Color getColor() {
		boolean breakPoint = true;
		switch (tile.getType()) {
		case Null:
			return Color.gray;
		case Number:
			int num = tile.getNumber();
			return NUMBER_COLORS[num];
		case Relase:
			return Color.PINK;
		default:
			return Color.BLACK;
		}
	}
}
