package org.example.styler.format.newline.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.parser.common.group.RuleGrouper;
import org.example.style.rule.StyleContext;

import java.util.*;

public class NewlineContext extends StyleContext {
    public static RuleGrouper grouper;
    // Syntax rule types adjacent to the newline character.
    public String typeName1, typeName2;
    // The minimum sum of code blocks preceding and following the newline.
    public int minTextLength;

    public NewlineContext(String typeName1, String typeName2) {
        this.typeName1 = typeName1;
        this.typeName2 = typeName2;
    }

    public NewlineContext(String typeName1, String typeName2, int minTextLength) {
        this.typeName1 = typeName1;
        this.typeName2 = typeName2;
        this.minTextLength = minTextLength;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
       parent.addAttribute("type1", typeName1);
       parent.addAttribute("type2", typeName2);
       parent.addAttribute("minCodeBockLines", Integer.toString(minTextLength));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        typeName1 = parent.attributeValue("type1");
        typeName2 = parent.attributeValue("type2");
        if (parent.attribute("minCodeBockLines") != null) {
            minTextLength = Integer.parseInt(parent.attributeValue("minCodeBockLines"));
        }
    }


    @Override
    public double calculateDistance(StyleContext targetContext) {
        double distance = -3;
        if (targetContext instanceof NewlineContext context) {
           distance += Objects.equals(typeName1, "") || Objects.equals(typeName1, context.typeName1) ? 1 : 0;
           distance += Objects.equals(typeName2, "") || Objects.equals(typeName2, context.typeName2) ? 1 : 0;
           distance += context.minTextLength >= minTextLength ? 1 : 0;
        }
        return distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeName1, typeName2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NewlineContext context) {
            return typeName1 == context.typeName1 && typeName2 == context.typeName2;
        }
        return false;
    }
}
