import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read input
        int N = scanner.nextInt();
        // Check if N can be represented as product of two integers between 1 and 9
        boolean possible = false;

        // Try all possible combinations of numbers between 1 and 9
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i * j == N) {
                    possible = true;
                    break;
                }
            }
            if (possible) {
                break;
            }
        }

        // Print result
        if (possible)System.out.println("Yes");
        else System.out.println("No");

        scanner.close();
    }
}