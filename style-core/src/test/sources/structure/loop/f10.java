public class LoopExample {
	public static void main(String[] args) {
		int sum = 0;

		// 循环变量 i 定义在循环外
		int i = 0;
		while (i < 5) {
			sum += i;
			i += 1;
		}

		int j = 0;
		for (; j < 10; sum++) {
			++j;
		}

	}
}
