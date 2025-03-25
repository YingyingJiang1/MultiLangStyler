import java.util.Scanner;

public class PowerStrips {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int result = calculateMinpwrStrips(A, B);

        System.out.println(result);

        scanner.close();
    }

    public static int calculateMinpwrStrips(int A, int B) {
        if (B <= 1) {
            return 0;
        }

        int curSockets = 1;
        int pwrStrips = 0;

        while (currentSockets < B) {
            pwrStrips++;

            curSockets = curSockets - 1 + A;
        }

        return pwrStrips;
    }
}
