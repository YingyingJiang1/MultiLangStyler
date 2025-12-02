package org.example.lang.base;

import org.antlr.v4.runtime.Token;
import org.example.antlr.common.context.RuleGroup;
import org.example.antlr.common.token.TokenGroup;
import org.example.lang.intf.FormatUnitGrouper;
import org.example.lang.intf.MyParser;


public class FormatUnitGrouperBase implements FormatUnitGrouper {
	private static FormatUnitGrouperBase instance = new FormatUnitGrouperBase();


	private FormatUnitGrouperBase() {
	}


	public static FormatUnitGrouperBase getInstance() {
		return instance;
	}

	public TokenGroup getTokenGroup(Token token, MyParser parser) {
		String text = token.getText();
		if (parser.isComment(token.getType())) {
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
		} else if (parser.getUnaryOps().contains(text)) {
			return TokenGroup.UNARY_OP;
		} else if (parser.isLiteral(token.getType())) {
			return TokenGroup.LITERAL;
		} else if (parser.isKeyword(token)) {
			return TokenGroup.KEYWORD;
		}
		return TokenGroup.SELF_TOKEN;
	}

	public RuleGroup getRuleGroup() {
		return null;
	}
}
