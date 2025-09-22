package org.example.styler.format.newline;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;
import org.example.RunStatistic;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.ExtendTokenFactory;
import org.example.parser.common.factory.TreeNodeFactoryGetter;
import org.example.parser.common.token.ExtendToken;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NewlineApplicator {
	public static Token addNewline(ParseTree node, int num,  MyParser parser) {
		ExtendToken token = getStopToken(node);
		if (token != null) {
			Token vws = ExtendTokenFactory.DEFAULT.create(parser.getVws(), StringUtils.repeat("\n", num));

			// vws should be inserted after trailing comment or before non-trailing comment.
			int i = token.getTrailingCommentIndex(parser);
			if (i < 0) {
				for (i = 0; i < token.getContextTokens().size(); i++) {
					if (parser.belongToComment(token.getContextTokens().get(i).getType())) {
						break;
					}
				}
			} else {
				i++;
			}
			token.addToken(i, vws);
			return vws;
		}
		return null;
	}

	public static void addNewline(Token token, int num, MyParser parser) {
		if (token instanceof ExtendToken extendToken) {
			Token vws = ExtendTokenFactory.DEFAULT.create(parser.getVws(), StringUtils.repeat("\n", num));

			// vws should be inserted after trailing comment or before non-trailing comment.
			int i = extendToken.getTrailingCommentIndex(parser);
			if (i < 0) {
				for (i = 0; i < extendToken.getContextTokens().size(); i++) {
					if (parser.belongToComment(extendToken.getContextTokens().get(i).getType())) {
						break;
					}
				}
			}
			extendToken.addToken(i, vws);
		}
	}

	public static void removeNewline(Token token, int num, MyParser parser) {
		if (token instanceof ExtendToken extToken) {
			List<Token> ctxTokens = extToken.getContextTokens();
			int idxInCtxTokens = extToken.indexInContextTokens();
			int toRemove = num;
			List<Token> newCtxTokens = new ArrayList<>(ctxTokens.subList(0, idxInCtxTokens + 1));
			for (int i = idxInCtxTokens + 1; i < ctxTokens.size(); i++) {
				Token t = ctxTokens.get(i);
				if (t.getType() == parser.getVws() && t instanceof ExtendToken extendToken) {
					int newlineCount = (int) t.getText().chars().filter(c -> c == '\n').count();

					if (toRemove >= newlineCount) {
						// Hws after the removed Vws should also be removed.
						if (i + 1 < ctxTokens.size() && ctxTokens.get(i + 1).getType() == parser.getHws()) {
							i++;
						}
					} else {
						extendToken.setText(StringUtils.repeat("\n", newlineCount - toRemove));
						newCtxTokens.add(extendToken);
					}
					toRemove -= newlineCount;
				} else {
					newCtxTokens.add(t);
				}
			}
			extToken.setContextTokens(newCtxTokens);
		}
	}


	public static void removeNewline(ParseTree node, int num, MyParser parser) {
		ExtendToken token = getStopToken(node);
		if (token == null) {
			return;
		}
		List<Token> ctxTokens = token.getContextTokens();
		int idxInCtxTokens = token.indexInContextTokens();

		int toRemove = num;
		List<Token> newCtxTokens = new ArrayList<>(ctxTokens.subList(0, idxInCtxTokens + 1));
		for (int i = idxInCtxTokens + 1; i < ctxTokens.size(); i++) {
			Token t = ctxTokens.get(i);
			if (t.getType() == parser.getVws() && t instanceof ExtendToken extendToken) {
				int newlineCount = (int) t.getText().chars().filter(c -> c == '\n').count();

				if (toRemove >= newlineCount) {
					// Hws after the removed Vws should also be removed.
					if (i + 1 < ctxTokens.size() && ctxTokens.get(i + 1).getType() == parser.getHws()) {
						i++;
					}
				} else {
					extendToken.setText(StringUtils.repeat("\n", newlineCount - toRemove));
					newCtxTokens.add(extendToken);
				}
				toRemove -= newlineCount;
			} else {
				newCtxTokens.add(t);
			}
		}
		token.setContextTokens(newCtxTokens);

	}



	private static ExtendToken getStopToken(ParseTree node) {
		ExtendToken token = null;
		if (node instanceof ExtendContext extCtx) {
			token = (ExtendToken) extCtx.getStop();
		} else if (node instanceof TerminalNode tNode) {
			token = (ExtendToken) tNode.getSymbol();
		}
		return token;
	}
}
