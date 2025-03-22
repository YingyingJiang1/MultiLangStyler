import java.util.Scanner;

public class PowerStrips {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read input
        int A = scanner.nextInt(); // number of sockets in each power strip
        int B = scanner.nextInt(); // required number of empty sockets
        // Calculate minimum number of power strips needed
        int result = calculateMinPowerStrips(A, B);

        // Print result
        System.out.println(result);
        scanner.close();
    }

    public static int calculateMinPowerStrips(int A, int B) {
        // If B is 1 or less, we don't need any power strips
        if (B <= 1) {
            return 0;
        }

        // Start with 1 socket
        int currentSockets = 1;
        int powerStrips = 0;

        // Keep adding power strips until we have B or more empty sockets
        while (currentSockets < B) {
            powerStrips++;
            // When we plug in a power strip, we lose 1 socket (where we plug it in)
            // but gain A sockets
            currentSockets = currentSockets - 1 + A;
        }

        return powerStrips;
    }
}
