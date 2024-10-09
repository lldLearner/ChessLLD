package Strategy;

import Board.Board;
import Board.Move;
import Board.Spot;

public class HorizontalVerticalMoveValidator extends MoveStrategy {

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

		if (dR == 0 && dC == 0) {
			return false;
		} else if (dC == 0 && dR != 0) {
			int dir = dR > 0 ? 1 : -1;
			for (int i = 1; i < Math.abs(dR); i++) {
				if (!board.isSpotEmpty(new Spot(startR + i * dir, startC))) {
					return false;
				}
			}
		} else if (dR == 0 && dC != 0) {
			int dir = dC > 0 ? 1 : -1;
			for (int i = 1; i < Math.abs(dC); i++) {
				if (!board.isSpotEmpty(new Spot(startR, startC + i * dir))) {
					return false;
				}
			}
		}

		return true;
	}

}
