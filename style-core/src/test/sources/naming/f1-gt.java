public class NamingStyleTestA {

	public static int calculateTotalScore(int student_count, int bonus_points) {
		int total_score = 0;
		int base_score = 60;

		for (int student_index = 0; student_index < student_count; student_index++) {
			int cur_score = base_score + bonus_points;
			total_score += cur_score;
		}

		return total_score;
	}
}