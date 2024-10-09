package Board;

public class Move {

	private Spot startSpot;
	private Spot endSpot;

	public Move(Spot startSpot, Spot endSpot) {
		super();
		this.startSpot = startSpot;
		this.endSpot = endSpot;
	}

	public Spot getStartSpot() {
		return startSpot;
	}

	public Spot getEndSpot() {
		return endSpot;
	}
}
