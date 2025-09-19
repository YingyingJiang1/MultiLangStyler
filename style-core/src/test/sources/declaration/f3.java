import java.util.*;

public class SplitStyle2 {

	int id;
	int version;

	public void run() {
		int a = 1;
		// important variable
		int b = 2;
		int c = 3;

		int x = 10;
		final int y = 20;
		int z = 30;

		double d1;
		double d2 = 1.0;
		double d3;

		String s1 = "hello";
		String s2 = "world";
		String s3; // unused

		List<String> names;
		List<String> values = new ArrayList<>();
		List<String> cache;

		int[] arr1;
		int arr2[];
		int[] arr3 = new int[5];

		for (int i = 0; i < 2; i++) {
			int f1 = i;
			int f2 = i + 1;
		}

		try {
			int t1 = 0;
			int t2 = 1;
		} catch (Exception e) {
			int code;
			int level = -1;
		}
	}
}
