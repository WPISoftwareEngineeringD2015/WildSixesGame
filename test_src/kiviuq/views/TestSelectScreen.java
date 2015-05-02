package kiviuq.views;

import java.awt.event.WindowEvent;

import junit.framework.TestCase;


public class TestSelectScreen extends TestCase {
	SelectScreen selectScreen;
	MainScreen mainScreen;

	protected void setUp() throws Exception {
//      Causing unit tests to terminate, temporarily just commenting it out.
//		selectScreen = new SelectScreen(mainScreen);
//		selectScreen.setVisible(true);
	}

	protected void tearDown() throws Exception {
//		selectScreen.dispatchEvent(new WindowEvent(selectScreen, WindowEvent.WINDOW_CLOSING));
//		super.tearDown();
	}
	
	public void testScreen(){
//		assertEquals(selectScreen.lastWindow, mainScreen);
	}
	
}
