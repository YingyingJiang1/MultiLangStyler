package org.example.styler.format.space;

import org.antlr.v4.runtime.Token;
import org.example.parser.common.MyParser;
import org.example.parser.common.token.ExtendToken;
import org.example.parser.common.token.TokenGroup;
import org.example.parser.common.token.TokenGrouper;
import org.example.style.rule.StyleContext;
import org.example.styler.Stage;
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
        style = new SpaceStyle();
        style.setStyleName("space");
    }


    @Override
    public void extractStyle(List<Token> tokens, int index, MyParser parser) {

        Token leftToken = index - 1 < 0 ? null : tokens.get(index - 1);
        Token rightToken = index + 1 >= tokens.size() ? null :tokens.get(index + 1);
        boolean leftSpace = leftToken != null && parser.getHws() == leftToken.getType();
        boolean rightSpace = rightToken != null && parser.getHws() == rightToken.getType();

        SpaceContext context = extractContext(tokens, index, Stage.EXTRACT, parser);
        SpaceProperty property = new SpaceProperty(leftSpace, rightSpace);

        String identifier = TokenGroup.IDENTIFIER.name(), keyword = TokenGroup.KEYWORD.name();
        if (context != null) {
            style.addRule(context, property);
        }
    }

    @Override
    public void applyStyle(List<Token> tokens, int index, MyParser parser) {
        Token cur = tokens.get(index);
        SpaceContext context = extractContext(tokens, index, Stage.APPLY, parser);
        SpaceProperty property = (SpaceProperty) style.getProperty(context);
        if (property != null) {
            if (cur instanceof ExtendToken extendToken) {
                if (property.space2) {
                    extendToken.addTokenAfter(parser.getTokenFactory().create(parser.getHws(), " "), parser);
                }
                if (context.tokenName2.isEmpty() && property.space1) {
                    extendToken.addTokenBefore(parser.getTokenFactory().create(parser.getHws(), " "), parser);
                }
            }
        }
    }
    
    private SpaceContext extractContext(List<Token> tokens, int index, Stage stage, MyParser parser) {
        ExtendToken token = (ExtendToken) tokens.get(index);
        String name = generateTokenName(token, parser);
        String text = token.getText();
        if (parser.belongToBinOp(text)) {
            // Positions on the left and right of a binary operator are symmetrical.
            return new SpaceContext(name);
        }

        if (index + 1 >= tokens.size()) {
            return null;
        }
        Token rightToken = stage == Stage.EXTRACT ? findFirstNonWSonRight(tokens, index + 1, parser) : tokens.get(index + 1);

        String rightText = rightToken == null ? "" : rightToken.getText();
        String rightName = generateTokenName(rightToken, parser);
        if (!parser.belongToBinOp(rightText)) {
            // name is separator, keyword or identifier.
            return new SpaceContext(name, rightName);
        }
        return null;
    }

    @Override
    protected Set<String> getRelevantTokens(MyParser parser) {
        if (relevantTokens == null) {
            relevantTokens = new HashSet<>();
            relevantTokens.addAll(parser.getSeparators());
            relevantTokens.addAll(parser.getOperators());
        }
        return relevantTokens;
    }

    @Override
    public boolean isRelevant(List<Token> tokens, int i, Stage stage, MyParser parser) {
        int type = tokens.get(i).getType();
        String text = tokens.get(i).getText();
        return type == parser.getIdentifier() || parser.getSeparators().contains(text) || parser.getOperators().contains(text) || parser.belongToKeyword(tokens.get(i));
    }

    private Token findFirstNonWSonLeft(List<Token> tokens, int start, MyParser parser) {
        for (int left = start; left >= 0; left--) {
            int type = tokens.get(left).getType();
            if (type != parser.getHws() && type != parser.getVws()) {
                return tokens.get(left);
            }
        }
        return null;
    }

    private Token findFirstNonWSonRight(List<Token> tokens, int start, MyParser parser) {
        for (int right = start; right < tokens.size(); ++right) {
            int type = tokens.get(right).getType();
            if (type != parser.getHws() && type != parser.getVws()) {
                return tokens.get(right);
            }
        }
        return null;
    }

    private boolean isSuffix(List<Token> tokens, int index, MyParser parser) {
        Token left = findFirstNonWSonLeft(tokens, index - 1, parser);
        return left != null && left.getType() == parser.getIdentifier();
    }
    
    private String generateTokenName(Token token, MyParser parser) {
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
