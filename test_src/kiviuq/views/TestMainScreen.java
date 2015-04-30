package kiviuq.views;

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
		assertSame(mainScreen., mainScreen);
		assertEquals(splashScreen.duration_ms, 1000);
	}
