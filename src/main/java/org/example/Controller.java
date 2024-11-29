package org.example;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.dom4j.DocumentException;
import org.example.io.StyleFileIO;
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
//    private final List<Styler> astStylers = new ArrayList<>();
//    private final List<Styler> tStreamStylers = new ArrayList<>(); // token stream stylers.
    protected Configuration conf;
    Path curPath = null;

    public Controller(Configuration conf) {
        this.conf = conf;
    }

    public Controller() {
    }


    private void init(ProgramStyle programStyle) {
        if (programStyle == null) {
            container = new StylerContainer();
        }
    }

    public ProgramStyle extractStyle(FileCollection files) {
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
            } catch (IOException e) {
                System.err.println("error in extracting style from file: " + files.getFilePath(i));
            }
        }
//    System.out.println("-----------------------------------------------------------------");
//    System.out.println("extraction result:");
//    System.out.println("extracted files: " + count + "/" + files.size());
//    System.out.println("-----------------------------------------------------------------");

        extractFinalize();
        return combineStyle();
    }

    private void extractOnAST() {
        parser.walkTree(Stage.EXTRACT, container.getStylers());
    }

    private void extractInitialize() {
//        TokenOperation.setStyleObj(programStyle);
//        ExtendContext.setStyleObj(programStyle);
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

    public void applyStyle(FileCollection files) throws IOException {
        applyInitialize();
        int count = 0;
        for (int i = 0; i < files.size(); i++) {
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
        }

//    System.out.println("-----------------------------------------------------------------");
//    System.out.println("application result:");
//    System.out.println("applied files: " + count + "/" + files.size());
//    System.out.println("-----------------------------------------------------------------");
        // applyFinalize();
    }


    /**
     * @apiNote :Apply style on token stream.
     */
    private void applyOnTS(List<Token> tokens) {
        int column = 0;

        // Handle the first token.
        for (int i = 0; tokens.get(i).getType() != parser.getEOF(); ++i) {
            ExtendToken curToken = (ExtendToken) tokens.get(i);
            int curTokenType = curToken.getType();
            curToken.setCharPositionInLine(column);

            boolean isVws = parser.getVws() == curTokenType;
            if (isVws || curToken.getText().endsWith("\n")) {
                column = 0;
            } else {
                column += curToken.getText().length();
            }

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
        }
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

    private void applyInitialize() {

    }

    private void applyFinalize() {
    }

    // Return the first non-comment and non-whitespace token after the @curIndex.
    private Token getFirstToken(List<Token> tokens, int curIndex) {
        int type = tokens.get(curIndex).getType();
        while (curIndex < tokens.size()) {
            type = tokens.get(curIndex).getType();
            if (type == JavaLexer.BLOCK_COMMENT || type == JavaLexer.LINE_COMMENT
                    || type == JavaLexer.HWS || type == JavaLexer.VWS) {
                ++curIndex;
            } else {
                break;
            }
        }
        return tokens.get(curIndex);
    }

    private Token getNext(List<Token> list, int index) {
        if (index < list.size()) {
            return list.get(index);
        }
        return null;
    }


//    private void initTokenToOperationMap() {
//        if (!tokenToOperationMap.isEmpty()) {
//            return;
//        }
//        // Numeric literal
//        tokenToOperationMap.put(JavaLexer.DECIMAL_LITERAL, new NumericLiteralTokenOperation());
//        tokenToOperationMap.put(JavaLexer.HEX_LITERAL, new NumericLiteralTokenOperation());
//        tokenToOperationMap.put(JavaLexer.OCT_LITERAL, new NumericLiteralTokenOperation());
//        tokenToOperationMap.put(JavaLexer.BINARY_LITERAL, new NumericLiteralTokenOperation());
//        tokenToOperationMap.put(JavaLexer.FLOAT_LITERAL, new NumericLiteralTokenOperation());
//        tokenToOperationMap.put(JavaLexer.HEX_FLOAT_LITERAL, new NumericLiteralTokenOperation());
//
//        // String literal
//        tokenToOperationMap.put(JavaLexer.CHAR_LITERAL, new StrLiteralTokenOperation());
//        tokenToOperationMap.put(JavaLexer.STRING_LITERAL, new StrLiteralTokenOperation());
//        tokenToOperationMap.put(JavaLexer.TEXT_BLOCK, new StrLiteralTokenOperation());
//
//        // Comment
//        tokenToOperationMap.put(JavaLexer.BLOCK_COMMENT, new CommentTokenOperation());
//        tokenToOperationMap.put(JavaLexer.LINE_COMMENT, new CommentTokenOperation());
//
//        // Horizontal whitespace
//        // tokenToOperationMap.put(JavaLexer.HWS, new HWSTokenOperation());
//
//        // Brace
//        // tokenToOperationMap.put(JavaLexer.LBRACE, new ProcessBrace());
//        // tokenToOperationMap.put(JavaLexer.RBRACE, new ProcessBrace());
//    }

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
        } catch (IOException | DocumentException e) {
            logger.error(e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("{}\nPath: {}", e.getMessage(), curPath.toString());
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
