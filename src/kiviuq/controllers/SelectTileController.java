package kiviuq.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import kiviuq.entities.Board;
import kiviuq.entities.MoveType;
import kiviuq.views.BoardView;
import kiviuq.views.TileView;

public class SelectTileController implements MouseListener {
	BoardView boardView;
	MoveType moveType;
	boolean isMousePressed;

	public SelectTileController(BoardView boardView) {
		this.boardView = boardView;
		this.moveType = boardView.getBoard().getMoveType();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		TileView sourcePanel = (TileView) e.getSource();
		if(isMousePressed) {
			sourcePanel.getTile().select();
			sourcePanel.repaint();
			boardView.getBoard().addTileSum(sourcePanel.getTile().getNumber());
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		isMousePressed = true;
		TileView sourcePanel = (TileView) e.getSource();
		sourcePanel.getTile().select();
		sourcePanel.repaint();
		boardView.getBoard().addTileSum(sourcePanel.getTile().getNumber());
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
//		isMousePressed = false;
		TileView sourcePanel = (TileView) e.getSource();
		if(moveType == MoveType.Normal) {
			// stuff
		}
		if(moveType == MoveType.Remove) {
			// stuff
		}
		if(moveType == MoveType.Swap) {
			// stuff
		}
		boardView.getBoard().resetTileSum();
		boardView.getBoard().resetTiles();
		boardView.repaintTiles();
	}
}
