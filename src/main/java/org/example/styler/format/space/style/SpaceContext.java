package org.example.styler.format.space.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.grouper.Grouper;
import org.example.style.rule.StyleContext;

public class SpaceContext extends StyleContext {
    // name are the following: operators, separators, "keyword", "identifier". `tokenName2` can be empty string
    // When `tokenName2` is empty, we focus on the space around the `tokenName1`.
    // When `tokenName2` is not empty, we focus on the space between the `tokenName1` and `tokenName2`.
    String tokenName1, tokenName2;
    static Grouper grouper;

    public SpaceContext(String tokenName1, String tokenName2) {
        if (grouper == null) {
            this.tokenName1 = tokenName1;
            this.tokenName2 = tokenName2;
        } else {
            this.tokenName1 = grouper.getGroupName(tokenName1);
            this.tokenName2 = grouper.getGroupName(tokenName2);
        }
    }

    public SpaceContext(String tokenName1) {
        if (grouper == null) {
            this.tokenName1 = tokenName1;
        } else {
            this.tokenName1 = grouper.getGroupName(tokenName1);
        }
        this.tokenName2 = "";
    }

    @Override
    public double calculateDistance(StyleContext targetContext) {
        double distance = 0;
        if (targetContext instanceof SpaceContext spaceContext) {
            distance += grouper.calculateGroupDistance(tokenName1, spaceContext.tokenName1);
            distance += grouper.calculateGroupDistance(tokenName2, spaceContext.tokenName2);
            return distance;
        }
        return super.calculateDistance(targetContext);
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        StringBuilder sb = new StringBuilder();
        sb.append(tokenName1);
        if (!tokenName2.isEmpty()) {
            sb.append(", ").append(tokenName2);
        }
        parent.addAttribute("token", sb.toString());
    }

    @Override
    public Object parseElement(Element parent, MyParser parser) {
        String[] tokens = parent.attributeValue("token").split(",");
        if (tokens.length > 0) {
            tokenName1 = tokens[0];
        }
        if (tokens.length > 1) {
            tokenName2 = tokens[1];
        }
        return this;
    }
}
