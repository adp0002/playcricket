package model;

/**
 * Represents a ball of Wicket
 * 
 * @author adprasad
 *
 */
public class Wicket extends Ball {
	private String playerId;
	private int atTotalRuns;
	
	private static final String LABEL = "w";
	
	public Wicket(int id, int overId, int number, int runs, String playerId, int atTotalRuns) {
		super(id, overId, number, runs);
		
		this.playerId = playerId;
		this.atTotalRuns = atTotalRuns;
	}

	public String getPlayerId() {
		return playerId;
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
