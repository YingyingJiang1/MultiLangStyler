package org.example.styler.hws.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.interfaces.StyleContext;

import java.util.ArrayList;
import java.util.List;

public class SpaceContext extends StyleContext {
    public int startToken, endToken;

    public SpaceContext(int startToken, int endToken) {
        this.startToken = startToken;
        this.endToken = endToken;
    }

    @Override
    public void addElement(Element parent, Parser parser) {
        parent.addElement("style_context").addText(Integer.toString(startToken) + "," + Integer.toString(endToken));
    }

    @Override
    public Object parseElement(Element parent, Parser parser) {
        String[] tokens = parent.element("style_context").getText().split(",");
        startToken = Integer.parseInt(tokens[0]);
        endToken = Integer.parseInt(tokens[1]);
        return this;
    }
}
