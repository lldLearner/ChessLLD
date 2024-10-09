package Pieces;

import Board.Board;
import Board.Move;
import Board.Spot;
import Enums.Color;
import Enums.PieceType;

public class Pawn extends Piece {

	public Pawn(PieceType symbol, Color color) {
		super(symbol, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validMove(Move move) {
		// TODO Auto-generated method stub
		return super.validMove(move) && pawnMoveValid(move);
	}

	public boolean pawnMoveValid(Move move) {
		Spot startSpot = move.getStartSpot();
		Spot endSpot = move.getEndSpot();
		Board board = Board.getBoard();
		int dx = endSpot.getRow() - startSpot.getRow();
		int dy = endSpot.getCol() - startSpot.getCol();
		Piece pieceAtStartSpot = board.getPiece(startSpot);
		Piece pieceAtEndspot = board.getPiece(endSpot);
		if (board.isSpotEmpty(endSpot)) {
			// +1 move
			if ((pieceAtStartSpot.getColor() == Color.WHITE && dx == 1 && dy == 0)
					|| (pieceAtStartSpot.getColor() == Color.BLACK && dx == -1 && dy == 0)) {
				return true;
			}

			if (!pieceAtStartSpot.isMoved() && ((pieceAtStartSpot.getColor() == Color.WHITE && dx == 2 && dy == 0
					&& board.isSpotEmpty(new Spot(startSpot.getRow() + 1, startSpot.getCol())))
					|| (pieceAtStartSpot.getColor() == Color.BLACK && dx == -2 && dy == 0
							&& board.isSpotEmpty(new Spot(startSpot.getRow() - 1, startSpot.getCol()))))) {
				return true;
			}
		} else {
			if ((pieceAtStartSpot.getColor() == Color.WHITE && dx == 1 && Math.abs(dy) == 1)
					|| (pieceAtStartSpot.getColor() == Color.BLACK && dx == -1 && Math.abs(dy) == 1)) {
				if (pieceAtEndspot.getColor() != pieceAtStartSpot.getColor()) {
					return true;
				}
			}
		}

		return false;
	}
}
