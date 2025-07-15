package org.example.styler.format.body;

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
    public double calculateDistance(StyleContext targetContext) {
        int distance = INIT_DISTANCE;
        if (targetContext instanceof BodyContext context) {
            if (bodyType.equals(context.bodyType)) {
                distance -= context.DEC_WHEN_EQUAL;
            } else if (context.bodyType.equals(BodyTypeEnum.NORMAL_BODY) || bodyType.equals(BodyTypeEnum.NORMAL_BODY)) {
                distance -= context.DEC_WHEN_HIGH_SIMILAR;
            } else if (context.bodyType.equals(BodyTypeEnum.ANY_BODY) || bodyType.equals(BodyTypeEnum.ANY_BODY)) {
                distance -= context.DEC_WHEN_MIDDLE_SIMILAR;
            }

            boolean numMeet = bodyNumType.equals(context.bodyNumType) ||
                    bodyNumType.equals(BodyNumType.ANY) ||
                    context.bodyNumType.equals(BodyNumType.ANY);
            return numMeet && distance != INIT_DISTANCE ? distance : INVALID_DISTANCE;
        }

        return INVALID_DISTANCE;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addElement("block_type").addText(bodyType.name());
        parent.addElement("body_type").addText(bodyNumType.name());
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        bodyType = BodyTypeEnum.valueOf(parent.element("block_type").getText().toUpperCase());
        bodyNumType = BodyNumType.valueOf(parent.element("body_type").getText().toUpperCase());
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
