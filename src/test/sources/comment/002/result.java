import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int caseNumber = 1;

        while (true) {
            int x = scanner.nextInt(); // Read the input number

            if (x == 0) {
                break; // Exit the loop if input is 0

            }

            System.out.println("Case " + caseNumber + ": " + x);

            caseNumber++; // Increment case number for next iteration

        }

        scanner.close();
    }
}
