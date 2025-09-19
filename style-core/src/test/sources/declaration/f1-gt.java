import java.util.*;

public class MergeStyle1 {

	// ===== 字段声明 =====
	private int id;private int version;private int count;   // merge
	private String name;
	private String description;       // split
	static double ratio = 0.5;static double factor = 1.2;
	final int MAX = 100;

	public void run() {
		// ===== 局部变量声明 =====
		int a = 1;int b = 2;int c = 3;
		int d;
		double x;double y = 3.14;double z;

		String s1 = "hello";
		String s2 = "world";String s3;

		// ===== 泛型容器声明 =====
		List<String> names;List<String> values = new ArrayList<>();
		List<Integer> numbers;

		// ===== 数组声明 =====
		int[] arr1;int[] arr2 = new int[5];
		int[] arr3;

		// ===== for 循环里的声明 =====
		for (int i = 0, j = 1; i < 3; i++, j++) { // merge
			String msg = "loop" + i;
			String res = "val" + j;
		}

		// ===== try-catch 里的声明 =====
		try {
			int t1 = 0;int t2 = 1;       // merge
		} catch (Exception e) {
			String err;
			String detail = e.getMessage();
		}
	}
}
