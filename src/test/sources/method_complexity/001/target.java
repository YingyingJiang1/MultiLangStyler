import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of days
        int n = scanner.nextInt();
        
        // Read the exchange rates
        long[] rates = new long[n];
        for (int i = 0; i < n; i++) {
            rates[i] = scanner.nextLong();
        }
        
        // Find the maximum profit
        long maxProfit = findMaxProfit(rates);
        
        // Print the result
        System.out.println(maxProfit);
        
        scanner.close();
    }
    
    private static long findMaxProfit(long[] rates) {
        if (rates.length < 2) return 0;
        
        long maxProfit = -1;  // Initialize to -1 for the case when no profit is possible
        long minRate = rates[0];
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < rates.length; i++) {
            // Update maxProfit if current profit is larger
            if (rates[i] - minRate > maxProfit) {
                maxProfit = rates[i] - minRate;
            }
            
            // Update minRate if we find a smaller rate
            if (rates[i] < minRate) {
                minRate = rates[i];
            }
        }
        
        // If no profit is found (maxProfit is still -1), keep it as -1
        // Otherwise, return the maximum profit found
        return maxProfit;
    }
}