import java.util.Scanner;

public class ConcatenationSquareChecker {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String concatenatedString = String.valueOf(a) + String.valueOf(b);
        int concatenatedNumber = Integer.parseInt(concatenatedString);

        if (isPerfectSquare(concatenatedNumber)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        scanner.close();
    }
    
    @Override
    private static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
