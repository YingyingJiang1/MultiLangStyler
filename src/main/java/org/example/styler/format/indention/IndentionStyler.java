package org.example.styler.format.indention;

import org.antlr.v4.runtime.Token;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.token.ExtendToken;
import org.example.style.SelfStyleManager;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.format.indention.style.IndentionProperty;
import org.example.styler.format.indention.style.IndentionStyle;
import org.example.utils.Helper;

import java.util.*;

public class IndentionStyler extends Styler {

    private int indentedEmptyLines = 0;
    private int totalEmptyLines = -1;
    // key: indention info, value: frequency
    private Map<IndentionInfo, Integer> indentionLengthMap = new HashMap<>();

    public IndentionStyler() {
        style = new IndentionStyle();
    }


    @Override
    public void extractStyle(List<Token> tokens, int index, MyParser parser) {
        if (totalEmptyLines < 0) {
            totalEmptyLines = countBlankLines(parser.getTokenStream().getText());
        }
        ExtendToken token = (ExtendToken) tokens.get(index);
        if (token.getType() == parser.getHws() && token.getCharPositionInLine() == 0) {

            IndentionInfo info = extractIndentionInfo(tokens, index, parser);
            indentionLengthMap.put(info, indentionLengthMap.getOrDefault(info, 0) + 1);
        }
    }



    @Override
    public List<Token> applyStyle(List<Token> tokens, int index, MyParser parser) {
        ExtendToken curToken = (ExtendToken) tokens.get(index);
        IndentionProperty targetProperty = (IndentionProperty) style.getProperty(null);


        if (targetProperty != null) {
            String indentionStr = targetProperty.getIndentionStr(curToken.getHierarchy()) + curToken.indention;

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
        Map<Character, Integer> typeMap = new HashMap<>();
        Map<Integer, Integer> topIndentionMap = new HashMap<>();
        for (Map.Entry<IndentionInfo, Integer> entry : indentionLengthMap.entrySet()) {
            IndentionInfo info = entry.getKey();

            int frequency = entry.getValue();
            typeMap.put(info.indentionType, typeMap.getOrDefault(info.indentionType, 0) + frequency);

            if (info.hierarchy == 0) {
                topIndentionMap.put(info.indentionLength, topIndentionMap.getOrDefault(info.indentionLength, 0) + frequency);
            }
        }


        try {
            int topHierarchyIndention = 0;
            if (!topIndentionMap.isEmpty()) {
                topHierarchyIndention = topIndentionMap.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow().getKey();
            }

            Map<Integer, Integer> indentionUnitMap = new HashMap<>();
            for (Map.Entry<IndentionInfo, Integer> entry : indentionLengthMap.entrySet()) {
                IndentionInfo info = entry.getKey();
                if (info.hierarchy > 0) {
                    int indentionUnit = (info.indentionLength - topHierarchyIndention) / info.hierarchy;
                    indentionUnitMap.put(indentionUnit, indentionUnitMap.getOrDefault(indentionUnit, 0) + entry.getValue());
                }
            }

            int indentionUnit = indentionUnitMap.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow().getKey();

            char indentionType = typeMap.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow().getKey();
            boolean indentEmptyLines = totalEmptyLines > 0 && indentedEmptyLines > totalEmptyLines - indentedEmptyLines;
            style.addRule(null, new IndentionProperty(indentionUnit, indentionType, indentEmptyLines, topHierarchyIndention));
        } catch (NoSuchElementException ignored) {
            ignored.printStackTrace();
        }

        style.fillStyle();


        indentedEmptyLines = 0;
        totalEmptyLines = -1;
        indentionLengthMap.clear();
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


    private IndentionInfo extractIndentionInfo(List<Token> tokens, int index, MyParser parser) {
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

        return new IndentionInfo(curLineIndention, hierarchy, indentionType);
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

    private static class IndentionInfo {
        int indentionLength;
        int hierarchy;
        char indentionType;

        public IndentionInfo(int indentionLength, int hierarchy, char indentionType) {
            this.indentionLength = indentionLength;
            this.hierarchy = hierarchy;
            this.indentionType = indentionType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IndentionInfo that = (IndentionInfo) o;
            return indentionLength == that.indentionLength && hierarchy == that.hierarchy && indentionType == that.indentionType;
        }

        @Override
        public int hashCode() {
            return Objects.hash(indentionLength, hierarchy, indentionType);
        }
    }
}
