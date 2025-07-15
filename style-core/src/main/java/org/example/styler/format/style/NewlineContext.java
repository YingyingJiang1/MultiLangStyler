package org.example.styler.format.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.RuleGroup;
import org.example.parser.common.context.RuleGrouper;
import org.example.style.rule.StyleContext;

import java.util.*;

public class NewlineContext extends StyleContext {
    public static RuleGrouper grouper;
    // Syntax rule types adjacent to the newline character.
    public String typeName1, typeName2;
    public boolean hasComment;
    // The minimum sum of code blocks preceding and following the newline.
    // This field is useful in the following case: more than one newline(blank lines) between two statement-level code blocks
    // Other cases, this field is set to 0.
    public int minTextLength;
    public boolean hasSameDecType = false;

    public NewlineContext() {
    }

    public NewlineContext(String typeName1, String typeName2) {
        this.typeName1 = typeName1;
        this.typeName2 = typeName2;
    }

    public NewlineContext(String typeName1, String typeName2, int minTextLength, boolean hasSameDecType) {
        this.typeName1 = typeName1;
        this.typeName2 = typeName2;
        this.minTextLength = minTextLength;
        this.hasSameDecType = hasSameDecType;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
       parent.addAttribute("type1", typeName1);
       parent.addAttribute("type2", typeName2);

        if (isMinTestLengthUseful()) {
            parent.addAttribute("minTextLength", Integer.toString(minTextLength));
        }
        if (isHasSameDecTypeUseful()) {
            parent.addAttribute("hasSameDecType", Boolean.toString(hasSameDecType));
        }

        parent.addAttribute("hasComment", Boolean.toString(hasComment));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        typeName1 = parent.attributeValue("type1");
        typeName2 = parent.attributeValue("type2");

        if (parent.attribute("minTextLength") != null) {
            minTextLength = Integer.parseInt(parent.attributeValue("minTextLength"));
        }
        if (parent.attribute("hasSameDecType") != null) {
            hasSameDecType = Boolean.parseBoolean(parent.attributeValue("hasSameDecType"));
        }

        hasComment = Boolean.parseBoolean(parent.attributeValue("hasComment"));
    }


    @Override
    public double calculateDistance(StyleContext targetContext) {
        double distance = INIT_DISTANCE;
        boolean textLengthMeet = true;
        if (targetContext instanceof NewlineContext context) {
            if (Objects.equals(typeName1, context.typeName1) && Objects.equals(typeName2, context.typeName2)) {
                distance -= DEC_WHEN_EQUAL;
                if (hasSameDecType && hasSameDecType == context.hasSameDecType) {
                    distance -= DEC_WHEN_EQUAL;
                }
            }
            textLengthMeet = context.minTextLength + 0.2 * minTextLength >= minTextLength; // Soften the requirement of text length.
        }
        return textLengthMeet && distance < INIT_DISTANCE ? distance : INVALID_DISTANCE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeName1, typeName2, minTextLength,hasSameDecType, hasComment);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NewlineContext context) {
            return Objects.equals(typeName1, context.typeName1) && Objects.equals(typeName2, context.typeName2)
                    && minTextLength == context.minTextLength && hasSameDecType == context.hasSameDecType
                    && hasComment == context.hasComment;
        }
        return false;
    }

    private boolean isMinTestLengthUseful() {
        return (RuleGroup.isSingleStmt(typeName1) || RuleGroup.isCompoundStmt(typeName1)) &&
                (RuleGroup.isSingleStmt(typeName2)) || RuleGroup.isCompoundStmt(typeName2);
    }

    private boolean isHasSameDecTypeUseful() {
        return typeName1.equals(RuleGroup.DECLARATION_STMT.name()) && typeName2.equals(typeName1);
    }
}
