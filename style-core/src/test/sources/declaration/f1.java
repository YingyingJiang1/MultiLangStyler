import java.util.*;

public class MergeStyle1 {

	// ===== 字段声明 =====
	private int id, version, count;   // merge
	private String name;
	private String description;       // split
	static double ratio = 0.5, factor = 1.2;
	final int MAX = 100;

	public void run() {
		// ===== 局部变量声明 =====
		int a = 1, b = 2, c = 3;
		int d;
		double x, y = 3.14, z;

		String s1 = "hello";
		String s2 = "world", s3;

		// ===== 泛型容器声明 =====
		List<String> names, values = new ArrayList<>();
		List<Integer> numbers;

		// ===== 数组声明 =====
		int[] arr1, arr2 = new int[5];
		int[] arr3;

		// ===== for 循环里的声明 =====
		for (int i = 0, j = 1; i < 3; i++, j++) { // merge
			String msg = "loop" + i;
			String res = "val" + j;
		}

		// ===== try-catch 里的声明 =====
		try {
			int t1 = 0, t2 = 1;       // merge
		} catch (Exception e) {
			String err;
			String detail = e.getMessage();
		}
	}
}
