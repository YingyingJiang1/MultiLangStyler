package org.example.style.format.grouper;

import org.example.antlr.JavaParser;
import org.example.parser.AntlrHelper;


public class FineGrainedGrouper implements Grouper {
	private static FineGrainedGrouper instance = new FineGrainedGrouper();
	public static final int KEYWORD_GROUP = START - 1;
	public static final int LITERAL_GROUP = START - 2;
	public static final int UNARY_OP_GROUP = START - 3;
	public static final int BIN_BIT_OP = START - 4; // &, ^, |
	public static final int BIN_ASSIGN_OP = START - 5; // =, +=, <<=,...
	public static final int BIN_ARITHMETIC_OP = START - 6; // +, -, *...
	public static final int BIN_LOGICAL_OP = START - 7; // &&, ||
	public static final int BIN_COMPARE_OP = START - 8; // <, <=, ==,...

	static String[] names = {
			"keyword", "literal", "unary_op",
			"bin_bit_op", "bin_assign_op", "bin_arithmetic_op",
			"bin_logical_op", "bin_compare_op",
	};

	private FineGrainedGrouper() {
	}


	public static FineGrainedGrouper getInstance() {
		return instance;
	}

	@Override
	public int getGroupId(int type) {
		if (AntlrHelper.isLiteral(type)) {
			return LITERAL_GROUP;
		} else if (AntlrHelper.isKeyword(type)) {
			return KEYWORD_GROUP;
		} else if (AntlrHelper.isUnaryOp(type)) {
			return UNARY_OP_GROUP;
		} else if (AntlrHelper.isBinBitOp(type)) {
			return BIN_BIT_OP;
		} else if (AntlrHelper.isBinAssignOp(type)) {
			return BIN_ASSIGN_OP;
		} else if (AntlrHelper.isBinLogicalOp(type)) {
			return BIN_LOGICAL_OP;
		} else if (AntlrHelper.isBinCompareOp(type)) {
			return BIN_COMPARE_OP;
		} else if (AntlrHelper.isBinArithmeticOp(type)) {
			return BIN_ARITHMETIC_OP;
		} else {
			return type;
		}
	}

	@Override
	public String getGroupName(int groupId) {
		return names[Math.abs(groupId) + START - 1];
	}

	@Override
	public int getGroupId(String groupName) {
		return switch (groupName) {
			case "keyword" -> KEYWORD_GROUP;
			case "literal" -> LITERAL_GROUP;
			case "unary_operator" -> UNARY_OP_GROUP;
			case "bin_bit_op" -> BIN_BIT_OP;
			case "bin_assign_op" -> BIN_ASSIGN_OP;
			case "bin_arithmetic_op" -> BIN_ARITHMETIC_OP;
			case "bin_logical_op" -> BIN_LOGICAL_OP;
			case "bin_compare_op" -> BIN_COMPARE_OP;
			default -> Integer.MIN_VALUE;
		};
	}

	@Override
	public boolean isBinaryOp(int groupId) {
		return groupId == BIN_ARITHMETIC_OP ||  groupId == BIN_ASSIGN_OP ||
				groupId == BIN_BIT_OP || groupId == BIN_COMPARE_OP ||
				groupId == BIN_LOGICAL_OP || groupId == JavaParser.QUESTION || groupId == JavaParser.COLON;
	}
}
