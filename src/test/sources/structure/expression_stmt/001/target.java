import java.util.Scanner;
public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int []h = new int [n];
		
		for(int i = 0; i < n ; i++) {
			h[i] = sc.nextInt()-1;
		
		}
		sc.close();
		int temp = -1;
		
		for(int i = 0; i < n-1 ; i++) {
			if(h[i] - h[i+1] == 1) {
				h[i+1] = h[i+1] + 1;
			}
			if(h[i] - h[i+1] >= 2) {
				temp = 0;
			break;
		 }
		}
		if(temp == -1) {
			System.out.println("Yes");
			
		}
		if(temp == 0) {
			System.out.println("No");
		}

	}
	}
