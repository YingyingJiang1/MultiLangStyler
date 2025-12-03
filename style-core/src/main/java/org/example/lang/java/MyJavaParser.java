package org.example.lang.java;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.lang.intf.MyParser;
import org.example.controller.TokenAugmentor;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.common.factory.ExtendTokenFactory;
import org.example.antlr.common.token.ExtendToken;
import org.example.antlr.common.token.TokenNameGetter;
import org.example.antlr.java.JavaLexer;
import org.example.antlr.java.JavaParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Predicate;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/5 22:08
 */
public class MyJavaParser implements MyParser {
    JavaParser parser = null;
    Path curFile = null;
    ParseTree root = null;

    private static Set<Integer> compoundStmts = new HashSet<>(Arrays.asList(
            JavaParser.RULE_ifStmt, JavaParser.RULE_ifElseStmt, JavaParser.RULE_forStmt,
            JavaParser.RULE_switchStmt,
            JavaParser.RULE_whileStmt, JavaParser.RULE_doWhileStmt, JavaParser.RULE_tryCatchStmt, JavaParser.RULE_tryResourceStmt
    ));
    protected static Set<Integer> simpleStmts = new HashSet<>(Arrays.asList(
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
    private static Set<Integer> literals = Set.of(
            JavaParser.NULL_LITERAL, JavaParser.BINARY_LITERAL, JavaParser.BOOL_LITERAL,
            JavaParser.CHAR_LITERAL, JavaParser.DECIMAL_LITERAL, JavaParser.HEX_LITERAL,
            JavaParser.OCT_LITERAL, JavaParser.FLOAT_LITERAL, JavaParser.HEX_FLOAT_LITERAL,
            JavaParser.STRING_LITERAL, JavaParser.TEXT_BLOCK
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
            case JavaParser.RULE_importDeclarationList -> parser.importDeclarationList();
            default -> null;
        };

        TokenAugmentor.addContextTokens(this);
        // 统一换行符
        ((CommonTokenStream) parser.getTokenStream()).getTokens().forEach(e -> {
            if (e.getType() == JavaParser.VWS || e.getType() == JavaParser.BLOCK_COMMENT || e.getType() == JavaParser.LINE_COMMENT) {
                ((ExtendToken) e).setText(e.getText().replace("\r\n", "\n"));
            }
        });
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

        root = tryParse();
        return root;
    }

    /**
     * Alternative implementation: modify the rule in JavaParser.g4，Add more productions to the compilationUnit rule.
     * But must be careful when return the root, root should be the child of compilationUnit node if the production used is new added.
     */
    private ParseTree tryParse() {
        Predicate<ExtendContext> parseFailTester = new Predicate<ExtendContext>() {
            @Override
            public boolean test(ExtendContext root) {
                return parser.getNumberOfSyntaxErrors() > 0 || root.children.isEmpty();
            }
        };

        ExtendContext root = (ExtendContext) parser.compilationUnit();
        if (parseFailTester.test(root)) {
            parser.reset();
            root = parser.typeDeclaration();
            if (parseFailTester.test(root)) {
                parser.reset();
                root = parser.methodDeclaration();
                if (parseFailTester.test(root)) {
                    parser.reset();
                    root = parser.constructorDeclaration();
                    if (parseFailTester.test(root)) {
                        parser.reset();
                        root = parser.statement();
                        if (parseFailTester.test(root)) {
                            parser.reset();
                            root = parser.expression();
                        }
                    }
                }
            }
        }
        if (parser.getNumberOfSyntaxErrors() > 0) {
            logger.error("Failed to parse code, " +
                    "this program is only able to parse the top-level(RULE_compilationUnit), typeDeclaration-level, method-level, stmt-level,expression-level code.");
            return null;
        }


        TokenAugmentor.addContextTokens(this);
        // 统一换行符
        ((CommonTokenStream) parser.getTokenStream()).getTokens().forEach(t -> {
            if (t.getType() == JavaParser.VWS || t.getType() == JavaParser.BLOCK_COMMENT || t.getType() == JavaParser.LINE_COMMENT) {
                ((ExtendToken) t).setText(t.getText().replace("\r\n", "\n"));
            }
        });
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
//        parser.removeErrorListeners();
        root = tryParse();


        return root;
    }

    public boolean isCompilationError() {
        return parser.getNumberOfSyntaxErrors() > 0;
    }

    public TokenStream getTokenStream() {
        return parser.getTokenStream();
    }


    @Override
    public String getLanguage() {
        return "java";
    }


    @Override
    public boolean belongToStmt(ParseTree t) {
        if (t instanceof ExtendContext ctx) {
            // block is included ??
            return ctx.getRuleIndex() == JavaParser.RULE_statement ||
                    simpleStmts.contains(ctx.getRuleIndex()) ||
                    compoundStmts.contains(ctx.getRuleIndex()) || ctx.getRuleIndex() == JavaParser.RULE_block;
        }
        return ((TerminalNode) t).getSymbol().getType() == JavaParser.SEMI;
    }

    @Override
    public boolean belongToMemberList(ParseTree t) {
        if (t instanceof ExtendContext ctx) {
            return memberLists.contains(ctx.getRuleIndex());
        }
        return false;
    }

    @Override
    public boolean belongToSimpleStmt(ParseTree t) {
        if (t instanceof ExtendContext ctx) {
            return simpleStmts.contains(getSpecificStmtType(ctx));
        }
        return false;
    }

    @Override
    public boolean belongToCompoundStmt(ParseTree t) {
        if (t instanceof ExtendContext ctx) {
            return compoundStmts.contains(ctx.getRuleIndex());
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
    public boolean isBody(ParseTree t) {
        return t instanceof JavaParser.BodyContext;
    }

    @Override
    public boolean isAnnotation(ParseTree t) {
        return t instanceof JavaParser.AnnotationContext;
    }

    @Override
    public boolean isBlock(ParseTree t) {
        if (t instanceof JavaParser.BlockContext) {
            return true;
        }
        return false;
    }


    @Override
    public boolean isTypeDeclaration(ParseTree t) {
        return t instanceof JavaParser.TypeDeclarationContext;
    }


    @Override
    public boolean isTypeType(ParseTree tree) {
        return tree instanceof JavaParser.TypeTypeContext;
    }

    @Override
    public boolean isContinueStmt(ParseTree t) {
        return t instanceof JavaParser.ContinueStmtContext;
    }

    @Override
    public boolean isLocalVarDeclaration(ParseTree t) {
        return t instanceof JavaParser.LocalVariableDeclarationContext;
    }

    @Override
    public boolean isLocalVarDeclarationStmt(ParseTree t) {
        return t instanceof JavaParser.LocalVariableDeclarationStmtContext;
    }

    @Override
    public boolean isLambdaExpression(ParseTree t) {
        return t instanceof JavaParser.LambdaExpressionContext;
    }


    @Override
    public boolean isTypeParameter(ParseTree t) {
        return t instanceof JavaParser.TypeParametersContext;
    }

    @Override
    public boolean isLiteral(ParseTree node) {
        return node instanceof JavaParser.LiteralContext;
    }

    @Override
    public boolean isVariableDeclaratorId(ParseTree t) {
        return t instanceof JavaParser.VariableDeclaratorIdContext;
    }

    @Override
    public boolean isVariableInitializer(ParseTree t) {
        return t instanceof JavaParser.VariableInitializerContext;
    }


    @Override
    public boolean isLambdaLVTIParameter(ParseTree t) {
        return t instanceof JavaParser.LambdaLVTIParameterContext;
    }

    @Override
    public boolean isLambdaParameters(ParseTree t) {
        return t instanceof JavaParser.LambdaParametersContext;
    }

    @Override
    public boolean isExpression(ParseTree t) {
        return t instanceof JavaParser.ExpressionContext;
    }

    @Override
    public boolean isPrimitiveType(ParseTree t) {
        return t instanceof JavaParser.PrimitiveTypeContext;
    }

    @Override
    public boolean isReferenceType(ParseTree t) {
        return t instanceof JavaParser.ClassOrInterfaceTypeContext;
    }


    @Override
    public int getRuleExpression() {
        return JavaParser.RULE_expression;
    }

    @Override
    public boolean belongToFileHeadDec(int rule) {
        return rule == JavaParser.RULE_importDeclaration || rule == JavaParser.RULE_packageDeclaration;
    }


    @Override
    public boolean belongToMethodHead(int ruleIndex) {
        return ruleIndex == JavaParser.RULE_methodHead || ruleIndex == JavaParser.RULE_constructorHead;
    }

    @Override
    public boolean belongToLoop(int ruleIndex) {
        return ruleIndex == JavaParser.RULE_forStmt || ruleIndex == JavaParser.RULE_whileStmt || ruleIndex == JavaParser.RULE_doWhileStmt;
    }


    @Override
    public boolean belongToAssignOp(String text) {
        return assignOps.contains(text);
    }

    @Override
    public boolean belongToCompareOp(String text) {
        return compareOps.contains(text);
    }

    @Override
    public boolean belongToBinOp(String text) {
        return binOps.contains(text);
    }

    @Override
    public boolean belongToUnOp(String name) {
        return unaryOps.contains(name);
    }


    @Override
    public boolean belongToOperator(String name) {
        return belongToBinOp(name) || belongToUnOp(name) || name.equals("[") || name.equals("]") || name.equals("(") || name.equals(")");
    }

    @Override
    public boolean isComment(int type) {
        return type == JavaParser.LINE_COMMENT || type == JavaParser.BLOCK_COMMENT;
    }


    @Override
    public boolean isKeyword(Token token) {
        return token.getType() != JavaParser.IDENTIFIER && token.getText().matches("[a-zA-Z]+");
    }

    @Override
    public boolean belongToIntLiteral(int type) {
        return type == JavaParser.DECIMAL_LITERAL || type == JavaParser.HEX_LITERAL || type == JavaParser.OCT_LITERAL ||
                type == JavaParser.BINARY_LITERAL;
    }

    @Override
    public boolean belongToFloatLiteral(int type) {
        return type == JavaParser.FLOAT_LITERAL || type == JavaParser.HEX_FLOAT_LITERAL;
    }

    @Override
    public boolean belongToLiteral(int type) {
        return getLiterals().contains(type);
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
    public int getRuleCatchClause() {
        return JavaParser.RULE_catchClause;
    }

    @Override
    public int getRuleFinallyBlock() {
        return JavaParser.RULE_finallyBlock;
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
    public int getRuleDoWhileStmt() {
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
    public boolean belongToMethodDec(int ruleIndex) {
        return JavaParser.RULE_methodDeclaration == ruleIndex || JavaParser.RULE_constructorDeclaration == ruleIndex;
    }

    @Override
    public int getRuleStmt() {
        return JavaParser.RULE_statement;
    }


    @Override
    public int getRuleExpressionList() {
        return JavaParser.RULE_expressionList;
    }

    @Override
    public int getRuleFieldDeclarationList() {
        return JavaParser.RULE_fieldDeclarationList;
    }

    @Override
    public int getRuleLiteral() {
        return JavaParser.RULE_literal;
    }

    @Override
    public int getRuleVariableDeclarators() {
        return JavaParser.RULE_variableDeclarators;
    }

    @Override
    public int getRuleVariableDeclarator() {
        return JavaParser.RULE_variableDeclarator;
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
    public int getMul() {
        return JavaParser.MUL;
    }

    @Override
    public int getRBrack() {
        return JavaParser.RBRACK;
    }

    @Override
    public void updateRoot(List<ParseTree> newTrees) {
        if (newTrees.isEmpty()) {
            return;
        }

        JavaParser.StatementContext virtualRoot = new JavaParser.StatementContext(null, -1);
        for (ParseTree tree : newTrees) {
            virtualRoot.addChild(tree);
        }
        root = virtualRoot;

    }

    @Override
    public boolean isLiteral(int tokenType) {
        return literals.contains(tokenType);
    }

    @Override
    public int getVar() {
        return JavaParser.VAR;
    }

    @Override
    public boolean belongToStringLiteral(int type) {
        return type == JavaParser.STRING_LITERAL || type == JavaParser.TEXT_BLOCK;
    }

    @Override
    public int getCharLiteralType() {
        return JavaParser.CHAR_LITERAL;
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
    public ExtendTokenFactory getTokenFactory() {
        return ExtendTokenFactory.DEFAULT;
    }


    @Override
    public Set<String> getOperators() {
        Set<String> operators = new HashSet<>();
        operators.addAll(binOps);
        operators.addAll(unaryOps);
        return operators;
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
    public Set<Integer> getCompoundStmts() {
        return compoundStmts;
    }

    @Override
    public Set<Integer> getSingleStmts() {
        return simpleStmts;
    }

    @Override
    public Set<Integer> getHomoOps() {
        return Set.of(
                JavaParser.ADD, JavaParser.SUB, JavaParser.MUL, JavaParser.DIV, JavaParser.MOD,
                JavaParser.BITAND, JavaParser.BITOR, JavaParser.CARET
        );
    }

    @Override
    public Set<Integer> getCompoundAssign() {
        return Set.of(
                JavaParser.ADD_ASSIGN, JavaParser.SUB_ASSIGN, JavaParser.MUL_ASSIGN, JavaParser.DIV_ASSIGN, JavaParser.MOD_ASSIGN,
                JavaParser.AND_ASSIGN, JavaParser.OR_ASSIGN, JavaParser.XOR_ASSIGN
        );
    }

    @Override
    public Set<Integer> getLiterals() {
        return literals;
    }

    @Override
    public Set<Integer> getMemberLists() {
        return memberLists;
    }


    @Override
    public int getRuleIndex(String ruleName) {
        return parser.getRuleIndex(ruleName);
    }

    @Override
    public ParseTree getRoot() {
        return root;
    }

    @Override
    public String getConstKeyword() {
        return "final";
    }

    @Override
    public String getSourceFile() {
        return parser.getSourceName();
    }

    @Override
    public String getInputCode() {
        return parser.getInputStream().getText();
    }

    @Override
    public int getDefaultChannel() {
        return JavaLexer.DEFAULT_TOKEN_CHANNEL;
    }


    @Override
    public int getRuleParExpression() {
        return JavaParser.RULE_parExpression;
    }

    @Override
    public int getRuleformalParameterList() {
        return JavaParser.RULE_formalParameterList;
    }

    @Override
    public int getRuleFormalParameter() {
        return JavaParser.RULE_formalParameter;
    }

    @Override
    public int getRuleSwitchStmt() {
        return JavaParser.RULE_switchStmt;
    }

    @Override
    public int getRuleTypeParameters() {
        return JavaParser.RULE_typeParameters;
    }

    @Override
    public int getRuleLocalVarDeclaration() {
        return JavaParser.RULE_localVariableDeclaration;
    }

    @Override
    public int getRuleFieldDeclaration() {
        return JavaParser.RULE_fieldDeclaration;
    }

    @Override
    public int getRuleImportDeclaration() {
        return JavaParser.RULE_importDeclaration;
    }

    @Override
    public int getRulePackageDeclaration() {
        return JavaParser.RULE_packageDeclaration;
    }

    @Override
    public int getRuleQualifiedName() {
        return JavaParser.RULE_qualifiedName;
    }

    @Override
    public int getRuleTypeList() {
        return JavaParser.RULE_typeList;
    }

    @Override
    public ExtendContext getSpecificStmt(ExtendContext stmt) {
        if (stmt instanceof JavaParser.StatementContext && stmt.getChild(0) instanceof ExtendContext ctx) {
            return ctx;
        }
        return stmt;
    }

    @Override
    public int getSpecificStmtType(ExtendContext ctx) {
        if (ctx instanceof JavaParser.StatementContext && ctx.getChild(0) instanceof ExtendContext specificStmt) {
            return specificStmt.getRuleIndex();
        }
        return ctx.getRuleIndex();
    }

    @Override
    public int getRuleContinueStmt() {
        return JavaParser.RULE_continueStmt;
    }

    @Override
    public int getRuleBreakStmt() {
        return JavaParser.RULE_breakStmt;
    }

    @Override
    public int getRuleArguments() {
        return JavaParser.RULE_arguments;
    }

    @Override
    public int getRuleReturnStmt() {
        return JavaParser.RULE_returnStmt;
    }

    @Override
    public int getRuleExpressionStmt() {
        return JavaParser.RULE_expressionStmt;
    }

    @Override
    public int getRuleLocalVarDeclarationStmt() {
        return JavaParser.RULE_localVariableDeclarationStmt;
    }


    @Override
    public int getRuleIntegerLiteral() {
        return JavaParser.RULE_integerLiteral;
    }

    @Override
    public int getRuleFloatLiteral() {
        return JavaParser.RULE_floatLiteral;
    }

    @Override
    public int getRuleCharLiteral() {
        return JavaParser.CHAR_LITERAL;
    }

    @Override
    public int getRuleStringLiteral() {
        return JavaParser.STRING_LITERAL;
    }

    @Override
    public int getRuleBoolLiteral() {
        return JavaParser.BOOL_LITERAL;
    }

    @Override
    public int getRuleTextBlockLiteral() {
        return JavaParser.TEXT_BLOCK;
    }

    @Override
    public int getRuleThrowStmt() {
        return JavaParser.RULE_throwStmt;
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
