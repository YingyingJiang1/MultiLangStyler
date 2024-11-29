package org.example.styler.format.indention;

import org.antlr.v4.runtime.Token;
import org.apache.commons.lang3.StringUtils;
import org.example.parser.common.token.ExtendToken;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.format.indention.style.IndentionProperty;

import java.util.List;

public class IndentionStyler extends Styler {

    public IndentionStyler() {
        style.setStyleName("indention");
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

    @Override
    public boolean isRelevant(List<Token> tokens, int i, Stage stage) {
        if (stage == Stage.EXTRACT) {
            return tokens.get(i).getType() == parser.getHws() && tokens.get(i).getCharPositionInLine() == 0;
        } else if(stage == Stage.APPLY) {
            return i - 1 >= 0 && tokens.get(i - 1).getText().endsWith("\n") && parser.getVws() != tokens.get(i).getType();
        } else {
            return false;
        }

    }
}
