import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int s = sc.nextInt();
			int a = s / 100;
			int b = s % 100;

			if ((a == 0 && b == 0) || (a == 0 && b > 12) || (a > 12 && b == 0) || (a > 12 && b > 12)) {
				System.out.println("NA");
			} else if ((a == 0 || a > 12) && 1 <= b && b <= 12) {
				System.out.println("YYMM");
			} else if (1 <= a && a <= 12 && (b == 0 || b > 12)) {
				System.out.println("MMYY");
			} else if (1 <= a && a <= 12 && 1 <= b && b <= 12) {
				System.out.println("AMBIGUOUS");
			}
		}
	}
}