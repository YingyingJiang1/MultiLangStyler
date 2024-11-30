package org.example;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.dom4j.DocumentException;
import org.example.io.StyleFileIO;
import org.example.myException.ApplyException;
import org.example.myException.ExtractException;
import org.example.parser.common.*;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.MyParserFactory;
import org.example.parser.common.token.ExtendToken;
import org.example.parser.java.antlr.JavaLexer;
import org.example.style.ProgramStyle;
import org.example.styler.Preprocessor;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.utils.FileCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/13 20:59
 */
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    private MyParser parser;
    private ParseTree tree;
    private StylerContainer container = null;
    protected Configuration conf;
    Path curPath = null;

    public Controller(Configuration conf) {
        this.conf = conf;
    }

    public Controller() {
    }

    public ProgramStyle extractStyle(FileCollection files) throws ExtractException {
        extractInitialize();
        int count = 0;
        for (int i = 0; i < files.size(); i++) {
            try {
                curPath = Paths.get(files.getFilePath(i));
                setParser(curPath);
                ParseTree tree = parser.parse(curPath);
                if (tree == null) {
                    // System.out.println("extraction failure because of syntax error:" + filePath);
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("compilation-error" +
                            ".txt", true), StandardCharsets.UTF_8));
                    writer.write(curPath.toString());
                    continue;
                }
                // System.out.println("extract style from file: " + filePath);
                ++count;
                Preprocessor preprocessor = new Preprocessor();
                preprocessor.preprocess(parser, Stage.EXTRACT);
                extractOnTS();
                extractOnAST();
//                preprocessor.restoreState(((CommonTokenStream) parser.getTokenStream()).getTokens(), parser);
            } catch (Exception e) {
                logger.error("Failed to extract style rules from file: {}", files.getFilePath(i));
                throw new ExtractException(e.getMessage());
            }
        }

        extractFinalize();
        return combineStyle();
    }

    private void extractOnAST() {
        parser.walkTree(Stage.EXTRACT, container.getStylers());
    }

    private void extractInitialize() {
        for (Styler styler : container.getStylers()) {
            styler.reset();
        }
    }

    private void extractFinalize() {
        for (Styler styler : container.getStylers()) {
            styler.doFinalize();
        }
    }

    // Extract style from token stream.
    private void extractOnTS() {
        CommonTokenStream tokenStream = (CommonTokenStream) parser.getTokenStream();
        if (tokenStream.getTokens().isEmpty()) {
            tokenStream.fill();
        }
        List<Token> tokens = tokenStream.getTokens();

        // Avoid exceptions caused by boundaries.
        int len = tokens.get(tokens.size() - 1).getType() == parser.getHws() ? tokens.size() - 2 : tokens.size() - 1;
        for (int i = 1; i < len; ++i) { // @i begins at 1 to avoid exceptions caused by boundaries.
            Token token = tokens.get(i);
            for (Styler styler : container.getStylers()) {
                if (styler.isRelevant(tokens, i, Stage.EXTRACT)) {
                    styler.extractStyle(tokens, i);
                }
            }
        }

    }

    public void applyStyle(FileCollection files, ProgramStyle programStyle) {

    }

    private void applyStyle(FileCollection files) throws ApplyException {
        applyInitialize();
        int count = 0;
        for (int i = 0; i < files.size(); i++) {
            try {
                curPath = Paths.get(files.getFilePath(i));
                setParser(curPath);
                tree = parser.parse(curPath);
                if (tree == null) {
                    // System.out.println("application failure because of syntax error:" + filePath);
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("compilation-error" +
                            ".txt", true), StandardCharsets.UTF_8));
                    writer.write(curPath.toString());
                    continue;
                }
                ++count;

                Preprocessor preprocessor = new Preprocessor();
                preprocessor.preprocess(parser, Stage.APPLY);
                parser.walkTree(Stage.APPLY, container.getStylers());

                List<Token> tokens = new LinkedList<>();
                generateTokens(tree, tokens);
                tokens.add(parser.getTokenFactory().create(parser.getEOF(), "<EOF>"));

                applyOnTS(tokens);
                saveApplyResult(tokens, preprocessor);
            } catch (Exception e) {
                logger.error("Failed to apply style rules to file: {}", files.getFilePath(i));
                throw new ApplyException(e.getMessage());
            }
        }
    }


    /**
     * @apiNote :Apply style on token stream.
     */
    private void applyOnTS(List<Token> tokens) {
        int column = 0;

        // Handle the first token.
        tokens.add(0, parser.getTokenFactory().create(-1, "<Virtual Head>"));
        for (int i = 1; tokens.get(i).getType() != parser.getEOF(); ++i) {
            ExtendToken curToken = (ExtendToken) tokens.get(i);
            int curTokenType = curToken.getType();

            for (Styler styler : container.getStylers()) {
                if (styler.isRelevant(tokens, i, Stage.APPLY)) {
                    styler.applyStyle(tokens, i);
                }
            }

            List<Token> contextTokens = curToken.getContextTokens();
            if (contextTokens.size() > 1) {
               tokens.remove(i);
               tokens.addAll(i, contextTokens);
               i += contextTokens.size() - 1;
            }

            for (Token token : contextTokens) {
                ((ExtendToken) token).setCharPositionInLine(column);
                if (token.getText().endsWith("\n")) {
                    column = 0;
                } else {
                    column += token.getText().length();
                }
            }
        }
        tokens.remove(0);
    }


    private void saveApplyResult(List<Token> tokens, Preprocessor preprocessor) throws IOException {
        StringBuilder builder = new StringBuilder();
        if (tokens.get(tokens.size() - 1).getType() == parser.getEOF()) {
            tokens = tokens.subList(0, tokens.size() - 1);
        }
        for (Token token : tokens) {
            preprocessor.restoreState(token, parser);
            builder.append(token.getText());
        }

        String code = builder.toString();
        Path resFilePath = null;
        String saveDir = null;
        if (conf.overrideSource) {
            resFilePath = curPath;
            Files.write(resFilePath, code.getBytes());
            return;
        } else if (conf.applyResultSaveDir != null) {
            saveDir = conf.applyResultSaveDir;
            if (!saveDir.endsWith(File.separator)) {
                saveDir = saveDir + File.separator;
            }
        } else {
            saveDir = curPath.getParent().toString();
        }

        String fileName = curPath.getFileName().toString();
        int dotIndex = fileName.lastIndexOf(".");
        String resPath = Paths.get(saveDir, fileName.substring(0, dotIndex) + "-result" + fileName.substring(dotIndex)).toString();

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resPath)))) {
            writer.write(code);
        }
    }


    private void init(ProgramStyle programStyle) {
        if (programStyle == null) {
            container = new StylerContainer();
        }
    }

    private void applyInitialize() {

    }

    private void applyFinalize() {
    }

    private void generateTokens(ParseTree root, List<Token> tokens) {
        if (root instanceof TerminalNode) {
            int hierarchy = ((ExtendContext) root.getParent()).hierarchy;
            ExtendToken token = (ExtendToken) (((TerminalNode) root).getSymbol());
            // There are some tokens add around the `token` after style transformations.
            List<Token> contextTokens = token.getContextTokens();
            contextTokens.forEach(t -> {
                if (t instanceof ExtendToken extToken) {
                    extToken.setHierarchy(hierarchy);
                }
            });
            token.contextTokens = null;
            tokens.addAll(contextTokens);
        } else {
            ExtendContext ctx = (ExtendContext) root;
            ctx.updateHierarchy(parser);
            for (ParseTree child : ctx.children) {
                generateTokens(child, tokens);
            }
        }
    }

    public ProgramStyle execute() {
        try {
            ProgramStyle programStyle = null;
            // extract style from existing style file or source codes.
            if (conf.styleFile != null) {
                programStyle = StyleFileIO.read(conf.styleFile, parser);
                init(programStyle);
            } else {
                init(null);
                programStyle = extractStyle(conf.extractionCollection);
            }
            StyleFileIO.write(programStyle, conf.styleFileSavedPath, parser);
            applyStyle(conf.applicationCollection);
            return programStyle;
        } catch (DocumentException | ExtractException | ApplyException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    private ProgramStyle combineStyle() {
        ProgramStyle programStyle = new ProgramStyle();
        for (Styler styler : container.getStylers()) {
            programStyle.add(styler.getStyle());
        }
        return programStyle;
    }

    private void setParser(Path filePath) {
        parser = MyParserFactory.createParser(filePath.getFileName().toString());
        container.getStylers().forEach(styler -> styler.setParser(parser));
    }


//    private static Extractor createExtractor(Configuration conf, ProgramStyle programStyle) throws IOException {
//        Extractor extractor = null;
//        if (conf.styleFile != null && !conf.styleFile.isEmpty()) {
//            extractor = new XmlExtractor(conf, programStyle);
//        }
//        if (extractor == null) {
//            extractor = new AntlrStyler(conf, programStyle);
//        }
//        return extractor;
//    }
}
