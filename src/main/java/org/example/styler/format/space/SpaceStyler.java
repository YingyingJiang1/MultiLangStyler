package org.example.styler.format.space;

import org.antlr.v4.runtime.Token;
import org.example.parser.common.token.ExtendToken;
import org.example.parser.common.token.TokenGroup;
import org.example.parser.common.token.TokenGrouper;
import org.example.style.rule.StyleContext;
import org.example.styler.Stage;
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
        String identifier = TokenGroup.IDENTIFIER.name(), keyword = TokenGroup.KEYWORD.name();
        style.addRule(new SpaceContext(keyword, identifier), new SpaceProperty(true));
        style.addRule(new SpaceContext(identifier, keyword), new SpaceProperty(true));
        style.addRule(new SpaceContext(keyword, keyword), new SpaceProperty(true));
        style.addRule(new SpaceContext(identifier, identifier), new SpaceProperty(true));
    }


    @Override
    public void extractStyle(List<Token> tokens, int index) {
        Token leftToken = tokens.get(index - 1), rightToken = tokens.get(index + 1);
        boolean leftSpace = parser.getHws() == leftToken.getType();
        boolean rightSpace = parser.getHws() == rightToken.getType();
        StyleContext context = extractContext(tokens, index, Stage.EXTRACT);
        SpaceProperty property = new SpaceProperty(leftSpace, rightSpace);
        if (context != null) {
            style.addRule(context, property);
        }
    }

    @Override
    public void applyStyle(List<Token> tokens, int index) {
        Token cur = tokens.get(index);
        StyleContext context = extractContext(tokens, index, Stage.APPLY);
        SpaceProperty property = (SpaceProperty) style.getSimilarProperty(context);
        if (property != null) {
            if (cur instanceof ExtendToken extendToken) {
                if (property.space2) {
                    extendToken.addTokenAfter(parser.getTokenFactory().create(parser.getHws(), " "), parser);
                }
                if (property.space1) {
                    extendToken.addTokenBefore(parser.getTokenFactory().create(parser.getHws(), " "), parser);
                }
            }
        }
    }
    
    private SpaceContext extractContext(List<Token> tokens, int index, Stage stage) {
        ExtendToken token = (ExtendToken) tokens.get(index);
        String name = generateTokenName(token);
        String text = token.getText();
        Token leftToken = stage == Stage.EXTRACT ? findFirstNonWSonLeft(tokens, index - 1) : tokens.get(index - 1);
        Token rightToken = stage == Stage.EXTRACT ? findFirstNonWSonRight(tokens, index + 1) : tokens.get(index + 1);
        String leftText = leftToken == null ? "" : leftToken.getText();
        String leftName = generateTokenName(leftToken);

        String rightText = rightToken == null ? "" : rightToken.getText();
        String rightName = generateTokenName(rightToken);

        if (parser.belongToBinOp(text)) {
            // Positions on the left and right of a binary operator are symmetrical.
            return new SpaceContext(name);
        } else if (parser.belongToUnOp(text)) {
            if (isSuffix(tokens, index)) { // suffix ++, suffix --
                return new SpaceContext(leftName, name);
            } else { // Right associated operator
                return new SpaceContext(name, rightName);
            }
        } else if (parser.belongToSeparator(text)) {
            // Positions on the left and right of a separator are considered respectively. And the case is exclusive if the adjacent token is operator,
            // because this case has already been handled in the previous branches.
            if (!parser.belongToBinOp(leftText)) {
                return new SpaceContext(leftName, name);
            }
            if (!parser.belongToBinOp(rightText)) {
                return new SpaceContext(name, rightName);
            }
        } else if (!parser.belongToOperator(rightText) && !parser.belongToSeparator(rightText)) {
            return new SpaceContext(name, rightName);
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
    public boolean isRelevant(List<Token> tokens, int i, Stage stage) {
        int type = tokens.get(i).getType();
        String text = tokens.get(i).getText();
        return type == parser.getIdentifier() || parser.getSeparators().contains(text) || parser.getOperators().contains(text) || parser.belongToKeyword(tokens.get(i));
    }

    private Token findFirstNonWSonLeft(List<Token> tokens, int start) {
        for (int left = start; left >= 0; left--) {
            int type = tokens.get(left).getType();
            if (type != parser.getHws() && type != parser.getVws()) {
                return tokens.get(left);
            }
        }
        return null;
    }

    private Token findFirstNonWSonRight(List<Token> tokens, int start) {
        for (int right = start; right < tokens.size(); ++right) {
            int type = tokens.get(right).getType();
            if (type != parser.getHws() && type != parser.getVws()) {
                return tokens.get(right);
            }
        }
        return null;
    }

    private boolean isSuffix(List<Token> tokens, int index) {
        Token left = findFirstNonWSonLeft(tokens, index - 1);
        return left != null && left.getType() == parser.getIdentifier();
    }
    
    private String generateTokenName(Token token) {
        if (token == null) {
            return "";
        }
        TokenGroup group = TokenGrouper.getInstance().getGroup(token, parser);
        if (group == TokenGroup.SELF_TOKEN) {
            return token.getText().replaceAll("\\s", "");
        }
        return group.name();
    }
}
