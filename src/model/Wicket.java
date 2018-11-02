package model;

/**
 * Represents a ball of Wicket
 * 
 * @author adprasad
 *
 */
public class Wicket extends Ball {
	
	private int atTotalRuns;
	
	private static final String LABEL = "w";
	
	public Wicket(int id, int overId, int number) {
		super(id, overId, number, MIN_RUNS);
	}
	
	public Wicket(int id, int overId, int number, int runs, String description, String strikerId, String nonStrikerId,
			int atTotalRuns) {
		super(id, overId, number, true, runs, description, strikerId, nonStrikerId);

		this.atTotalRuns = atTotalRuns;
	}

	public int getAtTotalRuns() {
		return atTotalRuns;
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
