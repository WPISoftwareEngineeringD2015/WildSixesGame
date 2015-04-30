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

	public SelectTileController(LevelScreen levelScreen, BoardView boardView,
			int x, int y) {
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

		if (lastX == -1 && lastY == -1) {
			return true;
		}

		if (x == lastX) {
			if (y == (lastY + 1) || y == (lastY - 1)) {
				return true;
			}
		}
		if (y == lastY) {
			if (x == (lastX + 1) || x == (lastX - 1)) {
				return true;
			}
		}

		return false;
	}

	public boolean isLastTile() {
		if (moveType == MoveType.Normal)
			if (board.getTileSum() >= 6)
				return true;

		if (moveType == MoveType.Swap)
			if (board.getTileCount() == 2)
				return true;

		return false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		moveType = boardView.getBoard().getMoveType();
		if(board.getMovesMade() >= board.getMoveLimit()) {
			return;
		}
		if (!board.isMousePressed()) {
			levelScreen.getSpecialButtonsView().setEnabled(false);
			TileView sourcePanel = (TileView) e.getSource();
			tile = sourcePanel.getTile();
			if (!tile.isSelectable(moveType)){
				levelScreen.getSpecialButtonsView().setEnabled(true);
				return;
			}
				
			// all board logic below this point
			board.pressMouse();
			board.increaseTileCount();
			tile.select();
			System.out.println("SelectTileController: Reached tile.select().");
			sourcePanel.repaint();

			if (moveType == MoveType.Normal)
				board.addTileSum(tile.getNumber());
			if (moveType == MoveType.Remove) {
				board.releaseMouse();
				board.resetTileCount();
				board.unselectTiles();
				boardView.repaintTiles();
				board.setLastX(-1);
				board.setLastY(-1);
				// stuff
				board.setMoveType(MoveType.Normal);
				new RemoveTileController(board, tile, levelScreen)
						.actionPerformed(null);
				levelScreen.refreshMoves();
			} else {
				board.setLastX(x);
				board.setLastY(y);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		moveType = boardView.getBoard().getMoveType();
		if (board.isMousePressed()) {
			TileView sourcePanel = (TileView) e.getSource();
			tile = sourcePanel.getTile();
			if(tile.isSelected()) {
				board.setLastX(x);
				board.setLastY(y);
				return;
			}
			if (tile.isSelectable(moveType)) {
				if (isAdjacent()) {
					board.increaseTileCount();
					tile.select();
					sourcePanel.repaint();

					if (moveType == MoveType.Normal) {
						board.addTileSum(sourcePanel.getTile().getNumber());
					}
					if (moveType == MoveType.Swap) {
						// stuff
					}

					if (isLastTile()) {
						levelScreen.getSpecialButtonsView().setEnabled(true);
						if (moveType == MoveType.Normal) {
							if (board.getTileSum() == 6) // else ignore move
								new ValidMoveController(board, levelScreen)
										.actionPerformed(null);
							board.resetTileSum();
						}
						if (moveType == MoveType.Swap) {
							// stuff
							new SwapTileController( board.getGrid()[lastX][lastY], tile, board,levelScreen)
								.actionPerformed(null);
							board.setMoveType(MoveType.Normal);
						}
						reset();
					} else {
						board.setLastX(x);
						board.setLastY(y);
					}

				}
			}
			// tile is NOT selectable
			else reset();
		}
	}
	private void reset() {
		levelScreen.getSpecialButtonsView().setEnabled(true);
		board.releaseMouse();
		board.resetTileCount();
		board.unselectTiles();
		boardView.repaintTiles();
		boardView.repaint();
		board.setLastX(-1);
		board.setLastY(-1);
	}
}
