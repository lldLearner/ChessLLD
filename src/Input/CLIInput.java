package Input;

import java.util.Scanner;

import Board.Move;
import Board.Spot;

public class CLIInput extends InputMethod {

	private Scanner sc;
	
	public CLIInput() {
		// TODO Auto-generated constructor stub
		this.sc = new Scanner(System.in);
	}
	
	@Override
	public int getStartRow() {
		// TODO Auto-generated method stub

		int sr = sc.nextInt();
		return sr;
	}

	@Override
	public int getStartCol() {
		// TODO Auto-generated method stub

		int sC = sc.nextInt();
		return sC;
	}

	@Override
	public int getEndRow() {
		// TODO Auto-generated method stub

		int er = sc.nextInt();
		return er;
	}

	@Override
	public int getEndCol() {
		// TODO Auto-generated method stub

		int eC = sc.nextInt();
		return eC;
	}
	
	public Move move() {
		System.out.println("Choose start row!");
		int sr = getStartCol();
		System.out.println("Choose start col!");
		int sc = getStartCol();
		System.out.println("Choose end row!");
		int er = getEndRow();
		System.out.println("Choose end col!");
		int ec = getEndCol();
		
		return new Move(new Spot(sr, sc), new Spot(er, ec));
	}

	@Override
	public boolean validateInput(int sR, int sC, int eR, int eC) {
		// TODO Auto-generated method stub
		return false;
	}

}
