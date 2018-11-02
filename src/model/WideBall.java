package model;

public class WideBall extends Extra {
	private static final String LABEL = "wd";
	
	public WideBall(int id, int overId, int number, boolean hasDefaultRuns) {
		super(id, overId, number, hasDefaultRuns, MIN_RUNS, 0);
	}
	
	public WideBall(int id, int overId, int number, boolean hasRuns, int runs, String description, String strikerId,
			String nonStrikerId, int atTotalRuns) {
		super(id, overId, number, hasRuns, runs, description, strikerId, nonStrikerId, atTotalRuns);
	}

	public boolean hasDefaultRuns() {
		return hasDefaultRuns;
	}

	@Override
	public String getLabelSymbol() {
		return LABEL;
	}
}
