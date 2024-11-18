package org.example.styler.format.indention;

import jdk.nio.mapmode.ExtendedMapMode;
import org.antlr.v4.runtime.Token;
import org.apache.commons.lang3.StringUtils;
import org.example.parser.common.ExtendToken;
import org.example.styler.Styler;
import org.example.styler.format.indention.style.IndentionProperty;
import org.example.styler.format.indention.style.IndentionStyle;
import org.example.styler.hws.style.SpaceContext;
import org.example.styler.hws.style.SpaceProperty;

import java.util.List;

public class IndentionStyler extends Styler {

    public IndentionStyler() {
        style = new IndentionStyle(parser);
    }

    @Override
    public void extractStyle(List<Token> tokens, int index) {
        ExtendToken token = (ExtendToken) tokens.get(index);
        if (token.getType() == parser.getHws() && token.getCharPositionInLine() == 0) {
            // Extract indention.
            String text = token.getText();
            int curLineIndention = text.length();
            char indentionType = '\0';

            if(text.matches(" +")){
                indentionType = ' ';
            } else if(text.matches("\t+")) {
                indentionType = '\t';
            }
            int hierarchy = token.getHierarchy();
            int indentionUnit = 0;
            if(hierarchy > 0){
                indentionUnit = curLineIndention / hierarchy;
            }

            if (indentionType != '\0' && indentionUnit != 0) {
                style.addRule(null, new IndentionProperty(indentionUnit, indentionType));
            }
        }
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
