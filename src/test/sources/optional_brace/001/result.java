import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean possible = false;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i * j == n) {
                    possible = true;
                    break;
                }
            }
            if (possible) {
                break;
            }
        }
        
        if (possible)System.out.println("Yes");
        else System.out.println("No");
        
        scanner.close();
    }
}
