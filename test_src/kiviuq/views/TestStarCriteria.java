package kiviuq.views;

import junit.framework.TestCase;
import kiviuq.entities.StarCriteria;
import kiviuq.entities.StarRating;

public class TestStarCriteria extends TestCase{
	public void testStarRank() {
		StarCriteria sc = new StarCriteria(10, 20, 30);
		assertEquals(StarRating.NoStars, sc.getStarRating(0));
		assertEquals(StarRating.OneStar, sc.getStarRating(11));
		assertEquals(StarRating.TwoStars, sc.getStarRating(21));
		assertEquals(StarRating.ThreeStars, sc.getStarRating(50));
	}
}
