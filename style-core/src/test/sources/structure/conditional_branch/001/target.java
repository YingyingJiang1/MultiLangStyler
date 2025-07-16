import java.util.Scanner;

public class SummerVacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N and M
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        // Array to store the days required for each assignment
        int[] A = new int[M];
        
        // Read the days required for each assignment
        int totalAssignmentDays = 0;
        for (int i = 0; i < M; i++) {
            A[i] = scanner.nextInt();
            totalAssignmentDays += A[i];
        }
        
        // Calculate the maximum hangout days
        int hangoutDays = N - totalAssignmentDays;
        
        // If total required days for assignments exceed vacation days, output -1
        if (hangoutDays < 0) {
            System.out.println(-1);
        } else {
            System.out.println(hangoutDays);
        }
        
        scanner.close();
    }
}