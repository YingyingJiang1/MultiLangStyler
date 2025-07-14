package org.example.styler.format.indention.style;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class IndentionProperty extends StyleProperty {
    public int indentionUnit;
    public char indentionType = ' ';
    public boolean indentEmptyLine = false;
    public int topHierarchyIndention = 0; // 顶层缩进长度，默认为0

    public IndentionProperty() {
    }

    public IndentionProperty(int indentionUnit, char indentionType, boolean indentEmptyLine, int topHierarchyIndention) {
        this.indentionUnit = indentionUnit;
        this.indentionType = indentionType;
        this.indentEmptyLine = indentEmptyLine;
        this.topHierarchyIndention = topHierarchyIndention;
    }

    public String getIndentionStr(int hierarchy) {
        int indentionLength = topHierarchyIndention + indentionUnit * hierarchy;
        return StringUtils.repeat(indentionType,indentionLength);
    }

    public int getIndentionLength(int hierarchy) {
        return topHierarchyIndention + indentionUnit * hierarchy;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("indentionUnit", String.valueOf(indentionUnit));
        parent.addAttribute("indentionType", indentionType == ' ' ? " " : "\\t");
        parent.addAttribute("indentEmptyLine", Boolean.toString(indentEmptyLine));
        parent.addAttribute("topHierarchyIndention", String.valueOf(topHierarchyIndention));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        indentionUnit = Integer.parseInt(parent.attributeValue("indentionUnit"));
        indentionType = parent.attributeValue("indentionType").equals(" ") ? ' ' : '\t';
        indentEmptyLine = Boolean.parseBoolean(parent.attributeValue("indentEmptyLine"));
        topHierarchyIndention = Integer.parseInt(parent.attributeValue("topHierarchyIndention"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(indentionUnit, indentionType, indentEmptyLine, topHierarchyIndention);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IndentionProperty property) {
            return indentionUnit == property.indentionUnit && indentionType == property.indentionType && indentEmptyLine == property.indentEmptyLine
                    && topHierarchyIndention == property.topHierarchyIndention;
        }
        return false;
    }
}
