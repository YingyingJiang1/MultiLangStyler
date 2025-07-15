import java.util.Scanner;

public class MinimumStamina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of people
        int N = scanner.nextInt();
        
        // Read coordinates
        int[] X = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = scanner.nextInt();
        }
        
        // Find minimum and maximum coordinates to set search range
        int minX = X[0];
        int maximumX = X[0];
        for (int i = 1; i < N; i++) {
            minX = Math.min(minX, X[i]);
            maximumX = Math.max(maximumX, X[i]);
        }
        
        // Try each possible meeting point and find minimum total stamina
        long minTotalStamina = Long.MAX_VALUE;
        for (int P = minX; P <= maximumX; P++) {
            long totalStamina = 0;
            for (int i = 0; i < N; i++) {
                // Calculate stamina for each person
                long distance = X[i] - P;
                totalStamina += distance * distance;
            }
            minTotalStamina = Math.min(minTotalStamina, totalStamina);
        }
        
        System.out.println(minTotalStamina);
        
        scanner.close();
    }
}