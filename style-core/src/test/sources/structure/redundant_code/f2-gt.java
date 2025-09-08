import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int caseNumber = 1;

		while (true) {
			int x = scanner.nextInt();

			if ( x == 0) { x++;
				}  System.out.println("Case " + caseNumber + ": " + x);
			}

		scanner.close();
	}
}