package org.example.styler.format.space.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

import java.util.Arrays;
import java.util.Objects;

public class SpaceContext extends StyleContext {
    // name are the following: operators, separators, "keyword", "identifier". `tokenName2` can be empty string
    // When `tokenName2` is empty, we focus on the space around the `tokenName1`.
    // When `tokenName2` is not empty, we focus on the space between the `tokenName1` and `tokenName2`.
    public String tokenName1, tokenName2;

    public SpaceContext() {
    }

    public SpaceContext(String tokenName1, String tokenName2) {
        this.tokenName1 = tokenName1;
        this.tokenName2 = tokenName2;
    }

    public SpaceContext(String tokenName1) {
        this.tokenName1 = tokenName1;
        this.tokenName2 = "";
    }

    @Override
    public double calculateDistance(StyleContext targetContext) {
        double distance = INIT_DISTANCE;
        if (targetContext instanceof SpaceContext spaceContext) {
            distance -= Objects.equals(tokenName1, spaceContext.tokenName1) &&
                    Objects.equals(tokenName2, spaceContext.tokenName2) ? DEC_WHEN_EQUAL : 0;
        }
        return distance < INIT_DISTANCE ? distance : INVALID_DISTANCE;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        StringBuilder sb = new StringBuilder();
        sb.append(tokenName1);
        if (tokenName2 != null && !tokenName2.isEmpty()) {
            sb.append(" ").append(tokenName2);
        }
        parent.addAttribute("tokens", sb.toString());
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        String[] tokens = Arrays.stream(parent.attributeValue("tokens").split(" "))
                .map(String::trim)
                .toArray(String[]::new);
        if (tokens.length > 0) {
            tokenName1 = tokens[0];
        }
        if (tokens.length > 1) {
            tokenName2 = tokens[1];
        }
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(tokenName1, tokenName2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SpaceContext context) {
            return Objects.equals(tokenName1, context.tokenName1) && Objects.equals(tokenName2, context.tokenName2);
        }
        return false;
    }
}
