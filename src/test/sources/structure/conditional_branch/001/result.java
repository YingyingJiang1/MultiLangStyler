import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        // Check if rotation is possible
        boolean isRotationPossible = checkRotation(s, t);
        
        System.out.println(isRotationPossible ? "Yes" : "No");
        scanner.close();
    }
    
    public static boolean checkRotation(String s, String t) {
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
