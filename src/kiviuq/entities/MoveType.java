package kiviuq.entities;

/**
 * Enumeration determining type of Move.
 */
public enum MoveType {
	/** Represents a normal move, (i.e. the user is selecting Tiles) */
	Normal,
	/** Represents a Swap move in which the user is switching two Tiles */
	Swap,
	/**
	 * Represents a Remove move in which the user is erasing a Tile from the
	 * Board
	 */
	Remove,
}
