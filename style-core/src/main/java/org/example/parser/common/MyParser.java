package org.example.parser.common;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.ExtendTokenFactory;
import org.example.parser.common.factory.context.TreeNodeFactory;
import org.example.parser.common.token.AmbigousToken;
import org.example.styler.Stage;
import org.example.styler.Styler;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface MyParser {
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

    Set<String> keywords = Set.of(
            "boolean", "byte", "char", "double", "float", "int", "long", "short", "void",
            "catch", "do", "else", "finally", "for", "if", "switch", "try", "while", "goto",
            "break", "case", "continue", "return", "abstract", "assert", "class", "const", "default",
            "enum", "extends", "final", "implements", "import", "instanceof", "interface", "native",
            "new", "package", "private", "protected", "public", "static", "strictfp", "super", "synchronized",
            "this", "throw", "throws", "transient", "volatile", "module", "open", "requires", "exports",
            "opens", "to", "uses", "provides", "with", "transitive", "var", "yield", "record", "sealed",
            "permits", "non-sealed","false", "true"
    );


    ParseTree parse(Path filePath) throws IOException;
    ParseTree parse(String code, int rule);
    ParseTree parseFromString(String code);
    TokenStream getTokenStream();
    void walkTree(Stage stage, List<Styler> stylers);

    String getLanguage();

    boolean isChangeHierarchy(ParseTree t, ParseTree parent);
    boolean belongToStmt(ParseTree t);
    boolean belongToExpandChildren(ParseTree t);
    boolean belongToMemberList(ParseTree t);
    boolean belongToSingleStmt(ParseTree t);
    boolean belongToCompoundStmt(ParseTree t);
    boolean belongToBraceOptionalStmt(int rule);
    boolean belongToFileHeadDec(int rule);
    boolean belongToVarDeclarationStmt(int ruleIndex);
    boolean belongToMethodHead(int ruleIndex);
    boolean belongToLoop(int ruleIndex);
    boolean belongToParameter(ParseTree t);



    boolean belongToAssignOp(String text);
    boolean belongToCompareOp(String text);
    boolean belongToBinOp(String text);
    boolean belongToUnOp(String name);
    boolean belongToSeparator(String name);
    boolean belongToOperator(String name);
    boolean belongToComment(int type);
    boolean belongToBrace(int type);
    boolean belongToKeyword(Token token);
    boolean belongToIntLiteral(int type);
    boolean belongToFloadLiteral(int type);
    boolean belongToLiteralType(int type);
    boolean belongToLiteral(int type);


    ParseTree createExpression(ParserRuleContext parent, int invokingState);

    boolean isStatement(ParseTree t);
    boolean isInitializer(ParseTree t);
    boolean isFieldDeclaration(ParseTree t);
    boolean isIdentifier(ParseTree t);
    boolean isFieldDeclarationList(ParseTree t);
    boolean isMethodDeclarationList(ParseTree t);
    boolean isConstructorDeclarationList(ParseTree t);
    boolean isInitializerList(ParseTree t);
    boolean isTypeDeclarationList(ParseTree t);
    boolean isBody(ParseTree t);
    boolean isAnnotation(ParseTree t);
    boolean isVws(ParseTree t);
    boolean isBlock(ParseTree t);
    boolean isCatchClause(ParseTree t);
    boolean isTypeDeclaration(ParseTree t);
    boolean isVariableDeclarators(ParseTree t);
    boolean isTypeType(ParseTree tree);
    boolean isReturnStmt(ParseTree t);
    boolean isContinueStmt(ParseTree lastTree);
    boolean isLocalVarDeclaration(ParseTree t);
    boolean isLocalVarDeclarationStmt(ParseTree t);
    boolean isLambdaExpression(ParseTree t);
    boolean isCompilationUnit(ParseTree t);
    boolean isTypeParameter(ParseTree t);
    boolean isLiteral(ParseTree node);
    boolean isVariableDeclaratorId(ParseTree t);
    boolean isVariableInitializer(ParseTree t);
    boolean isFunctionCall(ParseTree t);
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
    int getRuleExpStmt();
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



    int getVws();
    int getHws();
    int getIdentifier();
    int getLE();
    int getGE();
    int getLT();
    int getGT();
    int getEQ();
    int getNEQ();
    int getComma();
    int getSemi();
    int getLineComment();
    int getLBrace();
    int getRBrace();
    int getLParen();
    int getRParen();
    int getBang();
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
    TreeNodeFactory getTreeNodeFactory();
    Set<String> getOperators();
    Set<String> getSeparators();
    Set<String> getBinOps();
    Set<String> getUnaryOps();
    Set<Integer> getAllStmts();
    Set<Integer> getCompoundStmts();
    Set<Integer> getSingleStmts();
    Set<Integer> getDecHeads();
    Set<Integer> getHomoOps(); // All operands have the same type.
    Set<Integer> getCompoundAssign();
    Set<Integer> getLiterals();
    Set<Integer> getMemberLists();
    Set<Integer> getMemberDecs();
    Set<Integer> getArrayInitializerRules();
    Set<Integer> getBraceOptionalStmtRules();

    int getRuleIndex(String ruleName);

    ParseTree getRoot();
    ListenerState getListenerState();

    String getConstKeyword();
    String getSourceFile();
    String getInputCode();


    int getDefaultChannel();
    int getCommentChannel();
    int getHiddenChannel();
    ExtendListener getListener();

}
