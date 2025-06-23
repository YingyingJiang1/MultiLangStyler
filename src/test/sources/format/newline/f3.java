import java.util.Scanner;

public class PalaceConstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input
        int N = scanner.nextInt();  // Number of places
        int T = scanner.nextInt();  // Base temperature
        int A = scanner.nextInt();  // Target temperature
        
        int[] H = new int[N];  // Array to store elevations
        for (int i = 0; i < N; i++) {
            H[i] = scanner.nextInt();
        }
        
        // Find the place with temperature closest to A
        int bestPlace = 0;
        double minDiff = Double.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
            // Calculate temperature at current place
            double temp = T - (H[i] * 0.006);
            
            // Calculate difference from target temperature
            double diff = Math.abs(temp - A);
            
            // Update best place if current difference is smaller
            if (diff < minDiff) {
                minDiff = diff;
                bestPlace = i + 1;  // Adding 1 because places are 1-indexed
            }
        }
        
        // Print result
        System.out.println(bestPlace);
        
        scanner.close();
    }
}