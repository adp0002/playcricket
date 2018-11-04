package test;

import java.util.ArrayList;
import java.util.List;

import model.Ball;
import model.Over;
import model.Player;
import model.Runs;
import model.Squad;

public class Test {

	public void ballTest() {
		int id = 5, overId = 2, number = 8, runs = 4;
		String strikerId = "1", nonStrikerId = "2";
		boolean hasDefualtRuns = true;
		
		Squad squad = getPlayers();
		
		Ball dotBall = Ball.noRuns(id, overId, number);
		dotBall.setStrikerId(strikerId);
		dotBall.setNonStrikerId(nonStrikerId);
		
		Ball singleRun = Ball.singleRun(id, overId, number);
		Ball twoRuns = Ball.twoRuns(id, overId, number);
		Ball threeRuns = Ball.threeRuns(id, overId, number);
		Ball fourRuns = Ball.fourRuns(id, overId, number);
		Ball sixRuns = Ball.sixRuns(id, overId, number);
		Ball wicket = Ball.wicket(id, overId, number, 0, strikerId, 0);
		Ball wideBall = Ball.wideBall(id, overId, number, hasDefualtRuns);
		Ball noBall = Ball.noBall(id, overId, number);
		noBall.setRuns(6);
		Ball byes = Ball.byes(id, overId, number);
		byes.setRuns(3);
		Ball legByes = Ball.legByes(id, overId, number);
		legByes.setRuns(4);
		
		StringBuilder runsBuilder = new StringBuilder();
		runsBuilder.append(" " + dotBall.getLabel());
		runsBuilder.append(" " + singleRun.getLabel());
		runsBuilder.append(" " + twoRuns.getLabel());
		runsBuilder.append(" " + threeRuns.getLabel());
		runsBuilder.append(" " + fourRuns.getLabel());
		runsBuilder.append(" " + sixRuns.getLabel());
		runsBuilder.append(" " + wicket.getLabel().toUpperCase());
		runsBuilder.append(" " + wideBall.getLabel().toUpperCase());
		runsBuilder.append(" " + noBall.getLabel().toUpperCase());
		runsBuilder.append(" " + byes.getLabel().toUpperCase());
		runsBuilder.append(" " + legByes.getLabel().toUpperCase());
		runsBuilder.append("\n" + squad.getPlayer(dotBall.getStrikerId()) + " " + squad.getPlayer(dotBall.getNonStrikerId()));
		

		
		runsBuilder.append(" " + legByes.getLabel().toUpperCase());
//		print("Different Runs: " + runsBuilder);
		
		Over over = new Over(1, "1");
		over.addWideBall(Runs.Zero, strikerId, nonStrikerId, true);
		over.addWicket(strikerId, strikerId, nonStrikerId, Runs.Zero, 0, "L.B.W");
		over.addRuns(Runs.Four, strikerId, nonStrikerId);
		over.addRuns(Runs.Six, strikerId, nonStrikerId);
		over.addRuns(Runs.Four, strikerId, nonStrikerId);
		over.addRuns(Runs.Four, strikerId, nonStrikerId);
		over.addRuns(Runs.Zero, strikerId, nonStrikerId);
		over.addRuns(Runs.One, strikerId, nonStrikerId);
		
		over.addRuns(Runs.Four, strikerId, nonStrikerId);
		
		// Test
		StringBuilder oversStats = new StringBuilder();
		oversStats.append(over.getLabel() + " " + over.getBalls());
		oversStats.append(" R:" + over.getRuns() + ", W:"  + over.getWickets() + ", E:" + over.getExtras());
		System.out.println("Over(" + oversStats + ")");
	}

	public Squad getPlayers() {
		List<Player> players = new ArrayList<>();
		players.add(new Player("1", "Rohit Sharma", "male", 31, "Mumbai", "Batsman"));
		players.add(new Player("2", "Shikhar Dhavan", "male", 32, "Mumbai", "Batsman"));
		players.add(new Player("3", "Virat Kohli", "male", 30, "Delhi", "Batsman"));
		
		Squad squad = new Squad("India", players);
		return squad;
	}
	
	public void print(String text) {
		System.out.println(text);
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.ballTest();
	}

}
