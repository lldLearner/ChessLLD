package Pieces;

import Board.Board;
import Board.Move;
import Board.Spot;
import Enums.Color;
import Enums.PieceType;

public class Horse extends Piece {

	public Horse(PieceType symbol, Color color) {
		super(symbol, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validMove(Move move) {
		// TODO Auto-generated method stub
		return super.validMove(move) && isHorse(move);
	}

	public boolean isHorse(Move move) {
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

		if (!((Math.abs(dR) == 2 && Math.abs(dC) == 1) || (Math.abs(dR) == 1 && Math.abs(dC) == 2))) {
			return false;
		}

		if (pieceAtEndSpot != null && piece.getColor() == pieceAtEndSpot.getColor()) {
			return false;
		}

		return true;
	}
}
