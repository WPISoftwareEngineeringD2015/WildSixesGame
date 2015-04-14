package kiviuq.entities;

public class Tile {
	int number;
	TileType type;
	
	
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
