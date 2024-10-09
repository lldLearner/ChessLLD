package Pieces;

import Board.Board;
import Board.Move;
import Enums.Color;
import Enums.PieceType;

public abstract class Piece {

	private PieceType symbol;
	private Color color;
	private int movedAmount = 0;

	public Piece(PieceType symbol, Color color) {
		super();
		this.symbol = symbol;
		this.color = color;
	}

	public PieceType getSymbol() {
		return symbol;
	}

	public Color getColor() {
		return color;
	}

	public boolean validMove(Move move) {
		// TODO Auto-generated method stub
		Board b = Board.getBoard();
		if (b.outOfRange(move)) {
			return false;
		}

		if (b.isSpotEmpty(move.getStartSpot())) {
			return false;
		}

		// Todo -> Override .equals for move
		if (move.getStartSpot().getRow() == move.getEndSpot().getRow()
				&& move.getStartSpot().getCol() == move.getEndSpot().getCol()) {
			return false;
		}

		return true;
	}

	public void incrementMove() {
		// TODO Auto-generated method stub
		movedAmount++;
	}
	
	public void decrementMove() { 
		movedAmount--;
	}

	public boolean isMoved() {
		// TODO Auto-generated method stub
		return movedAmount != 0;
	}

	public void makeMove(Move move) {
		Board b = Board.getBoard();
		Piece pieceAtEndSpot = b.getPiece(move.getEndSpot());
		if (pieceAtEndSpot != null && pieceAtEndSpot.getColor() != this.getColor()) {
			b.addCapturedPieces(pieceAtEndSpot);
		}

		b.setPiece(move.getEndSpot(), this);
		b.setPiece(move.getStartSpot(), null);
		incrementMove();
	}
}
