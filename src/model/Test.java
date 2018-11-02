package model;

public class Test {

	public void ballTest() {
		int id = 5, overId = 2, number = 8, runs = 4;
		String strikerId = "Prudhvi Sha", nonStrikerId = "KL Rahul";
		boolean hasDefualtRuns = true;
		
		Ball dotBall = Ball.noRuns(id, overId, number);
		Ball singleRun = Ball.singleRun(id, overId, number);
		Ball twoRuns = Ball.twoRuns(id, overId, number);
		Ball threeRuns = Ball.threeRuns(id, overId, number);
		Ball fourRuns = Ball.fourRuns(id, overId, number);
		Ball sixRuns = Ball.sixRuns(id, overId, number);
		Ball wicket = Ball.wicket(id, overId, number);
		Ball wideBall = Ball.wideBall(id, overId, number, hasDefualtRuns);
		Ball noBall = Ball.noBall(id, overId, number, hasDefualtRuns);
		noBall.setRuns(4);
		
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
		print("Different Runs: " + runsBuilder);
		
	}

	public void print(String text) {
		System.out.println(text);
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.ballTest();
	}

}
