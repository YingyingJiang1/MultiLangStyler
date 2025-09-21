package org.example.styler.format.indention;

import org.antlr.v4.runtime.Token;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.example.RunStatistic;
import org.example.parser.common.MyParser;
import org.example.parser.common.token.ExtendToken;
import org.example.style.InconsistencyInfo;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.format.indention.style.IndentionInconsistencyInfo;
import org.example.styler.format.indention.style.IndentionProperty;
import org.example.styler.format.indention.style.IndentionStyle;
import org.slf4j.LoggerFactory;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.*;

public class IndentionStyler extends Styler {

    private int indentedEmptyLines = 0;
    private int totalEmptyLines = -1;
    // key: indention info, value: frequency
    private Map<IndentionInfo, Integer> indentionLengthMap = new HashMap<>();
    private MutablePair<String, IndentionStyle> styleCache = null;
    private static final int HWS = 1, VWS = 2, OTHER = 3;


    public IndentionStyler() {
        style = new IndentionStyle();
    }


    @Override
    public void extractStyle(List<Token> tokens, int index, MyParser parser) {
        ExtendToken token = (ExtendToken) tokens.get(index);
        IndentionInfo info = extractIndentionInfo(tokens, index, parser);
        if (info != null) {
            indentionLengthMap.put(info, indentionLengthMap.getOrDefault(info, 0) + 1);
        }
    }



    @Override
    public List<Token> applyStyle(List<Token> tokens, int index, MyParser parser) {
        ExtendToken curToken = (ExtendToken) tokens.get(index);
        IndentionProperty targetProperty = (IndentionProperty) style.getProperty(null);


        if (targetProperty != null) {
            String extraIndention = curToken.getType() == parser.getHws() ? ((ExtendToken) tokens.get(index + 1)).indention : curToken.indention;
            // 缩进不一致，统一转换为目标缩进
            if (!extraIndention.isEmpty() && extraIndention.indexOf(targetProperty.indentionType) < 0) {
                extraIndention = StringUtils.repeat(targetProperty.indentionType, targetProperty.indentionUnit);
            }

            int hierarchy = curToken.getHierarchy();
            if (curToken.getType() == parser.getHws() && index + 1 < tokens.size()) {
                hierarchy = ((ExtendToken) tokens.get(index + 1)).getHierarchy();
            }
            String indentionStr = targetProperty.getIndentionStr(hierarchy) + extraIndention;

            if (curToken.getType() == parser.getHws()) {
                Token nextToken = tokens.get(index + 1);
                if (nextToken.getType() == parser.getVws() && !targetProperty.indentEmptyLine) {
                    curToken.setText("");
                    RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
                } else {
                    curToken.setText(indentionStr);
                    RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
                }
            } else if (!indentionStr.isEmpty()) {
                if (targetProperty.indentEmptyLine || parser.getVws() != curToken.getType()) {
                    curToken.addTokenBefore(parser.getTokenFactory().create(parser.getHws(), indentionStr), parser);
                    RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
                }
            }
        }
        return null;
    }

    @Override
    public List<InconsistencyInfo> analyzeInconsistency(List<Token> tokens, int index, MyParser parser) {
        List<InconsistencyInfo> infos = null;

        ExtendToken curToken = (ExtendToken) tokens.get(index);
        IndentionProperty targetProperty = (IndentionProperty) style.getProperty(null);


        if (targetProperty != null) {
            String extraIndention = "";
//            if (index - 1 >= 0 && tokens.get(index - 1).getType() == parser.getVws() && tokens.get(index - 1) instanceof ExtendToken preExt) {
//                extraIndention = preExt.indention;
//            }
            String indentionStr = targetProperty.getIndentionStr(curToken.getHierarchy()) + extraIndention;
            int indentionLen = indentionStr.length();

            // Indention detected
            if (curToken.getType() == parser.getHws()) {
                int actualIndentLen = curToken.getText().length();
                int[] loc = {curToken.getLine(), curToken.getCharPositionInLine()};

                // check indention length
                Token nextToken = tokens.get(index + 1);
                // Indent empty line is prohibited, but empty line is indented actually.
                if (nextToken.getType() == parser.getVws() && !targetProperty.indentEmptyLine) {
                    infos = new ArrayList<>();
                    infos.add(new IndentionInconsistencyInfo(loc, loc, "Extra indention before blank lines"));
                } else if (nextToken.getType() != parser.getVws()) {
                    if (indentionLen > actualIndentLen) {
                        infos = new ArrayList<>();
                        infos.add(new IndentionInconsistencyInfo(loc, loc, "Indent too short"));
                    } else if (indentionLen < actualIndentLen) {
                        infos = new ArrayList<>();
                        infos.add(new IndentionInconsistencyInfo(loc, loc, "Indent too long"));
                    }
                }

                // Check indention type
                if (targetProperty.indentionType != curToken.getText().charAt(0)) {
                    String message = String.format("Inconsistent indention type '%c',", curToken.getText().charAt(0));
                    if (infos == null) {
                        infos = new ArrayList<>();
                        infos.add(new IndentionInconsistencyInfo(loc, loc, message));
                    } else {
                        infos.get(0).setMessage(infos.get(0).getMessage() + ", " + message);
                    }
                }
            } else if (!indentionStr.isEmpty()) { // Need indention, but no indention detected actually
                if (targetProperty.indentEmptyLine || parser.getVws() != curToken.getType()) {
                    int[] loc = {curToken.getLine(), curToken.getCharPositionInLine()};
                    infos = new ArrayList<>();
                    infos.add(new IndentionInconsistencyInfo(loc, loc, "Indent too short"));
                }
            }
        }

        return infos;
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
            char indentionType = typeMap.entrySet().stream().filter(e -> e.getKey() != '\0').max(Map.Entry.comparingByValue()).orElseThrow().getKey();

            int notIndentedEmptyLineCount = indentionLengthMap.entrySet().stream()
                    .filter(e -> e.getKey().leadingTokenType == VWS)
                    .max(Map.Entry.comparingByValue())
                    .orElse(Map.entry(new IndentionInfo(0, 0, '\0', VWS, -1), 0))
                    .getValue();
            int indentedEmptyLineCount = indentionLengthMap.entrySet().stream()
                    .filter(e -> e.getKey().leadingTokenType == HWS && e.getKey().nextTokenType == VWS)
                    .max(Map.Entry.comparingByValue())
                    .orElse(Map.entry(new IndentionInfo(0, 0, '\0', HWS, VWS), 0))
                    .getValue();

            boolean indentEmptyLines = indentedEmptyLineCount > notIndentedEmptyLineCount;
            style.addRule(null, new IndentionProperty(indentionUnit, indentionType, indentEmptyLines, topHierarchyIndention));
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).warn("No indention style was extracted.");
        }

        style.fillStyle();


        totalEmptyLines = -1;
        indentionLengthMap.clear();
    }

    @Override
    public boolean isRelevant(List<Token> tokens, int i, Stage stage, MyParser parser) {
        if (stage == Stage.EXTRACT) {
            return tokens.get(i).getCharPositionInLine() == 0;
        } else if(stage == Stage.APPLY) {
            return isLineLeadingToken(tokens, i, parser);
        } else {
            return false;
        }

    }

    /**
     *
     * @return indention string excludes hierarchy indention.
     */
    private String generateExtraIndention(String fullIndentionStr, int hierarchy, IndentionProperty originProperty, IndentionProperty targetProperty) {
        if (fullIndentionStr.isEmpty()) {
            return "";
        }

        IndentionProperty property = null;
        if (fullIndentionStr.startsWith("o")) {
            property = originProperty;
        } else {
            property = (IndentionProperty) style.getProperty(null);
        }

        return fullIndentionStr.substring(1).replaceFirst(property.getIndentionStr(hierarchy), "");
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

    private int getTokenType(Token token, MyParser parser) {
        if (token.getType() == parser.getHws()) {
            return HWS;
        } else if (token.getType() == parser.getVws()) {
            return VWS;
        } else {
            return OTHER;
        }
    }


    private IndentionInfo extractIndentionInfo(List<Token> tokens, int index, MyParser parser) {
        ExtendToken token = (ExtendToken) tokens.get(index);

        // No indention
        if (token.getType() != parser.getHws()) {
            int nextType = -1;
            if (index + 1 < tokens.size()) {
                nextType = getTokenType(tokens.get(index + 1), parser);
            }
            return new IndentionInfo(0, token.getHierarchy(), '\0', getTokenType(token, parser), nextType);
        }

        // Extract indention.
        String text = token.getText();
        int curLineIndention = text.length();

        char indentionType = '\0';
        if(text.matches(" +")){
            indentionType = ' ';
        } else if(text.matches("\t+")) {
            indentionType = '\t';
        }

        // Invalid indention type
        if (indentionType == '\0') {
            return null;
        }

        int hierarchy = token.getHierarchy();
        int nextType = -1;
        if (index + 1 < tokens.size()) {
            nextType = getTokenType(tokens.get(index + 1), parser);
        }
        return new IndentionInfo(curLineIndention, hierarchy, indentionType, getTokenType(token, parser), nextType);
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
        int leadingTokenType, nextTokenType;

        public IndentionInfo(int indentionLength, int hierarchy, char indentionType, int leadingTokenType, int nextTokenType) {
            this.indentionLength = indentionLength;
            this.hierarchy = hierarchy;
            this.indentionType = indentionType;
            this.leadingTokenType = leadingTokenType;
            this.nextTokenType = nextTokenType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IndentionInfo that = (IndentionInfo) o;
            return indentionLength == that.indentionLength && hierarchy == that.hierarchy && indentionType == that.indentionType && leadingTokenType == that.leadingTokenType && nextTokenType == that.nextTokenType;
        }

        @Override
        public int hashCode() {
            return Objects.hash(indentionLength, hierarchy, indentionType, leadingTokenType, nextTokenType);
        }
    }

}
