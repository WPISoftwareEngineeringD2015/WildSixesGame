package kiviuq.views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

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
	JButton x;
	JButton swap;
	JButton reset;
	
	private static final String RESOURCE_RESET = "/kiviuq/views/reset.png";
	private static final String RESOURCE_SWAP = "/kiviuq/views/swap.png";
	private static final String RESOURCE_X = "/kiviuq/views/x.png";
	
	
	public SpecialButtonsView(RestartLevelController rlc) {
		super();
		setLayout(new GridLayout(1, 3,0,0));
		
		reset = CreateImageBtn(RESOURCE_RESET, rlc);
		swap = CreateImageBtn(RESOURCE_SWAP, null);
		x = CreateImageBtn(RESOURCE_X, null);
	}
	
	private JButton CreateImageBtn(String resources, ActionListener al) {
		JButton b = new JButton("");
		b.setBorderPainted(false); // makes it not look like a button
		b.setIcon(new ImageIcon(LevelScreen.class.getResource(resources)));
		b.addActionListener(al);
		add(b);
		return b;
	}
	
	public JButton getXLabel() {
		return x;
	}
	
	public JButton getSwapLabel() {
		return swap;
	}
	
	public JButton getResetLabel() {
		return reset;
	}
	
}
