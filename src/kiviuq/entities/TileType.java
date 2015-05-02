package kiviuq.entities;

/**
 * Used by the {@link LevelTemplate} class to store what Tiles will be loaded
 * where in the game.
 * 
 * @author Evin Ugur
 *
 */
public enum TileType {
	/** Represents that a Tile will be a Number from 1-5 */
	Number,
	/** Represents that a Tile will be a NullTile (grayed out) */
	Null,
	/**
	 * Represents that a Tile will be a ReleaseTile for games that use
	 * {@link ReleaseBoard}
	 */
	Release,
	/**
	 * Represents that a Tile will be a NumberTile with the value of 6.
	 * Constructued {@link Tile} objects will have a TileType of {@link #Number}
	 * , this is only used when initially laying out the Board. If you want to
	 * see if a given {@link Tile} object is a Block simply use
	 * {@link Tile#isBlock()}.
	 */
	Block;
}
