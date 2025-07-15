import java.util.Scanner;
import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read inputs
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] h = new int[N];
        for (int i = 0; i < N; i++) {
            h[i] = scanner.nextInt();
        }

        // Initialize dp array
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Starting point

        // Compute minimum cost for each stone
        for (int i = 1; i < N; i++) {
            for (int j = Math.max(0, i - K); j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + Math.abs(h[i] - h[j]));
            }
        }

        // Output the minimum cost to reach the last stone
        System.out.println(dp[N - 1]);

        scanner.close();
    }
}