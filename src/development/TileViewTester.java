package development;

import javax.swing.JFrame;

import kiviuq.entities.Tile;
import kiviuq.entities.TileType;
import kiviuq.views.TileView;

public class TileViewTester extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TileViewTester() {
		Tile t = new Tile(5, 1, TileType.Number);
		setSize(900, 700);
		TileView tv = new TileView(t);
		getContentPane().add(tv);
		getContentPane().add(new TileView(new Tile(2, 1, TileType.Number)));
	}
	public static void main(String[] args) {
		TileViewTester t = new TileViewTester();
		t.setVisible(true);
	}
}
