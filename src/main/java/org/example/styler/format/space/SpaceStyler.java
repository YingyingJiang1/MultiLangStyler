package org.example.styler.format.space;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.example.parser.common.ExtendToken;
import org.example.parser.common.TokenNameGetter;
import org.example.style.rule.StyleContext;
import org.example.styler.Styler;
import org.example.styler.format.space.style.SpaceContext;
import org.example.styler.format.space.style.SpaceProperty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description This class focuses on the spaces around separators and operators.
 */
public class SpaceStyler extends Styler {
    static Set<String> relevantTokens = null;

    public SpaceStyler() {
        style.setStyleName("space");
        // There's always a space between keywords and identifiers.
        style.addRule(new SpaceContext("keyword", "identifier"), new SpaceProperty(true));
        style.addRule(new SpaceContext("identifier", "keyword"), new SpaceProperty(true));
    }


    @Override
    public void extractStyle(List<Token> tokens, int index) {
        Token leftToken = tokens.get(index - 1), rightToken = tokens.get(index + 1);
        boolean leftSpace = parser.getHws() == leftToken.getType();
        boolean rightSpace = parser.getHws() == rightToken.getType();
        StyleContext context = extractContext(tokens, index);
        SpaceProperty property = new SpaceProperty(leftSpace, rightSpace);


        if (context != null) {
            style.addRule(context, property);
        }
    }

    @Override
    public void applyStyle(List<Token> tokens, int index) {
        Token cur = tokens.get(index);
        StyleContext context = extractContext(tokens, index);
        SpaceProperty property = (SpaceProperty) style.getSimilarProperty(context);
        if (property != null) {
            if (cur instanceof CommonToken commonToken) {
                if (property.space2) {
                    commonToken.setText(cur.getText() + " ");
                }
                if (property.space1) {
                    commonToken.setText(" " + cur.getText());
                }
            }
        }
    }
    
    private SpaceContext extractContext(List<Token> tokens, int index) {
        ExtendToken token = (ExtendToken) tokens.get(index);
        String name = token.getText();
        String left = TokenNameGetter.getInstance().getName(findFirstNonHwsOfLeft(tokens, index - 1), parser);
        String right = TokenNameGetter.getInstance().getName(findFirstNonHwsOfRight(tokens, index + 1), parser);

        if (parser.isBinOp(name)) {
            // Positions on the left and right of a binary operator are symmetrical.
            return new SpaceContext(name);
        } else if (parser.isUnOp(name)) {
            if (isSuffix(tokens, index)) { // suffix ++, suffix --
                return new SpaceContext(left, name);
            } else { // Right associated operator
                return new SpaceContext(name, right);
            }
        } else if (parser.isSeparator(name)) {
            // Positions on the left and right of a separator are considered respectively. And the case is exclusive if the adjacent token is operator,
            // because this case has already been handled in the previous branches.
            if (!parser.isOperator(left)) {
                return new SpaceContext(left, name);
            }
            if (!parser.isOperator(right)) {
                return new SpaceContext(name, right);
            }
        }
        return null;
    }

    @Override
    protected Set<String> getRelevantTokens() {
        if (relevantTokens == null) {
            relevantTokens = new HashSet<>();
            relevantTokens.addAll(parser.getSeparators());
            relevantTokens.addAll(parser.getOperators());
        }
        return relevantTokens;
    }

    @Override
    public boolean isRelevant(Token token) {
        return token.getType() == parser.getIdentifier() || getRelevantTokens().contains(token.getText());
    }

    private Token findFirstNonHwsOfLeft(List<Token> tokens, int start) {
        for (int left = start; left >= 0; left--) {
            if (tokens.get(left).getType() != parser.getHws()) {
                return tokens.get(left);
            }
        }
        return null;
    }

    private Token findFirstNonHwsOfRight(List<Token> tokens, int start) {
        for (int right = start; right < tokens.size(); ++right) {
            if (tokens.get(right).getType() != parser.getHws()) {
                return tokens.get(right);
            }
        }
        return null;
    }

    private boolean isSuffix(List<Token> tokens, int index) {
        Token left = findFirstNonHwsOfLeft(tokens, index - 1);
        return left != null && left.getType() == parser.getIdentifier();
    }
}
