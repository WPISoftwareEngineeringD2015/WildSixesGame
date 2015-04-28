package kiviuq.entities;

public class LightningBoard extends Board{
	

	protected LightningBoard(LevelTemplate template) {
		super(template);
	}
	
	
	@Override
	public boolean hasWon() {
		return (this.points >= this.starCriteria.getPoints1());
	}
}
