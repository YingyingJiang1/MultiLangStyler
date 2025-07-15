import java.util.Scanner;

public class TicketSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        
        // Split the input string into individual digits
        int A = input.charAt(0) - '0';
        int B = input.charAt(1) - '0';
        int C = input.charAt(2) - '0';
        int D = input.charAt(3) - '0';
        
        // Array to hold the operators
        char[] operators = {'+', '-'};
        
        // Try all combinations of operators
        for (char op1 : operators) {
            for (char op2 : operators) {
                for (char op3 : operators) {
                    // Calculate the result of the expression
                    int result = calculate(A, op1, B, op2, C, op3, D);
                    if (result == 7) {
                        // If the result is 7, print the expression and return
                        System.out.printf("%d%c%d%c%d%c%d=7%n", A, op1, B, op2, C, op3, D);
                        return;
                    }
                }
            }
        }
    }
    
    // Method to calculate the result of the expression
    private static int calculate(int A, char op1, int B, char op2, int C, char op3, int D) {
        // Apply first operator
        int result = applyOperator(A, op1, B);
        // Apply second operator
        result = applyOperator(result, op2, C);
        // Apply third operator
        result = applyOperator(result, op3, D);
        return result;
    }
    
    // Method to apply a given operator between two numbers
    private static int applyOperator(int left, char operator, int right) {
        if (operator == '+') {
            return left + right;
        } else if (operator == '-') {
            return left - right;
        }
        return 0; // This should never be reached due to the constraints
    }
}