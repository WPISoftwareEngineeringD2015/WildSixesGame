package kiviuq.entities;

import java.io.Serializable;

public class StarCriteria implements Serializable {

	/**
	 * Suppresses a warning in Eclipse.
	 */
	private static final long serialVersionUID = 1L;
	/** the actual score */
	int points;
	/** the actual amount of moves made */
	int movesMade;

	/** the amount of points for earning one star */
	int points1;
	/** the amount of points for earning two stars */
	int points2;
	/** the amount of points for earning three stars */
	int points3;
	/** mount of moves needed that can be made for earning one star */
	int movesMade1;
	/** mount of moves needed that can be made for earning two stars */
	int movesMade2;
	/** mount of moves needed that can be made for earning three stars */
	int movesMade3;

	/**
	 * Specified Constructor for StarCriteria
	 * 
	 * @param points1
	 *            points for earning one star
	 * @param points2
	 *            points for earning two stars
	 * @param points3
	 *            points for earning three stars
	 * @param movesMade1
	 *            amount of moves needed that can be made for earning one star
	 * @param movesMade2
	 *            amount of moves needed that can be made for earning two stars
	 * @param movesMade3
	 *            amount of moves needed that can be made for earning three
	 *            stars
	 */
	public StarCriteria(int points1, int points2, int points3, int movesMade1,
			int movesMade2, int movesMade3) {
		this.points1 = points1;
		this.points2 = points2;
		this.points3 = points3;
		this.movesMade1 = movesMade1;
		this.movesMade2 = movesMade2;
		this.movesMade3 = movesMade3;
	}

	/**
	 * Unspecified Constructor for StarCriteria
	 */
	public StarCriteria() {
		this(0,0,0,0,0,0);
	}

	// TODO, so far it's only evident to the user that points are needed for
	// Stars... see StarCriteriaView.java ...
	/**
	 * @return the amount of points for earning one star
	 */
	public int getPoints1() {
		return points1;
	}

	/**
	 * @return the amount of points for earning two stars
	 */
	public int getPoints2() {
		return points2;
	}

	/**
	 * @return the amount of points for earning three stars
	 */
	public int getPoints3() {
		return points3;
	}

}
