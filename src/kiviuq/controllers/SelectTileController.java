package kiviuq.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import kiviuq.entities.Board;
import kiviuq.entities.MoveType;
import kiviuq.entities.Tile;
import kiviuq.views.BoardView;
import kiviuq.views.LevelScreen;
import kiviuq.views.TileView;

public class SelectTileController extends MouseAdapter {
	BoardView boardView;
	Board board;
	MoveType moveType;
	int x;
	int y;
	int lastX;
	int lastY;
	Tile tile;
	boolean waiting;
	LevelScreen levelScreen;

	public SelectTileController(LevelScreen levelScreen, BoardView boardView, int x, int y) {
		this.levelScreen = levelScreen;
		this.boardView = boardView;
		this.board = boardView.getBoard();
		this.x = x;
		this.y = y;
	}

	public void setWaiting(boolean bool) {
		waiting = bool;
	}

	private boolean isAdjacent() {
		lastX = board.getLastX();
		lastY = board.getLastY();

		if(lastX == -1 && lastY == -1) {
			return true;
		}

		if(x == lastX) {
			if(y == (lastY + 1) || y == (lastY - 1) ) {
				return true;
			}
		}

		if(y == lastY) {
			if(x == (lastX + 1) || x == (lastX - 1) ) {
				return true;
			}
		}

		return false;
	}

	private boolean isLastTile() {
		if(moveType == MoveType.Normal)
			if(board.getTileSum() >= 6)
				return true;

		if(moveType == MoveType.Swap)
			if(board.getTileCount() == 2)
				return true;

		return false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.board = boardView.getBoard();
		moveType = boardView.getBoard().getMoveType();
		if(!board.isMousePressed()) {
			board.pressMouse();
			board.increaseTileCount();
			TileView sourcePanel = (TileView) e.getSource();
			tile = sourcePanel.getTile();
			tile.select();
			sourcePanel.repaint();

			if(moveType == MoveType.Normal)
				board.addTileSum(tile.getNumber());
			if(moveType == MoveType.Remove) {
				board.releaseMouse();
				board.resetTileCount();
				board.resetTiles();
				boardView.repaintTiles();
				board.setLastX(-1);
				board.setLastY(-1);
				// stuff
				board.setMoveType(MoveType.Normal);
				new RemoveTileController(board, tile, levelScreen).actionPerformed(null);
			}else {
				board.setLastX(x);
				board.setLastY(y);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.board = boardView.getBoard();
		moveType = boardView.getBoard().getMoveType();
		if(board.isMousePressed()) {
			TileView sourcePanel = (TileView) e.getSource();
			tile = sourcePanel.getTile();
			if(!tile.isSelected()) {
				if(isAdjacent()) {
					board.increaseTileCount();
					tile.select();
					sourcePanel.repaint();

					if(moveType == MoveType.Normal) {
						board.addTileSum(sourcePanel.getTile().getNumber());
					}
					if(moveType == MoveType.Swap) {
						// stuff
					}

					if(isLastTile()) {
						if(moveType == MoveType.Normal) {
							// stuff
							board.resetTileSum();
						}
						if(moveType == MoveType.Swap) {
							// stuff
							new SwapTileController(board.getGrid()[lastX][lastY], tile, board, levelScreen).actionPerformed(null);
						}
						
						board.releaseMouse();
						board.resetTileCount();
						board.resetTiles();
						boardView.repaintTiles();
						boardView.repaint();
						board.setLastX(-1);
						board.setLastY(-1);
					}else {
						board.setLastX(x);
						board.setLastY(y);
					}
						
				}
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	//	@Override
	//	public void mouseMoved(MouseEvent e) {
	//		TileView sourcePanel = (TileView) e.getSource();
	//		if(isMousePressed) {
	//			sourcePanel.getTile().select();
	//			sourcePanel.repaint();
	//			board.addTileSum(sourcePanel.getTile().getNumber());
	//		}
	//	}
	//
	//	@Override
	//	public void mousePressed(MouseEvent e) {
	//		board.pressMouse();
	//		TileView sourcePanel = (TileView) e.getSource();
	//		tile = sourcePanel.getTile();
	//		tile.select();
	//		sourcePanel.repaint();
	//		board.setLastX(x);
	//		board.setLastY(y);
	//		board.addTileSum(tile.getNumber());
	//	}
	//
	//	@Override
	//	public void mouseReleased(MouseEvent e) {
	//		board.releaseMouse();
	//		TileView sourcePanel = (TileView) e.getSource();
	//		if(moveType == MoveType.Normal) {
	//			board.resetTileSum();
	//		}
	//		if(moveType == MoveType.Remove) {
	//			// stuff
	//		}
	//		if(moveType == MoveType.Swap) {
	//			// stuff
	//		}
	//		board.resetTiles();
	//		boardView.repaintTiles();
	//	}
}
