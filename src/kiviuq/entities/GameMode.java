package kiviuq.entities;

/**
<<<<<<< HEAD
 * Enum used to represent the state of the Game. This is used when reading input
 * from the LevelBuilder. The ideal way to determine what kind of {@link Board}
 * a Board is, is to simply use instanceof to check if your Board is a
 * {@link LightningBoard}, {@link ReleaseBoard}, {@link EliminationBoard} or an
 * {@link PuzzleBoard}.
 * 
 * @author Evin Ugur
 *
 */
public enum GameMode {
	/** Represents a {@link PuzzleBoard} from the LevelBuilder */
	Puzzle,
	/** Represents an {@link EliminationBoard} from the LevelBuilder */
	Elimination,
	/** Represents an {@link LightningBoard} from the LevelBuilder */
	Lightning,
	/** Represents an {@link ReleaseBoard} from the LevelBuilder */
	Release;
}
