package org.example.parser.common;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.styler.Styler;

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

    ParseTree parse(Path filePath) throws IOException;
    TokenStream getTokenStream();
    void walkTree(int state, List<Styler> enterStylers, List<Styler> exitStylers);

    boolean isChangeHierarchy(ParseTree t, ParseTree parent);
    boolean belongToStmt(ParseTree t);
    boolean belongToExpandChildren(ParseTree t);
    boolean belongToMemberList(ParseTree t);
    boolean belongToSingleStmt(ParseTree t);
    boolean belongToBraceOptionalStmt(int rule);

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




    boolean isBinOp(String name);
    boolean isUnOp(String name);
    boolean isSeparator(String name);
    boolean isOperator(String name);

    boolean isComment(int type);
    boolean isBrace(int type);


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
    int getType(String text);
    int getBlockComment();

    Set<String> getOperators();
    Set<String> getSeparators();
    Set<Integer> getAllStmts();
    Set<Integer> getCompoundStmts();

}
