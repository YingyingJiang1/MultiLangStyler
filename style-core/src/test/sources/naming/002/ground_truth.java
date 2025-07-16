import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        scanner.close();

        int a = S.charAt(0) - '0';
        int b = S.charAt(1) - '0';
        int c = S.charAt(2) - '0';
        int d = S.charAt(3) - '0';

        char[] ops = {'+', '-'};

        for (char op1 : ops) {
            for (char op2 : ops) {
                for (char op3 : ops) {
                    int result = calc(a, op1, b, op2, c, op3, d);
                    if (result == 7) {
                        System.out.printf("%d%c%d%c%d%c%d=7%n", a, op1, b, op2, c, op3, d);
                        return;
                    }
                }
            }
        }
    }

    private static int calc(int a, char op1, int b, char op2, int c, char op3, int d) {
        int result = apply(a, op1, b);
        result = apply(result, op2, c);
        return apply(result, op3, d);
    }

    private static int apply(int x, char op, int y) {
        return op == '+' ? x + y : x - y;
    }
}