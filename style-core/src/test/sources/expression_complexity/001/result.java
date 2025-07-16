import java.util.Scanner;

public class MostDivisibleByTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        int maxDivisions = 0;
        
        int result = 1;
        
        scanner.close();for (int i = 1; i <= n; i++) {
            int current = i;
            
            int divisions = 0;

            while (current % 2 == 0) {
                current /= 2;
                divisions++;
            }
            
            if (divisions>maxDivisions) {
                maxDivisions = divisions;
                result = i;
            }
        }
        
        System.out.println(result);
    }
}
