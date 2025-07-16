package org.example.analysis.style.extractor.parser;

import org.example.analysis.StyleType.BlankLine;
import org.example.analysis.feature.FeatureVector;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.featurevalue.DoubleFeatureValue;
import org.example.parser.common.MyParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BlankLineFeature extends ComputableStyleExtractor {
    @Override
    public void toComputableStyle(MyParser parser, Map<String, ComputableStyle> styleMap) {
        String[] lines = parser.getTokenStream().getText().split("\n");
        List<Integer> emptyLines = new ArrayList<>();
        // 获取所有空行编号
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].trim().isEmpty()) {
                emptyLines.add(i + 1);
            }
        }
        ComputableStyle cStyle = new ComputableStyle();
        FeatureVector fv = new FeatureVector();
        fv.addDimension(BlankLine.percentOfAllLinesAttr,
                new DoubleFeatureValue(lines.length == 0 ? 0 : emptyLines.size() / (double) lines.length));
        // 计算相邻空行的平均行距离
        double totalDistance = 0;
        for (int i = 0; i < emptyLines.size() - 1; i++) {
            totalDistance += emptyLines.get(i + 1) - emptyLines.get(i);
        }
        fv.addDimension(BlankLine.reasonablenessAttr,
                new DoubleFeatureValue(emptyLines.size() < 2 ? 0 : totalDistance / (double) (emptyLines.size() - 1)));

        cStyle.addRule(null, fv);
        styleMap.put(BlankLine.styleType, cStyle);
    }
}
