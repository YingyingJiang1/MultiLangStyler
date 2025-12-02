package org.example.lang.cpp;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.antlr.java.JavaParser;
import org.example.controller.TokenAugmentor;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.common.factory.ExtendTokenFactory;
import org.example.antlr.common.token.ExtendToken;
import org.example.antlr.common.token.TokenNameGetter;
import org.example.antlr.cpp.CPPLexer;
import org.example.antlr.cpp.CPPParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class MyCppParser implements MyParser {
	public static Logger logger = LoggerFactory.getLogger(MyCppParser.class);

	CPPParser parser = null;
	Path curFile = null;
	ParseTree root = null;

	protected static Set<Integer> compoundStmts = new HashSet<>(Arrays.asList(
			CPPParser.RULE_ifStatement,
			CPPParser.RULE_ifElseStatement,
			CPPParser.RULE_switchStatement,
			CPPParser.RULE_whileStatement,
			CPPParser.RULE_doWhileStatement,
			CPPParser.RULE_forStatement,
			CPPParser.RULE_block,
			CPPParser.RULE_tryBlock
	));

	protected static Set<Integer> simpleStmts = new HashSet<>(Arrays.asList(
			CPPParser.RULE_labeledStatement,
			CPPParser.RULE_declarationStatement,
			CPPParser.RULE_expressionStatement,
			CPPParser.RULE_jumpStatement
	));
	private static Set<Integer> literals = Set.of(
			CPPParser.IntegerLiteral, CPPParser.CharacterLiteral,CPPParser.FloatingLiteral,
			CPPParser.StringLiteral,CPPParser.BooleanLiteral,CPPParser.PointerLiteral,CPPParser.UserDefinedLiteral
			);


	@Override
	public ParseTree parse(Path filePath) throws IOException {
		curFile = filePath;
		ExtendTokenFactory tokenFactory = new ExtendTokenFactory();
		Lexer lexer = new CPPLexer(CharStreams.fromPath(filePath));
		lexer.setTokenFactory(tokenFactory);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		parser = new CPPParser(tokenStream);
		parser.setTokenFactory(tokenFactory);
		// this.parser.setErrorHandler(new AntlrErrorHandler());
//        parser.removeErrorListeners();
		root = tryParse();


		return root;
	}

	@Override
	public ParseTree parse(String text, int rule) {
		ExtendTokenFactory tokenFactory = new ExtendTokenFactory();
		Lexer lexer = new CPPLexer(CharStreams.fromString(text));
		lexer.setTokenFactory(tokenFactory);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		parser = new CPPParser(tokenStream);
		parser.setTokenFactory(tokenFactory);
		// this.parser.setErrorHandler(new AntlrErrorHandler());
//        parser.removeErrorListeners();

		ParseTree t = switch (rule) {
			case CPPParser.RULE_translationUnit -> parser.translationUnit();
			case CPPParser.RULE_statement -> parser.statement();
			case CPPParser.RULE_declarationseq -> parser.declarationseq();
			default -> null;
		};

		TokenAugmentor.addContextTokens(this);
		// 统一换行符
		((CommonTokenStream) parser.getTokenStream()).getTokens().forEach(e -> {
			if (e.getType() == CPPParser.Newline || e.getType() == CPPParser.BlockComment || e.getType() == CPPParser.LineComment) {
				((ExtendToken) e).setText(e.getText().replace("\r\n", "\n"));
			}
		});
		return t;
	}

	@Override
	public ParseTree parseFromString(String code) {
		ExtendTokenFactory tokenFactory = new ExtendTokenFactory();
		Lexer lexer = new CPPLexer(CharStreams.fromString(code));
		lexer.setTokenFactory(tokenFactory);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		parser = new CPPParser(tokenStream);
		parser.setTokenFactory(tokenFactory);
        parser.removeErrorListeners();
		root = tryParse();
		return root;
	}

	@Override
	public TokenStream getTokenStream() {
		return parser.getTokenStream();
	}

	/**
	 * Alternative implementation: modify the rule in CPPParser.g4，Add more productions to the compilationUnit rule.
	 * But must be careful when return the root, root should be the child of compilationUnit node if the production used is new added.
	 */
	private ParseTree tryParse() {
		Predicate<ExtendContext> parseFailTester = new Predicate<ExtendContext>() {
			@Override
			public boolean test(ExtendContext root) {
				return parser.getNumberOfSyntaxErrors() > 0 || root.children.isEmpty();
			}
		};

		ExtendContext root = (ExtendContext) parser.declarationseq();
		if (parser.getNumberOfSyntaxErrors() > 0) {
			logger.error("Failed to parse code.");
			return null;
		}


		TokenAugmentor.addContextTokens(this);
		// 统一换行符
		((CommonTokenStream) parser.getTokenStream()).getTokens().forEach(t -> {
			if (t.getType() == getVws() || t.getType() == getBlockComment() || t.getType() == getLineComment()) {
				((ExtendToken) t).setText(t.getText().replace("\r\n", "\n"));
			}
		});
		return root;
	}

	@Override
	public String getLanguage() {
		return "cpp";
	}

	@Override
	public boolean belongToStmt(ParseTree t) {
		if (t instanceof ExtendContext ctx) {
			// block is included ??
			return ctx.getRuleIndex() == CPPParser.RULE_statement ||
					simpleStmts.contains(ctx.getRuleIndex()) ||
					compoundStmts.contains(ctx.getRuleIndex());
		}
		return ((TerminalNode) t).getSymbol().getType() == CPPParser.Semi;
	}

	@Override
	public boolean belongToMemberList(ParseTree t) {
		return false;
	}

	@Override
	public boolean belongToSingleStmt(ParseTree t) {
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
	public boolean belongToFileHeadDec(int rule) {
		return false;
	}

	@Override
	public boolean belongToMethodHead(int ruleIndex) {
		return ruleIndex == CPPParser.RULE_declarator;
	}

	@Override
	public boolean belongToLoop(int ruleIndex) {
		return ruleIndex == CPPParser.RULE_forStatement || ruleIndex == CPPParser.RULE_whileStatement || ruleIndex == CPPParser.RULE_doWhileStatement;
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
		return CPPParser.LineComment == type || CPPParser.BlockComment == type;
	}

	@Override
	public boolean isKeyword(Token token) {
		return token.getType() != CPPParser.Identifier && token.getText().matches("[a-zA-Z]+");
	}

	@Override
	public boolean belongToIntLiteral(int type) {
		return type == CPPParser.IntegerLiteral;
	}

	@Override
	public boolean belongToFloatLiteral(int type) {
		return type == CPPParser.FloatingLiteral;
	}

	@Override
	public boolean belongToStringLiteral(int type) {
		return type == CPPParser.StringLiteral;
	}

	@Override
	public boolean belongToLiteral(int type) {
		return type == CPPParser.RULE_literal;
	}

	@Override
	public boolean isStatement(ParseTree t) {
		return t instanceof CPPParser.StatementContext;
	}

	@Override
	public boolean isInitializer(ParseTree t) {
		return t instanceof CPPParser.InitializerContext;
	}

	@Override
	public boolean isFieldDeclaration(ParseTree t) {
		return t instanceof CPPParser.MemberdeclarationContext;
	}

	@Override
	public boolean isIdentifier(ParseTree t) {
		return t instanceof CPPParser.IdExpressionContext;
	}

	@Override
	public boolean isFieldDeclarationList(ParseTree t) {
		return t instanceof CPPParser.MemberDeclaratorListContext;
	}

	@Override
	public boolean isMethodDeclarationList(ParseTree t) {
		return t instanceof CPPParser.MemberSpecificationContext;
	}

	@Override
	public boolean isConstructorDeclarationList(ParseTree t) {
		return t instanceof CPPParser.ConstructorInitializerContext;
	}

	@Override
	public boolean isInitializerList(ParseTree t) {
		return t instanceof CPPParser.InitializerListContext;
	}

	@Override
	public boolean isTypeDeclarationList(ParseTree t) {
		return t instanceof CPPParser.ClassSpecifierContext;
	}

	@Override
	public boolean isBody(ParseTree t) {
		return t instanceof CPPParser.FunctionBodyContext;
	}

	@Override
	public boolean isAnnotation(ParseTree t) {
		// C++没有注解，返回false
		return false;
	}

	@Override
	public boolean isBlock(ParseTree t) {
		return t instanceof CPPParser.BlockContext;
	}

	@Override
	public boolean isTypeDeclaration(ParseTree t) {
		return t instanceof CPPParser.TypeSpecifierContext;
	}

	@Override
	public boolean isTypeType(ParseTree t) {
		return t instanceof CPPParser.TypeSpecifierSeqContext
				|| t instanceof CPPParser.DeclSpecifierSeqContext;
	}

	@Override
	public boolean isContinueStmt(ParseTree t) {
		if (t instanceof CPPParser.JumpStatementContext jump) {
			return jump.getText().startsWith("continue");
		}
		return false;
	}

	@Override
	public boolean isLocalVarDeclaration(ParseTree t) {
		return t instanceof CPPParser.SimpleDeclarationContext;
	}

	@Override
	public boolean isLocalVarDeclarationStmt(ParseTree t) {
		return t instanceof CPPParser.DeclarationStatementContext;
	}

	@Override
	public boolean isLambdaExpression(ParseTree t) {
		return t instanceof CPPParser.LambdaExpressionContext;
	}

	@Override
	public boolean isTypeParameter(ParseTree t) {
		return t instanceof CPPParser.TypeParameterContext;
	}

	@Override
	public boolean isLiteral(ParseTree t) {
		return t instanceof CPPParser.LiteralContext;
	}

	@Override
	public boolean isVariableDeclaratorId(ParseTree t) {
		return t instanceof CPPParser.DeclaratoridContext;
	}

	@Override
	public boolean isVariableInitializer(ParseTree t) {
		return t instanceof CPPParser.InitializerContext;
	}

	@Override
	public boolean isLambdaLVTIParameter(ParseTree t) {
		// C++中lambda参数一般在parameterDeclaration内
		return t instanceof CPPParser.ParameterDeclarationContext;
	}

	@Override
	public boolean isLambdaParameters(ParseTree t) {
		return t instanceof CPPParser.LambdaDeclaratorContext;
	}

	@Override
	public boolean isExpression(ParseTree t) {
		return t instanceof CPPParser.ExpressionContext
				|| t instanceof CPPParser.AssignmentExpressionContext
				|| t instanceof CPPParser.ConditionalExpressionContext;
	}

	@Override
	public boolean isPrimitiveType(ParseTree t) {
		if (t instanceof CPPParser.SimpleTypeSpecifierContext ctx) {
			String text = ctx.getText();
			return Set.of("int", "char", "bool", "float", "double", "short", "long", "void").contains(text);
		}
		return false;
	}

	@Override
	public boolean isReferenceType(ParseTree t) {
		if (t instanceof CPPParser.SimpleTypeSpecifierContext ctx) {
			String text = ctx.getText();
			return text.endsWith("&") || text.endsWith("*");
		}
		return false;
	}


	@Override
	public int getRuleBlock() {
		return CPPParser.RULE_block;
	}

	@Override
	public int getRuleExpression() {
		return CPPParser.RULE_expression;
	}

	@Override
	public int getRuleIdentifier() {
		return CPPParser.RULE_idExpression;
	}

	@Override
	public int getRuleIfStmt() {
		return CPPParser.RULE_ifStatement;
	}

	@Override
	public int getRuleIfElseStmt() {
		return CPPParser.RULE_ifElseStatement;
	}

	@Override
	public int getRuleTypeDeclaration() {
		return CPPParser.RULE_typeSpecifier;
	}

	@Override
	public int getRuleBody() {
		return 0;
	}

	@Override
	public int getRuleModifierList() {
		return 0;
	}

	@Override
	public int getRuleTypeType() {
		return 0;
	}

	@Override
	public int getRuleSwitchBlockStatementGroup() {
		return 0;
	}

	@Override
	public int getRuleConstructorDeclaration() {
		return 0;
	}

	@Override
	public int getRuleMethodDeclaration() {
		return CPPParser.RULE_functionDefinition;
	}

	@Override
	public int getRuleSyncStmt() {
		return 0;
	}

	@Override
	public int getRuleInitializer() {
		return 0;
	}

	@Override
	public int getRuleArrayInitializer() {
		return 0;
	}

	@Override
	public int getRuleCatchClause() {
		return 0;
	}

	@Override
	public int getRuleFinallyBlock() {
		return 0;
	}

	@Override
	public int getRuleElementValueArrayInitializer() {
		return 0;
	}

	@Override
	public int getRuleTryCatchStmt() {
		return CPPParser.RULE_tryBlock;
	}

	@Override
	public int getRuleForStmt() {
		return CPPParser.RULE_forStatement;
	}

	@Override
	public int getRuleWhileStmt() {
		return CPPParser.RULE_whileStatement;
	}

	@Override
	public int getRuleDoWhileStmt() {
		return CPPParser.RULE_doWhileStatement;
	}

	@Override
	public int getRuleCompilationUnit() {
		return CPPParser.RULE_translationUnit;
	}

	@Override
	public int getRuleImportDeclarationList() {
		return 0;
	}

	@Override
	public int getRuleAnnotationList() {
		return 0;
	}

	@Override
	public boolean belongToMethodDec(int ruleIndex) {
		return false;
	}

	@Override
	public int getRuleStmt() {
		return CPPParser.RULE_statement;
	}

	@Override
	public int getRuleExpressionList() {
		return 0;
	}

	@Override
	public int getRuleFieldDeclarationList() {
		return 0;
	}

	@Override
	public int getRuleLiteral() {
		return CPPParser.RULE_literal;
	}

	@Override
	public int getRuleVariableDeclarators() {
		return 0;
	}

	@Override
	public int getRuleVariableDeclarator() {
		return 0;
	}

	@Override
	public int getRuleParExpression() {
		return 0;
	}

	@Override
	public int getRuleformalParameterList() {
		return 0;
	}

	@Override
	public int getRuleFormalParameter() {
		return 0;
	}

	@Override
	public int getRuleSwitchStmt() {
		return CPPParser.RULE_switchStatement;
	}

	@Override
	public int getRuleTypeParameters() {
		return 0;
	}

	@Override
	public int getRuleLocalVarDeclaration() {
		return 0;
	}

	@Override
	public int getRuleFieldDeclaration() {
		return 0;
	}

	@Override
	public int getRuleImportDeclaration() {
		return 0;
	}

	@Override
	public int getRulePackageDeclaration() {
		return 0;
	}

	@Override
	public int getRuleQualifiedName() {
		return 0;
	}

	@Override
	public int getRuleTypeList() {
		return 0;
	}

	@Override
	public ExtendContext getSpecificStmt(ExtendContext stmt) {
		if (stmt instanceof CPPParser.StatementContext && stmt.getChild(0) instanceof ExtendContext ctx) {
			return ctx;
		}
		return stmt;
	}

	@Override
	public int getSpecificStmtType(ExtendContext ctx) {
		if (ctx instanceof CPPParser.StatementContext && ctx.getChild(0) instanceof ExtendContext specificStmt) {
			return specificStmt.getRuleIndex();
		}
		return ctx.getRuleIndex();
	}

	@Override
	public int getRuleContinueStmt() {
		return 0;
	}

	@Override
	public int getRuleBreakStmt() {
		return 0;
	}

	@Override
	public int getRuleArguments() {
		return 0;
	}

	@Override
	public int getRuleReturnStmt() {
		return 0;
	}

	@Override
	public int getRuleExpressionStmt() {
		return CPPParser.RULE_expressionStatement;
	}

	@Override
	public int getRuleLocalVarDeclarationStmt() {
		return 0;
	}

	@Override
	public int getRuleIntegerLiteral() {
		return 0;
	}

	@Override
	public int getRuleFloatLiteral() {
		return 0;
	}

	@Override
	public int getRuleCharLiteral() {
		return 0;
	}

	@Override
	public int getRuleStringLiteral() {
		return 0;
	}

	@Override
	public int getRuleBoolLiteral() {
		return 0;
	}

	@Override
	public int getRuleTextBlockLiteral() {
		return 0;
	}

	@Override
	public int getRuleThrowStmt() {
		return 0;
	}


	@Override
	public int getVws() {
		// vertical white space (new line)
		return CPPParser.Newline; // 143
	}

	@Override
	public int getHws() {
		// horizontal white space
		return CPPParser.Whitespace; // 142
	}

	@Override
	public int getIdentifier() {
		return CPPParser.Identifier; // 132
	}

	@Override
	public int getLE() {
		return CPPParser.LessEqual; // 116
	}

	@Override
	public int getGE() {
		return CPPParser.GreaterEqual; // 117
	}

	@Override
	public int getLT() {
		return CPPParser.Less; // 102
	}

	@Override
	public int getGT() {
		return CPPParser.Greater; // 103
	}

	@Override
	public int getComma() {
		return CPPParser.Comma; // 122
	}

	@Override
	public int getSemi() {
		return CPPParser.Semi; // 128
	}

	@Override
	public int getLineComment() {
		return CPPParser.LineComment; // 145
	}

	@Override
	public int getLBrace() {
		return CPPParser.LeftBrace; // 89
	}

	@Override
	public int getRBrace() {
		return CPPParser.RightBrace; // 90
	}

	@Override
	public int getLParen() {
		return CPPParser.LeftParen; // 85
	}

	@Override
	public int getRParen() {
		return CPPParser.RightParen; // 86
	}

	@Override
	public int getBang() {
		return CPPParser.Not; // 100
	}

	@Override
	public int getBlockComment() {
		return CPPParser.BlockComment; // 144
	}

	@Override
	public int getSub() {
		return CPPParser.Minus; // 92
	}

	@Override
	public int getEOF() {
		return Token.EOF; // -1
	}

	@Override
	public int getMul() {
		return CPPParser.Star; // 93
	}

	@Override
	public int getRBrack() {
		return CPPParser.RightBracket; // 88
	}

	@Override
	public int getVar() {
		return 0;
	}

	@Override
	public int getCharLiteralType() {
		return 0;
	}

	@Override
	public int getType(String text) {
		if (text == null) {
			return Integer.MIN_VALUE;
		}

		Parser parser = this.parser == null ? new CPPParser(null) : this.parser;
		return text.startsWith("RULE") ?
				parser.getRuleIndex(text) :
				parser.getTokenType(TokenNameGetter.getInstance().getName(text));
	}


	@Override
	public String getTokenName(int type) {
		return CPPParser.VOCABULARY.getSymbolicName(type);
	}

	@Override
	public String getRuleName(int type) {
		String[] ruleNames = CPPParser.ruleNames;
		return ruleNames[type];
	}

	@Override
	public ExtendTokenFactory getTokenFactory() {
		return ExtendTokenFactory.DEFAULT;
	}


	@Override
	public Set<String> getOperators() {
		return Set.of();
	}

	@Override
	public Set<String> getBinOps() {
		return Set.of();
	}

	@Override
	public Set<String> getUnaryOps() {
		return Set.of();
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
		return Set.of();
	}

	@Override
	public Set<Integer> getCompoundAssign() {
		return Set.of();
	}

	@Override
	public Set<Integer> getLiterals() {
		return Set.of();
	}

	@Override
	public Set<Integer> getMemberLists() {
		return Set.of();
	}

	@Override
	public Set<Integer> getArrayInitializerRules() {
		return Set.of();
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
		return "const";
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
		return CPPLexer.DEFAULT_TOKEN_CHANNEL;
	}

	@Override
	public void updateRoot(List<ParseTree> newTrees) {

	}

	@Override
	public boolean isLiteral(int tokenType) {
		return literals.contains(tokenType);
	}


}
