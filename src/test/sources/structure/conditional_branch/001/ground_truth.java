import java.util.Scanner;

public class StringRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input strings
        String firstString = scanner.nextLine();
        String secondString = scanner.nextLine();
        
        // Check if rotation is possible
        boolean isRotationPossible = checkIfRotationExists(firstString, secondString);
        
        // Output the result
        if (isRotationPossible) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        scanner.close();
    }
    
    /**
     * Checks if one string is a rotation of another
     * @param firstString The original string
     * @param secondString The string to check for rotation
     * @return true if secondString is a rotation of firstString, false otherwise
     */
    private static boolean checkIfRotationExists(String firstString, String secondString) {
        // If lengths are different, rotation is impossible
        if (firstString.length() != secondString.length()) {
            return false;
        }
        
        // Create concatenated string to check all possible rotations
        String concatenatedString = firstString + firstString;
        
        // Check if secondString is present in concatenatedString
        return concatenatedString.contains(secondString);
    }
}