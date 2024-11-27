package org.example;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.dom4j.DocumentException;
import org.example.styler.body.optionalbrace.OptionalBraceStyler;
import org.example.styler.body.braceformat.BraceFormatStyler;
import org.example.styler.format.linestmt.LineStmtStyler;
import org.example.styler.format.linewrapping.LineWrappingStyler;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.structure.StructureStyler;
import org.example.utils.FileCollection;
import org.example.io.StyleFileIO;
import org.example.parser.common.*;
import org.example.parser.java.antlr.JavaLexer;
import org.example.style.ProgramStyle;
import org.example.styler.*;
import org.example.styler.arrangement.ArrangementStyler;
import org.example.styler.format.indention.IndentionStyler;
import org.example.styler.format.space.SpaceStyler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/13 20:59
 */
public class Controller {
    // For test
//    public static ProgramStyle programStyle;
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    private MyParser parser;
    private ParseTree tree;
//    private Map<Integer, TokenOperation> tokenToOperationMap = new HashMap<>();

    private final List<Styler> astStylers = new ArrayList<>();
    private final List<Styler> tStreamStylers = new ArrayList<>(); // token stream stylers.
//  protected ProgramStyle programStyle;
  protected Configuration conf;
    Path curPath = null;

    public static final int EXTRACTION_PROCESS = 1;
    public static final int APPLICATION_PROCESS = 2;

    public Controller(Configuration conf) {
        this.conf = conf;
    }

    public Controller() {}


    private void initStylers(ProgramStyle programStyle) {
        if (programStyle == null) {
            astStylers.add(new ArrangementStyler());
            astStylers.add(new OptionalBraceStyler());
            astStylers.add(new StructureStyler());
            astStylers.add(new BraceFormatStyler(false));
            astStylers.add(new LineWrappingStyler());
            astStylers.add(new LineStmtStyler());
            astStylers.add(new NewlineStyler(false));

            tStreamStylers.add(new SpaceStyler());
            tStreamStylers.add(new IndentionStyler()); // `IndentionStyler` must be the last styler.
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
                preprocessor.preprocess(parser, Styler.EXTRACTION_PROCESS);
                extractOnTS();
                extractOnAST();
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
        parser.walkTree(EXTRACTION_PROCESS, astStylers);
    }

    private void extractInitialize() {
//        TokenOperation.setStyleObj(programStyle);
//        ExtendContext.setStyleObj(programStyle);
    }

    private void extractFinalize() {
        List<Styler> stylers = new ArrayList<>();
        stylers.addAll(astStylers);
        stylers.addAll(tStreamStylers);
        for (Styler styler : stylers) {
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
        List<Integer> toBeRestored = processAmbiguousToken(tokens);

        // Avoid exceptions caused by boundaries.
        int len = tokens.get(tokens.size() - 1).getType() == parser.getHws() ? tokens.size() - 2 : tokens.size() - 1;
        List<Styler> indentionStylers = tStreamStylers.stream().filter(styler -> styler instanceof IndentionStyler).toList();
        tStreamStylers.removeIf(styler -> styler instanceof IndentionStyler);
        for (int i = 1; i < len; ++i) { // @i begins at 1 to avoid exceptions caused by boundaries.
            Token token = tokens.get(i);
            if (!indentionStylers.isEmpty() && token.getType() == parser.getHws() && token.getCharPositionInLine() == 0) {
                indentionStylers.get(0).extractStyle(tokens, i);
            }
            for (Styler styler : tStreamStylers) {
                styler.extractStyle(tokens, i);
            }
        }
        tStreamStylers.addAll(indentionStylers);

        // Must restore the type of modified tokens, otherwise things will go wrong in syntactic analysis phase.
        for (int i : toBeRestored) {
            if (tokenStream.get(i) instanceof CommonToken) {
                CommonToken commonToken = (CommonToken) tokenStream.get(i);
                commonToken.setType(-commonToken.getType());
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
            // System.out.println("apply style for file: " + filePath);

            // First round: apply on AST
            Preprocessor preprocessor = new Preprocessor();
            preprocessor.preprocess(parser, Styler.APPLICATION_PROCESS);
//            Set<Class> disabledClassed = new HashSet<>(List.of(AntlrBraceStyler.class, NewlineStyler.class);
//            disable(APPLICATION_PROCESS, disabledClassed);
            parser.walkTree(Styler.APPLICATION_PROCESS, astStylers);

            // Second round: apply on AST
//            Set<Class> enabledClasses = new HashSet<>(List.of(List.of(AntlrBraceStyler.class, NewlineStyler.class));
//            enable(enterStylers, APPLICATION_PROCESS, enabledClasses);
//            parser.walkTree(Styler.APPLICATION_PROCESS, enterStylers, exitStylers);

            String code = applyOnTS();
            saveApplyResult(code);

//            Experiment.addApplyResult(curPath.getFileName().toString());
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
    private String applyOnTS() {
        List<Token> tokens = new ArrayList<>();
        // ((ExtendContext) tree).hierarchy = -1; // Set the hierarchy of CompilationUnit to -1.
        generateTokens(tree, tokens);

        StringBuilder builder = new StringBuilder();

        processAmbiguousToken(tokens);

        int column = 0;

        // Handle the first token.
        if (!tokens.isEmpty()) {
            Token firstToken = tokens.get(0);
            builder.append(firstToken.getText());
            column += firstToken.getText().length();
        }

        List<Styler> indentionStylers = tStreamStylers.stream().filter(styler -> styler instanceof IndentionStyler).toList();
        tStreamStylers.removeIf(styler -> styler instanceof IndentionStyler);
        for (int i = 1; i < tokens.size(); ++i) {
            ExtendToken curToken = (ExtendToken) tokens.get(i);
            int curTokenType = curToken.getType();
            curToken.setCharPositionInLine(column);

            boolean isVws = AntlrHelper.isVws(curToken);
            if (isVws || curToken.getText().endsWith("\n")) {
                column = 0;
            } else {
                column += curToken.getText().length();
            }

            // In "(VWS or LINE_COMMENT),(VWS),(})", the second VWS is redundant.
            if (i < tokens.size() - 1) {
                Token preToken = tokens.get(i - 1), nextToken = tokens.get(i + 1);
                if (AntlrHelper.isVws(curToken) && preToken.getText().endsWith("\n") && AntlrHelper.isRBrace(nextToken)) {
                    continue;
                }
            }

            Token preToken = tokens.get(i - 1);
            // For efficiency reasons, apply indentation separately.
            if (!indentionStylers.isEmpty() && preToken.getText().endsWith("\n") && parser.getVws() != curTokenType) { // add indention
                indentionStylers.get(0).applyStyle(tokens, i);

            }
            for (Styler styler : tStreamStylers) {
                styler.applyStyle(tokens, i);
            }

            builder.append(curToken.getText());
        }
        tStreamStylers.addAll(indentionStylers);

        return builder.toString();
    }


    private void saveApplyResult(String programStr) throws IOException {
        Path resFilePath = null;
        String saveDir = null;
        if (conf.overrideSource) {
            resFilePath = curPath;
            Files.write(resFilePath, programStr.getBytes());
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
        String resPath = saveDir + fileName;

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resPath)))) {
            writer.write(programStr);
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

    /**
     * @Description Set real type for '<' and '-'.
     * @param tokens
     * @return
     */
    private List<Integer> processAmbiguousToken(List<Token> tokens) {
        List<Integer> toBeRestored = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++) {
            int type = tokens.get(i).getType();
            if (type == JavaLexer.LT) {
                toBeRestored.addAll(processAngleBracket(tokens, i));
            } else if (AntlrHelper.isSub(type)) {
                toBeRestored.addAll(processNegativeOperator(tokens, i));
            }
        }
        return toBeRestored;
    }

    /**
     * @param curIndex index of '-'
     * @return
     */
    private List<Integer> processNegativeOperator(List<Token> tokens, int curIndex) {
        List<Integer> tokenIndexs = new ArrayList<>(1);
        int i = curIndex - 1;
        for (; i >= 0; i--) {
            if (AntlrHelper.inDefaultChannel(tokens.get(i).getChannel())) {
                break;
            }
        }

        int preType = tokens.get(i).getType();
        if (preType != JavaLexer.IDENTIFIER && preType != JavaLexer.RPAREN && preType != JavaLexer.RBRACK) {
            ExtendToken subToken = (ExtendToken) tokens.get(curIndex);
            subToken.setType(-subToken.getType());
            tokenIndexs.add(curIndex);
        }

        return tokenIndexs;
    }


    /**
     * Try to match angle brackets, and then set the type of all matched tokens to -type.
     *
     * @param curIndex Index of '<'
     */
    private List<Integer> processAngleBracket(List<Token> tokens, int curIndex) {
        int count = 1;
        List<Integer> matchedTokens = new ArrayList<>();
        matchedTokens.add(curIndex);
        for (int i = curIndex + 1; i < tokens.size(); ++i) {
            Token token = tokens.get(i);
            int tokenType = token.getType();
            if (tokenType == parser.getLT()) {
                ++count;
                matchedTokens.add(i);
            } else if (tokenType == parser.getGT()) {
                --count;
                matchedTokens.add(i);
            } else if (tokenType != parser.getRuleIdentifier() && tokenType != parser.getComma() &&
                    tokenType != parser.getHws() && tokenType != parser.getVws()) {
                break;
            }
        }
        if (count == 0) {
            for (int i : matchedTokens) {
                if (tokens.get(i) instanceof CommonToken) {
                    CommonToken commonToken = (CommonToken) tokens.get(i);
                    commonToken.setType(-commonToken.getType());
                }
            }
            return matchedTokens;
        }
        matchedTokens.clear();
        return matchedTokens;
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
            token.setHierarchy(hierarchy);
            tokens.addAll(token.getFullTokens());
        } else {
            ExtendContext ctx = (ExtendContext) root;
            ctx.updateHierarchy(parser);
            for (ParseTree child : ctx.children) {
                generateTokens(child, tokens);
            }
        }
    }

    /**
     * Add comment for tokens in default channel.
     */
    private void processComment() {
        CommonTokenStream tokenStream = (CommonTokenStream) parser.getTokenStream();
        tokenStream.fill();
        List<Token> tokens = tokenStream.getTokens();
        for (int i = 0; i < tokens.size(); i++) {
            addComment(i);
        }
    }

    private void addComment(int tokenIndex) {
        CommonTokenStream tokenStream = (CommonTokenStream) parser.getTokenStream();
        Token token = tokenStream.get(tokenIndex);
        if (token.getChannel() != JavaLexer.DEFAULT_TOKEN_CHANNEL) {
            return;
        }
        List<Token> comments = tokenStream.getHiddenTokensToLeft(tokenIndex, JavaLexer.COMMENT_CHANNEL);
        if (comments != null) {
      /*System.out.println("token:" + token.getType());
      System.out.println("comments:");
      for(Token comment : comments) {
        System.out.println(comment.getText());
      }*/
            ((ExtendToken) token).comments = comments;
        }
    }

    private String getCommentsBefore(Token token) {
        return ((ExtendToken) token).getComments();
    }

    public ProgramStyle execute() {
        try {
            ProgramStyle programStyle = null;
            // extract style from existing style file or source codes.
            if (conf.styleFile != null) {
                programStyle = StyleFileIO.read(conf.styleFile, parser);
                initStylers(programStyle);
            } else {
                initStylers(null);
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
        for (Styler styler : astStylers) {
            programStyle.add(styler.getStyle());
        }
        return programStyle;
    }

    private void setParser(Path filePath) {
        parser = MyParserFactory.createParser(filePath.getFileName().toString());
        astStylers.forEach(styler -> styler.setParser(parser));
        tStreamStylers.forEach(styler -> styler.setParser(parser));
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
