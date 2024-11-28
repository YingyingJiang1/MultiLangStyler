package org.example.parser.common.group;

import org.example.parser.common.MyParser;
import org.example.parser.java.antlr.JavaParser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RuleGrouper {
	private static RuleGrouper instance = new RuleGrouper();

	private static Set<Integer> singleStmts = new HashSet<>(Arrays.asList(
			JavaParser.RULE_fieldDeclaration, JavaParser.RULE_localVariableDeclarationStmt,
			JavaParser.RULE_expressionStmt, JavaParser.RULE_returnStmt, JavaParser.RULE_yieldStmt,
			JavaParser.RULE_assertStmt, JavaParser.RULE_breakStmt, JavaParser.RULE_continueStmt, JavaParser.RULE_throwStmt
	));
	private static Set<Integer> blockStmts = new HashSet<>(Arrays.asList(
			JavaParser.RULE_ifStmt, JavaParser.RULE_ifElseStmt, JavaParser.RULE_forStmt,
			JavaParser.RULE_whileStmt, JavaParser.RULE_doWhileStmt, JavaParser.RULE_tryCatchStmt,
			JavaParser.RULE_tryResourceStmt, JavaParser.RULE_switchStmt, JavaParser.RULE_syncStmt
	));
	// Do not contain FieldDeclarationList, because it doesn't have {}
	private static Set<Integer> memberLists = new HashSet<>(Arrays.asList(
			JavaParser.RULE_typeDeclarationList,
		JavaParser.RULE_initializerList, JavaParser.RULE_methodDeclarationList,
		JavaParser.RULE_constructorDeclarationList
	));
	private static Set<Integer> blockDeclarations = new HashSet<>(Arrays.asList(
			JavaParser.RULE_typeDeclaration, JavaParser.RULE_methodDeclaration,
			JavaParser.RULE_constructorDeclaration, JavaParser.RULE_initializer
	));


	public static RuleGrouper getInstance() {
		return instance;
	}

	
	public RuleGroup getGroup(int ruleIndex, MyParser parser) {
		if (parser.getSingleStmts().contains(ruleIndex)) {
			return RuleGroup.SINGLE_STMT;
		} else if (parser.getCompoundStmts().contains(ruleIndex)) {
			return RuleGroup.COMPOUND_STMT;
		} else if (parser.getMemberLists().contains(ruleIndex)) {
			return RuleGroup.MEMBER_LIST;
		} else if (parser.getMemberDecs().contains(ruleIndex)) {
			return RuleGroup.MEMBER_DEC;
		} else {
			return RuleGroup.SELF_RULE;
		}
	}
//	
//	public int getGroupId(String groupName) {
//		return switch (groupName) {
//			case "single_stmt" -> SINGLE_STMT;
//			case "block_stmt" -> BLOCK_STMT;
//			case "member_list" -> MEMBER_LIST;
//			case "block_declaration" -> BLOCK_DECLARATION;
//			default -> Integer.MIN_VALUE;
//		};
//	}
}
