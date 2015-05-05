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
	
	public String getHighScoreText() {
		String ratingText = "";
		if(rating == StarRating.NoStars)
			ratingText = "0 Stars";
		if(rating == StarRating.OneStar)
			ratingText = "1 Star";
		if(rating == StarRating.TwoStars)
			ratingText = "2 Stars";
		if(rating == StarRating.ThreeStars)
			ratingText = "3 Stars";
		String highScoreText =
				String.format("<html><body>HIGH SCORE<br>Points: %d<br>Rating: %s</body></html>", points, ratingText);
		return highScoreText;
	}
}
