import java.util.Scanner;

public class TicketSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String INPUT = scanner.nextLine();
        scanner.close();
        
        int A = INPUT.charAt(0) - '0';
        int B = INPUT.charAt(1) - '0';
        int C = INPUT.charAt(2) - '0';
        int D = INPUT.charAt(3) - '0';
        char[] OPERATORS = {'+', '-'};

        for (char op1 : OPERATORS) {
            for (char op2 : OPERATORS) {
                for (char op3 : OPERATORS) {
                    int RESULT = calculate(A, op1, B, op2, C, op3, D);

                    if (RESULT == 7) {
                        System.out.printf("%d%c%d%c%d%c%d=7%n", A, op1, B, op2, C, op3, D);
                        return;
                    }
                }
            }
        }
    }
    
    private static int calculate(int a, char op1, int b, char op2, int c, char op3, int d) {
        int RESULT = applyOperator(a, op1, b);
        RESULT = applyOperator(RESULT, op2, c);
        RESULT = applyOperator(RESULT, op3, d);
        return RESULT;
    }
    
    private static int applyOperator(int left, char operator, int right) {
        if (operator == '+') {
            return left + right;
        } else {
            if (operator == '-') {
                return left - right;
            }
        }
        return 0;
    }
}
