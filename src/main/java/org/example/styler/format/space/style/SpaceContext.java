package org.example.styler.format.space.style;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.dom4j.Element;
import org.example.style.grouper.Grouper;
import org.example.style.rule.StyleContext;

public class SpaceContext extends StyleContext {
    String leftToken, rightToken;
    String selfToken; // self is the following types: operators, separators, keyword
    static Grouper grouper;

    public SpaceContext(String leftToken, String self, String rightToken) {
        if (grouper == null) {
            this.leftToken = leftToken;
            this.rightToken = rightToken;
            this.selfToken = self;
        } else {
            this.leftToken = grouper.getGroupName(leftToken);
            this.rightToken = grouper.getGroupName(rightToken);
            this.selfToken = grouper.getGroupName(self);
        }
    }

    public SpaceContext(Token left, Token self, Token right) {
        if (grouper == null) {
            this.leftToken = left == null ? "" : left.getText();
            this.rightToken = right == null ? "" : right.getText();
            this.selfToken = self == null ? "" : self.getText();
        } else {
            this.leftToken = grouper.getGroupName(leftToken);
            this.rightToken = grouper.getGroupName(rightToken);
            this.selfToken = grouper.getGroupName(self);
        }
    }

    @Override
    public double calculateDistance(StyleContext targetContext) {
        double distance = 0;
        if (targetContext instanceof SpaceContext spaceContext) {
            distance += grouper.calculateGroupDistance(leftToken, spaceContext.leftToken);
            distance += grouper.calculateGroupDistance(rightToken, spaceContext.rightToken);
            distance += grouper.calculateGroupDistance(selfToken, spaceContext.selfToken);
            return distance;
        }
        return super.calculateDistance(targetContext);
    }

    @Override
    public void addElement(Element parent, Parser parser) {
        parent.addAttribute("left", leftToken);
        parent.addAttribute("right", rightToken);
        parent.addAttribute("self", selfToken);
    }

    @Override
    public Object parseElement(Element parent, Parser parser) {
        leftToken = parent.attributeValue("left");
        rightToken = parent.attributeValue("right");
        selfToken = parent.attributeValue("self");
        return this;
    }
}
