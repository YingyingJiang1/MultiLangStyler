package org.example.analysis.feature.impl;

import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.featurevalue.DoubleFeatureValue;
import org.example.parser.common.MyParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BlankLineStyleFeature extends StyleFeature {
    @Override
    public void toFeatureVector(MyParser parser, Map<String, StyleVector> styleFeatures) {
        String[] lines = parser.getTokenStream().getText().split("\n");
        List<Integer> emptyLines = new ArrayList<>();
        // 获取所有空行编号
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].trim().isEmpty()) {
                emptyLines.add(i + 1);
            }
        }
        StyleVector fv = new StyleVector();
        fv.addFeature("Density", new DoubleFeatureValue(lines.length == 0 ? 0 : emptyLines.size() / (double) lines.length));
        double totalDistance = 0;
        for (int i = 0; i < emptyLines.size() - 1; i++) {
            totalDistance += emptyLines.get(i + 1) - emptyLines.get(i);
        }
        fv.addFeature("Avg distance of adjacent blank lines", new DoubleFeatureValue(emptyLines.isEmpty() ? 0 : totalDistance / (double) (emptyLines.size() - 1)));

        styleFeatures.put("Blank line", fv);
    }
}
