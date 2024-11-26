package org.example.styler.format.body.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

public class BodyLayoutContext extends StyleContext {
    public TypeEnum blockType;
    public int stmtNumInBlock; // 0:empty block, 1: only one single statement in block, 2: one single block statement or exceed one statement.

    public BodyLayoutContext() {}

    public BodyLayoutContext(TypeEnum blockType, int stmtNum) {
        this.blockType = blockType;
        this.stmtNumInBlock = stmtNum;
    }

    public int calculateDis(StyleContext context) {
        BodyLayoutContext braceContext = (BodyLayoutContext) context;
        if(this.equals(braceContext)) {
            return 0;
        }
        int typeDis = blockType == braceContext.blockType ? 0 : 1;
        return typeDis + Math.abs(stmtNumInBlock - braceContext.stmtNumInBlock);
    }


    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addElement("block_type").addText(blockType.name());
        Element stmtNumEle = parent.addElement("number_of_stmt");
        if(stmtNumInBlock < 2) {
            stmtNumEle.addText(Integer.toString(stmtNumInBlock));
        } else {
            stmtNumEle.addText("exceed 1");
        }
    }

    @Override
    public BodyLayoutContext parseElement(Element parent, MyParser parser) {
        BodyLayoutContext context = new BodyLayoutContext();
        context.blockType = TypeEnum.valueOf(parent.element("block_type").getText());
        Element stmtNumEle = parent.element("number_of_stmt");
        String stmtNumText = stmtNumEle.getText();
        if(stmtNumText.equals("exceed 1")) {
            context.stmtNumInBlock = 2;
        } else {
            context.stmtNumInBlock = Integer.parseInt(stmtNumText);
        }
        String[] arr = parent.element("line_break_info").getText().split("[(),]");
        return context;
    }


}
