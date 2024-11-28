package org.example.styler.body;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

import java.util.Objects;

public class BodyContext extends StyleContext {
    public BodyTypeEnum bodyType;
    public BodyNumType bodyNumType;

    public BodyContext() {}

    public BodyContext(BodyTypeEnum bodyType, BodyNumType bodyNumType) {
        this.bodyType = bodyType;
        this.bodyNumType = bodyNumType;
    }


    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addElement("block_type").addText(bodyType.name());
        parent.addElement("body_type").addText(bodyNumType.name());
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        BodyContext context = new BodyContext();
        context.bodyType = BodyTypeEnum.valueOf(parent.element("block_type").getText().toUpperCase());
        context.bodyNumType = BodyNumType.valueOf(parent.element("body_type").getText().toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(bodyType, bodyNumType);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BodyContext context) {
            return bodyType.equals(context.bodyType) && bodyNumType.equals(context.bodyNumType);
        }
        return false;
    }
}
