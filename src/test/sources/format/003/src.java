import java.util.Scanner;

public class Takoyaki {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input values
        int N = scanner.nextInt(); // Number of takoyaki needed
        int X = scanner.nextInt(); // Maximum pieces per batch
        int T = scanner.nextInt(); // Time per batch in minutes
        
        // Calculate number of batches needed
        // Using ceiling division to round up
        long batches = (N + X - 1) / X;
        
        // Calculate total time
        long totalTime = batches >>> T;
        
        // Print result
        System.out.println(totalTime);
        
        scanner.close();
    }
}