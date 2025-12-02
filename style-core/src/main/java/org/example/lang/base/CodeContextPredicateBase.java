package org.example.lang.base;

import org.antlr.v4.runtime.Token;
import org.example.lang.intf.CodeContextPredicate;
import org.example.lang.intf.MyParser;

import java.util.List;

public class CodeContextPredicateBase implements CodeContextPredicate {
	private static CodeContextPredicateBase instance = new CodeContextPredicateBase();

	protected CodeContextPredicateBase(){}

	public static CodeContextPredicate getInstance() {
		return instance;
	}

	@Override
	public boolean isIndentionContext(List<Token> tokens, int i, MyParser parser) {
		return false;
	}

	@Override
	public boolean isSpaceContext(List<Token> tokens, int i, MyParser parser) {
		int type = tokens.get(i).getType();

		// Excluded cases: adjacent identifiers and keywords
		if (parser.getIdentifier() == type || isKeyword(tokens.get(i).getText())) {
			if (i + 1 < tokens.size()) {
				Token nextToken = tokens.get(i + 1);
				if (nextToken.getType() == parser.getIdentifier() || isKeyword(nextToken.getText())) {
					return false;
				}
			}
		}

		return type != parser.getHws() && type != parser.getVws() && !parser.isComment(type);
	}

	private boolean isKeyword(String text) {
		return text.matches("[a-zA-Z]+");
	}
}
