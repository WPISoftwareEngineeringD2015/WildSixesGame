package kiviuq.entities;

import kiviuq.util.Constants;

public class Board {
	Tile[][] grid;
	boolean[][] eliminatedTiles; // should move to subclass later?
	int movesMade;
	int timePassed; 
	int points;
	public Board(LevelTemplate template) {
		grid =  new Tile[Constants.BOARD_LENGTH][Constants.BOARD_WIDTH];
		eliminatedTiles = new boolean[Constants.BOARD_LENGTH][Constants.BOARD_WIDTH];
	}
	
	public void increaseTimePassed() {
		// TODO 
	}
	
	public void increaseMovesMade() {
		movesMade++;
	}
	
}
