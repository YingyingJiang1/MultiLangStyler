import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }
        int q = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < q; i++) {
            if (set.contains(scanner.nextInt())) {
                count++;
            }
        }
        System.out.println(count);
    }
}