package org.example.styler.literal.usage;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.ListenerState;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.TreeNodeFactoryGetter;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.literal.LiteralEnum;
import org.example.styler.literal.usage.style.LiteralUsageContext;
import org.example.styler.literal.usage.style.LiteralUsageProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class LiteralUsageStyler extends Styler {
    Logger logger = LoggerFactory.getLogger(LiteralUsageStyler.class);
    private static Set<String> excludedNumbers = Set.of(
            "-1","1","0","-1.0","1.0","0.0"
    );
    private Map<String, Token> declaredConstants = new HashMap<>(0);

    public LiteralUsageStyler() {
        style.setStyleName("numeric_literal");
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        if (((ExtendContext) ctx.parent).getRuleIndex() != parser.getRuleExpression()) {
            return;
        }
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof TerminalNode ter) {
                if (parser.belongToLiteral(ter.getSymbol().getType())) {
                    LiteralUsageContext context = extractStyleContext(ter.getSymbol(), parser);
                    if (context != null) {
                        style.addRule(context, new LiteralUsageProperty(false));
                    }
                } else if(ter.getSymbol().getType() == parser.getIdentifier()) {
                    System.out.println("NumericLiteralStyler@extractStyle:提取使用常量声明");
                }
            }
        }

    }

    private LiteralUsageContext extractStyleContext(Token token, MyParser parser) {
        int type = token.getType();
        if (parser.belongToLiteralType(type)) {
            return new LiteralUsageContext(LiteralEnum.STRING);
        } else if (type == parser.getCharLiteralType()) {
            return new LiteralUsageContext(LiteralEnum.CHAR);
        } else if (!excludedNumbers.contains(token.getText())) {
            if (parser.belongToIntLiteral(type)) {
                return new LiteralUsageContext(LiteralEnum.INT_NUMBER);
            } else if (parser.belongToFloadLiteral(type)) {
                return new LiteralUsageContext(LiteralEnum.FLOAT_NUMBER);
            }
        }
        return null;
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        for (int i = 0; i < ctx.getChildCount(); ++i) {
            if (ctx.getChild(i) instanceof TerminalNode ter && parser.belongToLiteral(ter.getSymbol().getType())) {
                LiteralUsageContext context = extractStyleContext(ter.getSymbol(), parser);
                StyleProperty property = style.getProperty(context);
                if (property instanceof LiteralUsageProperty literalProperty) {
                    if (literalProperty.declareCons) {
                        Token declaredCons = declareCons(ter.getSymbol(),context, parser);
                        if (declaredCons != null) {
                            Token newToken = parser.getTokenFactory().create(declaredCons.getType(), declaredCons.getText());
                            ctx.replaceChild(ctx.getChild(i), TreeNodeFactoryGetter.getFactory(parser).createTerminal(newToken));
                        }
                    }
                }
            }
        }
        return ctx;
    }

    private Token declareCons(Token literalToken, LiteralUsageContext context, MyParser parser) {
        if (parser.getRoot() instanceof TerminalNode ter) {
            return null;
        }

        Optional<Token> declaredCons = declaredConstants.values().stream().filter(t -> t.getText().equals(literalToken.getText())).findAny();
        if (declaredCons.isPresent()) {
            return declaredCons.get();
        }

        // Get location of declaration.
        ListenerState listenerState = parser.getListenerState();
        ExtendContext parent = listenerState.getHighestLevel();
        if (parent == null) {
            logger.warn("If your code has a block structure, there may be something wrong of the state of tree listener.");
            return null;
        }
        if (parser.isBody(parent)) {
            ExtendContext  fieldDeclarationList = parent.getFirstCtxChildIf(parser::isFieldDeclarationList);
            if (fieldDeclarationList == null) {
                fieldDeclarationList = TreeNodeFactoryGetter.getFactory(parser).createFieldDeclarationList(parent);
            }
            parent = fieldDeclarationList;
        }

        // Generate declaration code.
        String type = switch (context.literalType) {
            case INT_NUMBER -> "long";
            case FLOAT_NUMBER -> "double";
            case CHAR -> "char";
            case STRING -> "String";
        };
        String tokenName = generateTokenName();
        String consModifier = parser.getConstantModifier();
        String code = String.format("%s %s %s = %s;", consModifier, type, tokenName, literalToken.getText());

        ExtendContext tree = (ExtendContext) parser.parseFromString(code);
        parent.insertChild(0, tree);
        Optional<Token> token = tree.getAllTokensRecIf(t -> t.getType() == parser.getIdentifier()).stream().findAny();
        if (token.isPresent()) {
            declaredConstants.put(tokenName, token.get());
            return token.get();
        }
        return null;
    }

    private String generateTokenName() {
        return "CONST_" + declaredConstants.size() + 1;
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        int ruleIndex = ctx.getRuleIndex();
        return ruleIndex == parser.getRuleLiteral() || ruleIndex == parser.getRuleIdentifier();
    }

    @Override
    public boolean isRelevant(List<Token> tokens, int i, Stage stage, MyParser parser) {
        return parser.belongToLiteral(tokens.get(i).getType());
    }
}
