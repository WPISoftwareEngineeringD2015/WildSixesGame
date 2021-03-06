package kiviuq.views;

import java.awt.event.WindowEvent;

import junit.framework.TestCase;


public class TestSplashScreen extends TestCase {
	SplashScreen splashScreen;
	MainScreen mainScreen;

	protected void setUp() throws Exception {
		mainScreen = new MainScreen();
		splashScreen = new SplashScreen(1000, mainScreen);
		splashScreen.setVisible(true);
	}

	protected void tearDown() throws Exception {
		splashScreen.dispatchEvent(new WindowEvent(splashScreen, WindowEvent.WINDOW_CLOSING));
		super.tearDown();
	}
	
	public void testScreen(){
		assertSame(splashScreen.nextWindow, mainScreen);
		assertEquals(splashScreen.duration_ms, 1000);
	}
	
	public void testLaunch() {
		assertFalse(mainScreen.isVisible());
		splashScreen.launchSplashScreen();
		assertTrue(mainScreen.isVisible());
	}
	

	
	
}
