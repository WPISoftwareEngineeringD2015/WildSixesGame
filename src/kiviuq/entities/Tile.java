package kiviuq.entities;

import kiviuq.views.TileView;

/**
 * Represents a singular Tile of any given type that is on a Board.
 * 
 * @author Evin Ugur
 *
 */
public class Tile {
	/** The number associated with this Tile, if any */
	int number;
	/** The multiplier associated with this Tile, if any */
	int mult;
	/** The {@link TileType type} of this Tile. */
	TileType type;
	/** Flag for indicating if the Tile is selected */
	boolean isSelected;

	/**
	 * Constructor for easily making new Number Tiles
	 * 
	 * @param number
	 *            the number value of the new Tile
	 * @param mult
	 *            the multiplier
	 */
	public Tile(int number, int mult) {
		this(number, mult, TileType.Number);
	}

	/**
	 * Constructor for easily making new non-Number Tiles
	 * 
	 * @param type
	 *            the type associated with the new Tile
	 */
	public Tile(TileType type) {
		this(-1, 1, type);
	}

	/**
	 * Constructor for verbosely making a Tile, this is called by the other Tile
	 * constructors
	 * 
	 * @param number
	 *            the number value of the new Tile
	 * @param mult
	 *            the multiplier
	 * @param type
	 *            the type associated with the new Tile
	 */
	public Tile(int number, int mult, TileType type) {
		this.number = number;
		this.mult = mult;
		this.type = type;
	}

	/**
	 * Convenience function to properly construct a block Tile
	 * 
	 * @return
	 */
	public static Tile NewBlockTile() {
		return new Tile(6, 1);
	}

	/**
	 * @return the multiplier for this Tile
	 */
	public int getMultiplier() {
		return mult;
	}

	/**
	 * The numerical value for this Tile.
	 * 
	 * @return The Tile's numerical value, or -1 if it does not have one.
	 */
	public int getNumber() {
		return number;
	}

	public void setType(TileType type) {
		this.type = type;
		if (type == TileType.Number) this.number =1; // doesn't matter for Lb
	}

	/**
	 * @return the {@link TileType} of the Tile.
	 */
	public TileType getType() {
		return type;
	}

	/**
	 * Generates a String representation of a Tile. Rendered on
	 * {@link TileView#getMainLabel()}.
	 */
	@SuppressWarnings("incomplete-switch")
	@Override
	public String toString() {
		String str = "";
		switch (type) {
		case Number:
			str = number + "";
			break;
		case Null:
			break;
		case Release:
			str = "R";
			break;
		}
		return str;
	}

	/**
	 * A String representation of a Multiplier. Used in {@link TileView} for
	 * displaying the multiplier value.
	 * 
	 * @return String representation of a Multiplier
	 */
	public String multToString() {
		String multStr = "";
		if (type == TileType.Number && number != 6 && mult > 1) {
			multStr = "x" + mult;
		}
		return multStr;
	}

	/**
	 * @return true if the Tile is selected
	 */
	public boolean isSelected() {
		return isSelected;
	}

	/**
	 * Sets a Tile to be selected.
	 */
	public void select() {
		isSelected = true;
	}

	/**
	 * Checks to see if this Tile is selectable given in the context of a given
	 * Game Move.
	 * 
	 * @param moveType
	 *            the move being performed.
	 * @return true if the Tile is selectable, false it otherwise. A Tile is
	 *         selectable if its {@link Tile#type} is {@link TileType#Number}
	 *         and the Move being performed is {@link MoveType#Remove} or
	 *         {@link MoveType#Swap} or the Tile's {@link Tile#number} is less
	 *         than 6.
	 */
	public boolean isSelectable(MoveType moveType) {
		if (type == TileType.Release || type == TileType.Null)
			return false;
		// MoveType.Remove can Remove any Tile of type Number
		if (moveType == MoveType.Remove)
			return true;
		return number < 6 || moveType == MoveType.Swap;
	}

	/**
	 * Sets a Tile to not be selected
	 */
	public void unSelect() {
		isSelected = false;
	}

	/**
	 * Convenience function to determine if a Tile is a block.
	 * 
	 * @return true if the Tile is a block, false otherwise
	 */
	public boolean isBlock() {
		return type == TileType.Number && number == 6;
	}

}
