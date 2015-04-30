package kiviuq.views;

import junit.framework.TestCase;


public class TestSplashScreen extends TestCase {
	SplashScreen splashScreen;
	MainScreen mainScreen;

	protected void setUp() throws Exception {
		splashScreen = new SplashScreen(1000, splashScreen);
		splashScreen.setVisible(true);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testScreen(){
		assertSame(splashScreen.nextWindow, mainScreen);
		assertEquals(splashScreen.duration_ms, 1000);
	}
	

	
	
}
