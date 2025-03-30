package org.example.styler.ifelse.multibranch.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

import java.util.Objects;

public class MultiBranchContext extends StyleContext {
    public int branches;

    public MultiBranchContext() {
    }

    public MultiBranchContext(int branches) {
        this.branches = branches;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("branches", String.valueOf(branches));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        branches = Integer.parseInt(parent.attributeValue("branches"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(branches);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MultiBranchContext other) {
            return branches == other.branches;
        }
        return false;
    }
}
