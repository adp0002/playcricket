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
	}

	public int getId() {
		return id;
	}

	public int getOverId() {
		return overId;
	}

	public int getNumber() {
		return number;
	}

	public boolean isCountable() {
		return countable;
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
	
	@Override
	public String toString() {
		return getOverLabel() + " " + getLabel();
	}
}
