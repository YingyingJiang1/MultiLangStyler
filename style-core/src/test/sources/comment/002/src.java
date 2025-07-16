import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = 1;  // To keep track of case numbers
        
        while (true) {
            int x = scanner.nextInt();  // Read the input number
            
            // Check if input is 0 (terminal symbol)
            if (x == 0) {
                break;  // Exit the loop if input is 0
            }
            
            // Print the output in required format
            System.out.println("Case " + caseNumber + ": " + x);
            
            caseNumber++;  // Increment case number for next iteration
        }
        
        scanner.close();
    }
}