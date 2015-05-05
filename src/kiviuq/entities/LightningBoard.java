package kiviuq.entities;

public class LightningBoard extends Board{
	
	/**
	 * Time limit for the Board.
	 */
	public int timeLimit;

	/**
	 * Constructs a new LightningBoard from template.
	 * @param template
	 * @param name 
	 */
	protected LightningBoard(LevelTemplate template, String name) {
		super(template, name);
		this.timeLimit = 0;
		this.timeLimit = template.timeLimit;
	}
	
	/**
	 * Returns the time limit of the Board.
	 * @return time limit
	 */
	@Override
	public int getTimeLimit() {
		return this.timeLimit;
	}
	
	/**
	 * Determines whether points are above lowest threshold.
	 * @return true if points > lowest StarCriteria
	 */
	@Override
	public boolean hasWon() {
		return (this.points >= this.starCriteria.getPoints1());
	}
	
	/**
	 * Stops all future moves on the Board.
	 * This method runs automatically when time >= time limit
	 */
	@Override
	public void stopMovement() {
			this.movesMade = this.moveLimit;
	}
	
}
