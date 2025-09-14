package org.example.controller;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.example.myException.ExtractException;
import org.example.parser.common.MyParser;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.utils.ParseTreeUtil;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Extractor {
    public static void extractRules(MyParser parser, StylerContainer container, TokenAugmentor tokenAugmentor) throws ExtractException {
        try {
//            tokenAugmentor.process(parser, Stage.EXTRACT);
            List<Styler> stylers = container.getStylers();
            extractOnAST(parser, stylers);
            extractOnTS(parser, stylers);
        } catch (Exception e) {
            LoggerFactory.getLogger(Extractor.class).error(e.getMessage(), e);
            throw new ExtractException(e.getMessage(), e);
        }
    }

    public static void extractOnAST(MyParser parser, List<Styler> stylers) {
        parser.walkTree(Stage.EXTRACT, stylers);
    }

    // Extract style from token stream.
    public static void extractOnTS(MyParser parser, List<Styler> stylers) {
        CommonTokenStream tokenStream = (CommonTokenStream) parser.getTokenStream();
        if (tokenStream.getTokens().isEmpty()) {
            tokenStream.fill();
        }
        List<Token> tokens = new ArrayList<>();
        ParseTreeUtil.generateTokens(parser.getRoot(), tokens, parser);

        TokenAugmentor.processAmbiguousToken(tokens, parser);

        // Avoid exceptions caused by boundaries.
        int len = tokens.size() - 1;
        for (int i = 0; i < len; ++i) {
            Token token = tokens.get(i);
            for (Styler styler : stylers) {
                if (styler.isEnable(Stage.EXTRACT) && styler.isRelevant(tokens, i, Stage.EXTRACT, parser)) {
                    styler.extractStyle(tokens, i, parser);
                }
            }
        }

        TokenAugmentor.restoreState(tokens, parser);
    }


}
