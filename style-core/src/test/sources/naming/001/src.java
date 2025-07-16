import java.util.Scanner;

public class ConcatenationSquareChecker {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Read the input values for a and b
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        // Concatenate a and b
        String concatenatedString = String.valueOf(a) + String.valueOf(b);

        // Convert the concatenated string to an integer
        int concatenatedNumber = Integer.parseInt(concatenatedString);

        // Check if the concatenated number is a perfect square
        if (isPerfectSquare(concatenatedNumber)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scanner.close();
    }

    @Override
    // Helper method to check if a number is a perfect square
    private static boolean isPerfectSquare(int number) {
        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }
}