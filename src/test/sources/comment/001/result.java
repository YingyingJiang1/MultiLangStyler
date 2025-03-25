import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); 
        int n = scanner.nextInt();
        HashSet<String> items = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String item = scanner.nextLine();
            items.add(item);
        }
        System.out.println(items.size());

        scanner.close();
    }
}
