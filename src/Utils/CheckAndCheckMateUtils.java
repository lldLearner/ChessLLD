package Utils;

import Board.Board;
import Board.Move;
import Board.Spot;
import Enums.Color;
import Pieces.King;
import Pieces.Piece;

public class CheckAndCheckMateUtils {

	public static boolean isKingCheck(Spot spot, Color color, Board board) {

		for (int r = 0; r < board.getLength(); r++) {
			for (int c = 0; c < board.getLength(); c++) {
				Piece enemyPiece = board.getPiece(new Spot(r, c));
				if (enemyPiece != null && enemyPiece.getColor() == color
						&& enemyPiece.validMove(new Move(new Spot(r, c), spot))) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean isCheckMate(Board board, Color color) {

		Spot opponentKingSpot = findKingLocation(color, board);
		if (!isKingCheck(opponentKingSpot, ColorUtils.getOppositeColor(color), board)) {
			return false;
		}
		for (int r = 0; r < board.getLength(); r++) {
			for (int c = 0; c < board.getLength(); c++) {
				Piece opponentPiece = board.getPiece(new Spot(r, c));
				for (int i = 0; i < board.getLength(); i++) {
					for (int j = 0; j < board.getLength(); j++) {
						Move possibleMove = new Move(new Spot(r, c), new Spot(i, j));
						if (opponentPiece != null && opponentPiece.getColor() == color
								&& opponentPiece.validMove(possibleMove)) {
							Piece capturedPiece = board.getPiece(new Spot(i, j));
							opponentPiece.makeMove(possibleMove);
							if (!isKingCheck(opponentKingSpot, ColorUtils.getOppositeColor(color), board)) {
								board.setPiece(new Spot(r, c), opponentPiece);
								board.setPiece(new Spot(i, j), capturedPiece);
								opponentPiece.decrementMove();
								return false;
							}

							board.setPiece(new Spot(r, c), opponentPiece);
							board.setPiece(new Spot(i, j), capturedPiece);
							opponentPiece.decrementMove();
						}
					}
				}
			}
		}

		return true;
	}

	public static Spot findKingLocation(Color color, Board board) {
		// TODO Auto-generated method stub
		for (int r = 0; r < board.getLength(); r++) {
			for (int c = 0; c < board.getLength(); c++) {
				Piece myPiece = board.getPiece(new Spot(r, c));
				if (myPiece != null && myPiece instanceof King && myPiece.getColor() == color) {
					return new Spot(r, c);
				}
			}
		}

		return null;
	}
}
