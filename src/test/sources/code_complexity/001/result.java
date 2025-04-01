import java.util.Scanner;

public class MostDivisibleByTwo {
    public static void main(String[] args) {
        int RESULT = 1;
        
        int maxDivisions = 0;
        
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        
        scanner.close();for (int I = 1; I <= N; I++) {
            int DIVISIONS = 0;
            
            int CURRENT = I;

            while (CURRENT % 2 == 0) {
                CURRENT /= 2;
                DIVISIONS++;
            }
            
            if (DIVISIONS>maxDivisions) {
                maxDivisions = DIVISIONS;
                RESULT = I;
            }
        }
        
        System.out.println(RESULT);
    }
}
