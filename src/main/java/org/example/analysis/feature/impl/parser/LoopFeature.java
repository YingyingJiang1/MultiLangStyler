package org.example.analysis.feature.impl.parser;

import org.example.analysis.StyleType;
import org.example.analysis.feature.ParserFeatureExtractor;
import org.example.analysis.feature.featurevalue.DoubleAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

import java.util.HashMap;
import java.util.Map;

public class LoopFeature implements ParserFeatureExtractor {
    @Override
    public void toFeatureVector(MyParser parser, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        Map<String, Integer> loopFrequency = new HashMap<String, Integer>();
        traverse((ExtendContext) parser.getRoot(), parser, loopFrequency);
        for (Map.Entry<String, Integer> entry : loopFrequency.entrySet()) {
            sv.addAttrValue(entry.getKey(), new DoubleAttrValue(entry.getValue()));
        }
        st2svMap.put(StyleType.Loops.styleType, sv);
    }

    private void traverse(ExtendContext root, MyParser parser,  Map<String, Integer> loopFrequency) {
        if (root.getRuleIndex() == parser.getRuleForStmt()) {
            ExtendContext forcontrol = (ExtendContext) root.getChild(0);
            if (forcontrol.getChildCount() == 1) {
                loopFrequency.put(StyleType.Loops.forEachAttr, loopFrequency.getOrDefault(StyleType.Loops.forEachAttr, 0) + 1);
            } else {
                loopFrequency.put(StyleType.Loops.forAttr, loopFrequency.getOrDefault(StyleType.Loops.forAttr, 0) + 1);
            }

        } else if (root.getRuleIndex() == parser.getRuleWhileStmt()) {
            loopFrequency.put(StyleType.Loops.whileAttr, loopFrequency.getOrDefault(StyleType.Loops.whileAttr, 0) + 1);
        } else if (root.getRuleIndex() == parser.getRuleDoWhileStmt()) {
            loopFrequency.put(StyleType.Loops.doWhileAttr,  loopFrequency.getOrDefault(StyleType.Loops.doWhileAttr, 0) + 1);
        }
    }
}
