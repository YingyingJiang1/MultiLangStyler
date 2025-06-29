package org.example.styler.format.indention;

import org.antlr.v4.runtime.Token;
import org.apache.commons.lang3.StringUtils;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.format.indention.style.IndentionProperty;
import org.example.styler.format.indention.style.IndentionStyle;

import java.util.List;

public class IndentionStyler extends Styler {

    private int indentedEmptyLines = 0;
    private int totalEmptyLines = -1;

    public IndentionStyler() {
        style = new IndentionStyle();
    }

//    @Override
//    public void extractStyle(ExtendContext ctx, MyParser parser) {
//        ctx.updateHierarchy(parser);
//        if (ctx.getStart().getTokenIndex() - 1 >= 0) {
//            Token leftToken = parser.getTokenStream().get(ctx.getStart().getTokenIndex() - 1);
//            if (leftToken.getType() == parser.getHws() && leftToken.getCharPositionInLine() == 0) {
//                String text = leftToken.getText();
//                int curLineIndention = text.length();
//                char indentionType = '\0';
//
//                if(text.matches(" +")){
//                    indentionType = ' ';
//                } else if(text.matches("\t+")) {
//                    indentionType = '\t';
//                }
//                int hierarchy = ctx.hierarchy;
//                int indentionUnit = 0;
//                if(hierarchy > 0){
//                    indentionUnit = curLineIndention / hierarchy;
//                }
//
//                if (indentionType != '\0' && indentionUnit != 0) {
//                    style.addRule(null, new IndentionProperty(indentionUnit, indentionType));
//                }
//            }
//        }
//
//    }

    @Override
    public void extractStyle(List<Token> tokens, int index, MyParser parser) {
        if (totalEmptyLines < 0) {
            totalEmptyLines = countBlankLines(parser.getTokenStream().getText());
        }
        ExtendToken token = (ExtendToken) tokens.get(index);
        if (token.getType() == parser.getHws() && token.getCharPositionInLine() == 0) {
            IndentionProperty property = extractProperty(tokens, index, parser);
            if (property.indentionType != '\0' && property.indentionUnit != 0) {
                style.addRule(null, property);
            }
        }
    }

    @Override
    public List<Token> applyStyle(List<Token> tokens, int index, MyParser parser) {
        ExtendToken curToken = (ExtendToken) tokens.get(index);
        IndentionProperty targetProperty = (IndentionProperty) style.getProperty(null);
        if (targetProperty != null) {
            String indentionStr = StringUtils.repeat(targetProperty.indentionType,
                    curToken.getHierarchy() * targetProperty.indentionUnit) +
                    StringUtils.repeat(targetProperty.indentionType, curToken.indention);


            if (curToken.getType() == parser.getHws()) {
                Token nextToken = tokens.get(index + 1);
                if (nextToken.getType() == parser.getVws() && !targetProperty.indentEmptyLine) {
                    curToken.setText("");
                } else {
                    curToken.setText(indentionStr);
                }
            } else if (!indentionStr.isEmpty()) {
                if (targetProperty.indentEmptyLine || parser.getVws() != curToken.getType()) {
                    curToken.addTokenBefore(parser.getTokenFactory().create(parser.getHws(), indentionStr), parser);
                }
            }
        }
        return null;
    }

    @Override
    public void extractFinalize() {
        style.fillStyle();

        if (style.getProperty(null) instanceof IndentionProperty property) {

            if (indentedEmptyLines > 0) {
                property.indentEmptyLine = totalEmptyLines > 0 && indentedEmptyLines > totalEmptyLines - indentedEmptyLines;
            }
        }

        indentedEmptyLines = 0;
        totalEmptyLines = -1;
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

    private int countBlankLines(String content) {
        String[] lines = content.split("\\R"); // "\\R" 匹配任何平台的换行符 (\n, \r\n, \r)
        int count = 0;
        for (String line : lines) {
            if (line.trim().isEmpty()) {
                count++;
            }
        }
        return count;
    }


    private IndentionProperty extractProperty(List<Token> tokens, int index, MyParser parser) {
        ExtendToken token = (ExtendToken) tokens.get(index);
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

            if (index + 1 < tokens.size()) {
                ExtendToken nextToken = (ExtendToken) tokens.get(index + 1);
                if (parser.getVws() == nextToken.getType() && indentionUnit > 0) {
                    indentedEmptyLines += 1;
                }
            }
        }

        return new IndentionProperty(indentionUnit, indentionType);
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
