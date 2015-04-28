package kiviuq.entities;

public class PuzzleBoard extends Board{

	protected PuzzleBoard(LevelTemplate template) {
		super(template);
	}
	
	@Override
	public boolean hasWon() {
		return (this.points >= this.starCriteria.getPoints1());
	}


}
