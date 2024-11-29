package org.example.parser.common.token;

import org.antlr.v4.runtime.Token;
import org.example.parser.common.MyParser;


public class TokenGrouper {
	private static TokenGrouper instance = new TokenGrouper();


	private TokenGrouper() {
	}


	public static TokenGrouper getInstance() {
		return instance;
	}

	public TokenGroup getGroup(Token token, MyParser parser) {
		String text = token.getText();
		if (parser.belongToComment(token.getType())) {
			return TokenGroup.COMMENT;
		} else if (token.getType() == parser.getIdentifier()) {
			return TokenGroup.IDENTIFIER;
		} else if (token.getText().equals("?")) {
			return TokenGroup.QUESTION;
		} else if (token.getText().equals(":")) {
			return TokenGroup.COLON;
		} else if (token.getText().equals(".")) {
			return TokenGroup.DOT;
		} else if (token.getText().equals("::")) {
			return TokenGroup.COLON_COLON;
		} else if (parser.getBinOps().contains(text)) {
			return TokenGroup.BIN_OP;
		} else if (parser.getBinOps().contains(text)) {
			return TokenGroup.BIN_OP;
		} else if (parser.getUnaryOps().contains(text)) {
			return TokenGroup.UNARY_OP;
		} else if (parser.getLiterals().contains(token.getType())) {
			return TokenGroup.LITERAL;
		} else if (parser.belongToKeyword(token)) {
			return TokenGroup.KEYWORD;
		}
		return TokenGroup.SELF_TOKEN;
	}


//
//	private static void init() {
//		groups.put(TokenGroup.UNARY_OP, new HashSet<>(List.of("~", "++", "--","!", "neg-")));
//		groups.put(TokenGroup.BIN_BIT_OP, new HashSet<>(List.of("&", "^", "|", ">>", ">>>", "<<")));
//		groups.put(TokenGroup.BIN_ASSIGN_OP, new HashSet<>(List.of("=", "+=", "-=", "*=", "/=", "%=", "&=", "^=", "|=", "<<=", ">>=", ">>>=")));
//		groups.put(TokenGroup.BIN_ARITHMETIC_OP, new HashSet<>(List.of("+", "-", "*", "/", "%")));
//		groups.put(TokenGroup.BIN_LOGICAL_OP, new HashSet<>(List.of("&&", "||")));
//		groups.put(TokenGroup.BIN_COMPARE_OP, new HashSet<>(List.of("<", "<=", ">", ">=", "==", "!=")));
//
//
//
//		similarGroups.add(new HashSet<>(List.of("bin_bit_op", "bin_assign_op", "bin_arithmetic_op", "bin_logical_op", "bin_compare_op",
//				"arrow", "colon")));
//
//	}
}
