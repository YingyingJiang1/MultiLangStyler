package org.example.styler.arrangement.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Attribute;
import org.dom4j.Element;
import org.example.style.StyleContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/25 21:43
 */
public class ArrangementContext extends StyleContext {
    String typeType;
    Map<String, Integer> statistic = new HashMap<>();

    public ArrangementContext() {
    }

    public ArrangementContext(String typeType, Map<String, Integer> statistic) {
        this.typeType = typeType;
        this.statistic = statistic;
    }

    public void addElement(Element parent, Parser parser) {
        Element contentEle = parent.addElement("content_context");
        contentEle.addText(typeType);
        for (Map.Entry<String, Integer> entry : statistic.entrySet()) {
            contentEle.addAttribute(entry.getKey(), entry.getValue().toString());
        }
    }

    // Calculate the degree that $this including $contentContext.
    public int inclusionDegree(ArrangementContext arrangementContext) {
        int degree = typeType.equals(arrangementContext.typeType) ? 1 : -1;
        for (Map.Entry<String, Integer> entry : statistic.entrySet()) {
            Integer value = arrangementContext.statistic.get(entry.getKey());
            if (value != null && entry.getValue() >= value) {
                ++degree;
            } else {
                --degree;
            }
        }
        return degree;
    }

    public boolean include(ArrangementContext arrangementContext) {
        if (!typeType.equals(arrangementContext.typeType)) {
            return false;
        }
        for (Map.Entry<String, Integer> entry : arrangementContext.statistic.entrySet()) {
            Integer value = statistic.get(entry.getKey());
            if (value == null || entry.getValue() >= value) {
                return false;
            }
        }
        return true;
    }


    public Object parseElement(Element parent, Parser parser) {
        Element contentEle = parent.element("content_context");
        ArrangementContext arrangementContext = new ArrangementContext();
        arrangementContext.typeType = contentEle.getText();
        List<Attribute> attributes = contentEle.attributes();
        for (Attribute attribute : attributes) {
            arrangementContext.statistic.put(attribute.getName(), Integer.parseInt(attribute.getValue()));
        }
        return arrangementContext;
    }

}
