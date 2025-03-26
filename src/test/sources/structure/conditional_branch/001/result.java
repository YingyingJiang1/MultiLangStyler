import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner SCANNER = new Scanner(System.in);
        String S = SCANNER.nextLine();
        String T = SCANNER.nextLine();
        // Check if rotation is possible
        boolean isRotationPossible = checkRotation(S, T);
        
        System.out.println(isRotationPossible ? "Yes" : "No");
        SCANNER.close();
    }
    
    public static boolean chkRotation(String s, String t) {
        // Concatenate S with itself
        // This will contain all possible rotations of S
        String doubledS = s + s;// If lengths are different, rotation is impossible
        if (s.length() != t.length()) {
            return false;
        }
        // If T is a substring of doubledS, then T is a rotation of S
        return doubledS.contains(t);
    }
}
