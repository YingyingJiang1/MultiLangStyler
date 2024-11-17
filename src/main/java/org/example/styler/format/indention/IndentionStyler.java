package org.example.styler.format.indention;

import org.antlr.v4.runtime.Token;
import org.apache.commons.lang3.StringUtils;
import org.example.parser.common.ExtendToken;
import org.example.styler.Styler;
import org.example.styler.format.indention.style.IndentionProperty;
import org.example.styler.format.indention.style.IndentionStyle;

import java.util.List;

public class IndentionStyler extends Styler {

    public IndentionStyler() {
        style = new IndentionStyle(parser);
    }

    @Override
    public void applyStyle(List<Token> tokens, int index) {
        ExtendToken curToken = (ExtendToken) tokens.get(index);
        IndentionProperty property = (IndentionProperty) style.getProperty(null);
        if (property != null) {
            String indentionStr = StringUtils.repeat(property.indentionType,
                    curToken.getHierarchy() * property.indentionUnit) +
                    StringUtils.repeat(property.indentionType, curToken.indention);
//            curToken.setCharPositionInLine(curToken.getCharPositionInLine() + indentionStr.length());
            curToken.setText(indentionStr + curToken.getText());
        }
    }
}
