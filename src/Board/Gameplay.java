package Board;

import Enums.Color;
import Input.CLIInput;
import Input.InputMethod;
import Pieces.King;
import Pieces.Piece;
import Utils.CheckAndCheckMateUtils;
import Utils.ColorUtils;
import Utils.StaleMateUtils;

public class Gameplay {

	// check handler
	private Players black;
	private Players white;
	private Board board;
	private Players currPlayer;
	private InputMethod inputMethod;
	private boolean isGameEnded;
	public Gameplay() {
		// TODO Auto-generated constructor stub
		this.black = new Players(Color.BLACK);
		this.white = new Players(Color.WHITE);
		this.board = Board.getBoard();
		this.currPlayer = this.black;
		this.inputMethod = new CLIInput();
		this.isGameEnded = false;
	}

	public void play() {
		// TODO Auto-generated method stub
		board.showChess();
		while (true) {
			System.out.println("Currplayer - " + this.currPlayer.getColor() + " making its turn!");
			Move move = inputMethod.move();
			makeMove(move);
			if(isGameEnded) {
				break;
			}
		}

	}

	private void makeMove(Move move) {
		// TODO Auto-generated method stub
		Piece piece = board.getPiece(move.getStartSpot());
		if (piece == null || !piece.validMove(move) || (piece.getColor() != this.currPlayer.getColor())
				|| (piece instanceof King && CheckAndCheckMateUtils.isKingCheck(move.getEndSpot(), ColorUtils.getOppositeColor(currPlayer.getColor()), board))) {
			System.out.println("The move is invalid, make another move!");
			play();
			return;
		}
		piece.makeMove(move);
		board.showChess();
		if(CheckAndCheckMateUtils.isCheckMate(board, ColorUtils.getOppositeColor(currPlayer.getColor()))) {
			System.out.println("Current player - " + currPlayer.getColor() + " wins the game!");
			isGameEnded = true;
			return;
		}
		
		if(StaleMateUtils.isCheckMate(board, currPlayer.getColor())) {
			System.out.println("The game is stalemate as current player - " + currPlayer.getColor() + " doesn't have valid move to make!");
			isGameEnded = true;
			return;
		}
		
		getNextPlayer();
	}

	private void getNextPlayer() {
		// TODO Auto-generated method stub
		if (this.currPlayer == white) {
			this.currPlayer = black;
		} else {
			this.currPlayer = white;
		}
	}
}
