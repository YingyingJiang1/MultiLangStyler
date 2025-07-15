package org.example.styler.ifelse.multibranch.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

public class DefaultBranchProperty extends StyleProperty {
    public boolean hasDefaultBranch;

    public DefaultBranchProperty(boolean hasDefaultBranch) {
        this.hasDefaultBranch = hasDefaultBranch;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("hasDefaultBranch", Boolean.toString(hasDefaultBranch));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        hasDefaultBranch = Boolean.parseBoolean(parent.attributeValue("hasDefaultBranch"));
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(hasDefaultBranch);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DefaultBranchProperty) {
            return hasDefaultBranch == ((DefaultBranchProperty) obj).hasDefaultBranch;
        } else {
            return false;
        }
    }
}
