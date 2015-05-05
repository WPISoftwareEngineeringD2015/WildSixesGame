package kiviuq.views;

import junit.framework.TestCase;
import kiviuq.entities.Score;
import kiviuq.entities.StarRating;

public class TestScore extends TestCase{
	
	public void testHighScoreTexts() {
		int points = 2;
		Score one = new Score(points, StarRating.OneStar);
		Score two = new Score(points, StarRating.TwoStars);
		Score three = new Score(points, StarRating.ThreeStars);
		assertTrue(Score.ScoreHTMLFormat(points, Score.TXT1).equals(one.getHighScoreText()));
		assertTrue(Score.ScoreHTMLFormat(points, Score.TXT2).equals(two.getHighScoreText()));
		assertTrue(Score.ScoreHTMLFormat(points, Score.TXT3).equals(three.getHighScoreText()));
		
	}
	
	public void testNoParamConstructorScore() {
		Score s = new Score();
		assertEquals(0, s.getPoints());
		assertEquals(StarRating.NoStars, s.getRating());
		assertTrue(s.getHighScoreText().equals(Score.ScoreHTMLFormat(s.getPoints(), Score.TXT0)));
	}
}
