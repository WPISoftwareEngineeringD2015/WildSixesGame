package kiviuq.entities;

public class Tile {
	int number;
	int mult;
	TileType type;
	boolean isSelected;
	
	public Tile(int number) {
		this(number, TileType.Number);
	}
	
	public Tile(TileType type) {
		this(-1, type);
	}
	
	public Tile(int number, TileType type) {
		this.number = number;
		this.type = type;
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
		return "x";
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
		return number < 6;
	}
	
	public void unSelect() {
		isSelected = false;
	}
	
	public void toggleSelect() {
		isSelected = !isSelected;
	}
	
}
