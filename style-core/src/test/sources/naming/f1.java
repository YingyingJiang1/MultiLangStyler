public class NamingStyleTestA {

	public static int calculateTotalScore(int studentCount, int bonusPoints) {
		int totalScore = 0;
		int baseScore = 60;

		for (int studentIndex = 0; studentIndex < studentCount; studentIndex++) {
			int currentScore = baseScore + bonusPoints;
			totalScore += currentScore;
		}

		return totalScore;
	}
}