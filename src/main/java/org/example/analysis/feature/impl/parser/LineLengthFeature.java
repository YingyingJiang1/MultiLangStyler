package org.example.analysis.feature.impl.parser;

import org.example.analysis.StyleType.LineLength;
import org.example.analysis.feature.ParserFeatureExtractor;
import org.example.analysis.feature.featurevalue.DoubleAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.parser.common.MyParser;

import java.util.Map;

public class LineLengthFeature implements ParserFeatureExtractor {
    @Override
    public void toFeatureVector(MyParser parser, Map<String, StyleVector> st2svMap) {
        String[] lines = parser.getTokenStream().getText().split("\n");
        // Initialize variables to calculate max, average, and variance
        int maxLength = Integer.MIN_VALUE;
        int totalLength = 0;
        int lineCount = lines.length;

        for (String line : lines) {
            int lineLength = line.length();
            maxLength = Math.max(maxLength, lineLength);
            totalLength += lineLength;
        }
        double averageLength = (double) totalLength / lineCount;

        double variance = 0;
        for (String line : lines) {
            variance +=  Math.pow(Math.abs(line.length() - averageLength), 2);
        }
        variance /= lineCount;

        StyleVector sv = new StyleVector();
        sv.addAttrValue(LineLength.avgLineLengthAttr, new DoubleAttrValue(averageLength));
        sv.addAttrValue(LineLength.maxLineLengthAttr, new DoubleAttrValue(maxLength));
        sv.addAttrValue(LineLength.varianceAttr, new DoubleAttrValue(variance));
        st2svMap.put(LineLength.styleType, sv);
    }
}
