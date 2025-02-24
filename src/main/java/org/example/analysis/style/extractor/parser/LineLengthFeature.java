package org.example.analysis.style.extractor.parser;

import org.example.analysis.StyleType.LineLength;
import org.example.analysis.style.ParserFeatureExtractor;
import org.example.analysis.feature.featurevalue.DoubleFeatureValue;
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
        sv.addAttrValue(LineLength.avgLineLengthAttr, new DoubleFeatureValue(averageLength));
        sv.addAttrValue(LineLength.maxLineLengthAttr, new DoubleFeatureValue(maxLength));
        sv.addAttrValue(LineLength.varianceAttr, new DoubleFeatureValue(variance));
        st2svMap.put(LineLength.styleType, sv);
    }
}
