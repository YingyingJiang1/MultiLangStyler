package org.example.analysis.style.extractor.parser;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.analysis.StyleType;
import org.example.analysis.feature.FeatureVector;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.DoubleFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.style.Style;

import java.util.HashMap;
import java.util.Map;

public class LoopFeature extends ComputableStyleExtractor {
    @Override
    public void toComputableStyle(MyParser parser, Map<String, ComputableStyle> styleMap) {
        FeatureVector fv = new FeatureVector();
        Map<String, Integer> loopFrequency = new HashMap<String, Integer>();
        traverse((ExtendContext) parser.getRoot(), parser, loopFrequency);
        for (Map.Entry<String, Integer> entry : loopFrequency.entrySet()) {
            fv.addDimension(entry.getKey(), new DoubleFeatureValue(entry.getValue()));
        }

        ComputableStyle cStyle = new ComputableStyle();
        cStyle.addRule(null, fv);
        styleMap.put(StyleType.Loops.styleType, cStyle);
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

        for (ParseTree child : root.children) {
            if (child instanceof ExtendContext ctx && parser.belongToStmt(child)) {
                traverse(ctx, parser, loopFrequency);
            }
        }
    }
}
