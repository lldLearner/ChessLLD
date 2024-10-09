package Pieces;

import Board.Move;
import Enums.Color;
import Enums.PieceType;
import Strategy.DiagonalMoveValidator;
import Strategy.MoveStrategy;

public class Bishop extends Piece {

	private MoveStrategy diagonalValidator;

	public Bishop(PieceType symbol, Color color) {
		super(symbol, color);
		diagonalValidator = new DiagonalMoveValidator();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validMove(Move move) {
		// TODO Auto-generated method stub
		return super.validMove(move) && diagonalValidator.moveValidator(move)
				&& !diagonalValidator.checkPieceAtEndSpot(move);
	}

//	public boolean isBishop(Move move) {
//		Spot startSpot = move.getStartSpot();
//		Spot endSpot = move.getEndSpot();
//		Board board = Board.getBoard();
//
//		Piece piece = board.getPiece(move.getStartSpot());
//		Piece pieceAtEndSpot = board.getPiece(move.getEndSpot());
//		int startR = startSpot.getRow();
//		int endR = endSpot.getRow();
//
//		int startC = startSpot.getCol();
//		int endC = endSpot.getCol();
//
//		int dR = endR - startR;
//		int dC = endC - startC;
//
//		if (Math.abs(dR) != Math.abs(dC)) {
//			return false;
//		}
//		int dirx = dR > 0 ? 1 : -1;
//		int diry = dC > 0 ? 1 : -1;
//
//		for (int i = 1; i < Math.abs(dR); i++) {
//			if (!board.isSpotEmpty(new Spot(startR + i * dirx, startC + i * diry))) {
//				return false;
//			}
//		}
//
//		if (pieceAtEndSpot != null && piece.getColor() == pieceAtEndSpot.getColor()) {
//			return false;
//		}
//
//		return true;
//	}
}
