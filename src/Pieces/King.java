package Pieces;

import Board.Board;
import Board.Move;
import Board.Spot;
import Enums.Color;
import Enums.PieceType;

public class King extends Piece {

	public King(PieceType symbol, Color color) {
		super(symbol, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validMove(Move move) {
		// TODO Auto-generated method stub
		return super.validMove(move) && validKing(move);
	}

	public boolean validKing(Move move) {
		Spot startSpot = move.getStartSpot();
		Spot endSpot = move.getEndSpot();
		Board board = Board.getBoard();

		Piece piece = board.getPiece(move.getStartSpot());
		Piece pieceAtEndSpot = board.getPiece(move.getEndSpot());
		int startR = startSpot.getRow();
		int endR = endSpot.getRow();

		int startC = startSpot.getCol();
		int endC = endSpot.getCol();

		int dR = endR - startR;
		int dC = endC - startC;

		if ((dR == 1 && dC == 0) || (dR == -1 && dC == 0) || (dC == 1 && dR == 0) || (dC == -1 && dR == 0)
				|| (dC == 1 && dR == 1) || (dC == -1 && dR == 1) || (dC == 1 && dR == -1) || (dC == -1 && dR == -1)) {
			if (pieceAtEndSpot != null && piece.getColor() == pieceAtEndSpot.getColor()) {
				return false;
			} else {
				return true;
			}
		}

		return false;
	}
}
