package kiviuq.views;

import junit.framework.TestCase;


public class TestSelectScreen extends TestCase {
	SelectScreen selectScreen;
	MainScreen mainScreen;

	protected void setUp() throws Exception {
		selectScreen = new SelectScreen(mainScreen);
		selectScreen.setVisible(true);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testScreen(){
		assertSame(selectScreen.lastWindow, mainScreen);
	}
}
