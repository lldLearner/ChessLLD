package Pieces;

import Board.Move;
import Enums.Color;
import Enums.PieceType;
import Strategy.HorizontalVerticalMoveValidator;
import Strategy.MoveStrategy;

public class Rook extends Piece {

	private MoveStrategy horizontalVerticalValidator;

	public Rook(PieceType symbol, Color color) {
		super(symbol, color);
		// TODO Auto-generated constructor stub
		this.horizontalVerticalValidator = new HorizontalVerticalMoveValidator();
	}

	@Override
	public boolean validMove(Move move) {
		// TODO Auto-generated method stub
		return super.validMove(move) && horizontalVerticalValidator.moveValidator(move)
				&& !horizontalVerticalValidator.checkPieceAtEndSpot(move);
	}

//	public boolean validRookMove(Move move) {
//		Board b = Board.getBoard();
//		Spot startSpot = move.getStartSpot();
//		Spot endSpot = move.getEndSpot();
//		Piece piece = b.getPiece(move.getStartSpot());
//		Piece pieceAtEndSpot = b.getPiece(move.getEndSpot());
//		int startR = startSpot.getRow();
//		int endR = endSpot.getRow();
//
//		int startC = startSpot.getCol();
//		int endC = endSpot.getCol();
//
//		int dR = endR - startR;
//		int dC = endC - startC;
//
//		// Moving Rowisse Veertical
//		if (dC == 0 && dR != 0) {
//			int dir = dR > 0 ? 1 : -1;
//			for (int i = 1; i < Math.abs(dR); i++) {
//				if (!b.isSpotEmpty(new Spot(startR + i * dir, startC))) {
//					return false;
//				}
//			}
//		} else if (dR == 0 && dC != 0) {
//			int dir = dC > 0 ? 1 : -1;
//			for (int i = 1; i < Math.abs(dC); i++) {
//				if (!b.isSpotEmpty(new Spot(startR, startC + i * dir))) {
//					return false;
//				}
//			}
//		} else {
//			return false;
//		}
//
//		if (pieceAtEndSpot != null && piece.getColor() == pieceAtEndSpot.getColor()) {
//			return false;
//		}
//
//		return true;
//	}
}
