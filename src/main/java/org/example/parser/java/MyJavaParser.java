package org.example.parser.java;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.*;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.ExtendTokenFactory;
import org.example.parser.common.token.TokenNameGetter;
import org.example.parser.java.antlr.JavaLexer;
import org.example.parser.java.antlr.JavaParser;
import org.example.myException.CompilationException;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.support.SimpleTriggerContext;

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

    private static Set<Integer> changeHierarchyRule = new HashSet<>(Arrays.asList(
            JavaParser.RULE_block, JavaParser.RULE_body, JavaParser.RULE_arrayInitializer,
            JavaParser.RULE_elementValueArrayInitializer
    ));
    private static Set<Integer> compoundStmts = new HashSet<>(Arrays.asList(
            JavaParser.RULE_ifStmt, JavaParser.RULE_ifElseStmt, JavaParser.RULE_forStmt,
            JavaParser.RULE_switchStmt,
            JavaParser.RULE_whileStmt, JavaParser.RULE_doWhileStmt, JavaParser.RULE_tryCatchStmt, JavaParser.RULE_tryResourceStmt
    ));
    protected static Set<Integer> singleStmts = new HashSet<>(Arrays.asList(
            JavaParser.RULE_fieldDeclaration,
            JavaParser.RULE_localVariableDeclarationStmt,JavaParser.RULE_assertStmt,
            JavaParser.RULE_returnStmt,JavaParser.RULE_syncStmt,
            JavaParser.RULE_throwStmt, JavaParser.RULE_breakStmt, JavaParser.RULE_continueStmt,
            JavaParser.RULE_yieldStmt,JavaParser.RULE_expressionStmt,JavaParser.RULE_labelStmt

    ));
    private static Set<Integer> memberLists = new HashSet<>(Arrays.asList(
            JavaParser.RULE_fieldDeclarationList, JavaParser.RULE_constructorDeclarationList,
            JavaParser.RULE_methodDeclarationList, JavaParser.RULE_typeDeclarationList,
            JavaParser.RULE_initializerList
    ));
    private static Set<Integer> memberDecs = Set.of(
            JavaParser.RULE_fieldDeclaration, JavaParser.RULE_constructorDeclaration,
            JavaParser.RULE_methodDeclaration, JavaParser.RULE_typeDeclaration,
            JavaParser.RULE_initializer
    );
    private static Set<Integer> braceOptionalBlocks = new HashSet<>(Arrays.asList(
            JavaParser.RULE_ifStmt, JavaParser.RULE_ifElseStmt, JavaParser.RULE_forStmt,JavaParser.RULE_whileStmt
    ));
    private static List<Integer> parsingRules = List.of(
            JavaParser.RULE_compilationUnit, JavaParser.RULE_statement
    );

    public MyJavaParser() {}


    public ParseTree parse(String text, int rule) {
        ExtendTokenFactory tokenFactory = new ExtendTokenFactory();
        Lexer lexer = new JavaLexer(CharStreams.fromString(text));
        lexer.setTokenFactory(tokenFactory);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        parser = new JavaParser(tokenStream);
        parser.setTokenFactory(tokenFactory);

        ParseTree t = switch (rule) {
            case JavaParser.RULE_compilationUnit -> parser.compilationUnit();
            case JavaParser.RULE_statement -> parser.statement();
            default -> null;
        };
        return t;
    }

    @Override
    public ParseTree parseFromString(String code) {
        ExtendTokenFactory tokenFactory = new ExtendTokenFactory();
        Lexer lexer = new JavaLexer(CharStreams.fromString(code));
        lexer.setTokenFactory(tokenFactory);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        parser = new JavaParser(tokenStream);
        parser.setTokenFactory(tokenFactory);

        parser.removeErrorListeners();

        tree = tryParse();
        return tree;
    }

    private ParseTree tryParse() {
        ExtendContext root = (ExtendContext) parser.compilationUnit();
        if (parser.getNumberOfSyntaxErrors() > 0 || root.children.isEmpty()) {
            parser.reset();
            root = parser.statement();
            if (parser.getNumberOfSyntaxErrors() > 0 || root.children.isEmpty()) {
                parser.reset();
                root = parser.expression();
            }
        }
        if (parser.getNumberOfSyntaxErrors() > 0) {
            LoggerFactory.getLogger(MyJavaParser.class).error("Failed to parse code from string, " +
                    "this program is only able to parse the expression-level, stmt-level and top-level(RULE_compilationUnit) code.");
            return null;
        }
        return root;
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
        tree = tryParse();
        return tree;
    }

    public boolean isCompilationError() {
        return parser.getNumberOfSyntaxErrors() > 0;
    }

    public TokenStream getTokenStream() {
        return parser.getTokenStream();
    }

    @Override
    public void walkTree(Stage stage, List<Styler> stylers) {
        ExtendJavaParserListener listener = new ExtendJavaParserListener(stage, stylers, this);
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
            // block is included ??
            return singleStmts.contains(ctx.getRuleIndex()) || compoundStmts.contains(ctx.getRuleIndex()) || ctx.getRuleIndex() == JavaParser.RULE_block;
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
    public boolean belongToSingleStmt(ParseTree t) {
        if (t instanceof ExtendContext ctx) {
            return singleStmts.contains(ctx.getRuleIndex());
        }
        return false;
    }

    @Override
    public boolean isStatement(ParseTree t) {
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
    public boolean isBlock(ParseTree t) {
        return t instanceof JavaParser.BlockContext;
    }

    @Override
    public boolean isCatchClause(ParseTree t) {
        return t instanceof JavaParser.CatchClauseContext;
    }

    @Override
    public boolean isTypeDeclaration(ParseTree t) {
        return t instanceof JavaParser.TypeDeclarationContext;
    }

    @Override
    public boolean isClassBodyDeclaration(ParseTree child) {
        return child instanceof JavaParser.ClassBodyDeclarationContext;
    }

    @Override
    public int getRuleExpression() {
        return JavaParser.RULE_expression;
    }

    @Override
    public boolean belongToBraceOptionalStmt(int rule) {
        return braceOptionalBlocks.contains(rule);
    }

    @Override
    public boolean belongToFileHeadDec(int rule) {
        return rule == JavaParser.RULE_importDeclaration || rule == JavaParser.RULE_packageDeclaration;
    }

    @Override
    public ParseTree createExpression(ParserRuleContext parent, int invokingState) {
        return new JavaParser.ExpressionContext(parent, invokingState);
    }

    @Override
    public boolean belongToBinOp(String name) {
        return binOps.contains(name);
    }

    @Override
    public boolean belongToUnOp(String name) {
        return unaryOps.contains(name);
    }

    @Override
    public boolean belongToSeparator(String name) {
        return separators.contains(name);
    }

    @Override
    public boolean belongToOperator(String name) {
        return belongToBinOp(name) || belongToUnOp(name);
    }

    @Override
    public boolean belongToComment(int type) {
        return type == JavaParser.LINE_COMMENT || type == JavaParser.BLOCK_COMMENT;
    }

    @Override
    public boolean belongToBrace(int type) {
        return type == JavaParser.LBRACE || type == JavaParser.RBRACE;
    }

    @Override
    public boolean belongToKeyword(Token token) {
        return token.getType() != JavaParser.IDENTIFIER && token.getText().matches("[a-zA-Z]+");
    }

    @Override
    public int getRuleTypeDeclaration() {
        return JavaParser.RULE_typeDeclaration;
    }

    @Override
    public int getRuleIdentifier() {
        return JavaParser.RULE_identifier;
    }

    @Override
    public int getRuleIfStmt() {
        return JavaParser.RULE_ifStmt;
    }

    @Override
    public int getRuleIfElseStmt() {
        return JavaParser.RULE_ifElseStmt;
    }

    @Override
    public int getRuleBody() {
        return JavaParser.RULE_body;
    }

    @Override
    public int getRuleModifierList() {
        return JavaParser.RULE_modifierList;
    }

    @Override
    public int getRuleTypeType() {
        return JavaParser.RULE_typeType;
    }

    @Override
    public int getRuleSwitchBlockStatementGroup() {
        return JavaParser.RULE_switchBlockStatementGroup;
    }

    @Override
    public int getRuleConstructorDeclaration() {
        return JavaParser.RULE_constructorDeclaration;
    }

    @Override
    public int getRuleMethodDeclaration() {
        return JavaParser.RULE_methodDeclaration;
    }

    @Override
    public int getRuleSyncStmt() {
        return JavaParser.RULE_syncStmt;
    }

    @Override
    public int getRuleInitializer() {
        return JavaParser.RULE_initializer;
    }

    @Override
    public int getRuleArrayInitializer() {
        return JavaParser.RULE_arrayInitializer;
    }

    @Override
    public int getRuleElementValueArrayInitializer() {
        return JavaParser.RULE_elementValueArrayInitializer;
    }

    @Override
    public int getRuleTryCatchStmt() {
        return JavaParser.RULE_tryCatchStmt;
    }

    @Override
    public int getRuleForStmt() {
        return JavaParser.RULE_forStmt;
    }

    @Override
    public int getRuleWhileStmt() {
        return JavaParser.RULE_whileStmt;
    }

    @Override
    public int getRuleDoWhile() {
        return JavaParser.RULE_doWhileStmt;
    }

    @Override
    public int getRuleCompilationUnit() {
        return JavaParser.RULE_compilationUnit;
    }

    @Override
    public int getRuleImportDeclarationList() {
        return JavaParser.RULE_importDeclarationList;
    }

    @Override
    public int getRuleAnnotationList() {
        return JavaParser.RULE_annotationList;
    }

    @Override
    public int getRuleAnnotation() {
        return JavaParser.RULE_annotation;
    }

    @Override
    public boolean belongToFunctionDec(int ruleIndex) {
        return JavaParser.RULE_methodDeclaration == ruleIndex || JavaParser.RULE_constructorDeclaration == ruleIndex;
    }

    @Override
    public int getRuleStmt() {
        return JavaParser.RULE_statement;
    }

    @Override
    public int getRuleExpStmt() {
        return JavaParser.RULE_expressionStmt;
    }

    @Override
    public int getRuleExpressionList() {
        return JavaParser.RULE_expressionList;
    }

    @Override
    public int getLE() {
        return JavaParser.LE;
    }

    @Override
    public int getGE() {
        return JavaParser.GE;
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
    public int getEQ() {
        return JavaParser.EQUAL;
    }

    @Override
    public int getNEQ() {
        return JavaParser.NOTEQUAL;
    }

    @Override
    public int getComma() {
        return JavaParser.COMMA;
    }

    @Override
    public int getSemi() {
        return JavaParser.SEMI;
    }

    @Override
    public int getLineComment() {
        return JavaParser.LINE_COMMENT;
    }

    @Override
    public int getLBrace() {
        return JavaParser.LBRACE;
    }

    @Override
    public int getRBrace() {
        return JavaParser.RBRACE;
    }

    @Override
    public int getRuleBlock() {
        return JavaParser.RULE_block;
    }

    @Override
    public int getLParen() {
        return JavaParser.LPAREN;
    }

    @Override
    public int getRParen() {
        return JavaParser.RPAREN;
    }

    @Override
    public int getBang() {
        return JavaParser.BANG;
    }

    @Override
    public int getBlockComment() {
        return JavaParser.BLOCK_COMMENT;
    }

    @Override
    public int getSub() {
        return JavaParser.SUB;
    }

    @Override
    public int getEOF() {
        return JavaParser.EOF;
    }

    @Override
    public int getType(String text) {
        if (text == null) {
            return Integer.MIN_VALUE;
        }
        return text.startsWith("RULE") ?
                new JavaParser(null).getRuleIndex(text) :
                new JavaParser(null).getTokenType(TokenNameGetter.getInstance().getName(text));
    }


    @Override
    public String getTokenName(int type) {
        return JavaLexer.VOCABULARY.getSymbolicName(type);
    }

    @Override
    public String getRuleName(int type) {
        String[] ruleNames = JavaParser.ruleNames;
        return ruleNames[type];
    }

    @Override
    public TokenFactory getTokenFactory() {
        return parser.getTokenFactory();
    }

    @Override
    public Set<String> getOperators() {
        Set<String> operators = new HashSet<>();
        operators.addAll(binOps);
        operators.addAll(unaryOps);
        return operators;
    }

    @Override
    public Set<String> getSeparators() {
        return separators;
    }

    @Override
    public Set<String> getBinOps() {
        return binOps;
    }

    @Override
    public Set<String> getUnaryOps() {
        return unaryOps;
    }

    @Override
    public Set<Integer> getAllStmts() {
        Set<Integer> allStmts = new HashSet<>();
        allStmts.addAll(singleStmts);
        allStmts.addAll(compoundStmts);
        allStmts.add(JavaParser.RULE_block);
        return allStmts;
    }

    @Override
    public Set<Integer> getCompoundStmts() {
        return compoundStmts;
    }

    @Override
    public Set<Integer> getSingleStmts() {
        return singleStmts;
    }

    @Override
    public Set<Integer> getDecHeads() {
        return new HashSet<>(List.of(
                JavaParser.RULE_classHead, JavaParser.RULE_enumHead, JavaParser.RULE_interfaceHead,
                JavaParser.RULE_recordHead, JavaParser.RULE_constructorHead, JavaParser.RULE_methodHead
        ));
    }

    @Override
    public Set<Integer> getHomoOps() {
        return Set.of(
                JavaParser.ADD, JavaParser.SUB, JavaParser.MUL, JavaParser.DIV, JavaParser.MOD,
                JavaParser.BITAND, JavaParser.BITOR, JavaParser.CARET
        );
    }

    @Override
    public Set<Integer> getOpAssign() {
        return Set.of(
                JavaParser.ADD_ASSIGN, JavaParser.SUB_ASSIGN, JavaParser.MUL_ASSIGN, JavaParser.DIV_ASSIGN, JavaParser.MOD_ASSIGN,
                JavaParser.AND_ASSIGN, JavaParser.OR_ASSIGN, JavaParser.XOR_ASSIGN
        );
    }

    @Override
    public Set<Integer> getLiterals() {
        return Set.of(
                JavaParser.NULL_LITERAL, JavaParser.BINARY_LITERAL, JavaParser.BOOL_LITERAL,
                JavaParser.CHAR_LITERAL, JavaParser.DECIMAL_LITERAL, JavaParser.HEX_LITERAL,
                JavaParser.OCT_LITERAL, JavaParser.FLOAT_LITERAL, JavaParser.HEX_FLOAT_LITERAL
        );
    }

    @Override
    public Set<Integer> getMemberLists() {
        return memberLists;
    }

    @Override
    public Set<Integer> getMemberDecs() {
        return memberDecs;
    }

    @Override
    public int getRuleIndex(String ruleName) {
        return parser.getRuleIndex(ruleName);
    }

    @Override
    public ParseTree getTree() {
        return tree;
    }

    @Override
    public Set<Integer> getArrayInitializerRules() {
        return Set.of(JavaParser.RULE_initializer, JavaParser.RULE_arrayInitializer, JavaParser.RULE_elementValueArrayInitializer);
    }

    @Override
    public int getVws() {
        return JavaParser.VWS;
    }

    @Override
    public int getHws() {
        return JavaParser.HWS;
    }

    @Override
    public int getIdentifier() {
        return JavaParser.IDENTIFIER;
    }

}
