package org.example.lang.cpp;

import org.example.antlr.cpp.CPPParser;
import org.example.antlr.java.JavaParser;
import org.example.lang.LangAdapterCreator;
import org.example.lang.base.PlaceholderParser;
import org.example.lang.intf.MyParser;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CppPlaceholderParser extends PlaceholderParser {
	private static Map<String, Set<Integer>> matchRules = new HashMap<>();
	private static Map<String, Set<Integer>> matchTokens = new HashMap<>();

	static {
		MyParser parser = LangAdapterCreator.createParser("cpp");
		matchRules.put("$I", Set.of(CPPParser.RULE_idExpression));
		matchRules.put("$E", Set.of(CPPParser.RULE_expression, CPPParser.RULE_assignmentExpression, CPPParser.RULE_idExpression,
				CPPParser.RULE_declarator // left value in assignment
		));
		matchRules.put("$S", Set.of(CPPParser.RULE_statement));
		matchRules.put("$T", Set.of(CPPParser.RULE_typeSpecifier));
		matchRules.put("$M", Set.of(CPPParser.RULE_declSpecifier));
		matchRules.put("$LITERAL", Set.of(CPPParser.RULE_literal));
		matchRules.put("$VAR_DEC", Set.of(CPPParser.RULE_simpleDeclaration));
		matchRules.put("$S(ifStmt)", Set.of(CPPParser.RULE_ifStatement));
		matchRules.put("$S(ifElseStmt)", Set.of(CPPParser.RULE_ifElseStatement));
		matchRules.put("$S(expStmt)", Set.of(CPPParser.RULE_expressionStatement));
		matchRules.put("$EXP_LIST", Set.of(CPPParser.RULE_expression));

		matchTokens.put("$HOMO_BOP", parser.getHomoOps());
		matchTokens.put("$HOMO_BOP_ASSIGN", parser.getCompoundAssign());
	}


	@Override
	protected Map<String, Set<Integer>> getTokenMatchMap() {
		return matchTokens;
	}

	@Override
	protected Map<String, Set<Integer>> getRuleMatchMap() {
		return matchRules;
	}

}
