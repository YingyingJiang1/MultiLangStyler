package org.example.parser.common;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.parser.java.antlr.JavaLexer;
import org.example.parser.java.antlr.JavaParser;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/30 19:56
 */
public class AntlrHelper {


	public static int getTokenType(String name) {
    return parser.getTokenType(name);
	}

	public static boolean isSingleStmt(int type) {
    return singleStmts.contains(type);
	}

  public static boolean isBraceOptionalBlocks(int rule) {
    return braceOptionalBlocks.contains(rule);
  }

	public static boolean isSemi(ExtendToken token) {
    return token.getType() == JavaParser.SEMI;
	}

  public static boolean isRBrace(Token nextToken) {
    return nextToken.getType() == JavaParser.RBRACE;
  }

  public static boolean ContainStmtRule(int ruleIndex) {
    return containStatementRule.contains(ruleIndex);
  }

  public static boolean isSeparator(int type) {
    return separators.contains(type);
  }

  private static Parser parser = new JavaParser(null);
  private static Map<String, Integer> operatorMap = new HashMap<>();
  private static Set<Integer> separators = new HashSet<>(Arrays.asList(
      JavaParser.COMMA, JavaParser.DOT, JavaParser.LPAREN, JavaParser.RPAREN,
      JavaParser.LBRACK, JavaParser.RBRACK
  ));
  protected static Set<Integer> allStmts = new HashSet<>(Arrays.asList(
      JavaParser.RULE_block,JavaParser.RULE_fieldDeclaration,
      JavaParser.RULE_localVariableDeclarationStmt,JavaParser.RULE_assertStmt,
      JavaParser.RULE_ifStmt,JavaParser.RULE_ifElseStmt, JavaParser.RULE_forStmt,
      JavaParser.RULE_whileStmt, JavaParser.RULE_doWhileStmt,
      JavaParser.RULE_tryCatchStmt,JavaParser.RULE_tryResourceStmt,
      JavaParser.RULE_switchStmt, JavaParser.RULE_syncStmt, JavaParser.RULE_returnStmt,
      JavaParser.RULE_throwStmt, JavaParser.RULE_breakStmt, JavaParser.RULE_continueStmt,
      JavaParser.RULE_yieldStmt,JavaParser.RULE_expressionStmt,JavaParser.RULE_labelStmt
  ));

  protected static Set<Integer> changeHierarchyRule = new HashSet<>(Arrays.asList(
      JavaParser.RULE_block,JavaParser.RULE_body,JavaParser.RULE_arrayInitializer,
      JavaParser.RULE_elementValueArrayInitializer
  ));

  protected static List<Integer> blockStructures;
  // Can not contain block.
  protected static Set<Integer> blockStmts = new HashSet<>(Arrays.asList(
      JavaParser.RULE_ifStmt,JavaParser.RULE_ifElseStmt, JavaParser.RULE_forStmt,
      JavaParser.RULE_switchStmt,
      JavaParser.RULE_whileStmt, JavaParser.RULE_doWhileStmt,JavaParser.RULE_tryCatchStmt,JavaParser.RULE_tryResourceStmt
  ));
  protected static Set<Integer> singleStmts = new HashSet<>(Arrays.asList(
      JavaParser.RULE_fieldDeclaration,
      JavaParser.RULE_localVariableDeclarationStmt,JavaParser.RULE_assertStmt,
      JavaParser.RULE_returnStmt,
      JavaParser.RULE_throwStmt, JavaParser.RULE_breakStmt, JavaParser.RULE_continueStmt,
      JavaParser.RULE_yieldStmt,JavaParser.RULE_expressionStmt,JavaParser.RULE_labelStmt

  ));

  protected static Set<Integer> braceOptionalBlocks = new HashSet<>(Arrays.asList(
      JavaParser.RULE_ifStmt, JavaParser.RULE_ifElseStmt, JavaParser.RULE_forStmt,JavaParser.RULE_whileStmt
  ));
  protected static Set<Integer> containStatementRule = new HashSet<>(Arrays.asList(
      JavaParser.RULE_ifStmt,JavaParser.RULE_ifElseStmt, JavaParser.RULE_forStmt,
      JavaParser.RULE_whileStmt, JavaParser.RULE_doWhileStmt,JavaParser.RULE_labelStmt
  ));

  static {
    blockStructures = Arrays.asList(
        JavaParser.RULE_packageDeclaration,JavaParser.RULE_importDeclarationList,
        JavaParser.RULE_typeDeclarationList, JavaParser.RULE_fieldDeclarationList,
        JavaParser.RULE_constructorDeclarationList, JavaParser.RULE_methodDeclarationList,
        JavaParser.RULE_initializerList,
        JavaParser.RULE_typeDeclaration, JavaParser.RULE_methodDeclaration,
        JavaParser.RULE_constructorDeclaration, JavaParser.RULE_initializer,
        JavaParser.RULE_ifStmt,JavaParser.RULE_ifElseStmt,JavaParser.RULE_switchStmt,
        JavaParser.RULE_forStmt,JavaParser.RULE_doWhileStmt,JavaParser.RULE_whileStmt,
        JavaParser.RULE_syncStmt
    );
    Collections.sort(blockStructures);
    operatorMap.put("()", 0);
    operatorMap.put("!", 3); operatorMap.put("~", 3); operatorMap.put("++", 3);
    operatorMap.put("--", 3); // prefix
    operatorMap.put("*",4); operatorMap.put("/",4); operatorMap.put("%",4);
    operatorMap.put("+",5); operatorMap.put("-",5);
    operatorMap.put("<<",6); operatorMap.put(">>",6);
    operatorMap.put(">>>",6);
    operatorMap.put("instanceof",7);
    operatorMap.put("<",7); operatorMap.put(">",7);
    operatorMap.put("<=",7); operatorMap.put(">=",7);
    operatorMap.put("==",7); operatorMap.put("!=",7);
    operatorMap.put("&",8); operatorMap.put("^",9); operatorMap.put("|",10);
    operatorMap.put("&&",11); operatorMap.put("||",12);
    operatorMap.put("?:",13);
    operatorMap.put("=",14); operatorMap.put("+=", 14); operatorMap.put("-=",14);
    operatorMap.put("*=",14); operatorMap.put("/=",14); operatorMap.put("&=",14);
    operatorMap.put("|=",14); operatorMap.put("^=",14); operatorMap.put("%=",14);
    operatorMap.put("<<=",14); operatorMap.put(">>=",14); operatorMap.put(">>>=",14);
  }

  public static boolean isExpression(ExtendContext ctx) {
    return ctx.getRuleIndex() == JavaParser.RULE_expression;
  }

  public static int getOrTokenType() {
    return parser.getTokenType("OR");
  }

  public static Set<Integer> getAllStmts() {
    return allStmts;
  }


  /**
   *
   * @param typeInt rule index or negative token type.
   * @return
   */
  public static String getTypeName(int typeInt) {
    if (typeInt >= 0) {
      String[] ruleNames = JavaParser.ruleNames;
      return ruleNames[typeInt];
    } else {
      return JavaLexer.VOCABULARY.getSymbolicName(-typeInt);
    }
  }

  public static String getTokenName(int typeInt) {
    return JavaLexer.VOCABULARY.getSymbolicName(typeInt);
  }

  public static String getRuleName(int ruleIndex) {
    return JavaParser.ruleNames[ruleIndex];
  }


  public static boolean isBlockStmt(int type) {
    return blockStmts.contains(type);
  }

  public static boolean isStmt(ParseTree t) {
    if(t instanceof ExtendContext ctx) {
      return allStmts.contains(ctx.getRuleIndex());
    }
    return ((TerminalNode) t).getSymbol().getType() == JavaParser.SEMI;
  }

  public static boolean isOperator(int type) {
    return JavaParser.QUESTION <= type && type <= JavaParser.DEC;
  }

  public static boolean precedenceLowerThan(String op1, String op2) {
    if (operatorMap.get(op1) == null || operatorMap.get(op2) == null) {
      System.err.println("operators are not added:" + op1 + "," + op2);
      return false;
    }
    return operatorMap.get(op1) > operatorMap.get(op2);
  }

  public static boolean isParen(Token token) {
    int type = token.getType();
    return parser.getTokenType("LPAREN") == type || parser.getTokenType("RPAREN") == type;
  }

  public static boolean isOr(Token token) {
    return token.getType() == JavaParser.OR;
  }

  public static boolean isHws(Token token) {
    return token.getType() == JavaLexer.HWS;
  }

  public static boolean isComment(Token token) {
    return token.getType() == JavaLexer.LINE_COMMENT || token.getType() == JavaLexer.BLOCK_COMMENT;
  }

  public static boolean isBlockComment(Token token) {
    return token.getType() == JavaParser.BLOCK_COMMENT;
  }

  public static boolean isBrace(Token token) {
    return token.getType() == JavaLexer.LBRACE || token.getType() == JavaLexer.RBRACE;
  }

  public static boolean isBrace(int type) {
    return type == JavaLexer.LBRACE || type == JavaLexer.RBRACE;
  }

  public static boolean isIdentifier(Token token) {
    return token.getType() == JavaLexer.IDENTIFIER;
  }

  public static boolean isEOF(Token token) {
    return token.getType() == JavaLexer.EOF;
  }

  public static boolean isNegative(int type) {
    return type == -JavaLexer.SUB;
  }

  public static boolean isLeftAngleBracket(int type) {
    return type == -JavaLexer.LT;
  }


  public static boolean isRightAngleBracket(int type) {
    return type == -JavaLexer.GT;
  }

  public static boolean isLineComment(Token token) {
    return token.getType() == JavaLexer.LINE_COMMENT;
  }

  public static boolean isVws(Token token) {
    return token.getType() == JavaLexer.VWS;
  }

  public static boolean isWs(Token token) {
    return token.getType() == JavaLexer.HWS || token.getType() == JavaLexer.VWS;
  }

  public static boolean isBlockStructure(int rule) {
    int index = Collections.binarySearch(blockStructures, rule);
    return index < 0;
  }

  public static boolean isChangeHierarchyRule(int rule) {
    return changeHierarchyRule.contains(rule);
  }

  public static boolean isKeyword(int type) {
    return JavaLexer.BOOLEAN <= type && type <= JavaLexer.NON_SEALED ||
        type == JavaLexer.BOOL_LITERAL || type == JavaLexer.NULL_LITERAL;
  }
  
  public static boolean isLiteral(int type) {
    return JavaLexer.DECIMAL_LITERAL <= type && type <= JavaLexer.NULL_LITERAL;
  }
  
  public static boolean isBinOp(int type) {
    return JavaLexer.QUESTION <= type && type <= JavaLexer.URSHIFT_ASSIGN;
  }

  public static boolean isBinBitOp(int type) {
    return JavaLexer.BITAND <= type && type <= JavaLexer.CARET;
  }

  public static boolean isBinAssignOp(int type) {
    return JavaLexer.ASSIGN <= type && type <= JavaLexer.URSHIFT_ASSIGN;
  }

  public static boolean isBinArithmeticOp(int type) {
    return JavaLexer.ADD <= type && type <= JavaLexer.MOD;
  }

  public static boolean isBinLogicalOp(int type) {
    return JavaLexer.AND <= type && type <= JavaLexer.OR;
  }

  public static boolean isBinCompareOp(int type) {
    return JavaLexer.GT <= type && type <= JavaLexer.NOTEQUAL;
  }

  public static boolean isUnaryOp(int type) {
    return JavaLexer.TILDE <= type && type <= JavaLexer.DEC;
  }

  public static boolean isSub(int type) {
    return type == JavaLexer.SUB;
  }

  public static boolean inDefaultChannel(int channel) {
    return channel == JavaLexer.DEFAULT_TOKEN_CHANNEL;
  }

  public static int maxType() {
    return JavaLexer.VOCABULARY.getMaxTokenType();
  }

  public static int maxRule() {
    return parser.getRuleNames().length;
  }
}
