package org.example.styler.format.newline.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.grouper.Grouper;
import org.example.style.rule.StyleContext;

import java.util.*;

public class NewlineContext extends StyleContext {
    public static Grouper grouper;
    public int type1, type2; // newline between `type1` node and `type2` node
    // Total text length of left child and right child. This is useful when style conflicts happens.
    Map<Integer, Integer> totalTextLens = new HashMap<>();
    double avgLen;
    int count = 0;

    public NewlineContext(int type1, int type2, int totalTexLen) {
        this.type1 = type1;
        this.type2 = type2;
        totalTextLens.put(totalTexLen, 1);
        count = 1;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        Element contextEle = parent.addElement("context");
        String type1Name = getTypeName(type1, parser);
        String type2Name = getTypeName(type2, parser);
        contextEle.addElement("type_around").addText(
                Integer.toString(type1) + ":" + type1Name + "," +
                        Integer.toString(type2) + ":" + type2Name);
        contextEle.addElement("possible_total_text_length").addText(totalTextLens.keySet().toString());

        if (avgLen == 0 && !totalTextLens.isEmpty()) {
            long totalLen = 0, size = 0;
            for (Map.Entry<Integer, Integer> entry : totalTextLens.entrySet()) {
                totalLen += entry.getKey() * entry.getValue();
                size += entry.getValue();
            }
            avgLen = (double) totalLen / size;
        }
        contextEle.addElement("average_total_text_length").addText(Double.toString(avgLen));
        contextEle.addElement("count").addText(Integer.toString(count));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        Element contextEle = parent.element("context");
        String[] types = contextEle.element("type_around").getText().split("[:,]");
        type1 = Integer.parseInt(types[0]);
        type2 = Integer.parseInt(types[2]);

        List<Integer> textLens = toIntList(contextEle.element("possible_total_text_length").getText());
        for (int textLen : textLens) {
            totalTextLens.put(textLen, 0);
        }
        avgLen = Double.parseDouble(contextEle.element("average_total_text_length").getText());
        count = Integer.parseInt(contextEle.element("count").getText());
        
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

    private String getTypeName(int type, MyParser parser) {
        if (grouper == null || !grouper.isGroup(type)) {
            return type >= 0 ? parser.getRuleName(type) : parser.getTokenName(-type);
        } else {
            return grouper.getGroupName(type);
        }

    }

    private List<Integer> toIntList(String str) {
        List<Integer> ret = new ArrayList<>();
        if(str.length() <= 2) {
            return ret;
        }
        String[] strs = str.substring(1, str.length() - 1).split(",");
        for(String integer : strs) {
            ret.add(Integer.parseInt(integer));
        }
        return ret;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type1, type2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NewlineContext context) {
            return type1 == context.type1 && type2 == context.type2;
        }
        return false;
    }
}
