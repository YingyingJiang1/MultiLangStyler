package org.example.styler.format.space;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.common.token.ExtendToken;
import org.example.antlr.common.token.TokenGroup;
import org.example.lang.LangAdapterCreator;
import org.example.lang.base.FormatUnitGrouperBase;
import org.example.lang.intf.CodeContextPredicate;
import org.example.lang.intf.MyParser;
import org.example.style.InconsistencyInfo;
import org.example.style.codecontext.CodeContext;
import org.example.style.codecontext.TokenBasedContext;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.styler.InconsistencyInfoGenerator;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.format.space.style.SpaceContext;
import org.example.styler.format.space.style.SpaceProperty;
import org.example.styler.format.space.style.SpaceStyle;

/**
 * @Description This class focuses on the spaces around separators and operators.
 */
public class SpaceStyler extends Styler {

    public SpaceStyler() {
        style = new SpaceStyle();
    }

    @Override
    public List<Token> applyStyle(List<Token> tokens, int index, MyParser parser) {
        List<CodeContext> codeContexts = constructCodeContext(tokens, index, parser);
        if (codeContexts == null) {
            return tokens;
        }
        for (CodeContext codeContext : codeContexts) {
            TokenBasedContext tokenBasedContext = (TokenBasedContext) codeContext;
            StyleContext styleContext = extractStyleContext(codeContext, parser);
            StyleProperty property = extractStyleProperty(codeContext, parser);
            StyleProperty targetProperty = style.getProperty(styleContext);

            if (styleContext instanceof SpaceContext spaceContext && targetProperty instanceof SpaceProperty targProperty
                && property instanceof SpaceProperty curProperty) {
                // process space property
                if (!spaceContext.tokenName2.isEmpty()) {
                    // space1 is invalid
                    curProperty.space1 = false;
                    targProperty.space1 = false;
                } 
              

                if (isInconsistent(curProperty, targProperty, parser)) {
                    if (curProperty.space2 != targProperty.space2) {
                        if (targProperty.space2) {
                            SpaceApplicator.addRightSpace(tokens, index, parser);
                        } else {
                            SpaceApplicator.removeRightSpace(tokens, index, parser);
                        }
                    }

                    if (spaceContext.tokenName2.isEmpty() && curProperty.space1 != targProperty.space1) {
                        if(targProperty.space1) {
                            SpaceApplicator.addLeftSpace(tokens, index, parser);
                        } else {
                            SpaceApplicator.removeLeftSpace(tokens, index, parser);
                        }
                    }
                }
            }
        }
        
        return tokens;
    }

    @Override
    public List<InconsistencyInfo> analyzeInconsistency(List<Token> tokens, int index, MyParser parser) {
        List<CodeContext> codeContexts = constructCodeContext(tokens, index, parser);
        if (codeContexts == null) {
            return new ArrayList<>();
        }
        for (CodeContext codeContext : codeContexts) {
            TokenBasedContext tokenBasedContext = (TokenBasedContext) codeContext;
            StyleContext styleContext = extractStyleContext(codeContext, parser);
            StyleProperty property = extractStyleProperty(codeContext, parser);
            StyleProperty targetProperty = style.getProperty(styleContext);

            if (styleContext instanceof SpaceContext spaceContext && targetProperty instanceof SpaceProperty targProperty
                && property instanceof SpaceProperty curProperty) {
                // process space property
                if (!spaceContext.tokenName2.isEmpty()) {
                    // space1 is invalid
                    curProperty.space1 = false;
                    targProperty.space1 = false;
                } 
              
                if (isInconsistent(curProperty, targProperty, parser)) {
                    InconsistencyInfo info = InconsistencyInfoGenerator.generateForSpace(tokenBasedContext, spaceContext,
                        curProperty, targProperty);
                    if (info != null) {
                        inconsistencyInfos.add(info);
                    }
                }
            }
        }
        
        return new ArrayList<>();
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
        CodeContextPredicate predicate = LangAdapterCreator.createCodeContextPredicate(parser.getLanguage());
        return predicate.isSpaceContext(tokens, i, parser);
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

    private int indexOfFirstNonWSonRight(List<Token> tokens, int start, MyParser parser) {
        for (int right = start; right < tokens.size(); ++right) {
            int type = tokens.get(right).getType();
            if (type != parser.getHws()) {
                return right;
            }
        }
        return -1;
    }

    private boolean isSuffix(List<Token> tokens, int index, MyParser parser) {
        Token left = findFirstNonWSonLeft(tokens, index - 1, parser);
        return left != null && left.getType() == parser.getIdentifier();
    }
    
    private String generateTokenName(Token token, MyParser parser) {
        if (token == null) {
            return "";
        }
        TokenGroup group = FormatUnitGrouperBase.getInstance().getTokenGroup(token, parser);
        if (group != TokenGroup.SELF_TOKEN) {
            return group.name();
        }
        return token.getText();
    }

    @Override
    protected List<CodeContext> constructCodeContext(List<Token> tokens, int index, MyParser parser) {
        if (index + 1 >= tokens.size()) {
            return null;
        }

        int indexOfRight = indexOfFirstNonWSonRight(tokens, index + 1, parser);
        Token rightToken = indexOfRight == -1 ? null : tokens.get(indexOfRight);
        // skip vws
        if (rightToken == null || rightToken.getType() == parser.getVws()) {
            return null;
        }

        String rightText = rightToken == null ? "" : rightToken.getText();
        // binary operator only occurs at the first position of a code context.
        if (parser.belongToBinOp(rightText) || rightText.equals("<EOF>")) {
            return null;
        }
       return List.of(new TokenBasedContext(tokens, List.of(index, indexOfRight)));
    }

    @Override
    protected StyleProperty extractStyleProperty(CodeContext codeContext, MyParser parser) {
        TokenBasedContext tokenBasedContext = (TokenBasedContext) codeContext;

        int index = tokenBasedContext.getIndexInTS(0);
        List<Token> tokens = tokenBasedContext.getTokens();
        Token leftToken = index - 1 < 0 ? null : tokens.get(index - 1);
        Token rightToken = index + 1 >= tokens.size() ? null :tokens.get(index + 1);

        // Skip all token pairs those have a vws.
//        if ((leftToken != null && leftToken.getType() == parser.getVws()) || (rightToken != null && rightToken.getType() == parser.getVws())) {
//            return null;
//        }

        boolean leftSpace = leftToken != null && parser.getHws() == leftToken.getType();
        boolean rightSpace = rightToken != null && parser.getHws() == rightToken.getType();
        SpaceProperty property = new SpaceProperty(leftSpace, rightSpace);
        return property;
    }

    @Override
    protected StyleContext extractStyleContext(CodeContext codeContext, MyParser parser) {
        if (!(codeContext instanceof TokenBasedContext)) {
            return null;
        }
        TokenBasedContext tokenBasedContext = (TokenBasedContext) codeContext;

        ExtendToken token = (ExtendToken) tokenBasedContext.getToken(0);
        String name = generateTokenName(token, parser);
        String text = token.getText();
        if (parser.belongToBinOp(text)) {
            // Positions on the left and right of a binary operator are symmetrical.
            return new SpaceContext(name);
        }

        Token rightToken = tokenBasedContext.getToken(1);
        String rightText = rightToken == null ? "" : rightToken.getText();
        String rightName = generateTokenName(rightToken, parser);
        if (!parser.belongToBinOp(rightText) && !rightName.equals("<EOF>")) {
            // name is separator, keyword or identifier.
            return new SpaceContext(name, rightName);
        }
        return null;
    }

    @Override
    protected boolean testStyleContext(StyleContext context) {
        return context instanceof SpaceContext;
    }
}
