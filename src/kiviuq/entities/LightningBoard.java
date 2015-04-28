package kiviuq.entities;

public class LightningBoard extends Board{
	
	public int timeLimit;

	protected LightningBoard(LevelTemplate template) {
		super(template);
		this.timeLimit = template.timeLimit;
	}
	
	@Override
	public int getTimeLimit() {
		return this.timeLimit;
	}
	
	@Override
	public boolean hasWon() {
		return (this.points >= this.starCriteria.getPoints1());
	}
}
