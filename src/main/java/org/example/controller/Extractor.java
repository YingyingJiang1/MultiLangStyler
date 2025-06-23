package org.example.controller;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.example.myException.ExtractException;
import org.example.parser.common.MyParser;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Extractor {
    public static void extractRules(MyParser parser, StylerContainer container, TokenAugmentor tokenAugmentor) throws ExtractException {
        try {
//            tokenAugmentor.process(parser, Stage.EXTRACT);
            extractOnTS(parser, container);
            tokenAugmentor.restoreState(((CommonTokenStream) parser.getTokenStream()).getTokens(), parser);
            extractOnAST(parser, container);
        } catch (Exception e) {
            LoggerFactory.getLogger(Extractor.class).error(e.getMessage(), e);
            throw new ExtractException(e.getMessage(), e);
        }
    }

    private static void extractOnAST(MyParser parser, StylerContainer container) {
        parser.walkTree(Stage.EXTRACT, container.getStylers());
    }

    // Extract style from token stream.
    private static void extractOnTS(MyParser parser, StylerContainer container) {
        CommonTokenStream tokenStream = (CommonTokenStream) parser.getTokenStream();
        if (tokenStream.getTokens().isEmpty()) {
            tokenStream.fill();
        }
        List<Token> tokens = tokenStream.getTokens();

        // Avoid exceptions caused by boundaries.
        int len = tokens.size() - 1;
        for (int i = 0; i < len; ++i) {
            Token token = tokens.get(i);
            for (Styler styler : container.getStylers()) {
                if (styler.isEnable(Stage.EXTRACT) && styler.isRelevant(tokens, i, Stage.EXTRACT, parser)) {
                    styler.extractStyle(tokens, i, parser);
                }
            }
        }
    }
}
