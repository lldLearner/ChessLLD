package Strategy;

import Board.Board;
import Board.Move;
import Board.Spot;

public class DiagonalMoveValidator extends MoveStrategy {

	@Override
	public boolean moveValidator(Move move) {
		// TODO Auto-generated method stub
		Spot startSpot = move.getStartSpot();
		Spot endSpot = move.getEndSpot();
		Board board = Board.getBoard();

		int startR = startSpot.getRow();
		int endR = endSpot.getRow();

		int startC = startSpot.getCol();
		int endC = endSpot.getCol();

		int dR = endR - startR;
		int dC = endC - startC;
		
		if (Math.abs(dR) != Math.abs(dC)) {
			return false;
		}
		int dirx = dR > 0 ? 1 : -1;
		int diry = dC > 0 ? 1 : -1;

		for (int i = 1; i < Math.abs(dR); i++) {
			if (!board.isSpotEmpty(new Spot(startR + i * dirx, startC + i * diry))) {
				return false;
			}
		}
		
		return true;
	}

}
