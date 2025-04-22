import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int r = scanner.nextInt();

        System.out.println(check(w, h, x, y, r) ? "Yes" : "No");
    }

    private static boolean check(int w, int h, int x, int y, int r) {
        if (x - r < 0) {
            return false;
        }
        if (x + r > w) {
            return false;
        }
        if (y - r < 0) {
            return false;
        }
        if (y + r > h) {
            return false;
        }
        return true;
    }
}