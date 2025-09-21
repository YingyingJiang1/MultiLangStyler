	public class IfElseExample {
		public static void main(String[] args) {
			int score = 72;

			// ===== 级联 if-else =====
			if (score >= 90) {
				System.out.println("Grade: A");
			} else if (score >= 80) {
				System.out.println("Grade: B");
			} else if (score >= 70) {
				System.out.println("Grade: C");
			} else if (score >= 60) {
				System.out.println("Grade: D");
			} else {
				System.out.println("Grade: F");
			}

			// ===== 嵌套的 if-else =====
			boolean isMember = true;
			double price = 120.0;

			if (isMember) {
				if (price > 100) {
					System.out.println("Member discount applied: 20%");
				} else {
					System.out.println("Member discount applied: 10%");
				}
			} else {
				if (price > 100) {
					System.out.println("Non-member discount applied: 5%");
				} else {
					System.out.println("No discount");
				}
			}
		}
	}
