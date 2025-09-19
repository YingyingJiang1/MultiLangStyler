import java.util.*;

public class MergeStyle2 {

	// ===== 字段声明 =====
	private int id;private int version;                 // merge
	private int level;
	final String NAME = "Default";           // split
	static double ratio = 0.5;static double factor = 1.2; // merge
	List<String> tags;                        // split
	List<String> categories;List<String> labels = new ArrayList<>(); // merge

	public void run() {
		// ===== 局部变量声明 =====
		int a = 1;int b = 2;
		int c;                                // split
		final int MAX = 100;final int MIN = 0;         // merge
		double x;double y = 3.14;                   // merge
		double z;

		// ===== 字符串变量及尾注释 =====
		String s1 = "hello";
		String s2 = "world";String s3;
		// split
		String s4;

		// ===== 泛型与数组 =====
		List<Integer> numbers;List<Integer> values = new ArrayList<>();
		List<Integer> backup;
		int[] arr1;int[] arr2 = new int[5];
		int[] arr3;


	}
}
