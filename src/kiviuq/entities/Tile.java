package kiviuq.entities;

public class Tile {
	int number;
	int mult;
	TileType type;
	boolean isSelected;
	
	public Tile(int number, int mult) {
		this(number, mult, TileType.Number);
	}
	
	public Tile(TileType type) {
		this(-1, 1, type);
	}
	
	public Tile(int number, int mult, TileType type) {
		this.number = number;
		this.mult = mult;
		this.type = type;
	}
	
	public static Tile MakeTile(TileType t) {
		return null;
	}
	
	public int getMultiplier() {
		return mult;
	}
	
	public int getNumber() {
		return number;
	}
	
	public TileType getType() {
		return type;
	}
	
	@Override 
	public String toString() {
		String str = "";
		switch (type) {
			default: break;
			case Number:
				str = number + "";
			case Null:
				break;
			case Release:
				str = "R";
		}
		return str;
	}
	
	public String multToString() {
		String multStr = "";
		if (type == TileType.Number && number != 6 && mult > 1	) {
			multStr = "x" + mult;
		}
		return multStr;
	}
	
	public boolean isSelected() {
		return isSelected;
	}
	
	public void select() {
		isSelected = true;
	}
	
	public boolean isSelectable(MoveType moveType) {
		if (type == TileType.Release || type == TileType.Null) return false;
		// MoveType.Remove can Remove any Tile of type Number
		if (moveType == MoveType.Remove) return true;
		return number < 6 || moveType == MoveType.Swap;
	}
	
	public void unSelect() {
		isSelected = false;
	}
	
	public void toggleSelect() {
		isSelected = !isSelected;
	}
	
	public boolean isBlock() {
		return type == TileType.Number && number == 6;
	}
	
}
