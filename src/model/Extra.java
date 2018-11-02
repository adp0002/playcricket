package model;

public abstract class Extra extends Ball {
	
	protected boolean hasDefaultRuns;
	private int atTotalRuns, defaultRuns;
	
	private static final int DEFAULT_RUNS = 1;
	private static final String DEFAULT_LABEL = "e";
	
	public Extra(int id, int overId, int number, boolean hasDefaultRuns, int runs, int atTotalRuns) {
		this(id, overId, number, hasDefaultRuns, runs, null, null, null, atTotalRuns);
	}
	
	public Extra(int id, int overId, int number, boolean hasDefaultRuns, int runs, String description, String strikerId,
			String nonStrikerId, int atTotalRuns) {
		super(id, overId, number, false, runs, description, strikerId, nonStrikerId);
		
		this.atTotalRuns = atTotalRuns;
		this.hasDefaultRuns = hasDefaultRuns;
	}
	
	public int getAtTotalRuns() {
		return atTotalRuns;
	}

	public abstract boolean hasDefaultRuns();
	
	public void setDefaultRuns(int defaultRuns) {
		if (defaultRuns < 0 || defaultRuns > MAX_RUNS) return;
		
		this.defaultRuns = defaultRuns;
	}
	
	public int getDefaultRuns() {
		return hasDefaultRuns() ? DEFAULT_RUNS : 0;
	}
	
	@Override
	public int getRuns() {
		int runs = super.getRuns();
		return hasDefaultRuns() ? runs + defaultRuns : runs ;
	}
	
	public abstract String getLabelSymbol();
	
	@Override
	public String getLabel() {
		String labelSymbol = getLabelSymbol(); 
		if (labelSymbol == null || labelSymbol.trim().length() == 0) {
			labelSymbol = DEFAULT_LABEL;
		}
		
		int defRuns = getDefaultRuns(); 
		
		String label = labelSymbol;
		label += hasDefaultRuns && defRuns > 0 ? getDefaultRuns()  : "";    // E or E1 
		label += getRuns() == 0 ? "" : "+" + getRuns(); // E+4 or E1+4 
		return label;
	}
	
	@Override
	public String toString() {
		return getOverLabel() + " " + getLabel();
	}
}
