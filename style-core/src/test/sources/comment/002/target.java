import java.util.Scanner;

public class CoffeeLikeStringChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input string
        String S = scanner.next();
        
        // Check if the string is coffee-like
        if (S.charAt(2) == S.charAt(3) && S.charAt(4) == S.charAt(5)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        scanner.close();
    }
}