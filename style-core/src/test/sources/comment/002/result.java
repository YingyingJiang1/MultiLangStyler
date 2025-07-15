import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int caseNumber = 1;
        
        while (true) {
            int x = scanner.nextInt();
            
            // Check if input is 0 (terminal symbol)
            if (x == 0) {
                break;
            }
            
            // Print the output in required format
            System.out.println("Case " + caseNumber + ": " + x);
            
            caseNumber++; // Increment case number for next iteration
        }
        
        scanner.close();
    }
}
