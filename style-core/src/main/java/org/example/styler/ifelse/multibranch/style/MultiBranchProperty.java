package org.example.styler.ifelse.multibranch.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;
import org.example.styler.ifelse.multibranch.BranchType;

public class MultiBranchProperty extends StyleProperty {
    public BranchType branchType;

    public MultiBranchProperty() {
    }

    public MultiBranchProperty(BranchType branchType) {
        this.branchType = branchType;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("branchType", branchType.name());
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        branchType = BranchType.valueOf(parent.attributeValue("branchType"));
    }
}
