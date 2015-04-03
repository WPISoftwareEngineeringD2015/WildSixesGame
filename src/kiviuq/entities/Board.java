package kiviuq.entities;

import java.util.HashMap;
import java.util.Map;

import kiviuq.util.Constants;

public class Board {
	Map<Location, Tile> grid = new HashMap<Location, Tile>();
	Map<Location, Boolean> eliminatedTiles = new HashMap<Location, Boolean>();
	int movesMade;
	int timePassed; 
	int points;
	public Board(LevelTemplate template) {
		for (int x = 0; x < Constants.BOARD_LENGTH; x++) {
			for (int y = 0; y < Constants.BOARD_WIDTH; y++) { 
				Location l = new Location(x, y);
				grid.put(l, null);
				eliminatedTiles.put(l, false);
			}
		}
	}
	
	public void increaseTimePassed() {
		// TODO 
	}
	
	public void increaseMovesMade() {
		movesMade++;
	}
	
}
