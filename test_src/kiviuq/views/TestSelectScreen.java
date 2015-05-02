package kiviuq.views;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;

import junit.framework.TestCase;


public class TestSelectScreen extends TestCase {
	SelectScreen selectScreen;
	MainScreen mainScreen;

	protected void setUp() throws Exception {
		mainScreen = new MainScreen();
		selectScreen = new SelectScreen(mainScreen);
		selectScreen.setVisible(true);
		
	}

	protected void tearDown() throws Exception {
		mainScreen.dispatchEvent(new WindowEvent(mainScreen, WindowEvent.WINDOW_CLOSING));
		super.tearDown();
	}
	
	public void testScreen() throws InterruptedException{
		JPanel testPanel = selectScreen.elimination1Panel;
		MouseEvent me = new MouseEvent(testPanel, 0, 100, 0, 0, 0, 0, false);
		for(MouseListener ml: testPanel.getMouseListeners()){
			ml.mouseClicked(me);
		}
		
		Thread.sleep(100);
		assertFalse(selectScreen.isVisible());
	}
}
