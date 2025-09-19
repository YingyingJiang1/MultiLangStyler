import java.util.*;

public class SplitStyle1 {

	// ===== 字段声明 =====
	private int id;
	private int version;
	// 下面两个变量相关
	private int level, score;
	static double ratio;                     // split
	List<String> tags;
	List<String> categories, labels = new ArrayList<>();

	public void run() {
		// ===== 局部变量声明 =====
		int a = 1;                           // tail comment
		int b = 2;
		int c = 3, d = 4;
		final int MAX = 100;
		double x;
		double y = 3.14;
		// split
		double z;

		// ===== 字符串变量及尾注释 =====
		String s1 = "hello";
		// 下一个变量用于输出
		String s2 = "world";
		String s3 = "java", s4 = "python";
		String s5;

		// ===== 泛型与数组 =====
		List<Integer> numbers;
		List<Integer> values = new ArrayList<>();
		int[] arr1;
		// 合并数组变量
		int[] arr2, arr3 = new int[5];

		// ===== 循环里的声明 =====
		for (int i = 0; i < 3; i++) {
			String loopMsg = "msg" + i;
			final String NAME = "Default";
			final int CONST = i;
		}

		// ===== try-catch里的声明 =====
		try {
			int t1;
			int t2 = 1;
			int t3, t4 = 2;
		} catch (Exception e) {
			String err;
			String msg = e.getMessage();
		}
	}
}
