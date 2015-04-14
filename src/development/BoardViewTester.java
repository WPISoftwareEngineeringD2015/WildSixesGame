package development;

import javax.swing.JFrame;

import kiviuq.entities.Board;
import kiviuq.entities.LevelTemplate;
import kiviuq.views.BoardView;

public class BoardViewTester extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BoardView bv;
	
	public BoardViewTester() {
		LevelTemplate lt = Templates.getExampleTemplate();
		setSize(2000, 2000);
		bv = new BoardView(new Board(lt));
		getContentPane().add(bv);
	}
	
	public static void main(String[] args) {
		BoardViewTester bvt = new BoardViewTester();
		bvt.setVisible(true);
	}
}
