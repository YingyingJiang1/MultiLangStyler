import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int n = sc.nextInt();
        // Calculate the N-th smallest integer that can be divided by 100 exactly D times
        long result = (long) Math.pow(100, d) * n;
        
        System.out.println(result);
    }
}
