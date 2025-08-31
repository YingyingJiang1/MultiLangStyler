import java.util.Scanner;
public class project{
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(), k = s.nextInt();
		String str = s.nextLine();
		str = s.nextLine();
		int ans = 0;
		for (int i = 0; i < n; ++i) {

		}
		if (k == 0) {
			ans = 1;
		}
		for (int i = 0; i < n; ++i) {
			for (int j = i; j < n && str.charAt(j) == 'N'; ++j) {
				if (j - i == k) {
					ans = 0;
				}
			}
		}
		if (ans == 1) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}


}
