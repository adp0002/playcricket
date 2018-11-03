package model;

public class LegByes extends Extra {

	private static final String LABEL = "lb";
	
	public LegByes(int id, int overId, int number) {
		super(id, overId, number, false, MIN_RUNS, 0);
	}
	
	public LegByes(int id, int overId, int number, boolean countable, boolean hasRuns, int runs, String description, String strikerId,
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
