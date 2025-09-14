package org.example.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathUtil {
	public static double median(List<? extends Number> numbers) {
		if (numbers == null || numbers.isEmpty()) {
			throw new IllegalArgumentException("List is null or empty");
		}

		// 转为 double
		List<Double> sorted = new ArrayList<>();
		for (Number num : numbers) {
			sorted.add(num.doubleValue());
		}
		Collections.sort(sorted);

		int n = sorted.size();
		if (n % 2 == 1) {
			return sorted.get(n / 2); // 奇数，取中间
		} else {
			return (sorted.get(n / 2 - 1) + sorted.get(n / 2)) / 2.0; // 偶数，取平均
		}
	}
}
