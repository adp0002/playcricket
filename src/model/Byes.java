package model;

public class Byes extends Extra {

	private static final String LABEL = "b";
	
	public Byes(int id, int overId, int number) {
		super(id, overId, number, false, MIN_RUNS, 0);
	}
	
	public Byes(int id, int overId, int number, boolean countable, boolean hasRuns, int runs, String description, String strikerId,
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
