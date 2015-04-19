package kiviuq.entities;

public class Score {
	int levelNumber;
	int movesMade;
	int points;
	StarRating rating;
	
	public Score(int levelNumber, int movesMade, int points, StarRating rating) {
		this.levelNumber = levelNumber;
		this.movesMade = movesMade;
		this.points = points;
		this.rating = rating;
	}
	
	public int getLevelNumber() {
		return levelNumber;
	}
	
	public int getMovesMade() {
		return movesMade;
	}
	
	public int getPoints() {
		return points;
	}
	
	public StarRating getRating() {
		return rating;
	}
	
}
