package org.example.parser.java;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.*;
import org.example.parser.java.antlr.JavaLexer;
import org.example.parser.java.antlr.JavaParser;
import org.example.myException.CompilationException;
import org.example.styler.Styler;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/5 22:08
 */
public class MyJavaParser implements MyParser {

    JavaParser parser = null;
    Path curFile = null;
    ParseTree tree = null;

    // 单例模式
    private static MyJavaParser instance = new MyJavaParser();

    private static Set<Integer> changeHierarchyRule = new HashSet<>(Arrays.asList(
            JavaParser.RULE_block, JavaParser.RULE_body, JavaParser.RULE_arrayInitializer,
            JavaParser.RULE_elementValueArrayInitializer
    ));
    private static Set<Integer> compoundStmts = new HashSet<>(Arrays.asList(
            JavaParser.RULE_ifStmt, JavaParser.RULE_ifElseStmt, JavaParser.RULE_forStmt,
            JavaParser.RULE_switchStmt,
            JavaParser.RULE_whileStmt, JavaParser.RULE_doWhileStmt, JavaParser.RULE_tryCatchStmt, JavaParser.RULE_tryResourceStmt
    ));
    private static Set<Integer> allStmts = new HashSet<>(Arrays.asList(
            JavaParser.RULE_block, JavaParser.RULE_fieldDeclaration,
            JavaParser.RULE_localVariableDeclarationStmt, JavaParser.RULE_assertStmt,
            JavaParser.RULE_ifStmt, JavaParser.RULE_ifElseStmt, JavaParser.RULE_forStmt,
            JavaParser.RULE_whileStmt, JavaParser.RULE_doWhileStmt,
            JavaParser.RULE_tryCatchStmt, JavaParser.RULE_tryResourceStmt,
            JavaParser.RULE_switchStmt, JavaParser.RULE_syncStmt, JavaParser.RULE_returnStmt,
            JavaParser.RULE_throwStmt, JavaParser.RULE_breakStmt, JavaParser.RULE_continueStmt,
            JavaParser.RULE_yieldStmt, JavaParser.RULE_expressionStmt, JavaParser.RULE_labelStmt
    ));
    private static Set<Integer> memberLists = new HashSet<>(Arrays.asList(
            JavaParser.RULE_fieldDeclarationList, JavaParser.RULE_constructorDeclarationList,
            JavaParser.RULE_methodDeclarationList, JavaParser.RULE_typeDeclarationList,
            JavaParser.RULE_initializerList
    ));


    private MyJavaParser() {}

    public static MyJavaParser getInstance() {
        return instance;
    }


    public MyJavaParser(String text) {
        ExtendTokenFactory tokenFactory = new ExtendTokenFactory();
        Lexer lexer = new JavaLexer(CharStreams.fromString(text));
        lexer.setTokenFactory(tokenFactory);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        parser = new JavaParser(tokenStream);
        parser.setTokenFactory(tokenFactory);
    }

    public List<ParseTree> parse(int rule, boolean flag) {
        if (flag) {
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
        if (t == null) {
            throw new CompilationException("No rules are added for code.");
        }
        ParseTreeWalker walker = new MyParseTreeWalker();
        ParseTreeListener listener = new ExtendJavaParserListener(this);
        List<ParseTree> ret = new ArrayList<>();
        if (flag) {
            // t is block context.
            ((ExtendContext) t).deleteStatementCtx(this);
            ret = ((ExtendContext) t).children.subList(1, t.getChildCount() - 1);
            walker.walk(listener, ret.get(0));
        } else {
            walker.walk(listener, t);
            ret.add(t);
        }
        return ret;
    }

    public ParseTree parse(Path filePath) throws IOException {
        curFile = filePath;
        ExtendTokenFactory tokenFactory = new ExtendTokenFactory();
        Lexer lexer = new JavaLexer(CharStreams.fromPath(filePath));
        lexer.setTokenFactory(tokenFactory);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        parser = new JavaParser(tokenStream);
        parser.setTokenFactory(tokenFactory);
        // this.parser.setErrorHandler(new AntlrErrorHandler());
        tree = parser.compilationUnit();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            tree = null;
        }
        return tree;
    }

    public boolean isCompilationError() {
        return parser.getNumberOfSyntaxErrors() > 0;
    }

    public TokenStream getTokenStream() {
        return parser.getTokenStream();
    }

    @Override
    public void walkTree(int state, List<Styler> enterStylers, List<Styler> exitStylers) {
        ExtendJavaParserListener listener = new ExtendJavaParserListener(state, enterStylers, exitStylers, this);
        ParseTreeWalker walker = new MyParseTreeWalker();
        walker.walk(listener, tree);
    }


    @Override
    public boolean isChangeHierarchy(ParseTree t, ParseTree parent) {
        if (t instanceof ExtendContext ctx && parent instanceof ExtendContext parentCtx) {
            int rule = ctx.getRuleIndex(), parentRule = parentCtx.getRuleIndex();
            return changeHierarchyRule.contains(parentRule) ||
                    parentRule == JavaParser.RULE_switchBlockStatementGroup && rule != JavaParser.RULE_switchLabel ||
                    compoundStmts.contains(parentRule) && belongToStmt(t) && rule != JavaParser.RULE_block;
        }
        return false;
    }

    @Override
    public boolean belongToStmt(ParseTree t) {
        if (t instanceof ExtendContext ctx) {
            return allStmts.contains(ctx.getRuleIndex());
        }
        return ((TerminalNode) t).getSymbol().getType() == JavaParser.SEMI;
    }

    @Override
    public boolean belongToExpandChildren(ParseTree t) {
        return !(t instanceof JavaParser.AnnotationContext || t instanceof JavaParser.AnnotationListContext);
    }

    @Override
    public boolean belongToMemberList(ParseTree t) {
        if (t instanceof ExtendContext ctx) {
            return memberLists.contains(ctx.getRuleIndex());
        }
        return false;
    }

    @Override
    public boolean isStmt(ParseTree t) {
        return t instanceof JavaParser.StatementContext;
    }

    @Override
    public boolean isInitializer(ParseTree t) {
        return t instanceof JavaParser.InitializerContext;
    }

    @Override
    public boolean isFieldDeclaration(ParseTree t) {
        return t instanceof JavaParser.FieldDeclarationContext;
    }

    @Override
    public boolean isIdentifier(ParseTree t) {
        return t instanceof JavaParser.IdentifierContext;
    }

    @Override
    public boolean isFieldDeclarationList(ParseTree t) {
        return t instanceof JavaParser.FieldDeclarationListContext;
    }

    @Override
    public boolean isMethodDeclarationList(ParseTree t) {
        return t instanceof JavaParser.MethodDeclarationListContext;
    }

    @Override
    public boolean isConstructorDeclarationList(ParseTree t) {
        return t instanceof JavaParser.ConstructorDeclarationListContext;
    }

    @Override
    public boolean isInitializerList(ParseTree t) {
        return t instanceof JavaParser.InitializerListContext;
    }

    @Override
    public boolean isTypeDeclarationList(ParseTree t) {
        return t instanceof JavaParser.TypeDeclarationListContext;
    }

    @Override
    public boolean isTopUnit(ParseTree t) {
        return t instanceof JavaParser.CompilationUnitContext;
    }

    @Override
    public boolean isBody(ParseTree t) {
        return t instanceof JavaParser.BodyContext;
    }

    @Override
    public boolean isAnnotation(ParseTree t) {
        return t instanceof JavaParser.AnnotationContext;
    }

    @Override
    public boolean isVws(ParseTree t) {
        return t  instanceof TerminalNode terminalNode && terminalNode.getSymbol().getType() == JavaParser.VWS;
    }

    @Override
    public boolean isBinOp(String name) {
        return binOps.contains(name);
    }

    @Override
    public boolean isUnOp(String name) {
        return unaryOps.contains(name);
    }

//    @Override
//    public boolean isKeyword(int type) {
//        return JavaLexer.BOOLEAN <= type && type <= JavaLexer.NON_SEALED ||
//                type == JavaLexer.BOOL_LITERAL || type == JavaLexer.NULL_LITERAL;
//    }

    @Override
    public int getTypeDeclaration() {
        return JavaParser.RULE_typeDeclaration;
    }

    @Override
    public int getIdentifier() {
        return JavaParser.RULE_identifier;
    }

    @Override
    public int getFieldDeclarationList() {
        return JavaParser.RULE_fieldDeclarationList;
    }

    @Override
    public int getMethodDeclarationList() {
        return JavaParser.RULE_methodDeclarationList;
    }

    @Override
    public int getConstructorDeclarationList() {
        return JavaParser.RULE_constructorDeclarationList;
    }

    @Override
    public int getInitializerList() {
        return JavaParser.RULE_initializerList;
    }

    @Override
    public int getTypeDeclarationList() {
        return JavaParser.RULE_typeDeclarationList;
    }

    @Override
    public int getBody() {
        return JavaParser.RULE_body;
    }

    @Override
    public int getModifierList() {
        return JavaParser.RULE_modifierList;
    }

    @Override
    public int getLT() {
        return JavaParser.LT;
    }

    @Override
    public int getGT() {
        return JavaParser.GT;
    }

    @Override
    public int getComma() {
        return JavaParser.COMMA;
    }

    @Override
    public List<String> getOperators() {
        List<String> operators = new ArrayList<String>(binOps);
        operators.addAll(unaryOps);
        return operators.stream().toList();
    }

    @Override
    public List<String> getSeparators() {
        return separators.stream().toList();
    }

    @Override
    public int getVws() {
        return JavaParser.VWS;
    }

    @Override
    public int getHws() {
        return JavaParser.HWS;
    }
}
