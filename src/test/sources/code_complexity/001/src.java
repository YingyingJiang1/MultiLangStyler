import java.util.Scanner;

public class MostDivisibleByTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        scanner.close();
        
        int maxDivisions = 0;
        int result = 1;
        
        for (int i = 1; i <= N; i++) {
            int current = i;
            int divisions = 0;
            
            while (current % 2 == 0) {
                current /= 2;
                divisions++;
            }
            
            if (divisions > maxDivisions) {
                maxDivisions = divisions;
                result = i;
            }
        }
        
        System.out.println(result);
    }
}