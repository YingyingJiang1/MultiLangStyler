package org.example.lang.base;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.common.factory.ExtendTokenFactory;
import org.example.antlr.common.token.AmbigousToken;
import org.example.antlr.common.token.ExtendToken;
import org.example.antlr.common.token.TokenNameGetter;
import org.example.stylekit.TokenAugmentor;
import org.example.lang.LangAdapterCreator;
import org.example.lang.intf.MyParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyParserBase implements MyParser {
	protected Parser parser = null;
	protected Path curFile = null;
	protected ParseTree root = null;


	static Set<String> assignOps = new HashSet<>(Arrays.asList(
			"=", "+=", "-=", "*=", "/=", "&=", "|=", "^=", "%=", "<<=", ">>=", ">>>="
	));
	static Set<String> compareOps = new HashSet<>(Arrays.asList(
			"==", "!=", "<", ">", "<=", ">="
	));
	static Set<String> binOps = new HashSet<>(Arrays.asList(
			"+", "-", "*", "/",  "%", "&", "|", "^", "=", "+=", "-=", "*=", "/=", "&=", "|=", "^=", "%=",
			"<<=", ">>=", ">>>=", "<", ">", "<=", ">=", "==", "!=", ":", "::", ".", "->",
			"&&", "||", "instanceof"
	));

	static Set<String> unaryOps = new HashSet<>(Arrays.asList(
			"~", "!", "++", "--", "?", AmbigousToken.NEGATIVE.name()
	));

	static Set<String> separators = new HashSet<>(Arrays.asList(
			",",  "(", ")", "{", "}", "[", "]", ";", AmbigousToken.LEFT_ANGLE_BRACKET.name(), AmbigousToken.RIGHT_ANGLE_BRACKET.name()
	));

	@Override
	public ParseTree parse(Path filePath) throws IOException {
		return parseFromString(Files.readString(filePath));
	}

	@Override
	public ParseTree parse(String code, int rule) {
		return null;
	}

	@Override
	public ParseTree parseFromString(String code) {
		parser = generateParser(code);
		root = tryParse();

		if (root == null) {
			logger.error("Failed to parse code, " +
					"this program is only able to parse the top-level, typeDeclaration-level, method-level, stmt-level,expression-level code.");
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

	protected Parser generateParser(String code) {
		return null;
	}

	protected ParseTree tryParse() {
		return null;
	}

	@Override
	public TokenStream getTokenStream() {
		return parser.getTokenStream();
	}

	@Override
	public String getLanguage() {
		return "";
	}

	@Override
	public boolean belongToStmt(ParseTree t) {
		return false;
	}

	@Override
	public boolean belongToMemberList(ParseTree t) {
		return false;
	}

	@Override
	public boolean belongToSimpleStmt(ParseTree t) {
		return false;
	}

	@Override
	public boolean belongToCompoundStmt(ParseTree t) {
		return false;
	}

	@Override
	public boolean belongToFileHeadDec(int rule) {
		return false;
	}

	@Override
	public boolean belongToMethodHead(int ruleIndex) {
		return false;
	}

	@Override
	public boolean belongToLoop(int ruleIndex) {
		return false;
	}

	@Override
	public boolean belongToAssignOp(String text) {
		return false;
	}

	@Override
	public boolean belongToCompareOp(String text) {
		return false;
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
		return binOps.contains(name) || unaryOps.contains(name) ||
				name.equals("?") || name.equals(":");
	}

	@Override
	public boolean isComment(int type) {
		return false;
	}

	@Override
	public boolean isKeyword(Token token) {
		return false;
	}

	@Override
	public boolean isKeyword(String text) {
		return false;
	}

	@Override
	public boolean belongToIntLiteral(int type) {
		return false;
	}

	@Override
	public boolean belongToFloatLiteral(int type) {
		return false;
	}

	@Override
	public boolean belongToStringLiteral(int type) {
		return false;
	}

	@Override
	public boolean belongToLiteral(int type) {
		return false;
	}

	@Override
	public boolean isStatement(ParseTree t) {
		return false;
	}

	@Override
	public boolean isInitializer(ParseTree t) {
		return false;
	}

	@Override
	public boolean isFieldDeclaration(ParseTree t) {
		return false;
	}

	@Override
	public boolean isIdentifier(ParseTree t) {
		return false;
	}

	@Override
	public boolean isFieldDeclarationList(ParseTree t) {
		return false;
	}

	@Override
	public boolean isMethodDeclarationList(ParseTree t) {
		return false;
	}

	@Override
	public boolean isConstructorDeclarationList(ParseTree t) {
		return false;
	}

	@Override
	public boolean isInitializerList(ParseTree t) {
		return false;
	}

	@Override
	public boolean isTypeDeclarationList(ParseTree t) {
		return false;
	}

	@Override
	public boolean isBody(ParseTree t) {
		return false;
	}

	@Override
	public boolean isAnnotation(ParseTree t) {
		return false;
	}

	@Override
	public boolean isBlock(ParseTree t) {
		return false;
	}

	@Override
	public boolean isTypeDeclaration(ParseTree t) {
		return false;
	}

	@Override
	public boolean isTypeType(ParseTree tree) {
		return false;
	}

	@Override
	public boolean isContinueStmt(ParseTree lastTree) {
		return false;
	}

	@Override
	public boolean isLocalVarDeclaration(ParseTree t) {
		return false;
	}

	@Override
	public boolean isLocalVarDeclarationStmt(ParseTree t) {
		return false;
	}

	@Override
	public boolean isLambdaExpression(ParseTree t) {
		return false;
	}

	@Override
	public boolean isTypeParameter(ParseTree t) {
		return false;
	}

	@Override
	public boolean isLiteral(ParseTree node) {
		return false;
	}

	@Override
	public boolean isVariableDeclaratorId(ParseTree t) {
		return false;
	}

	@Override
	public boolean isVariableInitializer(ParseTree t) {
		return false;
	}

	@Override
	public boolean isLambdaLVTIParameter(ParseTree t) {
		return false;
	}

	@Override
	public boolean isLambdaParameters(ParseTree t) {
		return false;
	}

	@Override
	public boolean isExpression(ParseTree t) {
		return false;
	}

	@Override
	public boolean isPrimitiveType(ParseTree t) {
		return false;
	}

	@Override
	public boolean isReferenceType(ParseTree t) {
		return false;
	}

	@Override
	public int getRuleBlock() {
		return 0;
	}

	@Override
	public int getRuleExpression() {
		return 0;
	}

	@Override
	public int getRuleIdentifier() {
		return 0;
	}

	@Override
	public int getRuleIfStmt() {
		return 0;
	}

	@Override
	public int getRuleIfElseStmt() {
		return 0;
	}

	@Override
	public int getRuleTypeDeclaration() {
		return 0;
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
		return 0;
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
		return 0;
	}

	@Override
	public int getRuleForStmt() {
		return 0;
	}

	@Override
	public int getRuleWhileStmt() {
		return 0;
	}

	@Override
	public int getRuleDoWhileStmt() {
		return 0;
	}

	@Override
	public int getRuleCompilationUnit() {
		return 0;
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
		return 0;
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
		return 0;
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
		return 0;
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
		if (isStatement(stmt) && stmt.getChild(0) instanceof ExtendContext ctx) {
			return ctx;
		}
		return stmt;
	}

	@Override
	public int getSpecificStmtType(ExtendContext ctx) {
		if (isStatement(ctx) && ctx.getChild(0) instanceof ExtendContext specificStmt) {
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
		return 0;
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
		return 0;
	}

	@Override
	public int getHws() {
		return 0;
	}

	@Override
	public int getIdentifier() {
		return 0;
	}

	@Override
	public int getLE() {
		return 0;
	}

	@Override
	public int getGE() {
		return 0;
	}

	@Override
	public int getLT() {
		return 0;
	}

	@Override
	public int getGT() {
		return 0;
	}

	@Override
	public int getComma() {
		return 0;
	}

	@Override
	public int getSemi() {
		return 0;
	}

	@Override
	public int getLineComment() {
		return 0;
	}

	@Override
	public int getLBrace() {
		return 0;
	}

	@Override
	public int getRBrace() {
		return 0;
	}

	@Override
	public int getLParen() {
		return 0;
	}

	@Override
	public int getRParen() {
		return 0;
	}

	@Override
	public int getBang() {
		return 0;
	}

	@Override
	public int getBlockComment() {
		return 0;
	}

	@Override
	public int getSub() {
		return 0;
	}

	@Override
	public int getEOF() {
		return 0;
	}

	@Override
	public int getMul() {
		return 0;
	}

	@Override
	public int getRBrack() {
		return 0;
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
		return text.startsWith("RULE") ?
				parser.getRuleIndex(text) :
				parser.getTokenType(TokenNameGetter.getInstance().getName(text));

	}

	@Override
	public String getTokenName(int type) {
		return parser.getVocabulary().getSymbolicName(type);
	}

	@Override
	public String getRuleName(int type) {
		return parser.getRuleNames()[type];
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
		return Set.of();
	}

	@Override
	public Set<Integer> getSingleStmts() {
		return Set.of();
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
		return "";
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
		return 0;
	}

	@Override
	public void updateRoot(List<ParseTree> newTrees) {
		if (newTrees.isEmpty()) {
			return;
		}

		ExtendContext virtualRoot = LangAdapterCreator.createTreeNodeFactory(getLanguage()).createStatement(null);
		for (ParseTree tree : newTrees) {
			virtualRoot.addChild(tree);
		}
		root = virtualRoot;
	}

	@Override
	public boolean isLiteral(int tokenType) {
		return false;
	}
}
