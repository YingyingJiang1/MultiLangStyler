import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int T = scanner.nextInt();
        
        long batches = (N + X - 1) / X;
        long totalTime = batches * T;
        
        System.out.println(totalTime);
    }
}