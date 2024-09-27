package org.example.styler;

import com.ibm.icu.text.CharsetDetector;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentException;
import org.example.Configuration;
import org.example.antlr.JavaLexer;
import org.example.antlr.JavaParser;
import org.example.core.tokenOp.CommentTokenOperation;
import org.example.core.tokenOp.NumericLiteralTokenOperation;
import org.example.core.tokenOp.StrLiteralTokenOperation;
import org.example.core.tokenOp.TokenOperation;
import org.example.experiment.Experiment;
import org.example.parser.*;
import org.example.style.ProgramStyle;
import org.example.style.format.FormatStyle;
import org.example.style.format.IndentionRule;
import org.example.styler.arrangement.ArrangementStyler;
import org.example.styler.brace.AntlrBraceStyler;
import org.example.styler.format.FormatStyler;
import org.example.styler.hws.HwsStyler;
import org.example.styler.linewrapping.LineWrappingStyler;
import org.example.styler.naming.NamingStyler;
import org.example.styler.newline.NewlineStyler;
import org.example.styler.structure.StructureStyler;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/20 22:14
 */
public class AntlrStyler extends Styler {
  private JavaParser parser;
  private ParseTree tree;
  private Map<Integer, TokenOperation> tokenToOperationMap = new HashMap<>();
  private List<StylerBase> enterStylers = new ArrayList<>();
  private List<StylerBase> exitStylers = new ArrayList<>();
  private List<StylerBase> tStreamStylers = new ArrayList<>(); // token stream stylers.


  public AntlrStyler(Configuration conf, ProgramStyle programStyle) throws IOException {
    super(conf, programStyle);
    exitStylers.add(new NamingStyler());
    exitStylers.add(ArrangementStyler.getInstance());
    exitStylers.add(new AntlrCommentStyler());
    exitStylers.add(new FormatStyler());
    exitStylers.add(new StructureStyler());

    tStreamStylers.add(new HwsStyler());
    tStreamStylers.add(new LineWrappingStyler());
  }

  @Override
  public void extractStyle() throws IOException, DocumentException {
    extractInitialize();
    enableAll(Styler.EXTRACTION_PROCESS);
    int count = 0;
    for (int i = 0; i < files.size(); i++) {
      filePath = files.getFilePath(i);
      generateTree(filePath);
      if (parser.getNumberOfSyntaxErrors() > 0) {
        // System.out.println("extraction failure because of syntax error:" + filePath);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("compilation-error" +
            ".txt", true), StandardCharsets.UTF_8));
        writer.write(filePath);
        continue;
      }
      // System.out.println("extract style from file: " + filePath);
      ++count;
      Preprocessor preprocessor = new Preprocessor();
      preprocessor.preprocess(parser, Styler.EXTRACTION_PROCESS);
      extractStylePhase1();
      extractStylePhase2();
    }
    programStyle.fill();
//    System.out.println("-----------------------------------------------------------------");
//    System.out.println("extraction result:");
//    System.out.println("extracted files: " + count + "/" + files.size());
//    System.out.println("-----------------------------------------------------------------");

    // extractFinalize();
  }

  protected void extractInitialize() {
    files = conf.extractionCollection;
    initTokenToOperationMap();
    TokenOperation.initializeProcess();
    TokenOperation.setStyleObj(programStyle);
    ExtendContext.setStyleObj(programStyle);
  }

  protected void extractFinalize() {
    for(TokenOperation operation : tokenToOperationMap.values()) {
      operation.doFinalize();
    }
    List<StylerBase> stylers = new ArrayList<>();
    stylers.addAll(enterStylers);
    stylers.addAll(exitStylers);
    stylers.addAll(tStreamStylers);

    for (StylerBase styler : stylers) {
      styler.doFinalize(programStyle);
    }
  }

  // Extract style from token stream.
  private void extractStylePhase1() {
    CommonTokenStream tokenStream = (CommonTokenStream) parser.getTokenStream();
    if (tokenStream.getTokens().isEmpty()) {
      tokenStream.fill();
    }
    List<Token> tokens = tokenStream.getTokens();
    List<Integer> toBeRestored = processAmbiguousToken(tokens);
    // Avoid exceptions caused by boundaries.
    int len = tokens.get(tokens.size() - 1).getType() == JavaLexer.HWS ? tokens.size() - 2 : tokens.size() - 1;

    for (int i = 1; i < len; ++i) { // @i begins at 1 to avoid exceptions caused by boundaries.
      Token token = tokens.get(i);
      int type = token.getType();

      for (StylerBase styler : tStreamStylers) {
        styler.extractStyle(tokens, i, programStyle);
      }
      TokenOperation op = tokenToOperationMap.get(type);
      if (op != null) {
        i += op.extractStyle(tokens, i, programStyle);
      }
    }

    // Must restore the type of modified tokens, otherwise things will go wrong in syntactic analysis phase.
    for(int i : toBeRestored) {
      if(tokenStream.get(i) instanceof CommonToken) {
        CommonToken commonToken = (CommonToken) tokenStream.get(i);
        commonToken.setType(-commonToken.getType());
      }
    }
  }

  // Extract style from AST.
  private void extractStylePhase2() throws IOException {
    ExtendParserListener listener = new ExtendParserListener(programStyle,
        Styler.EXTRACTION_PROCESS, enterStylers, exitStylers);
    ParseTreeWalker walker = new MyParseTreeWalker();
    walker.walk(listener, tree);
    // Files.write(Paths.get("source-ast.txt"), root.toStringTree(parser).getBytes());
  }

  @Override
  public void applyStyle() throws IOException {
    applyInitialize();
    int count = 0;
    for (int i = 0; i < files.size(); i++) {
      filePath = files.getFilePath(i);
      generateTree(filePath);
      if (parser.getNumberOfSyntaxErrors() > 0) {
        // System.out.println("application failure because of syntax error:" + filePath);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("compilation-error" +
            ".txt", true), StandardCharsets.UTF_8));
        writer.write(filePath);
        continue;
      }
      ++count;
      // System.out.println("apply style for file: " + filePath);
      Preprocessor preprocessor = new Preprocessor();
      preprocessor.preprocess(parser, Styler.APPLICATION_PROCESS);
      enableAll(Styler.APPLICATION_PROCESS);
      disable(Styler.APPLICATION_PROCESS, FormatStyler.class);
      applyStylePhase1();

      String code = applyFormat();
      saveApplyResult(code);

      Experiment.addApplyResult(Paths.get(filePath).getFileName().toString());
    }

//    System.out.println("-----------------------------------------------------------------");
//    System.out.println("application result:");
//    System.out.println("applied files: " + count + "/" + files.size());
//    System.out.println("-----------------------------------------------------------------");
    // applyFinalize();
  }

  private void cleanState() {

  }

  private String applyFormat() throws IOException {
    List<StylerBase> enterStylers = new ArrayList<>();
    List<StylerBase> exitStylers = new ArrayList<>();
    enterStylers.add(new AntlrBraceStyler(false, true));
    enterStylers.add(new NewlineStyler(false, true));
    ExtendParserListener listener = new ExtendParserListener(programStyle,
        Styler.APPLICATION_PROCESS, enterStylers, exitStylers);
    ParseTreeWalker walker = new MyParseTreeWalker();
    walker.walk(listener, tree);
    return applyStylePhase2();
  }

  // Apply style on AST.
  private void applyStylePhase1() throws IOException {
    ExtendParserListener listener = new ExtendParserListener(programStyle,
        Styler.APPLICATION_PROCESS, enterStylers, exitStylers);
    ParseTreeWalker walker = new MyParseTreeWalker();
    walker.walk(listener, tree);
    // Files.write(Paths.get("target-ast.txt"), root.toStringTree(parser).getBytes());
  }

  /**
   * @apiNote :Apply style on token stream.
   */
  private String applyStylePhase2() {
    List<Token> tokens = new ArrayList<>();
    // ((ExtendContext) tree).hierarchy = -1; // Set the hierarchy of CompilationUnit to -1.
    generateTokens(tree, tokens);

    StringBuilder builder = new StringBuilder();
    FormatStyle formatStyle = (FormatStyle) programStyle.getStyle(ProgramStyle.FORMAT);

    processAmbiguousToken(tokens);

    int column = 0;

    // Handle the first token.
    if(!tokens.isEmpty()) {
      Token firstToken = tokens.get(0);
      builder.append(firstToken.getText());
      column += firstToken.getText().length();
    }

    for(int i = 1; i < tokens.size(); ++i) {
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
      if(i < tokens.size() - 1) {
        Token preToken = tokens.get(i - 1), nextToken = tokens.get(i + 1);
        if(AntlrHelper.isVws(curToken) && preToken.getText().endsWith("\n") && AntlrHelper.isRBrace(nextToken)) {
          continue;
        }
      }

      for(StylerBase styler : tStreamStylers) {
        styler.applyStyle(tokens, i, programStyle);
      }

      Token preToken = tokens.get(i - 1);
      if(preToken.getText().endsWith("\n") && !isVws) { // add indention
        IndentionRule indentionProperty = formatStyle.getIndentionProperty();
        if (indentionProperty != null) {
          String indentionStr = StringUtils.repeat(indentionProperty.indentionType,
              curToken.getHierarchy() * indentionProperty.indentionUnit) +
              StringUtils.repeat(indentionProperty.indentionType, curToken.indention);
          curToken.setCharPositionInLine(curToken.getCharPositionInLine() + indentionStr.length());
          builder.append(indentionStr);
        }
      } else {
        String space = formatStyle.getSpaceBetween(preToken.getType(), curToken.getType());
        curToken.setCharPositionInLine(curToken.getCharPositionInLine() + space.length());
        builder.append(space);
      }

      builder.append(curToken.getText());
    }
    return builder.toString();
  }

  public void enableAll(int process) {
    for(StylerBase styler : enterStylers) {
      styler.enable(process);
    }
    for(StylerBase styler : exitStylers) {
      styler.enable(process);
    }
  }

  public void disableAll(int process) {
    for(StylerBase styler : enterStylers) {
      styler.disable(process);
    }
    for(StylerBase styler : exitStylers) {
      styler.disable(process);
    }
  }

  public void enable(int process, Class cls) {
    for(StylerBase styler : enterStylers) {
      if(styler.getClass().equals(cls)) {
        styler.enable(process);
      }
    }
    for(StylerBase styler : exitStylers) {
      if(styler.getClass().equals(cls)) {
        styler.enable(process);
      }
    }
  }

  public void disable(int process, Class cls) {
    for(StylerBase styler : enterStylers) {
      if(styler.getClass().equals(cls)) {
        styler.disable(process);
      }
    }
    for(StylerBase styler : exitStylers) {
      if(styler.getClass().equals(cls)) {
        styler.disable(process);
      }
    }
  }


  private void saveApplyResult(String programStr) throws IOException {
    String encode = StandardCharsets.UTF_8.toString();
    try(FileInputStream inputStream = new FileInputStream(filePath);) {
      // Get encode.
      CharsetDetector detector = new CharsetDetector();
      byte[] bytes = inputStream.readAllBytes();
      detector.setText(bytes);
      encode = detector.detect().getName();
    }


    Path resFilePath = null;
    Path filePath = Paths.get(this.filePath);
    String saveDir = null;
    if(conf.overrideSource) {
      resFilePath = filePath;
      Files.write(resFilePath, programStr.getBytes());
      return;
    } else if(conf.applyResultSaveDir != null) {
      saveDir = conf.applyResultSaveDir;
      if(!saveDir.endsWith(File.separator)) {
        saveDir = saveDir + File.separator;
      }

    } else {
      saveDir = filePath.getParent().toString();
    }
    String fileName = filePath.getFileName().toString();
    int dotIndex = fileName.lastIndexOf(".");
    String resPath = saveDir + fileName;
//    String resPath = saveDir + (dotIndex == -1 ? "result.java" : fileName.substring(0, fileName.indexOf(".")) +
//        "-result.java");

   //  String resPath = saveDir + (dotIndex == -1 ? "result.java" : fileName);
    try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resPath), encode))) {
      writer.write(programStr);
    }
  }

  protected void applyInitialize() {
    files = conf.applicationCollection;
    initTokenToOperationMap();
    TokenOperation.initializeProcess();
    TokenOperation.setStyleObj(programStyle);
    ExtendContext.setStyleObj(programStyle);
  }

  protected void applyFinalize() {
    for(TokenOperation operation : tokenToOperationMap.values()) {
      operation.doFinalize();
    }
  }

  // Return the first non-comment and non-whitespace token after the @curIndex.
  private Token getFirstToken(List<Token> tokens, int curIndex) {
    int type = tokens.get(curIndex).getType();
    while(curIndex < tokens.size()) {
      type = tokens.get(curIndex).getType();
      if(type == JavaLexer.BLOCK_COMMENT || type == JavaLexer.LINE_COMMENT
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

  private List<Integer> processAmbiguousToken(List<Token> tokens) {
    List<Integer> toBeRestored = new ArrayList<>();
    for (int i = 0; i < tokens.size(); i++) {
      int type = tokens.get(i).getType();
      if(type == JavaLexer.LT) {
        toBeRestored.addAll(processAngleBracket(tokens, i));
      } else if(AntlrHelper.isSub(type)) {
        toBeRestored.addAll(processNegativeOperator(tokens, i));
      }
    }
    return toBeRestored;
  }

  /**
   *
   * @param curIndex index of '-'
   * @return
   */
  private List<Integer> processNegativeOperator(List<Token> tokens, int curIndex) {
    List<Integer> tokenIndexs = new ArrayList<>(1);
    int i = curIndex - 1;
    for (; i >= 0; i--) {
      if(AntlrHelper.inDefaultChannel(tokens.get(i).getChannel())) {
        break;
      }
    }

    int preType = tokens.get(i).getType();
    if(preType != JavaLexer.IDENTIFIER && preType != JavaLexer.RPAREN && preType != JavaLexer.RBRACK) {
      ExtendToken subToken = (ExtendToken) tokens.get(curIndex);
      subToken.setType(-subToken.getType());
      tokenIndexs.add(curIndex);
    }

    return tokenIndexs;
  }


  /**
   * Try to match angle brackets, and then set the type of all matched tokens to -type.
   * @param curIndex Index of '<'
   */
  private List<Integer> processAngleBracket(List<Token> tokens, int curIndex) {
    int count = 1;
    List<Integer> matchedTokens = new ArrayList<>();
    matchedTokens.add(curIndex);
    for(int i = curIndex + 1; i < tokens.size(); ++i) {
      Token token = tokens.get(i);
      int tokenType = token.getType();
      if(tokenType == JavaParser.LT) {
        ++count;
        matchedTokens.add(i);
      } else if(tokenType == JavaParser.GT) {
        --count;
        matchedTokens.add(i);
      } else if(tokenType != JavaParser.IDENTIFIER && tokenType != JavaParser.COMMA &&
          tokenType != JavaParser.HWS && tokenType != JavaParser.VWS) {
        break;
      }
    }
    if(count == 0) {
      for(int i : matchedTokens) {
        if(tokens.get(i) instanceof CommonToken) {
          CommonToken commonToken = (CommonToken) tokens.get(i);
          commonToken.setType(-commonToken.getType());
        }
      }
      return matchedTokens;
    }
    matchedTokens.clear();
    return matchedTokens;
  }




  private void initTokenToOperationMap () {
    if(!tokenToOperationMap.isEmpty()) {
      return;
    }
    // Numeric literal
    tokenToOperationMap.put(JavaLexer.DECIMAL_LITERAL, new NumericLiteralTokenOperation());
    tokenToOperationMap.put(JavaLexer.HEX_LITERAL, new NumericLiteralTokenOperation());
    tokenToOperationMap.put(JavaLexer.OCT_LITERAL, new NumericLiteralTokenOperation());
    tokenToOperationMap.put(JavaLexer.BINARY_LITERAL, new NumericLiteralTokenOperation());
    tokenToOperationMap.put(JavaLexer.FLOAT_LITERAL, new NumericLiteralTokenOperation());
    tokenToOperationMap.put(JavaLexer.HEX_FLOAT_LITERAL, new NumericLiteralTokenOperation());

    // String literal
    tokenToOperationMap.put(JavaLexer.CHAR_LITERAL, new StrLiteralTokenOperation());
    tokenToOperationMap.put(JavaLexer.STRING_LITERAL, new StrLiteralTokenOperation());
    tokenToOperationMap.put(JavaLexer.TEXT_BLOCK, new StrLiteralTokenOperation());

    // Comment
    tokenToOperationMap.put(JavaLexer.BLOCK_COMMENT, new CommentTokenOperation());
    tokenToOperationMap.put(JavaLexer.LINE_COMMENT, new CommentTokenOperation());

    // Horizontal whitespace
    // tokenToOperationMap.put(JavaLexer.HWS, new HWSTokenOperation());

    // Brace
    // tokenToOperationMap.put(JavaLexer.LBRACE, new ProcessBrace());
    // tokenToOperationMap.put(JavaLexer.RBRACE, new ProcessBrace());
  }

  private void generateTokens(ParseTree root, List<Token> tokens) {
    if (root instanceof TerminalNode) {
      int hierarchy = ((ExtendContext) root.getParent()).hierarchy;
      ExtendToken token = (ExtendToken) (((TerminalNode) root).getSymbol());
      token.setHierarchy(hierarchy);
      for(Token comment : token.comments) {
        ((ExtendToken) comment).setHierarchy(hierarchy);
      }
      if (token.trailingComment) {
        tokens.add(token);
        tokens.addAll(((ExtendToken) token).comments);
      } else {
        tokens.addAll(((ExtendToken) token).comments);
        tokens.add(token);
      }
    } else {
      ExtendContext ctx = (ExtendContext) root;
      ctx.updateHierarchy();
      for(ParseTree child : ctx.children) {
        generateTokens(child, tokens);
      }
    }
  }

  private void generateTree(String filePath) throws IOException {
    ExtendTokenFactory tokenFactory = new ExtendTokenFactory();
    Lexer lexer = new JavaLexer(CharStreams.fromPath(Paths.get(filePath)));
    lexer.setTokenFactory(tokenFactory);
    CommonTokenStream tokenStream = new CommonTokenStream(lexer);
    parser = new JavaParser(tokenStream);
    parser.setTokenFactory(tokenFactory);
    // this.parser.setErrorHandler(new AntlrErrorHandler());
    this.filePath = filePath;
    tree = parser.compilationUnit();
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
    CommonTokenStream tokenStream =  (CommonTokenStream) parser.getTokenStream();
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

}
