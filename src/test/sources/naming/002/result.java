import java.util.Scanner;

public class TicketSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        
        int a = input.charAt(0) - '0';
        int b = input.charAt(1) - '0';
        int c = input.charAt(2) - '0';
        int d = input.charAt(3) - '0';
        char[] operators = {'+', '-'};

        for (char op1 : operators) {
            for (char op2 : operators) {
                for (char op3 : operators) {
                    int result = calculate(a, op1, b, op2, c, op3, d);

                    if (result == 7) {
                        System.out.printf("%d%c%d%c%d%c%d=7%n", a, op1, b, op2, c, op3, d);
                        return;
                    }
                }
            }
        }
    }
    
    private static int calculate(int a, char op1, int b, char op2, int c, char op3, int d) {
        int result = applyOperator(a, op1, b);
        result = applyOperator(result, op2, c);
        result = applyOperator(result, op3, d);
        return result;
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
