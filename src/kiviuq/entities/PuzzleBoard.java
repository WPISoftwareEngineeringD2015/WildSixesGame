package kiviuq.entities;

public class PuzzleBoard extends Board {

	/**
	 * Constructs a new PuzzleBoard from template.
	 * 
	 * @param template
	 *            the LevelTemplate to pass into {@link Board}'s constructor.
	 */
	protected PuzzleBoard(LevelTemplate template) {
		super(template);
	}

	/**
	 * Determines whether points are above lowest threshold.
	 * 
	 * @return true if points > lowest StarCriteria
	 */
	@Override
	public boolean hasWon() {
		return (this.points >= this.starCriteria.getPoints1());
	}

}
