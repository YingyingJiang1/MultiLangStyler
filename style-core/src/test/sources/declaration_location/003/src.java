import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)) {

			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			
			int countT = c / b + (c % b > 0 ? 1 : 0);
			int countA = a / d + (a % d > 0 ? 1 : 0);
			
			System.out.println(countA < countT ? "No" : "Yes"); 

		}
	}

}