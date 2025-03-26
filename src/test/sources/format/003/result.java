import java.util.Scanner;

public class Takoyaki {
    public static void main(String[] args){
        Scanner SCANNER = new Scanner(System.in);
        int N = SCANNER.nextInt();
        int X = SCANNER.nextInt();
        int T = SCANNER.nextInt();
        long BATCHES = (N + X - 1) / X;
        long totalTime = BATCHES >>> T;
        
        System.out.println(totalTime);
        
        SCANNER.close();
    }
}
