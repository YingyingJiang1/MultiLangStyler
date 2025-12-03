package org.example.lang.intf;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.common.factory.ExtendTokenFactory;
import org.example.antlr.common.token.AmbigousToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface MyParser {
    Logger logger = LoggerFactory.getLogger(MyParser.class);

    Set<String> assignOps = new HashSet<>(Arrays.asList(
            "=", "+=", "-=", "*=", "/=", "&=", "|=", "^=", "%=", "<<=", ">>=", ">>>="
    ));
    Set<String> compareOps = new HashSet<>(Arrays.asList(
            "==", "!=", "<", ">", "<=", ">="
    ));
    Set<String> binOps = new HashSet<>(Arrays.asList(
            "+", "-", "*", "/",  "%", "&", "|", "^", "=", "+=", "-=", "*=", "/=", "&=", "|=", "^=", "%=",
            "<<=", ">>=", ">>>=", "<", ">", "<=", ">=", "==", "!=", ":", "::", ".", "->",
            "&&", "||", "instanceof"
    ));

    Set<String> unaryOps = new HashSet<>(Arrays.asList(
            "~", "!", "++", "--", "?", AmbigousToken.NEGATIVE.name()
    ));

    Set<String> separators = new HashSet<>(Arrays.asList(
            ",",  "(", ")", "{", "}", "[", "]", ";", AmbigousToken.LEFT_ANGLE_BRACKET.name(), AmbigousToken.RIGHT_ANGLE_BRACKET.name()
    ));


    ParseTree parse(Path filePath) throws IOException;
    ParseTree parse(String code, int rule);
    ParseTree parseFromString(String code);
    TokenStream getTokenStream();

    String getLanguage();

    boolean belongToStmt(ParseTree t);
    boolean belongToMemberList(ParseTree t);
    boolean belongToSimpleStmt(ParseTree t);
    boolean belongToCompoundStmt(ParseTree t);
    boolean belongToFileHeadDec(int rule);
    boolean belongToMethodHead(int ruleIndex);
    boolean belongToLoop(int ruleIndex);

    boolean belongToAssignOp(String text);
    boolean belongToCompareOp(String text);
    boolean belongToBinOp(String text);
    boolean belongToUnOp(String name);
    boolean belongToOperator(String name);
    boolean isComment(int type);
    boolean isKeyword(Token token);
    boolean belongToIntLiteral(int type);
    boolean belongToFloatLiteral(int type);
    boolean belongToStringLiteral(int type);
    boolean belongToLiteral(int type);

    /********************************************************** 节点类型判断  **********************************************************/
    boolean isStatement(ParseTree t);
    boolean isInitializer(ParseTree t);
    boolean isFieldDeclaration(ParseTree t);
    boolean isIdentifier(ParseTree t);
    boolean isFieldDeclarationList(ParseTree t);
    boolean isMethodDeclarationList(ParseTree t);
    boolean isConstructorDeclarationList(ParseTree t);
    boolean isInitializerList(ParseTree t);
    boolean isTypeDeclarationList(ParseTree t);

    /**
     * @return {@code true} if the node is the body of a function or a type declaration; {@code false} otherwise
     */
    boolean isBody(ParseTree t);
    boolean isAnnotation(ParseTree t);
    boolean isBlock(ParseTree t);
    boolean isTypeDeclaration(ParseTree t);
    boolean isTypeType(ParseTree tree);
    boolean isContinueStmt(ParseTree lastTree);
    boolean isLocalVarDeclaration(ParseTree t);
    boolean isLocalVarDeclarationStmt(ParseTree t);
    boolean isLambdaExpression(ParseTree t);
    boolean isTypeParameter(ParseTree t);
    boolean isLiteral(ParseTree node);
    boolean isVariableDeclaratorId(ParseTree t);
    boolean isVariableInitializer(ParseTree t);
    boolean isLambdaLVTIParameter(ParseTree t);
    boolean isLambdaParameters(ParseTree t);
    boolean isExpression(ParseTree t);
    boolean isPrimitiveType(ParseTree t);
    boolean isReferenceType(ParseTree t);


    int getRuleBlock();
    int getRuleExpression();
    int getRuleIdentifier();
    int getRuleIfStmt();
    int getRuleIfElseStmt();
    int getRuleTypeDeclaration();
    int getRuleBody();
    int getRuleModifierList();
    int getRuleTypeType();
    int getRuleSwitchBlockStatementGroup();
    int getRuleConstructorDeclaration();
    int getRuleMethodDeclaration();
    int getRuleSyncStmt();
    int getRuleInitializer();
    int getRuleArrayInitializer();
    int getRuleCatchClause();
    int getRuleFinallyBlock();
    int getRuleElementValueArrayInitializer();
    int getRuleTryCatchStmt();
    int getRuleForStmt();
    int getRuleWhileStmt();
    int getRuleDoWhileStmt();
    int getRuleCompilationUnit();
    int getRuleImportDeclarationList();
    int getRuleAnnotationList();
    boolean belongToMethodDec(int ruleIndex);
    int getRuleStmt();
    int getRuleExpressionList();
    int getRuleFieldDeclarationList();
    int getRuleLiteral();
    int getRuleVariableDeclarators();
    int getRuleVariableDeclarator();
    int getRuleParExpression();
    int getRuleformalParameterList();
    int getRuleFormalParameter();
    int getRuleSwitchStmt();
    int getRuleTypeParameters();
    int getRuleLocalVarDeclaration();
    int getRuleFieldDeclaration();

    int getRuleImportDeclaration();
    int getRulePackageDeclaration();
    int getRuleQualifiedName();
    int getRuleTypeList();
    ExtendContext getSpecificStmt(ExtendContext stmt);
    int getSpecificStmtType(ExtendContext ctx);
    int getRuleContinueStmt();

    int getRuleBreakStmt();

    int getRuleArguments();
    int getRuleReturnStmt();
    int getRuleExpressionStmt();
    int getRuleLocalVarDeclarationStmt();
    int getRuleIntegerLiteral();
    int getRuleFloatLiteral();
    int getRuleCharLiteral();
    int getRuleStringLiteral();
    int getRuleBoolLiteral();
    int getRuleTextBlockLiteral();
    int getRuleThrowStmt();

    /**
     * Return the token type of newline.
     */
    int getVws();

    /**
     * Return the token type of horizontal whitespace.
     */
    int getHws();

    int getIdentifier();
    int getLE();
    int getGE();
    int getLT();
    int getGT();
    int getComma();
    int getSemi();

    /**
     * Return the token type of line comment.
     */
    int getLineComment();
    int getLBrace();
    int getRBrace();
    int getLParen();
    int getRParen();
    int getBang();

    /**
     * Return the token type of block comment.
     */
    int getBlockComment();

    int getSub();
    int getEOF();
    int getMul();
    int getRBrack();
    int getVar();

    int getCharLiteralType();
    int getType(String text);

    String getTokenName(int type);
    String getRuleName(int type);

    ExtendTokenFactory getTokenFactory();
    Set<String> getOperators();
    Set<String> getBinOps();
    Set<String> getUnaryOps();
    Set<Integer> getCompoundStmts();
    Set<Integer> getSingleStmts();
    Set<Integer> getHomoOps(); // All operands have the same type.
    Set<Integer> getCompoundAssign();
    Set<Integer> getLiterals();
    Set<Integer> getMemberLists();
    Set<Integer> getArrayInitializerRules();

    int getRuleIndex(String ruleName);

    ParseTree getRoot();

    String getConstKeyword();
    String getSourceFile();
    String getInputCode();


    int getDefaultChannel();

	void updateRoot(List<ParseTree> newTrees);

    boolean isLiteral(int tokenType);
}
