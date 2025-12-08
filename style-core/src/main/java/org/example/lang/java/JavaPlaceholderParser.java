package org.example.lang.java;

import org.example.antlr.java.JavaParser;
import org.example.lang.LangAdapterCreator;
import org.example.lang.base.PlaceholderParser;
import org.example.lang.intf.MyParser;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JavaPlaceholderParser extends PlaceholderParser {
	private static Map<String, Set<Integer>> matchRules = new HashMap<>();
	private static Map<String, Set<Integer>> matchTokens = new HashMap<>();

	private static void init() {
		MyParser parser = LangAdapterCreator.createParser("java");

		matchRules.put("$I", Set.of(parser.getRuleIdentifier()));
		matchRules.put("$E", Set.of(parser.getRuleExpression()));
		matchRules.put("$S", Set.of(parser.getRuleStmt()));
		matchRules.put("$T", Set.of(JavaParser.RULE_typeType));
		matchRules.put("$M", Set.of(parser.getRuleModifierList()));
		matchRules.put("$LITERAL", Set.of(parser.getRuleLiteral()));
		matchRules.put("$VAR_DEC", Set.of(JavaParser.RULE_localVariableDeclaration));
		matchRules.put("$S(ifStmt)", Set.of(parser.getRuleIfStmt()));
		matchRules.put("$S(ifElseStmt)", Set.of(parser.getRuleIfElseStmt()));
		matchRules.put("$S(expStmt)", Set.of(parser.getRuleExpressionStmt()));
		matchRules.put("$EXP_LIST", Set.of(JavaParser.RULE_expressionList));

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
