package kiviuq.entities;

public class Score {
	int levelNumber;
	int movesMade;
	int points;
	StarCriteria criteria;
	StarRating rating;
	
	public Score(int levelNumber, int movesMade, int points, StarCriteria criteria) {
		this.levelNumber = levelNumber;
		this.movesMade = movesMade;
		this.points = points;
		this.criteria = criteria;
		// TODO: write code to determine rating
		//this.rating = .........
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
