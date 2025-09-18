public class BraceExample {
	public static void main(String[] args) {
		int x = 3;
		int y = 0;

		// ===== 级联 if-else （总是写大括号） =====
		if (x > 5) 
			System.out.println("x > 5");
		else if (x == 5) 
			System.out.println("x == 5");
		else if (x > 0) 
			System.out.println("0 < x < 5");
		else 
		System.out.println("x <= 0");

		if (y == 0) ;
		else 
		System.out.println("y != 0");

		for (int i = 0; i < 3; i++) 
			System.out.println("for loop i = " + i);

		int count = 0;
		while (count < 0) ;
		int j = 0;
		while (j < 3) 
			System.out.println("while loop j = " + j++);

		int k = 0;
		do 
			System.out.println("do-while loop k = " + k++);
		while (k < 3);
	}
}
