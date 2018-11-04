package model;

import java.util.ArrayList;
import java.util.List;

public class Over {
	public interface Callback {
		void onOverComplete(Over over);
		void onBall(Ball ball);
	}
	
	private int id;
	private String bowlerId;
	private boolean overCompleted;
	private int runs, wickets, extras, ballNumber = 1;
	
	private Callback callback;
	private List<Ball> balls = new ArrayList<>();
	
	public Over(int id, String bowlerId) {
		this.id = id;
		this.bowlerId = bowlerId;
	}

	public int getId() {
		return id;
	}
	
	public String getBowlerId() {
		return bowlerId;
	}

	public void setBowlerId(String bowlerId) {
		this.bowlerId = bowlerId;
	}

	public int getExtras() {
		return extras;
	}

	public void setExtras(int extras) {
		this.extras = extras;
	}

	public int getRuns() {
		return runs;
	}

	public int getWickets() {
		return wickets;
	}

	public int getBallNumber() {
		return ballNumber;
	}

	public boolean isOverCompleted() {
		return overCompleted;
	}

	private int getCompletedBallsCount() {
		int ballsCompleted = 0;
		for (Ball ball: balls) {
			if (ball.isCountable()) {
				ballsCompleted++;
			}
		}
		
		return ballsCompleted;
	}
	
	public List<Ball> getBalls() {
		return balls;
	}
	
	public void addWideBall(Runs runs, String strikerId, String nonStrikerId, boolean hasDefualtRuns) {
		if (runs == null || overCompleted) return;
		Ball ball = Ball.wideBall(balls.size(), this.id, this.ballNumber, hasDefualtRuns);
		// Set players info
		ball.setStrikerId(strikerId);
		ball.setNonStrikerId(nonStrikerId);
		
		// Add ball to current over
		addBall(ball);
	}
	
	public void addNoBall(Runs runs, String strikerId, String nonStrikerId) {
		if (runs == null || overCompleted) return;
		
		Ball ball = Ball.noBall(balls.size(), this.id, this.ballNumber);
		// Set players info
		ball.setStrikerId(strikerId);
		ball.setNonStrikerId(nonStrikerId);
		
		// Add ball to current over
		addBall(ball);
	}
	
	public void addRuns(Runs runs, String strikerId, String nonStrikerId) {
		if (runs == null || overCompleted) return;
		
		Ball ball = getBallByRuns(runs, balls.size(), this.id, this.ballNumber);
		// Set players info
		ball.setStrikerId(strikerId);
		ball.setNonStrikerId(nonStrikerId);
		
		// Add ball to current over
		addBall(ball);
	}
	
	private Ball getBallByRuns(Runs runs, int id, int overId, int ballNumber) {
		switch (runs) {
		case One:
			return Ball.singleRun(id, overId, ballNumber);
		case Two:
			return Ball.twoRuns(id, overId, ballNumber); 
		case Three:
			return Ball.threeRuns(id, overId, ballNumber);
		case Four:
			return Ball.fourRuns(id, overId, ballNumber);
		case Six:
			return Ball.sixRuns(id, overId, ballNumber);
		default:
			return Ball.noRuns(balls.size(), id, ballNumber);
		}
	}
	
	public void addWicket(String playerId, String strikerId, String nonStrikerId, Runs runs, int atTotalRuns, String description) {
		if (playerId == null || overCompleted) return;
		int id = balls.size(), overId = id, number = ballNumber;
		
		Ball ball = Ball.wicket(id, overId, number, runs.ordinal(), playerId, atTotalRuns + runs.ordinal());
		
		// Set info
		ball.setStrikerId(strikerId);
		ball.setNonStrikerId(nonStrikerId);
		ball.setDescription(description);
		
		// Add ball to current over
		addBall(ball);
	}
	
	public void addByes(String strikerId, String nonStrikerId, int runs, String description) {
		if (runs < 0 || overCompleted) return;
		int id = balls.size(), overId = id, number = ballNumber;
		
		Ball ball = Ball.byes(id, overId, number);
		
		// Set info
		ball.setStrikerId(strikerId);
		ball.setNonStrikerId(nonStrikerId);
		ball.setDescription(description);
		
		// Add ball to current over
		addBall(ball);
	}
	
	public void addLegByes(String strikerId, String nonStrikerId, int runs, String description) {
		if (runs < 0 || overCompleted) return;
		int id = balls.size(), overId = id, number = ballNumber;
		
		Ball ball = Ball.byes(id, overId, number);
		
		// Set info
		ball.setStrikerId(strikerId);
		ball.setNonStrikerId(nonStrikerId);
		ball.setDescription(description);
		
		// Add ball to current over
		addBall(ball);
	}
	
	private void addBall(Ball ball) {
		if (ball == null || overCompleted) {
			System.out.println("Over: Failed to add Ball");
			return;
		}

		// Add ball to current over
		balls.add(ball);

		// Mark over completed
		ballNumber = getCompletedBallsCount() + 1;
		overCompleted = ballNumber > Ball.MAX_BALLS;

		// Update Stats
		setOverStats(ball);
		
		// Notify on end of every ball
		if (callback != null) {
			callback.onBall(ball);
		}		
	}
	
	private void setOverStats(Ball ball) {
		if (ball == null || overCompleted) {
			return;
		}
		
		// Set runs
		runs += ball.getRuns();
		
		// Set extras
		if (ball instanceof Extra) {
			extras++;
		}
		
		// Set wickets
		if (ball instanceof Wicket) {
			wickets++;
		}
	}
	
	public String getLabel() {
		return id + "." + (ballNumber-1);
	}
}
