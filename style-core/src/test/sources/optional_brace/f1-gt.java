public class NoBraceExample {
	public static void main(String[] args) {
		int x = 3;
		int y = 0;

		// ===== 级联 if-else （无大括号） =====
		if (x > 5){
			System.out.println("x > 5");
		}else if (x == 5){
			System.out.println("x == 5");
		}else if (x > 0){
			System.out.println("0 < x < 5");
		}else{
			System.out.println("x <= 0");
		}


		// ===== if 语句中的空语句 =====
		if (y == 0){
		 // 空语句，不执行任何操作
		}		else{
			System.out.println("y != 0");
		}

		// ===== for 循环（无大括号，单条语句） =====
		for (int i = 0; i < 3; i++){
			System.out.println("for loop i = " + i);
		}

		// ===== while 循环（空语句） =====
		int count = 0;
		while (count < 0){
		 // 永远不会执行，空循环体
		}

		// ===== while 循环（单条语句） =====
		int j = 0;
		while (j < 3){
			System.out.println("while loop j = " + j++);
		}

		// ===== do-while 循环（单条语句） =====
		int k = 0;
		do{
			System.out.println("do-while loop k = " + k++);
		}while (k < 3);
	}
}
