import java.util.Scanner;

public class NumberSequenceProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize case counter
        int caseCounter = 1;
        
        // Process input numbers until 0 is encountered
        while (true) {
            // Read the input number
            int inputNumber = scanner.nextInt();
            
            // Check if input is the termination signal
            if (inputNumber == 0) {
                break;
            }
            
            // Print the output in required format
            System.out.println("Case " + caseCounter + ": " + inputNumber);
            
            caseCounter++;
        }
        
        scanner.close();
    }
}