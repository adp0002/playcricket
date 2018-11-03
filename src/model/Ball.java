package model;

/**
 * Represents Ball
 * 
 * @author adprasad
 */
public class Ball {
	private boolean countable;
	private int id, overId, number, runs;
	private String description, strikerId, nonStrikerId;

	// Maximum runs allowed for single fair delivery
	public static final int MIN_RUNS = 0;
	public static final int MAX_RUNS = 6;
	public static final int MIN_BALLS = 0;
	public static final int MAX_BALLS = 6;
	
	public static Ball noRuns(int id, int overId, int number) {
		return new Ball(id, overId, number, MIN_RUNS);
	}
	
	public static Ball singleRun(int id, int overId, int number) {
		return new Ball(id, overId, number, 1);
	}
	
	public static Ball twoRuns(int id, int overId, int number) {
		return new Ball(id, overId, number, 2);
	}
	
	public static Ball threeRuns(int id, int overId, int number) {
		return new Ball(id, overId, number, 3);
	}
	
	public static Ball fourRuns(int id, int overId, int number) {
		return new Ball(id, overId, number, 4);
	}
	
	public static Ball sixRuns(int id, int overId, int number) {
		return new Ball(id, overId, number, 6);
	}
	
	public static Ball wicket(int id, int overId, int number) {
		return new Wicket(id, overId, number);
	}
	
	public static Ball wideBall(int id, int overId, int number, boolean hasDefualtRuns) {
		return new WideBall(id, overId, number, hasDefualtRuns);
	}
	
	public static Ball noBall(int id, int overId, int number) {
		return new NoBall(id, overId, number);
	}
	
	public static Ball byes(int id, int overId, int number) {
		return new Byes(id, overId, number);
	}
	
	public static Ball legByes(int id, int overId, int number) {
		return new LegByes(id, overId, number);
	}
	
	public Ball(int id, int overId, int number, int runs) {
		this(id, overId, number, true, runs, null, null, null);
	}
	
	public Ball(int id, int overId, int number, int runs, String description, String strikerId, String nonStrikerId) {
		this(id, overId, number, true, runs, description, strikerId, nonStrikerId);
	}
	
	public Ball(int id, int overId, int number, boolean countable, int runs, String description, String strikerId,
			String nonStrikerId) {
		this.id = id;
		this.overId = overId;
		this.number = number;
		this.countable = countable;
		this.runs = runs;
		this.description = description;
		this.strikerId = strikerId;
		this.nonStrikerId = nonStrikerId;
		
		applyValidations();
	}

	private void applyValidations() {
		number = number < MIN_BALLS ? MIN_BALLS : number > MAX_BALLS ? MAX_BALLS : number;
	}
	
	public int getId() {
		return id;
	}

	public int getOverId() {
		return overId;
	}

	public int getNumber() {
		return number < MIN_BALLS ? MIN_BALLS : number < MAX_BALLS ? MAX_BALLS : number;
	}

	public boolean isCountable() {
		return countable;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}
	
	public int getRuns() {
		return runs;
	}

	public String getDescription() {
		return description;
	}

	public String getStrikerId() {
		return strikerId;
	}

	public String getNonStrikerId() {
		return nonStrikerId;
	}

	public String getLabel() {
		return "" + runs;
	}

	public String getOverLabel() {
		return overId + "." + number;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setStrikerId(String strikerId) {
		this.strikerId = strikerId;
	}

	public void setNonStrikerId(String nonStrikerId) {
		this.nonStrikerId = nonStrikerId;
	}

	@Override
	public String toString() {
		return getOverLabel() + " " + getLabel();
	}
}
