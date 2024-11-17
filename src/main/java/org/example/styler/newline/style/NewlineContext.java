package org.example.styler.newline.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.rule.StyleContext;
import org.example.parser.AntlrHelper;
import org.example.style.format.grouper.Grouper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class NewlineContext extends StyleContext {
    public static Grouper grouper;
    public int type1, type2;
    // Total text length of left child and right child. This is useful when style conflicts happens.
    Map<Integer, Integer> totalTextLens = new HashMap<>();
    double avgLen;
    int count = 0;

    public NewlineContext(int type1, int type2) {
        this.type1 = type1;
        this.type2 = type2;
    }

    public NewlineContext(int type1, int type2, int totalTextLen) {
        this.type1 = type1;
        this.type2 = type2;
        this.totalTextLens.put(totalTextLen, 1);
        ++count;
    }

    public NewlineContext() {
    }

    public NewlineContext getGroupedContext() {
        if (grouper == null) {
            return null;
        }

        NewlineContext newlineContext = new NewlineContext(grouper.getGroupId(type1), grouper.getGroupId(type2));
        newlineContext.totalTextLens.putAll(totalTextLens);
        newlineContext.avgLen = avgLen;
        return newlineContext;
    }


    public void merge(NewlineContext newlineContext) {
        if (this.equals(newlineContext)) {
            for (Map.Entry<Integer, Integer> entry : newlineContext.totalTextLens.entrySet()) {
                int key = entry.getKey(), value = entry.getValue();
                totalTextLens.merge(key, value, Integer::sum);
                count += value;
            }
        }
    }

    public double calculateDistance(NewlineContext newlineContext) {
        double dis = 0;
        int len = newlineContext.totalTextLens.keySet().iterator().next();
        if (totalTextLens.get(len) == null) {
            dis += Math.abs(len - avgLen);
        }
        return Integer.MAX_VALUE - count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewlineContext newlineContext = (NewlineContext) o;
        return type1 == newlineContext.type1 && type2 == newlineContext.type2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type1, type2);
    }

    @Override
    public void addElement(Element parent, Parser parser) {
        Element contextEle = parent.addElement("context");
        String type1Name = grouper == null ? AntlrHelper.getTypeName(type1) : grouper.getGroupName(type1);
        String type2Name = grouper == null ? AntlrHelper.getTypeName(type2) : grouper.getGroupName(type2);
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
    public Object parseElement(Element parent, Parser parser) {
        Element contextEle = parent.element("context");
        String[] types = contextEle.element("type_around").getText().split("[:,]");
        type1 = Integer.parseInt(types[0]);
        type2 = Integer.parseInt(types[2]);

        List<Integer> textLens = AntlrHelper.toIntList(contextEle.element("possible_total_text_length").getText());
        for (int textLen : textLens) {
            totalTextLens.put(textLen, 0);
        }
        avgLen = Double.parseDouble(contextEle.element("average_total_text_length").getText());
        count = Integer.parseInt(contextEle.element("count").getText());
        return this;
    }
}
