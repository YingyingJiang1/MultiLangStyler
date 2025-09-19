package org.example.styler.declaration.layout.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class DeclarationLayoutProperty extends StyleProperty {
    public boolean mergeVar;
    double mergeCount, totalCount;

    public DeclarationLayoutProperty() {
    }

    public DeclarationLayoutProperty(double mergeCount, double totalCount) {
        this.mergeCount = mergeCount;
        this.totalCount = totalCount;
        mergeVar = (double) mergeCount / totalCount > 0.5;
    }

    public boolean hasMergedDec() {
        return mergeCount > 0;
    }

    public boolean hasSingleDec() {
        return totalCount - mergeCount > 0;
    }

    public boolean isMerge(){
        return mergeVar;
    }


    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("mergeVar", String.valueOf(mergeVar));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        mergeVar = Boolean.parseBoolean(Objects.requireNonNull(parent.attributeValue("mergeVar")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeclarationLayoutProperty property = (DeclarationLayoutProperty) o;
        return mergeVar == property.mergeVar && Double.compare(mergeCount, property.mergeCount) == 0 && Double.compare(totalCount, property.totalCount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mergeVar, mergeCount, totalCount);
    }
}
