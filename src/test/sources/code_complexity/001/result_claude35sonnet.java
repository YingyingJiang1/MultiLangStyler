import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input number
        int N = scanner.nextInt();
        
        // Find the number with most divisions by 2
        int result = findMostDivisibleByTwo(N);
        
        // Print the result
        System.out.println(result);
        
        scanner.close();
    }
    
    public static int findMostDivisibleByTwo(int n) {
        // Initialize variables to track maximum divisions and result
        int maxDivisions = 0;
        int result = 1;
        
        // Check each number from 1 to N
        for (int i = 1; i <= n; i++) {
            // Count divisions by 2 for current number
            int divisions = countDivisionsByTwo(i);
            
            // Update result if current number has more divisions
            if (divisions > maxDivisions) {
                maxDivisions = divisions;
                result = i;
            }
        }
        
        // Return the number with most divisions by 2
        return result;
    }
    
    public static int countDivisionsByTwo(int number) {
        int divisions = 0;
        int current = number;
        
        // Count how many times the number can be divided by 2
        while (current % 2 == 0) {
            current /= 2;
            divisions++;
        }
        
        return divisions;
    }
}