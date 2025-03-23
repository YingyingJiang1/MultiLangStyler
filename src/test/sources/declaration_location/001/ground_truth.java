import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read input
        int n = scanner.nextInt();
        String s = scanner.next();
        // Get the first half of the string
        String firstHalf = s.substring(0, n / 2);
        // Get the second half of the string
        String secondHalf = s.substring(n / 2);

        // Check if the string length is even
        // If it's odd, it can't be a concatenation of two identical strings
        if (n % 2 != 0) {
            System.out.println("No");
            return;
        }
        // Compare the two halves
        if (firstHalf.equals(secondHalf)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scanner.close();
    }
}
