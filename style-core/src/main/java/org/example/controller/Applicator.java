package org.example.controller;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.myException.ApplyException;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.utils.ParseTreeUtil;

import java.util.LinkedList;
import java.util.List;

public class Applicator {
    public static List<Token> applyRules(MyParser parser, StylerContainer container, TokenAugmentor tokenAugmentor) throws ApplyException {
        try {
//            tokenAugmentor.process(parser, Stage.APPLY);
            parser.walkTree(Stage.APPLY, container.getFirstRoundStylers());
            parser.walkTree(Stage.APPLY, container.getSecondRoundStylers());

            List<Token> tokens = new LinkedList<>();
            ParseTreeUtil.generateTokens(parser.getRoot(), tokens, parser);
//            tokens.add(parser.getTokenFactory().create(parser.getEOF(), "<EOF>"));

            applyOnTS(tokens, parser, container.getTsStylers());
            for (Styler styler : container.getStylers()) {
                styler.applicationFinalize();
            }
            return tokens;
        } catch (Exception e) {
            throw new ApplyException(e.getMessage(), e);
        }
    }


    /**
     * @apiNote :Apply style on token stream.
     */
    private static void applyOnTS(List<Token> tokens, MyParser parser, List<Styler> stylers) {
        int column = 0;

        TokenAugmentor.processAmbiguousToken(tokens, parser);
        // Handle the first token.
//        tokens.add(0, parser.getTokenFactory().create(-1, "<Virtual Head>"));
        for (int i = 0; i < tokens.size(); ++i) {
            ExtendToken curToken = (ExtendToken) tokens.get(i);
            curToken.resetContextTokens();
            int curTokenType = curToken.getType();

            // Skip deleted tokens.
            if (curTokenType == -1) {
                continue;
            }

            // All token stylers should not change the length of `tokens`.
            // Add new tokens into the field `contextTokens` of current token.
            // Set type and text of a token to remove it.
            for (Styler styler : stylers) {
                if (styler.isEnable(Stage.APPLY) && styler.isRelevant(tokens, i, Stage.APPLY, parser)) {
                    styler.applyStyle(tokens, i, parser);
                }
            }

            // Length of the `tokens` will change after this code.
            List<Token> contextTokens = curToken.getContextTokens();
            if (contextTokens.size() > 1) {
                tokens.remove(i);
                tokens.addAll(i, contextTokens);
                i += contextTokens.size() - 1;
            }

//            // Set char position in line.
//            for (Token token : contextTokens) {
//                ((ExtendToken) token).setCharPositionInLine(column);
//                if (token.getText().endsWith("\n")) {
//                    column = 0;
//                } else {
//                    column += token.getText().length();
//                }
//            }
        }

        TokenAugmentor.restoreState(tokens, parser);

    }

}
