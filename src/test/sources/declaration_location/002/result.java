import java.util.Scanner;

public class MinimumStamina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        for (int i = 0; i<n; i++) {
            x[i] = scanner.nextInt();
        }
        
        int minX = x[0];
        int maxX = x[0];
        for (int i = 1; i<n; i++) {
            minX = Math.min(minX, x[i]);
            
            maxX = Math.max(maxX, x[i]);
        }
        
        long minTotalStamina = Long.MAX_VALUE;
        for (int p = minX; p <= maxX; p++) {
            long totalStamina = 0;
            for (int i = 0; i<n; i++) {
                long distance = x[i] - p;
                totalStamina += distance * distance;
            }
            minTotalStamina = Math.min(minTotalStamina, totalStamina);
        }
        
        System.out.println(minTotalStamina);
        
        scanner.close();
    }
}
