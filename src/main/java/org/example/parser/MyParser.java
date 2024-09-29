package org.example.parser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.example.antlr.JavaLexer;
import org.example.antlr.JavaParser;
import org.example.myException.CompilationException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/5 22:08
 */
public class MyParser {

	JavaParser parser;

  public MyParser(Path path) throws IOException {
    ExtendTokenFactory tokenFactory = new ExtendTokenFactory();
    Lexer lexer = new JavaLexer(CharStreams.fromPath(path));
    lexer.setTokenFactory(tokenFactory);
    CommonTokenStream tokenStream = new CommonTokenStream(lexer);
    parser = new JavaParser(tokenStream);
    parser.setTokenFactory(tokenFactory);
  }

  public MyParser(String text) {
    ExtendTokenFactory tokenFactory = new ExtendTokenFactory();
    Lexer lexer = new JavaLexer(CharStreams.fromString(text));
    lexer.setTokenFactory(tokenFactory);
    CommonTokenStream tokenStream = new CommonTokenStream(lexer);
    parser = new JavaParser(tokenStream);
    parser.setTokenFactory(tokenFactory);
  }

  public List<ParseTree> parse(int rule, boolean flag) {
    if(flag) {
      rule = JavaParser.RULE_block;
    }
    ParseTree t = switch (rule) {
      case JavaParser.RULE_compilationUnit -> parser.compilationUnit();
      case JavaParser.RULE_expressionStmt -> parser.expressionStmt();
      case JavaParser.RULE_ifStmt -> parser.ifStmt();
      case JavaParser.RULE_ifElseStmt -> parser.ifElseStmt();
      case JavaParser.RULE_forStmt -> parser.forStmt();
      case JavaParser.RULE_whileStmt -> parser.whileStmt();
      case JavaParser.RULE_returnStmt -> parser.returnStmt();
      case JavaParser.RULE_block -> parser.block();
      case JavaParser.RULE_expression -> parser.expression();
      case JavaParser.RULE_localVariableDeclarationStmt -> parser.localVariableDeclarationStmt();
      default -> null;
    };
    if (parser.getNumberOfSyntaxErrors() > 0) {
      throw new CompilationException("Code:" + parser.getInputStream().getText());
    }
    if(t == null) {
      throw new CompilationException("No rules are added for code.");
    }
    ParseTreeWalker walker = new MyParseTreeWalker();
    ParseTreeListener listener = new ExtendParserListener();
    List<ParseTree> ret = new ArrayList<>();
    if(flag) {
      // t is block context.
      ((ExtendContext) t).deleteStatementCtx();
      ret = ((ExtendContext) t).children.subList(1, t.getChildCount() - 1);
      walker.walk(listener, ret.get(0));
    } else {
      walker.walk(listener, t);
      ret.add(t);
    }
    return ret;
  }

  public ParseTree parse() throws IOException {
    return parser.compilationUnit();
  }

  public boolean isCompilationError() {
    return parser.getNumberOfSyntaxErrors() > 0;
  }

  public List<Token> getTokens() {
    return ((CommonTokenStream)parser.getTokenStream()).getTokens();
  }
}
