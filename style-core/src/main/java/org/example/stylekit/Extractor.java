package org.example.stylekit;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.MyEnvironment;
import org.example.lang.LangAdapterCreator;
import org.example.myException.ExtractException;
import org.example.lang.MyParseTreeWalker;
import org.example.lang.intf.MyParser;
import org.example.style.StyleProfile;
import org.example.style.StyleFileIO;
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
import java.util.ArrayList;
import java.util.List;

public class Extractor {
    private static final Logger logger = LoggerFactory.getLogger(Extractor.class);


    /**
     * Extract dominant style for each style aspects from program files or an XML style file.
     * @param path file or directory paths separated by semicolon.
     * @param language programming language.
     * @param container StylerContainer to use.
     * @return extracted ProgramStyle object.
     */
    public static StyleProfile extractStyle(String path, String language, StylerContainer container) {
        FileCollection fileCollection = FileCollector.getFileCollection(List.of(path.split(";")));

        for (int i = 0; i < fileCollection.size(); i++) {
            try {
                Path curPath = Paths.get(fileCollection.getFilePath(i));

                // Read style from style file successfully, return directly.
                if (curPath.getFileName().toString().endsWith(".xml")) {
                    StyleProfile ret = StyleFileIO.read(curPath.toString());
                    container.fillStyle(ret);
                    if (ret != null) {
                        return ret;
                    }
                }

                if (GeneralUtil.checkFileExtension(curPath.getFileName().toString(), language)) {
                    MyParser parser = LangAdapterCreator.createParser(language);
                    ParseTree tree = parser.parse(curPath);
                    if (tree == null) {
                        logger.info("Failed to extract style rules from file '{}' because of compilation error.", curPath.toString());
                        continue;
                    }
                    TokenAugmentor tokenAugmentor = new TokenAugmentor();
                    Extractor.extractRules(parser, container, tokenAugmentor);
                } else {
                    logger.warn("File extension {} is not supported.", curPath.getFileName().toString());
                }

            } catch (Exception e) {
                logger.error("Failed to extract style rules from file: {}", fileCollection.getFilePath(i), e);
            }
        }

        extractFinalize(container);
        return combineStyle(container);
    }

    /**
     * Extract dominant style for each style aspects from source code string.
     * @param code source code string.
     * @param language programming language.
     * @param container StylerContainer to use.
     * @return extracted ProgramStyle object.
     */
    public static StyleProfile extractStyleFromString(String code, String language, StylerContainer container) {
        language = language.toLowerCase();
        MyParser parser = LangAdapterCreator.createParser(language);
        ParseTree tree = parser.parseFromString(code);
        if (tree == null) {
            return null;
        }

        try {
            TokenAugmentor tokenAugmentor = new TokenAugmentor();
            Extractor.extractRules(parser, container, tokenAugmentor);
            extractFinalize(container);
            return combineStyle(container);
        } catch (Exception e) {
            logger.error("Failed to extract style .",  e);
        }
        return null;
    }

    private static void extractRules(MyParser parser, StylerContainer container, TokenAugmentor tokenAugmentor) throws ExtractException {
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

    private static void extractOnAST(MyParser parser, List<Styler> stylers) {
        MyParseTreeWalker walker = new MyParseTreeWalker(parser, stylers);
        walker.walkTree(Stage.EXTRACT);
    }

    // Extract style from token stream.
    private static void extractOnTS(MyParser parser, List<Styler> stylers) {
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

    private static void extractFinalize(StylerContainer container) {
        for (Styler styler : container.getStylers()) {
            if (styler.isEnable(Stage.EXTRACT)) {
                styler.extractFinalize();
            }
        }
    }


    public static StyleProfile combineStyle(StylerContainer container) {
        StyleProfile styleProfile = new StyleProfile();
        for (Styler styler : container.getStylers()) {
            styleProfile.add(styler.getStyle());
        }
        return styleProfile;
    }

}
