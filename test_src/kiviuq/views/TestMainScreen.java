package kiviuq.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import junit.framework.TestCase;

public class TestMainScreen extends TestCase {
	SplashScreen splashScreen;
	MainScreen mainScreen;

	protected void setUp() throws Exception {
		mainScreen = new MainScreen();
		mainScreen.setVisible(true);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testScreen(){
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				mainScreen.goToSelectScreen();
			}
		};
		listener.actionPerformed(null);
		
		assertTrue(!mainScreen.isVisible());
//		assertEquals(splashScreen.duration_ms, 1000);
	}
}
