package org.example.styler.body;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

public class BodyContext extends StyleContext {
    public BodyBlockTypeEnum blockType;
    public BodyNumType bodyNumType;

    public BodyContext() {}

    public BodyContext(BodyBlockTypeEnum blockType, BodyNumType bodyNumType) {
        this.blockType = blockType;
        this.bodyNumType = bodyNumType;
    }

//    public int calculateDis(StyleContext context) {
//        BodyLayoutContext braceContext = (BodyLayoutContext) context;
//        if(this.equals(braceContext)) {
//            return 0;
//        }
//        int typeDis = blockType == braceContext.blockType ? 0 : 1;
//        return typeDis + Math.abs(bodyType - braceContext.bodyType);
//    }


    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addElement("block_type").addText(blockType.name());
        parent.addElement("body_type").addText(bodyNumType.name());
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        BodyContext context = new BodyContext();
        context.blockType = BodyBlockTypeEnum.valueOf(parent.element("block_type").getText().toUpperCase());
        context.bodyNumType = BodyNumType.valueOf(parent.element("body_type").getText().toUpperCase());
    }
}
