import java.util.Scanner;
import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read inputs
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] h = new int[n];
        for (int i = 0; i<n; i++) {
            h[i] = scanner.nextInt();
        }
        
        // Initialize dp array
        int[] dp = new int[n];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0; // Starting point
        
        // Compute minimum cost for each stone
        for (int i = 1; i<n; i++) {
            for (int j = Math.max(0, i - k); j<i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + Math.abs(h[i] - h[j]));
            }
        }
        
        // Output the minimum cost to reach the last stone
        System.out.println(dp[n - 1]);
        
        scanner.close();
    }
}
