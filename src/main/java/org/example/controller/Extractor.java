package org.example.controller;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.StylerContainer;
import org.example.myException.ExtractException;
import org.example.parser.common.MyParser;
import org.example.style.ProgramStyle;
import org.example.styler.Preprocessor;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Extractor {
    public static void extractRules(MyParser parser, StylerContainer container, Preprocessor preprocessor) throws ExtractException {
        try {
            preprocessor.preprocess(parser, Stage.EXTRACT);
            extractOnTS(parser, container);
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
        int len = tokens.get(tokens.size() - 1).getType() == parser.getHws() ? tokens.size() - 2 : tokens.size() - 1;
        for (int i = 0; i < len; ++i) {
            Token token = tokens.get(i);
            for (Styler styler : container.getStylers()) {
                if (styler.isRelevant(tokens, i, Stage.EXTRACT, parser)) {
                    styler.extractStyle(tokens, i, parser);
                }
            }
        }
    }
}
