import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String S = scanner.next();

        if (N % 2 != 0) {
            System.out.println("No");
            return;
        }
        
        String firstHalf = S.substring(0, N / 2);
        String secondHalf = S.substring(N / 2);

        if (firstHalf.equals(secondHalf)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        scanner.close();
    }
}
