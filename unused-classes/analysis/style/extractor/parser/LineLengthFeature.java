package org.example.analysis.style.extractor.parser;

import org.example.analysis.StyleType.LineLength;
import org.example.analysis.feature.FeatureVector;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.DoubleFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.parser.common.MyParser;

import java.util.Map;

public class LineLengthFeature extends ComputableStyleExtractor {
    @Override
    public void toComputableStyle(MyParser parser, Map<String, ComputableStyle> styleMap) {
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

        FeatureVector fv = new FeatureVector();
        fv.addDimension(LineLength.avgLineLengthAttr, new DoubleFeatureValue(averageLength));
        fv.addDimension(LineLength.maxLineLengthAttr, new DoubleFeatureValue(maxLength));
        fv.addDimension(LineLength.varianceAttr, new DoubleFeatureValue(variance));

        ComputableStyle cStyle = new ComputableStyle();
        cStyle.addRule(null, fv);
        styleMap.put(LineLength.styleType, cStyle);
    }
}
