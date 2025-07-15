import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input strings
        String S = scanner.nextLine();
        String T = scanner.nextLine();
        
        // Check if rotation is possible
        boolean isRotationPossible = checkRotation(S, T);
        
        // Print result
        System.out.println(isRotationPossible ? "Yes" : "No");
        
        scanner.close();
    }
    
    public static boolean checkRotation(String S, String T) {
        // If lengths are different, rotation is impossible
        if (S.length() != T.length()) {
            return false;
        }
        
        // Concatenate S with itself
        // This will contain all possible rotations of S
        String doubledS = S + S;
        
        // If T is a substring of doubledS, then T is a rotation of S
        return doubledS.contains(T);
    }
}