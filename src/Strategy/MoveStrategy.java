package Strategy;

import Board.Board;
import Board.Move;
import Pieces.Piece;

public abstract class MoveStrategy {

	abstract public boolean moveValidator(Move move);

	public boolean checkPieceAtEndSpot(Move move) {
		// TODO Auto-generated method stub

		Board board = Board.getBoard();

		Piece piece = board.getPiece(move.getStartSpot());
		Piece pieceAtEndSpot = board.getPiece(move.getEndSpot());
		
		return pieceAtEndSpot != null && piece.getColor() == pieceAtEndSpot.getColor();
	}
}
