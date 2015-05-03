package kiviuq.entities;


public class Score {
	int levelNumber;
	int movesMade;
	int points;
	StarCriteria criteria;
	StarRating rating;
	
	/**
	 * Constructs a new Score.
	 */
	public Score(int levelNumber, int movesMade, int points, StarCriteria criteria) {
		this.levelNumber = levelNumber;
		this.movesMade = movesMade;
		this.points = points;
		this.criteria = criteria;
	}
	
	/**
	 * Returns level number.
	 * @return level number
	 */
	public int getLevelNumber() {
		return levelNumber;
	}
	
	/**
	 * Returns moves made.
	 * @return moves made
	 */
	public int getMovesMade() {
		return movesMade;
	}
	
	/**
	 * Returns current points.
	 * @return current points
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
	
}
