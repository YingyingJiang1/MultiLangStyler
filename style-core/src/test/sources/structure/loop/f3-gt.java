public class LoopExample {
	public static void main(String[] args) {
		int sum = 0;

		// 循环变量 i 定义在循环外
		int i = 0;
		while (i < 5) {
			sum += i;
			i += 1;
		}

		// 这里还能访问 i
		System.out.println("循环结束后 i = " + i);
		System.out.println("sum = " + sum);
	}
}
