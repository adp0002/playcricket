package model;

public class LegByes extends Ball {

	private static final String LABEL = "lb";
	
	public LegByes(int id, int overId, int number) {
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
