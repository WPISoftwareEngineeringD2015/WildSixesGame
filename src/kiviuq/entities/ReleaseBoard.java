package kiviuq.entities;

public class ReleaseBoard extends Board{
	
	protected ReleaseBoard(LevelTemplate template) {
		super(template);
	}

	@Override
	public boolean hasWon() {
		return false; // TODO implement
	}
}
