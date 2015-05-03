package kiviuq.entities;

import java.io.Serializable;

public class StarCriteria implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int points;
	int movesMade;
	
	int points1, points2, points3;
	int movesMade1, movesMade2, movesMade3;
	
	public StarCriteria(int points1, int points2, int points3, 
			int movesMade1, int movesMade2, int movesMade3) {
		this.points1 = points1;
		this.points2 = points2;
		this.points3 = points3;
		this.movesMade1 = movesMade1;
		this.movesMade2 = movesMade2;
		this.movesMade3 = movesMade3;
	}
	
	public StarCriteria() {
		this.points1 = 0;
		this.points2 = 0;
		this.points3 = 0;
		this.movesMade1 = 0;
		this.movesMade2 = 0;
		this.movesMade3 = 0;
	}
	
	// TODO, so far it's only evident to the user that points are needed for Stars... see StarCriteriaView.java ...
	/**
	 * get method for int points1
	 * @return int points1
	 */
	public int getPoints1() {
		return points1;
	}
	
	/**
	 * get method for int points2
	 * @return int points2
	 */
	public int getPoints2() {
		return points2;
	}
	
	/**
	 * get method for int points3
	 * @return int points3
	 */
	public int getPoints3() {
		return points3;
	}
	
	/**
	 * set method for int points1
	 * @param i value to set int points1 attribute to
	 */
	public void setPoints1(int i) {
		this.points1 = i;
	}
	
	/**
	 * set method for int points2
	 * @param i value to set int points2 attribute to
	 */
	public void setPoints2(int i) {
		this.points2 = i;
	}
	
	/**
	 * set method for int points3
	 * @param i value to set int points3 attribute to
	 */
	public void setPoints3(int i) {
		this.points3 = i;
	}
	
	/**
	public StarRating getRating() {
		if (points >= points3 && movesMade <= movesMade3) return StarRating.ThreeStars;
		else if (points >= points2 && movesMade <= movesMade2) return StarRating.TwoStars;
		else if (points >= points1 && movesMade <= movesMade1) return StarRating.OneStar;
		return StarRating.NoStars;
	}
	*/
	
}
