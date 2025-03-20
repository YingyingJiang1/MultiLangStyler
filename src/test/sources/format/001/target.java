import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int X = scanner.nextInt();

        int start = X - K + 1;
        int end = X + K - 1;

        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
    }
}