package model;

public class Byes extends Ball {

	private static final String LABEL = "b";
	
	public Byes(int id, int overId, int number) {
		super(id, overId, number, MIN_RUNS);
	}

	@Override
	public String getLabel() {
		return LABEL + (getRuns() == 0 ? "" : "" + getRuns());
	}

	@Override
	public String toString() {
		return getOverLabel() + " " + getLabel();
	}
}
