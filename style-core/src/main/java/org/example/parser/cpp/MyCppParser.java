package org.example.parser.cpp;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.ExtendTokenFactory;
import org.example.parser.common.factory.context.TreeNodeFactory;
import org.example.parser.cpp.antlr.CPP14Parser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

public class MyCppParser implements MyParser {
	@Override
	public ParseTree parse(Path filePath) throws IOException {
		return null;
	}

	@Override
	public ParseTree parse(String code, int rule) {
		return null;
	}

	@Override
	public ParseTree parseFromString(String code) {
		return null;
	}

	@Override
	public TokenStream getTokenStream() {
		return null;
	}

	@Override
	public String getLanguage() {
		return "cpp";
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
	public boolean belongToSingleStmt(ParseTree t) {
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
		return false;
	}

	@Override
	public boolean belongToUnOp(String name) {
		return false;
	}

	@Override
	public boolean belongToOperator(String name) {
		return false;
	}

	@Override
	public boolean belongToComment(int type) {
		return false;
	}

	@Override
	public boolean belongToKeyword(Token token) {
		return false;
	}

	@Override
	public boolean belongToIntLiteral(int type) {
		return false;
	}

	@Override
	public boolean belongToFloadLiteral(int type) {
		return false;
	}

	@Override
	public boolean belongToLiteralType(int type) {
		return false;
	}

	@Override
	public boolean belongToLiteral(int type) {
		return false;
	}

	@Override
	public ParseTree createExpression(ParserRuleContext parent, int invokingState) {
		return null;
	}

	@Override
	public boolean isStatement(ParseTree t) {
		return t instanceof CPP14Parser.StatementContext;
	}

	@Override
	public boolean isInitializer(ParseTree t) {
		return t instanceof CPP14Parser.InitializerContext;
	}

	@Override
	public boolean isFieldDeclaration(ParseTree t) {
		return t instanceof CPP14Parser.MemberdeclarationContext;
	}

	@Override
	public boolean isIdentifier(ParseTree t) {
		return t instanceof CPP14Parser.IdExpressionContext;
	}

	@Override
	public boolean isFieldDeclarationList(ParseTree t) {
		return t instanceof CPP14Parser.MemberDeclaratorListContext;
	}

	@Override
	public boolean isMethodDeclarationList(ParseTree t) {
		return t instanceof CPP14Parser.MemberSpecificationContext;
	}

	@Override
	public boolean isConstructorDeclarationList(ParseTree t) {
		return t instanceof CPP14Parser.ConstructorInitializerContext;
	}

	@Override
	public boolean isInitializerList(ParseTree t) {
		return t instanceof CPP14Parser.InitializerListContext;
	}

	@Override
	public boolean isTypeDeclarationList(ParseTree t) {
		return t instanceof CPP14Parser.ClassSpecifierContext;
	}

	@Override
	public boolean isBody(ParseTree t) {
		return t instanceof CPP14Parser.FunctionBodyContext;
	}

	@Override
	public boolean isAnnotation(ParseTree t) {
		// C++没有注解，返回false
		return false;
	}

	@Override
	public boolean isBlock(ParseTree t) {
		return t instanceof CPP14Parser.CompoundStatementContext;
	}

	@Override
	public boolean isTypeDeclaration(ParseTree t) {
		return t instanceof CPP14Parser.ClassSpecifierContext
				|| t instanceof CPP14Parser.EnumSpecifierContext;
	}

	@Override
	public boolean isTypeType(ParseTree t) {
		return t instanceof CPP14Parser.TypeSpecifierSeqContext
				|| t instanceof CPP14Parser.DeclSpecifierSeqContext;
	}

	@Override
	public boolean isContinueStmt(ParseTree t) {
		if (t instanceof CPP14Parser.JumpStatementContext jump) {
			return jump.getText().startsWith("continue");
		}
		return false;
	}

	@Override
	public boolean isLocalVarDeclaration(ParseTree t) {
		return t instanceof CPP14Parser.SimpleDeclarationContext;
	}

	@Override
	public boolean isLocalVarDeclarationStmt(ParseTree t) {
		return t instanceof CPP14Parser.DeclarationStatementContext;
	}

	@Override
	public boolean isLambdaExpression(ParseTree t) {
		return t instanceof CPP14Parser.LambdaExpressionContext;
	}

	@Override
	public boolean isTypeParameter(ParseTree t) {
		return t instanceof CPP14Parser.TypeParameterContext;
	}

	@Override
	public boolean isLiteral(ParseTree t) {
		return t instanceof CPP14Parser.LiteralContext;
	}

	@Override
	public boolean isVariableDeclaratorId(ParseTree t) {
		return t instanceof CPP14Parser.DeclaratoridContext;
	}

	@Override
	public boolean isVariableInitializer(ParseTree t) {
		return t instanceof CPP14Parser.InitializerContext;
	}

	@Override
	public boolean isLambdaLVTIParameter(ParseTree t) {
		// C++中lambda参数一般在parameterDeclaration内
		return t instanceof CPP14Parser.ParameterDeclarationContext;
	}

	@Override
	public boolean isLambdaParameters(ParseTree t) {
		return t instanceof CPP14Parser.LambdaDeclaratorContext;
	}

	@Override
	public boolean isExpression(ParseTree t) {
		return t instanceof CPP14Parser.ExpressionContext
				|| t instanceof CPP14Parser.AssignmentExpressionContext
				|| t instanceof CPP14Parser.ConditionalExpressionContext;
	}

	@Override
	public boolean isPrimitiveType(ParseTree t) {
		if (t instanceof CPP14Parser.SimpleTypeSpecifierContext ctx) {
			String text = ctx.getText();
			return Set.of("int", "char", "bool", "float", "double", "short", "long", "void").contains(text);
		}
		return false;
	}

	@Override
	public boolean isReferenceType(ParseTree t) {
		if (t instanceof CPP14Parser.SimpleTypeSpecifierContext ctx) {
			String text = ctx.getText();
			return text.endsWith("&") || text.endsWith("*");
		}
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
	public int getRuleExpStmt() {
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
		return null;
	}

	@Override
	public int getSpecificStmtType(ExtendContext ctx) {
		return 0;
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
		return 0;
	}

	@Override
	public String getTokenName(int type) {
		return "";
	}

	@Override
	public String getRuleName(int type) {
		return "";
	}

	@Override
	public ExtendTokenFactory getTokenFactory() {
		return null;
	}

	@Override
	public TreeNodeFactory getTreeNodeFactory() {
		return null;
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
		return 0;
	}

	@Override
	public ParseTree getRoot() {
		return null;
	}

	@Override
	public String getConstKeyword() {
		return "";
	}

	@Override
	public String getSourceFile() {
		return "";
	}

	@Override
	public String getInputCode() {
		return "";
	}

	@Override
	public int getDefaultChannel() {
		return 0;
	}

	@Override
	public void updateRoot(List<ParseTree> newTrees) {

	}
}
