package org.example.styler.linewrapping.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.interfaces.StyleProperty;

import java.util.*;

public class LineWrappingProperty extends StyleProperty {
    // Where to add newline, before or after the specific token ?
    int tokenType;
    boolean before = true;

    // Where to start the successive lines, align with the specific token or indent fixed length?
    public Set<Integer> alignTokens = new HashSet<>();
    public int fixedIndention = 0;
    private List<Integer> fixedIndentions = new ArrayList<>();
    public int count = 1;

    public LineWrappingProperty() {

    }

    public LineWrappingProperty(int count) {
        this.count = 0;
    }

    public LineWrappingProperty(LineWrappingProperty lineWrappingProperty) {
        this.alignTokens = lineWrappingProperty.alignTokens;
        this.fixedIndention = lineWrappingProperty.fixedIndention;
        this.fixedIndentions = lineWrappingProperty.fixedIndentions;
        this.count = lineWrappingProperty.count;
    }

    public void addAlignToken(int type) {
        alignTokens.add(type);
    }

    public void addIndention(int indention) {
        if (indention >= fixedIndentions.size()) {
            fixedIndentions.addAll(Collections.nCopies(indention - fixedIndentions.size() + 1, 0));
        }
        fixedIndentions.set(indention, fixedIndentions.get(indention) + 1);
    }

    public void merge(LineWrappingProperty lineWrappingProperty) {
        count += lineWrappingProperty.count;
        alignTokens.retainAll(lineWrappingProperty.alignTokens);
        for (Integer indention : lineWrappingProperty.fixedIndentions) {
            addIndention(indention);
        }
    }

    public void fill() {
        int maxCount = 0;
        for (int i = 0; i < fixedIndentions.size(); i++) {
            if (fixedIndentions.get(i) >= maxCount) {
                maxCount = fixedIndentions.get(i);
                fixedIndention = i;
            }
        }
    }


    @Override
    public void addElement(Element parent) {
        Element ele = parent.addElement("property");
        ele.addElement("aligns").addText(alignTokens.toString());
        ele.addElement("fix_indention").addText(Integer.toString(fixedIndention));
    }

    @Override
    public void parseElement(Element parent) {
        Element ele = parent.element("property");
        String[] strs = ele.elementText("aligns").split(",");
        for (String str : strs) {
            alignTokens.add(Integer.parseInt(str));
        }
        IndentionRule indentionRule = new IndentionRule();
        fixedIndention = Integer.parseInt(ele.elementText("fix_indention"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineWrappingProperty lineWrappingProperty = (LineWrappingProperty) o;
        return Objects.equals(alignTokens, lineWrappingProperty.alignTokens) && Objects.equals(fixedIndention, lineWrappingProperty.fixedIndention);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alignTokens, fixedIndention);
    }

    @Override
    public void addElement(Element parent, Parser parser) {

    }

    @Override
    public Object parseElement(Element parent, Parser parser) {
        return null;
    }
}
