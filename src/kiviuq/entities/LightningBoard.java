package kiviuq.entities;

public class LightningBoard extends Board{
	

	protected LightningBoard(LevelTemplate template) {
		super(template);
	}
	
	
	@Override
	public boolean hasWon() {
		return false; // TODO implement
	}
}
