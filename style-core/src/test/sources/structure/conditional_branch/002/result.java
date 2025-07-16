import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int caseNumber = 1;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int x = scanner.nextInt();

            if (x == 0) {
                x++;
                System.out.println("Case " + caseNumber + ": " + x);
                caseNumber++;
            } else {
                System.out.println("Case " + caseNumber + ": " + x);
                caseNumber++;
            }
        }
        
        scanner.close();
    }
}
