package org.example.styler.format.newline.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.RuleGrouper;
import org.example.style.rule.StyleContext;

import java.util.*;

public class NewlineContext extends StyleContext {
    public static RuleGrouper grouper;
    // Syntax rule types adjacent to the newline character.
    public String typeName1, typeName2;
    // The minimum sum of code blocks preceding and following the newline.
    // This field is useful in the following cases:
    // 1. more than one newline(blank lines) between two statement-level code blocks
    // 2. No newline between two single statements
    // Other cases, this field is set to 0.
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
        double distance = INIT_DISTANCE;
        boolean textLengthMeet = true;
        if (targetContext instanceof NewlineContext context) {
            if (Objects.equals(typeName1, context.typeName1)) {
                distance -= 2;
            } else if(Objects.equals(typeName1, "") ) {
                distance -= 1;
            }
            if (Objects.equals(typeName2, context.typeName2)) {
                distance -= 2;
            } else if(Objects.equals(typeName2, "") ) {
                distance -= 1;
            }
            textLengthMeet = context.minTextLength >= minTextLength;
        }
        return textLengthMeet && distance < INIT_DISTANCE ? distance : INVALID_DISTANCE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeName1, typeName2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NewlineContext context) {
            return Objects.equals(typeName1, context.typeName1) && Objects.equals(typeName2, context.typeName2);
        }
        return false;
    }
}
