package org.example.styler.format.newline.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.grouper.Grouper;
import org.example.style.rule.StyleContext;

import java.util.HashMap;
import java.util.Map;

public class NewlineContext extends StyleContext {
    public static Grouper grouper;
    public int type1, type2; // newline between `type1` node and `type2` node
    // Total text length of left child and right child. This is useful when style conflicts happens.
    Map<Integer, Integer> totalTextLens = new HashMap<>();
    double avgLen;
    int count = 0;

    @Override
    public void addElement(Element parent, Parser parser) {

    }

    @Override
    public Object parseElement(Element parent, Parser parser) {
        return null;
    }


    @Override
    public double calculateDistance(StyleContext targetContext) {
        double distance = 0;
        if (targetContext instanceof NewlineContext newlineContext) {
            int len = newlineContext.totalTextLens.keySet().iterator().next();
            if(totalTextLens.get(len) == null) {
                distance += Math.abs(len - avgLen);
            }
            return Integer.MAX_VALUE - count;
        }
        return super.calculateDistance(targetContext);
    }
}
