public class NamingStyleTestA {

	public static int calculateTotalScore(int student_cnt, int bonus_points) {
		int total_score = 0;
		int base_score = 60;

		for (int student_idx = 0; student_idx < student_cnt; student_idx++) {
			int cur_score = base_score + bonus_points;
			total_score += cur_score;
		}

		return total_score;
	}
}