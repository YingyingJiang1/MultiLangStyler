package org.example.utils;

import org.antlr.v4.runtime.Token;
import org.example.parser.common.MyParser;

import java.util.ArrayList;
import java.util.List;

public class TokenStreamUtil {
	public static Token findFirstNonWSonLeft(List<Token> tokens, int start, MyParser parser) {
		for (int left = start - 1; left >= 0; left--) {
			int type = tokens.get(left).getType();
			if (type != parser.getHws() && type != parser.getVws()) {
				return tokens.get(left);
			}
		}
		return null;
	}

	public static Token findFirstDefaultTokenOnLeft(List<Token> tokens, int start, MyParser parser) {
		for (int left = start - 1; left >= 0; left--) {
			int channel = tokens.get(left).getChannel();
			if (channel == parser.getDefaultChannel()) {
				return tokens.get(left);
			}
		}
		return null;
	}


	public static Token findFirstDefaultTokenOnRight(List<Token> tokens, int start, MyParser parser) {
		for (int right = start + 1; right < tokens.size(); ++right) {
			int channel = tokens.get(right).getChannel();
			if (channel == parser.getDefaultChannel()) {
				return tokens.get(right);
			}
		}
		return null;
	}


	public static Token findFirstNonWSonRight(List<Token> tokens, int start, MyParser parser) {
		for (int right = start + 1; right < tokens.size(); ++right) {
			int type = tokens.get(right).getType();
			if (type != parser.getHws()) {
				return tokens.get(right);
			}
		}
		return null;
	}

	public static List<Token> findAllSyntaxIndependentTokensOnRight(List<Token> tokens, int start, MyParser parser) {
		List<Token> result = new ArrayList<Token>();
		for (int right = start + 1; right < tokens.size(); ++right) {
			int type = tokens.get(right).getType();
			if (type == parser.getHws() || type == parser.getVws() || parser.belongToComment(type)) {
				result.add(tokens.get(right));
			} else {
				break;
			}
		}
		return result;
	}
}
