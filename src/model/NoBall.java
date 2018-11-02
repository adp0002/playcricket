package model;

public class NoBall extends Extra {

	private static final String LABEL = "nb";
	
	public NoBall(int id, int overId, int number, boolean hasDefaultRuns) {
		super(id, overId, number, hasDefaultRuns, MIN_RUNS, 0);
	}
	
	public NoBall(int id, int overId, int number, boolean countable, boolean hasRuns, int runs, String description, String strikerId,
			String nonStrikerId, int atTotalRuns) {
		super(id, overId, number, false, runs, description, strikerId, nonStrikerId, atTotalRuns);
	}

	@Override
	public boolean hasDefaultRuns() {
		return hasDefaultRuns;
	}

	@Override
	public String getLabelSymbol() {
		return LABEL;
	}
}
