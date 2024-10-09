package Pieces;

import Enums.Color;
import Enums.PieceType;

public class PieceFactory {

	public static Piece createPiece(PieceType symbol, Color color) {
		switch (symbol) {
		case PAWN: {

			return new Pawn(symbol, color);
		}
		case ROOK: {

			return new Rook(symbol, color);
		}
		case HORSE: {
			return new Horse(symbol, color);
		}
		case BISHOP: {
			return new Bishop(symbol, color);
		}
		case QUEEN: {
			return new Queen(symbol, color);
		}
		case KING: {
			return new King(symbol, color);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + symbol);
		}
	}
}
