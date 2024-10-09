package Board;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import Enums.Color;
import Enums.PieceType;
import Pieces.Piece;
import Pieces.PieceFactory;

public class Board {

	private static final Board b = new Board();
	private int length;
	private int width;
	private Piece[][] chessBoard;
	private PieceType[][] configurations;
	private List<Piece> capturedPieces;

	private Board() {
		// TODO Auto-generated constructor stub
		this.length = 8;
		this.width = 8;
		this.chessBoard = new Piece[length][width];
		this.configurations = new PieceType[][] {
				{ PieceType.PAWN, PieceType.PAWN, PieceType.PAWN, PieceType.PAWN, PieceType.PAWN, PieceType.PAWN,
						PieceType.PAWN, PieceType.PAWN },
				{ PieceType.ROOK, PieceType.HORSE, PieceType.BISHOP, PieceType.KING, PieceType.QUEEN, PieceType.BISHOP,
						PieceType.HORSE, PieceType.ROOK } };
		this.capturedPieces = new ArrayList<>();
		initializeGame();
	}

	public static Board getBoard() {
		// TODO Auto-generated method stub
		
		return b;
	}

	private void initializeGame() {
		// TODO Auto-generated method stub
		for (int i = 0; i < configurations.length; i++) {
			for (int j = 0; j < configurations[0].length; j++) {
				Piece piece = PieceFactory.createPiece(configurations[i][j], Color.WHITE);
				setPiece(new Spot(configurations.length - 1 - i, j), piece);
			}
		}

		for (int i = 0; i < configurations.length; i++) {
			for (int j = 0; j < configurations[0].length; j++) {
				Piece piece = PieceFactory.createPiece(configurations[i][j], Color.BLACK);
				setPiece(new Spot(i + length - configurations.length, j), piece);
			}
		}
	}

	public boolean outOfRange(Move move) {
		return outOfRange(move.getStartSpot().getRow(), move.getStartSpot().getCol())
				|| outOfRange(move.getEndSpot().getRow(), move.getEndSpot().getCol());
	}

	public boolean outOfRange(int x, int y) {
		// TODO Auto-generated method stub
		return x < 0 && y < 0 && x >= length && y >= width;
	}

	public void setPiece(Spot spot, Piece piece) {
		// TODO Auto-generated method stub

		if (outOfRange(spot.getRow(), spot.getCol())) {
			throw new IndexOutOfBoundsException();
		}
		this.chessBoard[spot.getRow()][spot.getCol()] = piece;
	}

	public Piece getPiece(Spot spot) {
		// TODO Auto-generated method stub
		if (outOfRange(spot.getRow(), spot.getCol())) {
			throw new IndexOutOfBoundsException();
		}

		return this.chessBoard[spot.getRow()][spot.getCol()];
	}
	
	public boolean isSpotEmpty(Spot spot) {
		return this.getPiece(spot) == null;
	}

	public void showChess() {
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard.length; j++) {
				if (chessBoard[i][j] == null) {
					System.out.print("   ");
				} else {
					if (chessBoard[i][j].getColor() == Color.WHITE)
						System.out.print("w" + chessBoard[i][j].getSymbol().toString().charAt(0) + " ");
					else
						System.out.print("b" + chessBoard[i][j].getSymbol().toString().charAt(0) + " ");
				}
			}
			System.out.println();
		}
		
		System.out.println("*******************************");
	}
	
	public void addCapturedPieces(Piece piece) {
		// TODO Auto-generated method stub
		capturedPieces.add(piece);
	}
	
	public int getLength() {
		return length;
	}
	
	public int getWidth() {
		return width;
	}
}
