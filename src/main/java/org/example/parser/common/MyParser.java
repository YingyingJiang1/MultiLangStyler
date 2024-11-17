package org.example.parser.common;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.java.antlr.JavaParser;
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

    boolean isStmt(ParseTree t);
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

    boolean isBinOp(String name);
    boolean isUnOp(String name);
    boolean isSeparator(String name);
    boolean isOperator(String name);


    int getVws();
    int getHws();
    int getTypeDeclaration();
    int getIdentifier();
    int getFieldDeclarationList();
    int getMethodDeclarationList();
    int getConstructorDeclarationList();
    int getInitializerList();
    int getTypeDeclarationList();
    int getBody();
    int getModifierList();
    int getLT();
    int getGT();
    int getComma();
    List<String> getOperators();
    List<String> getSeparators();
}
