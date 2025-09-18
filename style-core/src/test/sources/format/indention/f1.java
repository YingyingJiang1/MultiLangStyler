public class SwitchExample {
	public static void main(String[] args) {
		String day = "MONDAY";

		// 传统 switch 语句
		switch (day) {
			case "MONDAY":
				System.out.println("Traditional switch: Start of the work week");
				break;
			case "FRIDAY":
				System.out.println("Traditional switch: End of the work week");
				break;
			case "SATURDAY":
			case "SUNDAY":
				System.out.println("Traditional switch: Weekend!");
				break;
			default:
				System.out.println("Traditional switch: Midweek day");
				break;
		}

		// Java 17 switch 表达式
		String message = switch (day) {
			case "MONDAY" -> "Switch expression: Start of the work week";
			case "FRIDAY" -> "Switch expression: End of the work week";
			case "SATURDAY", "SUNDAY" -> "Switch expression: Weekend!";
			default -> "Switch expression: Midweek day";
		};

		System.out.println(message);
	}
}
