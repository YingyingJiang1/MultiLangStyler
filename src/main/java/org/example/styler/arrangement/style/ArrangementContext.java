package org.example.styler.arrangement.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Attribute;
import org.dom4j.Element;
import org.example.style.rule.StyleContext;

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

    // Calculate the degree that $this including $contentContext.
    int inclusionDegree(ArrangementContext context) {
        int degree = typeType.equals(context.typeType) ? 1 : -1;
        for (Map.Entry<String, Integer> entry : statistic.entrySet()) {
            Integer value = context.statistic.get(entry.getKey());
            if (value != null && entry.getValue() >= value) {
                ++degree;
            } else {
                --degree;
            }
        }
        return degree;
    }

    boolean include(ArrangementContext context) {
        if (!typeType.equals(context.typeType)) {
            return false;
        }
        for (Map.Entry<String, Integer> entry : context.statistic.entrySet()) {
            Integer value = statistic.get(entry.getKey());
            if (value == null || entry.getValue() >= value) {
                return false;
            }
        }
        return true;
    }


    public void addElement(Element parent, Parser parser) {
        parent.addText(typeType);
        for (Map.Entry<String, Integer> entry : statistic.entrySet()) {
            parent.addAttribute(entry.getKey(), entry.getValue().toString());
        }
    }


    public ArrangementContext parseElement(Element parent, Parser parser) {
        typeType = parent.getText();
        List<Attribute> attributes = parent.attributes();
        for (Attribute attribute : attributes) {
            statistic.put(attribute.getName(), Integer.parseInt(attribute.getValue()));
        }
        return this;
    }

}
