package kiviuq.entities;

public class Tile {
	int number;
	TileType type;
	
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
	
}
