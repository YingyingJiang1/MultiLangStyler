package org.example.styler.format.space;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.example.parser.common.ExtendToken;
import org.example.style.Style;
import org.example.style.rule.StyleContext;
import org.example.styler.Styler;
import org.example.styler.format.space.style.SpaceContext;
import org.example.styler.format.space.style.SpaceProperty;
import org.example.styler.format.space.style.SpaceStyle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description This class focuses on the spaces around separators and operators.
 */
public class SpaceStyler extends Styler {
    static Set<String> relevantTokens = null;

    public SpaceStyler() {
        style = new SpaceStyle(parser);

        // There's always a space between keywords and identifiers.
        style.addRule(new SpaceContext("keyword", "identifier", ""), new SpaceProperty(true, false));
        style.addRule(new SpaceContext("", "identifier", "keyword"), new SpaceProperty(false, true));
    }


    @Override
    public void extractStyle(List<Token> tokens, int index) {
        ExtendToken token = (ExtendToken) tokens.get(index);
        String name = token.getText();

        Token leftToken = tokens.get(index - 1), rightToken = tokens.get(index + 1);
        boolean leftSpace = parser.getHws() == leftToken.getType();
        boolean rightSpace = parser.getHws() == rightToken.getType();
        StyleContext context = null;
        SpaceProperty property = null;

        // Positions on the left and right of a binary operator are symmetrical.
        if (parser.isBinOp(name)) {
            context = new SpaceContext("", name, "");
            property = new SpaceProperty(leftSpace, rightSpace);
        } else if (parser.isUnOp(name)) {
            if (isSuffix(tokens, index)) { // suffix ++, suffix --
                String leftName = findFirstNonHwsOfLeft(tokens, index - 1);
                context = new SpaceContext(leftName, name, "");
                property = new SpaceProperty(leftSpace, false);
            } else { // Right associated operator
                String rightName = findFirstNonHwsOfRight(tokens, index + 1);
                context = new SpaceContext("", name, rightName);
                property = new SpaceProperty(false, rightSpace);
            }
        }

        style.addRule(context, property);
    }

    @Override
    public void applyStyle(List<Token> tokens, int index) {
        Token cur = tokens.get(index), left = tokens.get(index - 1), right = tokens.get(index + 1);
        String selfText = cur.getType() == parser.getIdentifier() ? "identifier" : cur.getText();
        String leftText = left.getType() == parser.getIdentifier() ? "identifier" : left.getText();
        String rightText = right.getType() == parser.getIdentifier() ? "identifier" : right.getText();

        StyleContext context = new SpaceContext(leftText,selfText, rightText);
        SpaceProperty property = (SpaceProperty) style.getSimilarProperty(context);
        if (property != null) {
            if (cur instanceof CommonToken commonToken) {
                if (property.rightSpace) {
                    commonToken.setText(cur.getText() + " ");
                }
                if (property.leftSpace) {
                    commonToken.setText(" " + cur.getText());
                }
            }
        }
    }

    @Override
    protected Set<String> getRelevantTokens() {
        if (relevantTokens == null) {
            relevantTokens = new HashSet<>();
            relevantTokens.addAll(parser.getSeparators());
            relevantTokens.addAll(parser.getOperators());
            relevantTokens.add("identifier");
        }
        return relevantTokens;
    }

    private String findFirstNonHwsOfLeft(List<Token> tokens, int start) {
        for (int left = start; left >= 0; left--) {
            if (tokens.get(left).getType() != parser.getHws()) {
                return tokens.get(left).getText();
            }
        }
        return "";
    }

    private String findFirstNonHwsOfRight(List<Token> tokens, int start) {
        for (int right = start; right < tokens.size(); ++right) {
            if (tokens.get(right).getType()!= parser.getHws()) {
                return tokens.get(right).getText();
            }
        }
        return "";
    }

    private boolean isSuffix(List<Token> tokens, int index) {
        String left = findFirstNonHwsOfLeft(tokens, index - 1);
        return left
    }
