package org.example.stylekit;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.lang.LangAdapterCreator;
import org.example.myException.ApplyException;
import org.example.lang.MyParseTreeWalker;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.token.ExtendToken;
import org.example.style.StylerContainer;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.utils.FileCollection;
import org.example.utils.FileCollector;
import org.example.utils.GeneralUtil;
import org.example.utils.ParseTreeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Applicator {
    private static final Logger logger = LoggerFactory.getLogger(Applicator.class);

//    private StylerContainer container;
//    private String language;
//
//
//    public Applicator(String language, StyleProfile targetStyleProfile) {
//        this.container = MyEnvironment.getIConfig().creasteStylerContainer(language);
//        this.container.fillStyle(targetStyleProfile);
//        this.language = language;
//    }
//
//    public Applicator(String language, StylerContainer container) {
//        this.container = container;
//        this.language = language;
//    }


    /**
     * Apply style rules to program files.
     * @param path program file or directory paths separated by semicolon.
     * @return Map<file path, result code>
     */
    public static Map<String, String> applyStyle(String path, String language, StylerContainer container) {
        FileCollection fileCollection = FileCollector.getFileCollection(List.of(path.split(";")));

        Map<String, String> results = new HashMap<>();
        for (int i = 0; i < fileCollection.size(); i++) {
            try {
                Path curPath = Paths.get(fileCollection.getFilePath(i));
                if (GeneralUtil.checkFileExtension(curPath.getFileName().toString(), language)) {
                    MyParser parser = LangAdapterCreator.createParser(language);
                    ParseTree tree = parser.parse(curPath);
                    if (tree == null) {
                        logger.info("Failed to apply style rules to file '{}' because of compilation error.", curPath.toString());
                        continue;
                    }

                    TokenAugmentor tokenAugmentor = new TokenAugmentor();
                    List<Token> tokens = Applicator.applyRules(parser, container);
                    results.put(curPath.toString(), toString(tokens, tokenAugmentor, parser));
                }

            } catch (Exception e) {
                logger.error("Failed to apply style rules to file: {}", fileCollection.getFilePath(i));
                logger.error("Exception details:", e);
            }
        }
        return results;
    }


    public static String applyStyleFromString(String code, String language, StylerContainer container) {
        try {
            MyParser parser = LangAdapterCreator.createParser(language);
            ParseTree tree = parser.parseFromString(code);
            if (tree == null) {
                return code;
            }

            TokenAugmentor tokenAugmentor = new TokenAugmentor();
            List<Token> tokens = Applicator.applyRules(parser, container);
            return toString(tokens, tokenAugmentor, parser);
        } catch (Exception e) {
            logger.error("Exception details:", e);
        }
        return code;
    }

    private static synchronized List<Token> applyRules(MyParser parser, StylerContainer container) throws ApplyException {
        try {
//            tokenAugmentor.process(parser, Stage.APPLY);
            MyParseTreeWalker walker = new MyParseTreeWalker(parser, container.getFirstRoundStylers());
            walker.walkTree(Stage.APPLY);
            walker = new MyParseTreeWalker(parser, container.getSecondRoundStylers());
            walker.walkTree(Stage.APPLY);

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
        for (int i = 0; i < tokens.size() - 1; ++i) {
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


    private static String toString(List<Token> tokens, TokenAugmentor tokenAugmentor, MyParser parser) {
        StringBuilder builder = new StringBuilder();
        if (tokens.get(tokens.size() - 1).getType() == parser.getEOF()) {
            tokens = tokens.subList(0, tokens.size() - 1);
        }
        tokenAugmentor.restoreState(tokens, parser);
        for (Token token : tokens) {
            builder.append(token.getText());
        }
        return builder.toString();
    }

}
