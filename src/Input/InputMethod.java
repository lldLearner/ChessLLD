package Input;

import Board.Move;

abstract public class InputMethod {

	abstract public int getStartRow();

	abstract public int getStartCol();

	abstract public int getEndRow();

	abstract public int getEndCol();
	
	abstract public boolean validateInput(int sR, int sC, int eR, int eC);

	abstract public Move move();
}
