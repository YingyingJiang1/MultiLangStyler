import java.util.Scanner;

public class MinimumStamina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read number of people
        int n = scanner.nextInt();
        // Read coordinates
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }

        // Find minimum and maximum coordinates to set search range
        int minX = x[0];
        int maxX = x[0];
        for (int i = 1; i < n; i++) {
            minX = Math.min(minX, x[i]);

            maxX = Math.max(maxX, x[i]);
        }

        // Try each possible meeting point and find minimum total stamina
        long minTotalStamina = Long.MAX_VALUE;
        for (int p = minX; p <= maxX; p++) {
            long totalStamina = 0;
            for (int i = 0; i < n; i++) {
                // Calculate stamina for each person
                long distance = x[i] - p;
                totalStamina += distance * distance;
            }
            minTotalStamina = Math.min(minTotalStamina, totalStamina);
        }

        System.out.println(minTotalStamina);

        scanner.close();
    }
}
