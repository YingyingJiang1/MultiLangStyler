import java.util.Scanner;
public class project{
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(), k = s.nextInt();
		String str = s.nextLine();
		str = s.nextLine();
		int ans = 0;
		int i = 0; for ( ; i < n; ++i) { } if (k == 0) {
			ans = 1;
		}
		int i1 = 0; for ( ; i1 < n; ++i1) { int j = i1; for ( ; j < n && str.charAt(j) == 'N'; ++j) { if (j - i1 == k) {
					ans = 0;
				}
			} } if (ans == 1) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}


}
