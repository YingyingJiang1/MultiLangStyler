import java.util.Scanner;

public class PowerStrips {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int result = calculateMinPowerStrips(a, b);

        System.out.println(result);

        scanner.close();
    }

    public static int calculateMinPowerStrips(int a, int b) {
        if (b <= 1) {
            return 0;
        }

        int curSockets = 1;
        int pwrStrips = 0;

        while (curSockets < b) {
            pwrStrips++;

            curSockets = curSockets - 1 + a;
        }

        return pwrStrips;
    }
}
