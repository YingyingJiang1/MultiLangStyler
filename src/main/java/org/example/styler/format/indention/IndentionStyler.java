package org.example.styler.format.indention;

import org.antlr.v4.runtime.Token;
import org.apache.commons.lang3.StringUtils;
import org.example.parser.common.MyParser;
import org.example.parser.common.token.ExtendToken;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.format.indention.style.IndentionProperty;
import org.example.styler.format.indention.style.IndentionStyle;

import java.util.List;

public class IndentionStyler extends Styler {

    public IndentionStyler() {
        style = new IndentionStyle();
    }

    @Override
    public void extractStyle(List<Token> tokens, int index, MyParser parser) {
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
    public List<Token> applyStyle(List<Token> tokens, int index, MyParser parser) {
        ExtendToken curToken = (ExtendToken) tokens.get(index);
        IndentionProperty property = (IndentionProperty) style.getProperty(null);
        if (property != null) {
            String indentionStr = StringUtils.repeat(property.indentionType,
                    curToken.getHierarchy() * property.indentionUnit) +
                    StringUtils.repeat(property.indentionType, curToken.indention);
            if (!indentionStr.isEmpty()) {
                curToken.addTokenBefore(parser.getTokenFactory().create(parser.getHws(), indentionStr), parser);
            }
        }
        return null;
    }

    @Override
    public boolean isRelevant(List<Token> tokens, int i, Stage stage, MyParser parser) {
        if (stage == Stage.EXTRACT) {
            return tokens.get(i).getType() == parser.getHws() && tokens.get(i).getCharPositionInLine() == 0;
        } else if(stage == Stage.APPLY) {
            return isLineLeadingToken(tokens, i, parser);
        } else {
            return false;
        }

    }

    private boolean isLineLeadingToken(List<Token> tokens, int i, MyParser parser) {
        int j = i - 1;
        for (; j >= 0; j--) {
            int type = tokens.get(j).getType();
            if (tokens.get(j).getText().endsWith("\n")) {
                return true;
            }
            // Deleted token
            if (type == -1) {
                continue;
            }
            return false;
        }
        return j < 0;
    }
}
