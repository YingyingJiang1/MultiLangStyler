import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int N = sc.nextInt();

        // Calculate the N-th smallest integer that can be divided by 100 exactly D times
        long result = (long) Math.pow(100, D) * N;

        System.out.println(result);
    }
}