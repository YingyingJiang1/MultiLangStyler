package org.example.style.grouper;

import org.example.parser.java.antlr.JavaParser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RuleGrouper implements Grouper {
	private static RuleGrouper instance = new RuleGrouper();
	private static final int START = 1 << 30;
	public static final int SINGLE_STMT = START + 1;
	public static final int BLOCK_STMT = START + 2;
	public static final int MEMBER_LIST = START + 3;
	public static final int BLOCK_DECLARATION = START + 4;
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


//	@Override
//	public int getGroupId(int type) {
//		if (singleStmts.contains(type)) {
//			return SINGLE_STMT;
//		} else if (blockStmts.contains(type)) {
//			return BLOCK_STMT;
//		} else if(memberLists.contains(type)){
//			return MEMBER_LIST;
//		} else if(blockDeclarations.contains(type)){
//			return BLOCK_DECLARATION;
//		} else {
//			return type;
//		}
//	}

	@Override
	public boolean isGroup(int type) {
		return type > START;
	}

	@Override
	public String getGroupName(String name) {
		return "";
	}

	@Override
	public String getGroupName(int groupId) {
		if (groupId == SINGLE_STMT) {
			return "single_stmt";
		} else if (groupId == BLOCK_STMT) {
			return "block_stmt";
		} else if(groupId == MEMBER_LIST) {
			return "member_list";
		} else if(groupId == BLOCK_DECLARATION) {
			return "block_declaration";
		} else {
			return "";
		}
	}

	@Override
	public int calculateGroupDistance(String group1, String group2) {
		return 0;
	}

//	@Override
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
