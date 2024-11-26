package org.example.styler.format.linewrapping;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.example.parser.common.ExtendContext;
import org.example.parser.common.ExtendToken;
import org.example.style.rule.StyleContext;
import org.example.styler.Styler;
import org.example.styler.format.linewrapping.style.LineWrappingContext;
import org.example.styler.format.linewrapping.style.LineWrappingProperty;
import org.example.styler.format.linewrapping.style.LineWrappingStyle;

import java.util.*;

public class LineWrappingStyler extends Styler {
    private static Set<Integer> relevantRules = null;
    private DescriptiveStatistics codeStats = new DescriptiveStatistics();
    private DescriptiveStatistics commentStats = new DescriptiveStatistics();
    private Map<LineWrappingProperty.SucceedLoc, Integer> succeedLocFre = new HashMap<>();
    private int maxLenBefore = 0;

    public LineWrappingStyler() {
        style = new LineWrappingStyle();
    }

    @Override
    public void extractStyle(List<Token> tokens, int index) {
        String[] lines = parser.getTokenStream().getText().split("\n");
        for (String line : lines) {
            // Comment length are not included in the column limit
            if (line.startsWith("//") || line.startsWith("/*")) {
                commentStats.addValue(line.length());
            }
        }
    }

    @Override
    public void extractStyle(ExtendContext ctx) {
        List<Token> tokens = extractRelatedTokens(ctx);
        List<MutablePair<Token, Token>> linePairs = findLinePairs(tokens);
        if (!linePairs.isEmpty()) {
            int totalLen = ctx.start.getCharPositionInLine();
            for (int i = 0; i < linePairs.size(); i++) {
                MutablePair<Token, Token> pair = linePairs.get(i);
                Token endLineToken = pair.getLeft(), startLineToken = pair.getRight();
                int lineLen = endLineToken.getCharPositionInLine() + endLineToken.getText().length();
                totalLen += lineLen - startLineToken.getCharPositionInLine();
                codeStats.addValue(lineLen);

                if (i + 1 < linePairs.size()) {
                    MutablePair<Token, Token> nextPair = linePairs.get(i + 1);
                    int relativeIndention = nextPair.getLeft().getCharPositionInLine() - ctx.start.getCharPositionInLine();
                    LineWrappingProperty.SucceedLoc succeedLoc = new LineWrappingProperty.SucceedLoc(relativeIndention);
                    succeedLocFre.put(succeedLoc, succeedLocFre.getOrDefault(succeedLoc, 1));
                }
            }

            if (totalLen > maxLenBefore) {
                maxLenBefore = totalLen;
            }
        }

    }

    /**
     * @implNote Choose break locations according to their properties.
     * @param ctx
     * @return
     */
    @Override
    public ExtendContext applyStyle(ExtendContext ctx) {
        List<Token> tokens = extractRelatedTokens(ctx);

        if (!tokens.isEmpty()) {
            LineWrappingProperty property = (LineWrappingProperty) style.getProperty(new LineWrappingContext(LineWrappingContext.Attr.CODE));
            int totalLen = calculateTotalLen(tokens);

            if (property.isLineWrapping(totalLen)) {
                // key: priority, value: list of indices of tokens.
                Map<Integer, List<Integer>> breakLocsPriority = new HashMap<Integer, List<Integer>>();
                for (int i = 0; i < tokens.size(); i++) {
                    int priority = property.getPriority(tokens.get(i));
                    if (priority >= 0) {
                        breakLocsPriority.putIfAbsent(priority, new ArrayList<>());
                        breakLocsPriority.get(priority).add(i);
                    }
                }

                // Breaking strategy: try to ensure each line is averaged.
                int priority = 0;
                int start = 0;
                while (property.isLineWrapping(totalLen)) {
                    List<Integer> indices = breakLocsPriority.get(priority);
                    if (!indices.isEmpty()) {
                        int breakIndex = indices.get(0);
                        breakLine(property, tokens, breakIndex);
                        indices.remove(0);
                        totalLen -= calculateTotalLen(tokens.subList(start, breakIndex + 1));
                        start = breakIndex + 1;
                    } else {
                        priority++;
                    }
                }
            }
        }
        return ctx;
    }

    @Override
    public void doFinalize() {
        StyleContext codeContext = new LineWrappingContext(LineWrappingContext.Attr.CODE);
        StyleContext commentContext = new LineWrappingContext(LineWrappingContext.Attr.COMMENT);
        List<Map.Entry<LineWrappingProperty.SucceedLoc, Integer>> sorted =
                succeedLocFre.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).toList();
        LineWrappingProperty.SucceedLoc succeedLoc = null;
        if (!sorted.isEmpty()) {
            succeedLoc = sorted.get(sorted.size() - 1).getKey();
        }
        style.addRule(codeContext, new LineWrappingProperty(
                codeStats.getVariance(), (int) codeStats.getMax(), maxLenBefore, null, succeedLoc));
        // Comments are always line-wrapped.
        style.addRule(commentContext, new LineWrappingProperty(
                commentStats.getVariance(), (int) commentStats.getMax(), -1, null, succeedLoc));
    }


    @Override
    protected Set<Integer> getRelevantRules() {
        if(relevantRules == null) {
            relevantRules = new HashSet<Integer>();
            relevantRules.addAll(parser.getSingleStmts());
            relevantRules.addAll(parser.getCompoundStmts());
            relevantRules.addAll(parser.getDecHeads());
        }
        return relevantRules;
    }

    private List<Token> extractRelatedTokens(ExtendContext ctx) {
        int end = ctx.getChildCount();
        if (!parser.belongToSingleStmt(ctx)) {
            end = ctx.indexOfIf(t -> parser.isBlock(t) || parser.isBody(t));
        }

        List<Token> tokens = new ArrayList<Token>();
        for (int i = 0; i < end; i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof ExtendContext childCtx) {
                tokens.addAll(childCtx.getAllTokensRec());
            } else if (child instanceof TerminalNode ter) {
                tokens.add(ter.getSymbol());
            }
        }
        return tokens;
    }

    private int calculateTotalLen(List<Token> tokens) {
        if (tokens.isEmpty()) return 0;
        List<MutablePair<Token, Token>> linePairs = findLinePairs(tokens);
        int totalLen = linePairs.stream().reduce(tokens.get(0).getCharPositionInLine(),
                (acc, pair) -> acc + pair.getRight().getCharPositionInLine() - pair.getLeft().getCharPositionInLine() + pair.getRight().getText().length(),
                (a, b) -> a
        );
        return tokens.get(0).getCharPositionInLine() + totalLen;
    }

    /**
     *
     * @param tokens
     * @return A list pair of tokens, left is the start token of current line, right is the end token of current line.
     */
    private List<MutablePair<Token, Token>> findLinePairs(List<Token> tokens) {
        int size = tokens.size();
        ExtendToken virtualToken = new ExtendToken(-1);
        virtualToken.setLine(-1);
        virtualToken.setCharPositionInLine(-1);
        List<MutablePair<Token, Token>> pairs = new ArrayList<>();
        Token start = tokens.isEmpty() ? null : tokens.get(0), end = null;
        for (int i = 0; i < size; i++) {
            if (tokens.get(i).getLine() == tokens.get(i + 1).getLine()) {
                continue;
            }
            pairs.add(new MutablePair<Token, Token>(start, tokens.get(i)));
            start = tokens.get(i + 1);
        }
        tokens.remove(tokens.size() - 1);
        return pairs;
    }

    private void breakLine(LineWrappingProperty property, List<Token> tokens, int breakIndex) {
        ExtendToken targetToken = (ExtendToken) tokens.get(breakIndex);
        Boolean breakAfter = property.getLocation(targetToken);
        if (breakAfter == Boolean.TRUE) {
            targetToken.setText(targetToken.getText() + System.lineSeparator());
            if (breakIndex + 1 < tokens.size()) {
                ExtendToken nextToken = (ExtendToken) tokens.get(breakIndex + 1);
                nextToken.setIndention(property.succeedLoc.relativeIndention);
            }
        } else if (breakAfter == Boolean.FALSE) {
            targetToken.setIndention(property.succeedLoc.relativeIndention);
            if (breakIndex - 1 >= 0) {
                ExtendToken preToken = (ExtendToken) tokens.get(breakIndex - 1);
                preToken.setText(preToken.getText() + System.lineSeparator());
            }
        }
    }
}
