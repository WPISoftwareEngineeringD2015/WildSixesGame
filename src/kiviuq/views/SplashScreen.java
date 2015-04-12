package kiviuq.views;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class SplashScreen extends JFrame{

	/**
	 * Auto-generated by eclipse to suppress a warning
	 */
	private static final long serialVersionUID = 1L;
	
	int duration_ms;
	JFrame nextWindow;
	
	public SplashScreen(int duration_ms, JFrame nextWindow) {
		super();
		setResizable(false);
		setTitle("Sixes Wild -- Loading");
		setSize(750, 450);
		setLocationRelativeTo(null); // centers
		this.duration_ms = duration_ms;
		this.nextWindow = nextWindow;
		
		JLabel lblSixesWild = new JLabel("Sixes Wild!!!!!!!!!!!!");
		getContentPane().add(lblSixesWild, BorderLayout.CENTER);
	}
	
	public void launchSplashSreen() {
		setVisible(true);
		try {
			Thread.sleep(duration_ms);
		} catch (Exception e) {System.err.println("Could not sleep in splash screen");}
		nextWindow.setVisible(true);
		dispose();
	}
	
	
}