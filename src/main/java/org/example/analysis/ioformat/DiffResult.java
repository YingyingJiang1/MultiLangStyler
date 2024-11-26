package org.example.analysis.ioformat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffResult {
    private Map<String, List<InputPair>> consistentPairs = new HashMap<>();
    private Map<String, List<InputPair>> inconsistentPairs = new HashMap<>();

    public void add(String styleName, InputPair inputPair, boolean consistent) {
        if (consistent) {
            consistentPairs.computeIfAbsent(styleName, k -> new ArrayList<>()).add(inputPair);
        } else {
            inconsistentPairs.computeIfAbsent(styleName, k -> new ArrayList<>()).add(inputPair);
        }
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<>(consistentPairs.keySet());
        keys.addAll(inconsistentPairs.keySet());
        for (String key : keys) {
            sb.append(key).append(": ");
            int consistentCount = consistentPairs.get(key) == null ? 0 : consistentPairs.get(key).size();
            sb.append("Consistent pairs:").append(consistentCount).append(", ");
            int inconsistentCount = inconsistentPairs.get(key) == null ? 0 : inconsistentPairs.get(key).size();
            sb.append("Inconsistent pairs:").append(inconsistentCount).append("\n");
        }
        return sb.toString();
    }
}
