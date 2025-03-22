import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W = scanner.nextInt();
        int H = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int r = scanner.nextInt();

        if (x - r >= 0 && x + r <= W && y - r >= 0 && y + r <= H) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}