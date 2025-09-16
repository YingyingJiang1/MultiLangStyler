package org.example.styler.structure.style;

import java.util.HashMap;
import java.util.Map;

public class CategoryResult {
	Map<Integer, Integer> id2writting = new HashMap<>();

	public void add(int id, int writingIndex) {
		id2writting.put(id, writingIndex);
	}
}
