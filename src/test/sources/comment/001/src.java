import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        
        // Use HashSet to store unique items
        HashSet<String> items = new HashSet<>();
        
        // Read N strings and add them to the HashSet
        for (int i = 0; i < N; i++) {
            String item = scanner.nextLine();
            items.add(item);
        }
        
        // Print the number of unique items
        System.out.println(items.size());
        
        scanner.close();
    }
}