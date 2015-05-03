package kiviuq.views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import kiviuq.controllers.ResetTilesController;
import kiviuq.controllers.SelectRemoveController;
import kiviuq.controllers.SelectSwapController;

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
	
	/**
	 * Creates a new SpecialButtonsView with its controllers integrated.
	 * @param rtc
	 * @param ssc
	 * @param src
	 */
	public SpecialButtonsView(ResetTilesController rtc, SelectSwapController ssc, SelectRemoveController src) {
		super();
		setLayout(new GridLayout(1, 3,0,0));
		
		reset = CreateImageBtn(RESOURCE_RESET, rtc);
		swap = CreateImageBtn(RESOURCE_SWAP, ssc);
		x = CreateImageBtn(RESOURCE_X, src);
	}
	
	/**
	 * Allows to button to be painted with an image.
	 * @param resources
	 * @param al
	 * @return
	 */
	private JButton CreateImageBtn(String resources, ActionListener al) {
		JButton b = new JButton("");
		b.setBorderPainted(false); // makes it not look like a button
		b.setIcon(new ImageIcon(LevelScreen.class.getResource(resources)));
		b.addActionListener(al);
		add(b);
		return b;
	}
	
	/**
	 * Returns the Eliminate Tile Label.
	 * @return XLabel
	 */
	public JButton getXLabel() {
		return x;
	}
	
	/**
	 * Returns the Swap Tile Label
	 * @return SwapLabel
	 */
	public JButton getSwapLabel() {
		return swap;
	}
	
	/**
	 * Returns the Reset Tiles Label
	 * @return ResetLabel
	 */
	public JButton getResetLabel() {
		return reset;
	}
	
	/**
	 * Sets all the buttons of the SpecialTileView as enabled.
	 */
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		x.setEnabled(enabled);
		swap.setEnabled(enabled);
		reset.setEnabled(enabled);
	}
	
}
