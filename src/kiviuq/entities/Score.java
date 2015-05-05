package kiviuq.entities;


public class Score{
	/**
	 * 
	 */
	int points;
	StarRating rating;
	
	/**
	 * Constructs a new Score
	 * with input points and rating.
	 */
	public Score(int points, StarRating rating) {
		this.points = points;
		this.rating = rating;
	}
	
	/**
	 * Constructs a new Score.
	 */
	public Score() {
		this.points = 0;
		this.rating = StarRating.NoStars;
	}
	
	/**
	 * Returns points.
	 * @return points
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Returns rating.
	 * @return rating
	 */
	public StarRating getRating() {
		return rating;
	}
	
	public final static String TXT0 = "0 Stars";
	public final static String TXT1 = "1 Star";
	public final static String TXT2 = "2 Stars";
	public final static String TXT3 = "3 Stars";
	
	public static String ScoreHTMLFormat(int points, String ratingText) {
		return String.format("<html><body>HIGH SCORE<br>Points: %d<br>Rating: %s</body></html>", points, ratingText);
	}
	
	public String getHighScoreText() {
		String ratingText = "";
		if(rating == StarRating.NoStars)
			ratingText = TXT0;
		if(rating == StarRating.OneStar)
			ratingText = TXT1;
		if(rating == StarRating.TwoStars)
			ratingText = TXT2;
		if(rating == StarRating.ThreeStars)
			ratingText = TXT3;
		String highScoreText =
				ScoreHTMLFormat(points, ratingText);
		return highScoreText;
	}
}
