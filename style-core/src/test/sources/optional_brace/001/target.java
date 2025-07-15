import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long d = sc.nextLong();

        long lcm = lcm(c, d);
        long count = b - a + 1;
        count -= b / c - (a - 1) / c;
        count -= b / d - (a - 1) / d;
        count += b / lcm - (a - 1) / lcm;

        System.out.println(count);
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }
}