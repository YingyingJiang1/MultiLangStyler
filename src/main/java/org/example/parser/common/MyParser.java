package org.example.parser.common;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenFactory;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.styler.Stage;
import org.example.styler.Styler;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface MyParser {
    Set<String> binOps = new HashSet<>(Arrays.asList(
            "+", "-", "*", "/",  "%", "&", "|", "^", "=", "+=", "-=", "*=", "/=", "&=", "|=", "^=", "%=",
            "<<=", ">>=", ">>>=", "<", ">", "<=", ">=", "==", "!=", ":", "::", ".", "->"
    ));

    Set<String> unaryOps = new HashSet<>(Arrays.asList(
            "~", "!", "++", "--", "?", "#neg-"
    ));

    Set<String> separators = new HashSet<>(Arrays.asList(
            ",",  "(", ")", "{", "}", "[", "]", ";", "#sep<", "#sep>"
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
    TokenStream getTokenStream();
    void walkTree(Stage stage, List<Styler> stylers);

    boolean isChangeHierarchy(ParseTree t, ParseTree parent);
    boolean belongToStmt(ParseTree t);
    boolean belongToExpandChildren(ParseTree t);
    boolean belongToMemberList(ParseTree t);
    boolean belongToSingleStmt(ParseTree t);
    boolean belongToBraceOptionalStmt(int rule);
    boolean belongToFileHeadDec(int rule);


    boolean belongToBinOp(String name);
    boolean belongToUnOp(String name);
    boolean belongToSeparator(String name);
    boolean belongToOperator(String name);
    boolean belongToComment(int type);
    boolean belongToBrace(int type);
    boolean belongToKeyword(Token token);

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
    boolean isTopUnit(ParseTree t);
    boolean isBody(ParseTree t);
    boolean isAnnotation(ParseTree t);
    boolean isVws(ParseTree t);
    boolean isBlock(ParseTree t);
    boolean isCatchClause(ParseTree t);
    boolean isTypeDeclaration(ParseTree t);

    int getRuleBlock();
    int getRuleExpression();
    int getRuleIdentifier();
    int getRuleIfStmt();
    int getRuleIfElseStmt();
    int getRuleTypeDeclaration();
    int getRuleFieldDeclarationList();
    int getRuleMethodDeclarationList();
    int getRuleConstructorDeclarationList();
    int getRuleInitializerList();
    int getRuleTypeDeclarationList();
    int getRuleBody();
    int getRuleModifierList();
    int getRuleTypeType();
    int getRuleSwitchBlockStatementGroup();
    int getRuleConstructorDeclaration();
    int getRuleMethodDeclaration();
    int getRuleSyncStmt();
    int getRuleInitializer();
    int getRuleArrayInitializer();
    int getRuleElementValueArrayInitializer();
    int getRuleTryCatchStmt();
    int getRuleForStmt();
    int getRuleWhileStmt();



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

    int getType(String text);

    String getTokenName(int type);
    String getRuleName(int type);

    TokenFactory getTokenFactory();

    Set<String> getOperators();
    Set<String> getSeparators();
    Set<String> getBinOps();
    Set<String> getUnaryOps();
    Set<Integer> getAllStmts();
    Set<Integer> getCompoundStmts();
    Set<Integer> getSingleStmts();
    Set<Integer> getDecHeads();
    Set<Integer> getHomoOps(); // All operands have the same type.
    Set<Integer> getOpAssign();
    Set<Integer> getLiterals();
    Set<Integer> getMemberLists();
    Set<Integer> getMemberDecs();

    int getRuleIndex(String ruleName);


}
