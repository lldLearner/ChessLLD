package Pieces;

import Board.Move;
import Enums.Color;
import Enums.PieceType;
import Strategy.DiagonalMoveValidator;
import Strategy.HorizontalVerticalMoveValidator;
import Strategy.MoveStrategy;

public class Queen extends Piece {

	private MoveStrategy diagonalValidator;
	private MoveStrategy horizontalVerticalValidator;

	public Queen(PieceType symbol, Color color) {
		super(symbol, color);
		this.diagonalValidator = new DiagonalMoveValidator();
		this.horizontalVerticalValidator = new HorizontalVerticalMoveValidator();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validMove(Move move) {
		// TODO Auto-generated method stub
		return super.validMove(move) && (diagonalValidator.moveValidator(move)
				|| horizontalVerticalValidator.moveValidator(move)) && !diagonalValidator.checkPieceAtEndSpot(move); 
	}

//	public boolean isQueenValid(Move move) {
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
//		if (dR == 0 && dC == 0) {
//			return false;
//		} else if (dC == 0 && dR != 0) {
//			int dir = dR > 0 ? 1 : -1;
//			for (int i = 1; i < Math.abs(dR); i++) {
//				if (!board.isSpotEmpty(new Spot(startR + i * dir, startC))) {
//					return false;
//				}
//			}
//		} else if (dR == 0 && dC != 0) {
//			int dir = dC > 0 ? 1 : -1;
//			for (int i = 1; i < Math.abs(dC); i++) {
//				if (!board.isSpotEmpty(new Spot(startR, startC + i * dir))) {
//					return false;
//				}
//			}
//		} else {
//
//			if (Math.abs(dR) != Math.abs(dC)) {
//				return false;
//			}
//			int dirx = dR > 0 ? 1 : -1;
//			int diry = dC > 0 ? 1 : -1;
//
//			for (int i = 1; i < Math.abs(dR); i++) {
//				if (!board.isSpotEmpty(new Spot(startR + i * dirx, startC + i * diry))) {
//					return false;
//				}
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
