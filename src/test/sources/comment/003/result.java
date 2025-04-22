import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create a Scanner object to take input
        Scanner sc = new Scanner(System.in);
        // take an integer as input
        int D = sc.nextInt();
        // take another integer as input
        int N = sc.nextInt();
        // calculate the result by raising 100 to the power of D and then multiplying the result by N
        // cast the result to long to prevent overflow
        long result = (long) Math.pow(100, D) * N;
        // print the result
        System.out.println(result);
    }
}
