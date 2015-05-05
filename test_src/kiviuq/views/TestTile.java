package kiviuq.views;

import junit.framework.TestCase;
import kiviuq.entities.MoveType;
import kiviuq.entities.Tile;
import kiviuq.entities.TileType;

public class TestTile extends TestCase{
	
	Tile block;
	Tile nullTile;
	Tile releaseTile;
	Tile[] numTiles = { new Tile(1,1), new Tile(2,1), new Tile(3,1), new Tile(4,1), new Tile(5,1) } ;
	
	@Override
	protected void setUp() {
		block = Tile.NewBlockTile();
		nullTile = new Tile(TileType.Null);
		releaseTile = new Tile(TileType.Release);
	}
	
	public void testToString() { 
		assertTrue(block.toString().equals("6"));
		for (int i = 1; i < 6; i++) {
			assertTrue(new Tile(i, 1).toString().equals("" + i));
		}
	}
	
	public void testSelection() {
		assertTrue(block.isSelectable(MoveType.Swap));
		assertTrue(block.isSelectable(MoveType.Remove));
		assertFalse(block.isSelectable(MoveType.Normal));
		for (MoveType mt : MoveType.values()) {
			// these are NEVER selectable
			assertFalse(nullTile.isSelectable(mt));
			assertFalse(releaseTile.isSelectable(mt));
		}
		for (Tile num : numTiles) {
			assertTrue(num.isSelectable(MoveType.Remove));
			assertTrue(num.isSelectable(MoveType.Normal));
		}
	}
	
	
}
