package org.example.styler.format.space;

import org.antlr.v4.runtime.Token;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.parser.common.token.TokenGroup;
import org.example.parser.common.token.TokenGrouper;
import org.example.style.InconsistencyInfo;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.format.indention.style.IndentionInconsistencyInfo;
import org.example.styler.format.space.style.SpaceContext;
import org.example.styler.format.space.style.SpaceInconsistencyInfo;
import org.example.styler.format.space.style.SpaceProperty;
import org.example.styler.format.space.style.SpaceStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @Description This class focuses on the spaces around separators and operators.
 */
public class SpaceStyler extends Styler {
    static Set<String> relevantTokens = null;

    public SpaceStyler() {
        style = new SpaceStyle();
    }


    @Override
    public void extractStyle(List<Token> tokens, int index, MyParser parser) {

        SpaceContext context = extractContext(tokens, index, parser);
        SpaceProperty property = extractProperty(context, tokens, index, parser);
        if (context == null || property == null) {
            return;
        }

        style.addRule(context, property);

    }

    @Override
    public List<Token> applyStyle(List<Token> tokens, int index, MyParser parser) {

        SpaceContext context = extractContext(tokens, index, parser);
        SpaceProperty property = extractProperty(context,tokens,  index, parser);
        SpaceProperty targetProperty = (SpaceProperty) style.getProperty(context);


        if (property != null && targetProperty != null) {
            if (property.space2 != targetProperty.space2) {
                if (targetProperty.space2) {
                    SpaceApplicator.addRightSpace(tokens, index, parser);
                } else {
                    SpaceApplicator.removeRightSpace(tokens, index, parser);
                }
            }

            if (context.tokenName2.isEmpty() && property.space1 != targetProperty.space1) {
                if(targetProperty.space1) {
                    SpaceApplicator.addLeftSpace(tokens, index, parser);
                } else {
                    SpaceApplicator.removeLeftSpace(tokens, index, parser);
                }
            }
        }
        return null;
    }

    @Override
    public List<InconsistencyInfo> analyzeInconsistency(List<Token> tokens, int index, MyParser parser) {
        List<InconsistencyInfo> infos = null;

        SpaceContext context = extractContext(tokens, index, parser);
        SpaceProperty property = extractProperty(context,tokens,  index, parser);
        SpaceProperty targetProperty = (SpaceProperty) style.getProperty(context);


        if (property != null && targetProperty != null && !property.equals(targetProperty)) {
            infos = new ArrayList<>();
            if (property.space2 != targetProperty.space2) {

                if (targetProperty.space2) {
                    int[] loc = {tokens.get(index).getLine(), tokens.get(index).getCharPositionInLine()};
                    String message = "Missing space on the right";
                    infos.add(new SpaceInconsistencyInfo(loc, loc, message));
                } else {
                    int[] loc = {tokens.get(index + 1).getLine(), tokens.get(index + 1).getCharPositionInLine()};
                    String message = "An extra space";
                    infos.add(new SpaceInconsistencyInfo(loc, loc, message));
                }
            }

            if (context.tokenName2.isEmpty() && property.space1 != targetProperty.space1) {
                if(targetProperty.space1) {
                    int[] loc = {tokens.get(index).getLine(), tokens.get(index).getCharPositionInLine()};
                    String message = "Missing space on the left";
                    infos.add(new SpaceInconsistencyInfo(loc, loc, message));
                } else {
                    int[] loc = {tokens.get(index - 1).getLine(), tokens.get(index - 1).getCharPositionInLine()};
                    String message = "An extra space";
                    infos.add(new SpaceInconsistencyInfo(loc, loc, message));
                }
            }
        }

        return infos;
    }

    private SpaceContext extractContext(List<Token> tokens, int index, MyParser parser) {
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
        Token rightToken = findFirstNonWSonRight(tokens, index + 1, parser);

        // skip vws
        if (rightToken.getType() == parser.getVws()) {
            return null;
        }

        String rightText = rightToken == null ? "" : rightToken.getText();
        String rightName = generateTokenName(rightToken, parser);
        if (!parser.belongToBinOp(rightText) && !rightName.equals("<EOF>")) {
            // name is separator, keyword or identifier.
            return new SpaceContext(name, rightName);
        }
        return null;
    }

    private SpaceProperty extractProperty(SpaceContext context, List<Token> tokens, int index, MyParser parser) {
        if (context == null) {
            return null;
        }

        Token leftToken = index - 1 < 0 ? null : tokens.get(index - 1);
        Token rightToken = index + 1 >= tokens.size() ? null :tokens.get(index + 1);

        // Skip all token pairs those have a vws.
//        if ((leftToken != null && leftToken.getType() == parser.getVws()) || (rightToken != null && rightToken.getType() == parser.getVws())) {
//            return null;
//        }

        boolean leftSpace = leftToken != null && parser.getHws() == leftToken.getType();
        boolean rightSpace = rightToken != null && parser.getHws() == rightToken.getType();
        SpaceProperty property = new SpaceProperty(leftSpace, rightSpace);
        String identifier = TokenGroup.IDENTIFIER.name(), keyword = TokenGroup.KEYWORD.name();
        if (!context.tokenName2.isEmpty()) {
            property.space1 = false;
        }

        return property;
    }

    @Override
    public void extractFinalize() {
        // There's always a space between keywords and identifiers.
        String identifier = TokenGroup.IDENTIFIER.name(), keyword = TokenGroup.KEYWORD.name();
        List<SpaceContext> defaultContexts = List.of(
                new SpaceContext(keyword, identifier),new SpaceContext(identifier, keyword),
                new SpaceContext(keyword, keyword), new SpaceContext(identifier, identifier)
        );
        for (SpaceContext context : defaultContexts) {
            style.addRule(context, new SpaceProperty(true));
        }

        super.extractFinalize();
    }

    @Override
    public boolean isRelevant(List<Token> tokens, int i, Stage stage, MyParser parser) {
        int type = tokens.get(i).getType();
        return type != parser.getHws() && type != parser.getVws() && !parser.belongToComment(type);
//        String text = tokens.get(i).getText();
//        return type == parser.getIdentifier() || parser.getSeparators().contains(text) || parser.getOperators().contains(text) || parser.belongToKeyword(tokens.get(i));
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
            if (type != parser.getHws()) {
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
        if (group != TokenGroup.SELF_TOKEN) {
            return group.name();
        }
        return token.getText();
    }
}
