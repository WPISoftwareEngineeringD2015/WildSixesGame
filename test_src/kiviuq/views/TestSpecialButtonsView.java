package kiviuq.views;

import junit.framework.TestCase;

public class TestSpecialButtonsView extends TestCase{
	public void testImgResourceStrings() {
		SpecialButtonsView sbv = new SpecialButtonsView(null, null, null);
		sbv.setEnabled(false);
		assertFalse(sbv.getXLabel().isEnabled());
		assertFalse(sbv.getSwapLabel().isEnabled());
		assertFalse(sbv.getResetLabel().isEnabled());
		sbv.setEnabled(true);
		assertTrue(sbv.getXLabel().isEnabled());
		assertTrue(sbv.getSwapLabel().isEnabled());
		assertTrue(sbv.getResetLabel().isEnabled());
		
	}
}
