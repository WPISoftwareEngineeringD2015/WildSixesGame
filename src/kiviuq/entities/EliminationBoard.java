package kiviuq.entities;

public class EliminationBoard extends Board{
	
	protected EliminationBoard(LevelTemplate template) {
		super(template);
	}
	
	@Override
	public boolean hasWon() {
		return false; // TODO implement
	}
}
