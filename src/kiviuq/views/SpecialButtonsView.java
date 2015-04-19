package kiviuq.views;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kiviuq.controllers.RestartLevelController;

public class SpecialButtonsView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel x;
	JLabel swap;
	JButton reset;
	
	public SpecialButtonsView(RestartLevelController rlc) {
		super();
		setLayout(new GridLayout(1, 3,0,0));
		reset = new JButton("");
		reset.setBorderPainted(false);
		reset.setIcon(new ImageIcon(LevelScreen.class.getResource("/kiviuq/views/reset.png")));
		reset.addActionListener(rlc);
		
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
	
	public JButton getResetLabel() {
		return reset;
	}
	
}
