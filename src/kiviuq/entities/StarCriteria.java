package kiviuq.entities;

public class StarCriteria {
	int points;
	int movesMade;
	
	int points1, points2, points3;
	int movesMade1, movesMade2, movesMade3;
	
	public StarCriteria(int points, int movesMade, int points1, int points2, int points3, 
			int movesMade1, int movesMade2, int movesMade3) {
		this.points = points;
		this.movesMade = movesMade;
		this.points1 = points1;
		this.points2 = points2;
		this.points3 = points3;
		this.movesMade1 = movesMade1;
		this.movesMade2 = movesMade2;
		this.movesMade3 = movesMade3;
	}
	
	// TODO, so far it's only evident to the user that points are needed for Stars... see StarCriteriaView.java ...
	
	public int getPoints1() {
		return points1;
	}
	
	public int getPoints2() {
		return points2;
	}
	
	public int getPoints3() {
		return points3;
	}
	
	public StarRating getRating() {
		if (points >= points3 && movesMade <= movesMade3) return StarRating.ThreeStars;
		else if (points >= points2 && movesMade <= movesMade2) return StarRating.TwoStars;
		else if (points >= points1 && movesMade <= movesMade1) return StarRating.OneStar;
		return StarRating.NoStars;
	}
	
}
