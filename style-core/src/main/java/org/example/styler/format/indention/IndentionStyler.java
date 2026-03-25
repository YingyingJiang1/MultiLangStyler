package org.example.styler.format.indention;

import org.antlr.v4.runtime.Token;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.example.RunStatistic;
import org.example.antlr.common.context.ExtendContext;
import org.example.lang.LangAdapterCreator;
import org.example.lang.intf.CodeContextPredicate;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.token.ExtendToken;
import org.example.style.InconsistencyInfo;
import org.example.style.codecontext.CodeContext;
import org.example.style.codecontext.TokenBasedContext;
import org.example.style.rule.StyleProperty;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.format.indention.style.IndentionInconsistencyInfo;
import org.example.styler.InconsistencyInfoGenerator;
import org.example.styler.format.indention.style.IndentionProperty;
import org.example.styler.format.indention.style.IndentionStyle;
import org.example.utils.NodeUtil;
import org.example.utils.ParseTreeUtil;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class IndentionStyler extends Styler {

    private int totalEmptyLines = -1;
    // key: indention info, value: frequency
    private Map<IndentionInfo, Integer> indentionLengthMap = new HashMap<>();
    private MutablePair<String, IndentionStyle> styleCache = null;
    private static final int HWS = 1, VWS = 2, OTHER = 3;
    private Set<Integer> relevantASTNodeTypes = null;

    public IndentionStyler() {
        style = new IndentionStyle();
    }

    @Override
    public void extractStyle(List<Token> tokens, int index, MyParser parser) {
        ExtendToken token = (ExtendToken) tokens.get(index);
        IndentionInfo info = extractIndentionInfo(tokens, index, parser);
        if (info != null && info.hierarchy > 0) {
            indentionLengthMap.put(info, indentionLengthMap.getOrDefault(info, 0) + 1);
        }
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        if (relevantASTNodeTypes == null) {
            relevantASTNodeTypes = new HashSet<>() {
                {
                    add(parser.getRuleTypeDeclaration());
                    add(parser.getRuleMethodDeclaration());
                    add(parser.getRuleConstructorDeclaration());
                    add(parser.getRuleFieldDeclaration());
                    add(parser.getRuleStmt());
                }
            };
        }
        return relevantASTNodeTypes.contains(ctx.getRuleIndex());
    }

    /**
     * Handles the hierarchy 0 case, which needs syntactic information to determine whether the leading token is a valid
     * hierarchy 0 indention token.
     */
    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        if (ctx.hierarchy == 0 && ctx.getStart() != null) {
            Token preToken = ParseTreeUtil.getPreToken(ctx, ctx.getStart());
            Token realPreToken = null; // previous token of ctx.getStart() in token stream.
            // start token of ctx is the first token in default channel.
            if (preToken == null && ctx.getStart() instanceof ExtendToken firstDefaultToken) {
                realPreToken = firstDefaultToken.getContextTokens().get(0);
            } else if (preToken instanceof ExtendToken extendToken && extendToken.getContextTokens() != null) {
                realPreToken = extendToken.getContextTokens().get(extendToken.getContextTokens().size() - 1);
            }
            if (realPreToken != null && realPreToken.getType() == parser.getHws()) {
                IndentionInfo info = new IndentionInfo(realPreToken.getText().length(), 0,
                        parseIndentionType(realPreToken.getText()), parser.getHws(), -1);
                indentionLengthMap.put(info, indentionLengthMap.getOrDefault(info, 0) + 1);
            }
        }
    }

    @Override
    public List<Token> applyStyle(List<Token> tokens, int index, MyParser parser) {
        ExtendToken curToken = (ExtendToken) tokens.get(index);
        StyleProperty targetStyleProperty = style.getProperty(null);


        if (targetStyleProperty instanceof IndentionProperty targetProperty) {
            String extraIndention = curToken.getType() == parser.getHws() && index + 1 < tokens.size() 
            ? ((ExtendToken) tokens.get(index + 1)).indention : curToken.indention;
            if (!extraIndention.isEmpty() && extraIndention.indexOf(targetProperty.indentionType) < 0) {
                extraIndention = StringUtils.repeat(targetProperty.indentionType, targetProperty.indentionUnit);
            }

            int hierarchy = curToken.getHierarchy();
            if (curToken.getType() == parser.getHws() && index + 1 < tokens.size()) {
                hierarchy = ((ExtendToken) tokens.get(index + 1)).getHierarchy();
            }
            String indentionStr = targetProperty.getIndentionStr(hierarchy) + extraIndention;

            // 缩进不一致，统一转换为目标缩进
            if (curToken.getType() == parser.getHws()) {
                Token nextToken = tokens.get(index + 1);
                if (nextToken.getType() == parser.getVws() && !targetProperty.indentEmptyLine) {
                    curToken.setText("");
                    // RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
                } else {
                    curToken.setText(indentionStr);
                    // RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
                }
            } else if (!indentionStr.isEmpty()) {
                if (targetProperty.indentEmptyLine || parser.getVws() != curToken.getType()) {
                    curToken.addTokenBefore(parser.getTokenFactory().create(parser.getHws(), indentionStr), parser);
                    // RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
                }
            }
        }
        return null;
    }




    @Override
    public List<InconsistencyInfo> analyzeInconsistency(List<Token> tokens,
            int index, MyParser parser) {
        List<CodeContext> codeContexts = constructCodeContext(tokens, index, parser);
        if (codeContexts.isEmpty()) {
            return inconsistencyInfos;
        }

        TokenBasedContext codeContext = (TokenBasedContext) codeContexts.get(0);
        ExtendToken curToken = (ExtendToken) tokens.get(index);
        StyleProperty targetStyleProperty = style.getProperty(null);


        if (targetStyleProperty instanceof IndentionProperty targetProperty) {
            String extraIndention = curToken.getType() == parser.getHws() && index + 1 < tokens.size() 
            ? ((ExtendToken) tokens.get(index + 1)).indention : curToken.indention;
            if (!extraIndention.isEmpty() && extraIndention.indexOf(targetProperty.indentionType) < 0) {
                extraIndention = StringUtils.repeat(targetProperty.indentionType, targetProperty.indentionUnit);
            }

            int hierarchy = curToken.getHierarchy();
            if (curToken.getType() == parser.getHws() && index + 1 < tokens.size()) {
                hierarchy = ((ExtendToken) tokens.get(index + 1)).getHierarchy();
            }
            String targetIndentionStr = targetProperty.getIndentionStr(hierarchy) + extraIndention;
            String curIndentionStr = curToken.getType() == parser.getHws() ? curToken.getText() : "";

            // 缩进不一致，统一转换为目标缩进
            if (!curIndentionStr.equals(targetIndentionStr)) {
                InconsistencyInfo info = InconsistencyInfoGenerator.generateForIndention(
                    codeContext, curIndentionStr, targetIndentionStr);
                if (info != null) {
                    inconsistencyInfos.add(info);
                }
            }
        }
        return inconsistencyInfos;
    }

    

    @Override
    protected List<CodeContext> constructCodeContext(List<Token> tokens,
            int index, MyParser parser) {
        if (index + 1 >= tokens.size()) {
            return List.of();
        }
        return List.of(new TokenBasedContext(tokens, index, 2));
    }

    @Override
    public void extractFinalize() {
        // 计算缩进字符类别
        Map<Character, Integer> typeMap = new HashMap<>();
        indentionLengthMap.entrySet().stream().filter(e -> e.getKey().indentionType != '\0')
                .forEach(e -> typeMap.put(e.getKey().indentionType,
                        e.getValue() + typeMap.getOrDefault(e.getKey().indentionType, 0)));
        Optional<Map.Entry<Character, Integer>> optional = typeMap.entrySet().stream().filter(e -> e.getKey() != '\0')
                .max(Map.Entry.comparingByValue());
        if (!optional.isPresent()) {
            return; // 无有效风格特征，提前退出
        }
        char indentionType = optional.get().getKey();

        Map<Integer, List<Integer>> hierarchy2lenListMap = new HashMap<>();
        indentionLengthMap.entrySet().stream().filter(e -> e.getKey().indentionType == indentionType)
                .forEach(entry -> {
                    IndentionInfo info = entry.getKey();
                    hierarchy2lenListMap.computeIfAbsent(info.hierarchy, k -> new ArrayList<>()).addAll(Collections.nCopies(entry.getValue(), info.indentionLength));
                });

        Map<Integer, Integer> hierarchy2lenMap = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> e : hierarchy2lenListMap.entrySet()) {
            int hierarchy = e.getKey();
            List<Integer> lengths = e.getValue();

            // 计算众数
            Map<Integer, Long> freqMap = lengths.stream()
                    .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
            int modeLength = freqMap.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .get()
                    .getKey();

            hierarchy2lenMap.put(hierarchy, modeLength);
        }
		hierarchy2lenMap.putIfAbsent(0, 0);

        try {
            // 计算每一级缩进单位
            List<Integer> indentionUnitLens = new ArrayList<>();
            // 跳过 0-1，因为hierarchy 0的样本较少，有比较大概率会出现异常
            for (int i = 2; i < hierarchy2lenMap.size(); i++) {
                indentionUnitLens.add(hierarchy2lenMap.get(i) - hierarchy2lenMap.get(i - 1));
            }
            int indentionUnit = indentionUnitLens.stream()
                    .max(Comparator.comparingInt(l -> Collections.frequency(indentionUnitLens, l)))
                    .orElse(2);

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
            int topHierarchyIndentionLen = 0;
            if (hierarchy2lenMap.get(0) > 0) {
                topHierarchyIndentionLen = indentionUnit;
            }

            boolean indentEmptyLines = indentedEmptyLineCount > notIndentedEmptyLineCount;

            style.addRule(null, new IndentionProperty(indentionUnit, indentionType, indentEmptyLines, topHierarchyIndentionLen));
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).warn("No indention style was extracted.");
        }

        style.fillStyle();


        totalEmptyLines = -1;
        indentionLengthMap.clear();
    }

    @Override
    public boolean isRelevant(List<Token> tokens, int i, Stage stage, MyParser parser) {
        CodeContextPredicate predicate = LangAdapterCreator.createCodeContextPredicate(parser.getLanguage());
        return predicate.isIndentionContext(tokens, i, parser);
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

    private char getIndentionType(String text) {
        char indentionType = '\0';
        if(text.matches(" +")){
            indentionType = ' ';
        } else if(text.matches("\t+")) {
            indentionType = '\t';
        }

       return indentionType;
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

        char indentionType = parseIndentionType(text);

        // Invalid indention type
        if (indentionType == '\0') {
            return null;
        }

        int hierarchy = token.getHierarchy();
        if (index + 1 < tokens.size() && tokens.get(index + 1) instanceof ExtendToken extendToken) {
            hierarchy = extendToken.getHierarchy();
        }
        int nextType = -1;
        if (index + 1 < tokens.size()) {
            nextType = getTokenType(tokens.get(index + 1), parser);
        }

        if (hierarchy == 0 && tokens.get(index + 1).getChannel() != parser.getDefaultChannel()) {
            return null;
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

    private char parseIndentionType(String indentionStr) {
        if (indentionStr.matches(" +")) {
            return ' ';
        } else if (indentionStr.matches("\t+")) {
            return '\t';
        } else {
            return '\0';
        }
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
