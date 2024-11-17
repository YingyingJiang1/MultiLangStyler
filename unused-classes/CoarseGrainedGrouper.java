package org.example.style.grouper;

import org.example.parser.AntlrHelper;

public class CoarseGrainedGrouper implements Grouper {
	private static CoarseGrainedGrouper instance = new CoarseGrainedGrouper();
	public static final int KEYWORD_GROUP = START - 1;
	public static final int LITERAL_GROUP = START - 2;
	public static final int UNARY_OP_GROUP = START - 3;
	public static final int BIN_OP_GROUP = START - 4;

	static String[] names = {
			"keyword", "literal", "unary_operator", "binary_operator"
	};

	private CoarseGrainedGrouper() {
	}

	public static CoarseGrainedGrouper getInstance() {
		return instance;
	}

	@Override
	public int getGroupId(int type) {
		if (AntlrHelper.isKeyword(type)) {
			return KEYWORD_GROUP;
		} else if (AntlrHelper.isLiteral(type)) {
			return LITERAL_GROUP;
		} else if (AntlrHelper.isBinOp(type)) {
			return BIN_OP_GROUP;
		} else if (AntlrHelper.isUnaryOp(type)) {
			return UNARY_OP_GROUP;
		} else {
			return type;
		}
	}

	@Override
	public String getGroupId(int groupId) {
		return names[Math.abs(groupId) + START - 1];
	}

	@Override
	public int getGroupId(String groupName) {
		return switch (groupName) {
			case "keyword" -> KEYWORD_GROUP;
			case "literal" -> LITERAL_GROUP;
			case "unary_operator" -> UNARY_OP_GROUP;
			case "binary_operator" -> BIN_OP_GROUP;
			default -> Integer.MIN_VALUE;
		};
	}

	@Override
	public boolean isBinaryOp(int groupId) {
		return groupId == BIN_OP_GROUP;
	}
}
