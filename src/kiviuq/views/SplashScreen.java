package kiviuq.views;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

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
		setTitle("Sixes Wild");
		setSize(750, 450);
		setLocationRelativeTo(null); // centers
		this.duration_ms = duration_ms;
		this.nextWindow = nextWindow;
		getContentPane().setLayout(null);
		
		JLabel lblSixesWild = new JLabel("Sixes Wild - Team Kiviuq");
		lblSixesWild.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblSixesWild.setBounds(10, 11, 408, 68);
		getContentPane().add(lblSixesWild);
		
		JLabel lblTeamNames = new JLabel("<html>Alyssa Graham<br>Jackson Oliva<br>Molly Homchenko<br>Gabriel Bell<br>Evin Ugur</html>");
		lblTeamNames.setBounds(10, 73, 127, 108);
		getContentPane().add(lblTeamNames);
	}
	
	public void launchSplashScreen() {
		setVisible(true);
		try {
			Thread.sleep(duration_ms);
		} catch (Exception e) {System.err.println("Could not sleep in splash screen");}
		nextWindow.setVisible(true);
		dispose();
	}
}
