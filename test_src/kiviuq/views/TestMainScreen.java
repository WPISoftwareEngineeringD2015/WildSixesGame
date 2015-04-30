package kiviuq.views;

import junit.framework.TestCase;

public class TestMainScreen extends TestCase {
	MainScreen main;

	protected void setUp() throws Exception {
		main = new MainScreen();
		main.setVisible(true);		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
