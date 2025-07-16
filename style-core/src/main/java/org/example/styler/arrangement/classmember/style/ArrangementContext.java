package org.example.styler.arrangement.classmember.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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


    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("type", typeType);
        String statStr = statistic.entrySet().toString();
        parent.addAttribute("statistic", statStr.substring(1, statStr.length() - 1));
    }

    public void parseElement(Element parent, MyParser parser) {
        typeType = parent.attributeValue("type");
        if (parent.attributeValue("statistic") != null) {
            String[] statisticStrs = parent.attributeValue("statistic").replace(" ", "").split("[,=]");
            for (int i = 0; i < statisticStrs.length; i += 2) {
                statistic.put(statisticStrs[i], Integer.parseInt(statisticStrs[i + 1]));
            }
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeType, statistic);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof ArrangementContext context) {
            return typeType.equals(context.typeType) && statistic.equals(context.statistic);
        }
        return false;
    }
}
