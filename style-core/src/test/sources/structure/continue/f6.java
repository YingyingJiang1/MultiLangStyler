import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String str = in.next();
		System.out.println(getAns(str, N));
		in.close();
	}

	public static int getAns(String str, int N) {
		int ans = 0;
		StringBuilder sb = new StringBuilder(str);
		for (int i = 25; i >= 0; i--) {
			char ch = (char) (97 + i);
			for (int j = 0; j < sb.length(); j++) {
				if (sb.length() == 1) {
					break;
				}
				char ch1 = sb.charAt(j);
				if (ch != ch1) {
					continue;
				}
//				System.out.println(j);
				if (j == 0 && ((int) ch - 1 == (int) sb.charAt(j + 1))) {
					//System.out.println("leftMost " + j);
					sb.deleteCharAt(j);
					ans++;
					j -= 1;
					continue;
				} else if (j == sb.length() - 1 && ((int) ch - 1 == (int) sb.charAt(j - 1))) {
					//System.out.println("rightMost " + j);
					sb.deleteCharAt(j);
					ans++;
					j -= 1;
					continue;
				} else if ((j < sb.length() - 1 && (int) ch - 1 == (int) sb.charAt(j + 1))
						|| (j > 0 && (int) ch - 1 == (int) sb.charAt(j - 1))) {
					//System.out.println("middle " + j);
					sb.deleteCharAt(j);
					ans++;
					j -= 2;
					//System.out.println("middle " + j + " " + sb.toString() + " " + sb.length());
					continue;
				}
				//System.out.println(sb.toString());
			}
		}
		return ans;
	}

}
