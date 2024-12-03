package org.example.analysis.feature.impl;

import org.example.analysis.StyleType.BlankLine;
import org.example.analysis.feature.FeatureExtractor;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.featurevalue.DoubleAttrValue;
import org.example.parser.common.MyParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BlankLineFeatureExtractor extends FeatureExtractor {
    @Override
    public void toFeatureVector(MyParser parser, Map<String, StyleVector> st2svMap) {
        String[] lines = parser.getTokenStream().getText().split("\n");
        List<Integer> emptyLines = new ArrayList<>();
        // 获取所有空行编号
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].trim().isEmpty()) {
                emptyLines.add(i + 1);
            }
        }
        StyleVector sv = new StyleVector();
        sv.addAttrValue(BlankLine.percentOfAllLinesAttr, new DoubleAttrValue(lines.length == 0 ? 0 : emptyLines.size() / (double) lines.length));
        // 计算相邻空行的平均行距离
        double totalDistance = 0;
        for (int i = 0; i < emptyLines.size() - 1; i++) {
            totalDistance += emptyLines.get(i + 1) - emptyLines.get(i);
        }
        sv.addAttrValue(BlankLine.reasonablenessAttr, new DoubleAttrValue(emptyLines.isEmpty() ? 0 : totalDistance / (double) (emptyLines.size() - 1)));

        st2svMap.put(BlankLine.styleType, sv);
    }
}
