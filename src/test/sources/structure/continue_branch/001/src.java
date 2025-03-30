
public static void main(string[] args) throws Exception {
	Scanner sc = new Scanner(System.in);
	out = new PrintWriter(System.out);
	String s = sc.next();
	boolean is = false;
	int t = s.length();
	for (int i = 1; s.length() > i; i++)
		if ('1' == s.charAt(i)) {
			continue;
		} else {
			is = true;
			if (is) out.print(t / 2 + t % 2);
			else {
				out.print(t / 2 + t % 2);
				out.close();
			}
		}

}