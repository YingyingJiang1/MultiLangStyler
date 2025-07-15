package org.example.parser.common.context;

import org.example.parser.common.MyParser;

public class RuleGrouper {
	protected static RuleGrouper instance = new RuleGrouper();


	public static RuleGrouper getInstance(String language) {
		return instance;
	}

	
	public RuleGroup getGroup(int ruleIndex, MyParser parser) {
		if (parser.getSingleStmts().contains(ruleIndex)) {
			return RuleGroup.SINGLE_STMT;
		} else if (parser.getCompoundStmts().contains(ruleIndex)) {
			return RuleGroup.COMPOUND_STMT;
		} else if (parser.belongToMethodDec(ruleIndex)) {
			return RuleGroup.FUNCTION_DEC;
		} else if(parser.getRuleTypeDeclaration() == ruleIndex) {
			return RuleGroup.TYPE_DEC;
		} else if (parser.getMemberLists().contains(ruleIndex)) {
			return RuleGroup.MEMBER_LIST;
		} else if (parser.getRuleBlock() == ruleIndex){
			return RuleGroup.STANDALONE_BLOCK;
		} else if (parser.belongToFileHeadDec(ruleIndex)) {
			return RuleGroup.FILE_HEAD_DEC;
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
