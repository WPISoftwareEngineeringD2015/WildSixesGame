package kiviuq.views;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SpecialButtonsView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel x;
	JLabel swap;
	JLabel reset;
	
	public SpecialButtonsView() {
		super();
		setLayout(new GridLayout(1, 3,0,0));
		reset = new JLabel("");
		reset.setIcon(new ImageIcon(LevelScreen.class.getResource("/kiviuq/views/reset.png")));
		
		swap = new JLabel("");
		swap.setIcon(new ImageIcon(LevelScreen.class.getResource("/kiviuq/views/swap.png")));
		
		x = new JLabel("");
		x.setIcon(new ImageIcon(LevelScreen.class.getResource("/kiviuq/views/x.png")));
		
		add(x);
		add(swap);
		add(reset);
		
	}
	
	public JLabel getXLabel() {
		return x;
	}
	
	public JLabel getSwapLabel() {
		return swap;
	}
	
	public JLabel getResetLabel() {
		return reset;
	}
	
}
