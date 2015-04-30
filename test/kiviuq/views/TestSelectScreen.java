package kiviuq.views;

import junit.framework.TestCase;


public class TestSelectScreen extends TestCase {
	SelectScreen selectScreen;

	protected void setUp() throws Exception {
		selectScreen = new SelectScreen(selectScreen);
		selectScreen.setVisible(true);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
