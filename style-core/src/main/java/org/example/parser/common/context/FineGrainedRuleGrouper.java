package org.example.parser.common.context;

import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.factory.MyParserFactory;
import org.example.parser.java.antlr.JavaParser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FineGrainedRuleGrouper extends RuleGrouper {
    private static RuleGrouper instance = new FineGrainedRuleGrouper();
    protected static String curLanguage = "";

    protected static Set<Integer> declarationStmts = null;
    protected static Set<Integer> conditionalStmts = null;
    protected static Set<Integer> loopStmts = null;
    protected static Set<Integer> exceptionHandleStmts = null;
    protected static Set<Integer> concurrencyControlStmts = null;



    public static RuleGrouper getInstance(String language) {
        init(language);
        return instance;
    }


    public RuleGroup getGroup(int ruleIndex, MyParser parser) {
        if (parser.getRuleExpressionStmt() == ruleIndex) {
            return RuleGroup.EXPRESSION_STMT;
        } else if (declarationStmts.contains(ruleIndex)) {
            return RuleGroup.DECLARATION_STMT;
        } else if (conditionalStmts.contains(ruleIndex)) {
            return RuleGroup.CONDITIONAL_STMT;
        } else if (loopStmts.contains(ruleIndex)) {
            return RuleGroup.LOOP_STMT;
        } else if (exceptionHandleStmts.contains(ruleIndex)) {
            return RuleGroup.EXCEPTION_HANDLE_STMT;
        } else if (concurrencyControlStmts.contains(ruleIndex)) {
            return RuleGroup.CONCURRENCY_CONTROL_STMT;
        } else {
            return super.getGroup(ruleIndex, parser);
        }
    }

    private static void init(String language) {
        if (!language.equals(curLanguage)) {
            curLanguage = language;
            MyParser parser = MyParserFactory.createParser(curLanguage);
            declarationStmts = new HashSet<>(Arrays.asList(
                   parser.getRuleLocalVarDeclarationStmt(), parser.getRuleFieldDeclaration()
            ));
            conditionalStmts = new HashSet<>(Arrays.asList(
                    parser.getRuleIfStmt(), parser.getRuleSwitchStmt(),parser.getRuleIfElseStmt()
            ));
            loopStmts = new HashSet<>(Arrays.asList(
                    parser.getRuleForStmt(), parser.getRuleWhileStmt(), parser.getRuleDoWhileStmt()
            ));
            exceptionHandleStmts = new HashSet<>(Arrays.asList(
                    parser.getRuleTryCatchStmt()
            ));
            concurrencyControlStmts = new HashSet<>(Arrays.asList(
                    parser.getRuleSyncStmt()
            ));
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

