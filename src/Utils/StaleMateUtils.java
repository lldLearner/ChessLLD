package Utils;

import Board.Board;
import Board.Move;
import Board.Spot;
import Enums.Color;
import Pieces.Piece;

public class StaleMateUtils {

	public static boolean isCheckMate(Board board, Color color) {

		Spot kingSpot = CheckAndCheckMateUtils.findKingLocation(color, board);
		if (!CheckAndCheckMateUtils.isKingCheck(kingSpot, ColorUtils.getOppositeColor(color), board)) {
			return false;
		}
		for (int r = 0; r < board.getLength(); r++) {
			for (int c = 0; c < board.getLength(); c++) {
				Piece piece = board.getPiece(new Spot(r, c));
				for (int i = 0; i < board.getLength(); i++) {
					for (int j = 0; j < board.getLength(); j++) {
						Move possibleMove = new Move(new Spot(r, c), new Spot(i, j));
						if (piece != null && piece.getColor() == color
								&& piece.validMove(possibleMove)) {
							Piece capturedPiece = board.getPiece(new Spot(i, j));
							piece.makeMove(possibleMove);
							if (!CheckAndCheckMateUtils.isKingCheck(kingSpot, ColorUtils.getOppositeColor(color), board)) {
								board.setPiece(new Spot(r, c), piece);
								board.setPiece(new Spot(i, j), capturedPiece);
								piece.decrementMove();
								return false;
							}

							board.setPiece(new Spot(r, c), piece);
							board.setPiece(new Spot(i, j), capturedPiece);
							piece.decrementMove();
						}
					}
				}
			}
		}

		return true;
	}
}
