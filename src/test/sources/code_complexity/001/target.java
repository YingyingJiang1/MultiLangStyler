import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input string
        String S = scanner.nextLine();
        
        // Check if the string is coffee-like
        boolean isCoffeeLike = checkCoffeeLike(S);
        
        // Print the result
        System.out.println(isCoffeeLike ? "Yes" : "No");
        
        scanner.close();
    }
    
    public static boolean checkCoffeeLike(String s) {
        // Check if the 3rd and 4th characters are equal
        boolean condition1 = s.charAt(2) == s.charAt(3);
        
        // Check if the 5th and 6th characters are equal
        boolean condition2 = s.charAt(4) == s.charAt(5);
        
        // Return true only if both conditions are satisfied
        return condition1 && condition2;
    }
}