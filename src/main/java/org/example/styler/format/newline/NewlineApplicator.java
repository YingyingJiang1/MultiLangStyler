package org.example.styler.format.newline;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.ExtendTokenFactory;
import org.example.parser.common.factory.TreeNodeFactoryGetter;
import org.example.parser.common.token.ExtendToken;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NewlineApplicator {
	public static void addNewline(ParseTree node, int num, MyParser parser) {
		ExtendToken token = getStopToken(node);
		if (token != null) {
			Token vws = ExtendTokenFactory.DEFAULT.create(parser.getVws(), StringUtils.repeat(System.lineSeparator(), num));

			// vws should be inserted after trailing comment or before non-trailing comment.
			int i = token.getTrailingCommentIndex(parser);
			if (i < 0) {
				for (i = 0; i < token.getContextTokens().size(); i++) {
					if (parser.belongToComment(token.getContextTokens().get(i).getType())) {
						break;
					}
				}
			}
			token.addToken(i, vws);
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
		Iterator<Token> iter = ctxTokens.listIterator(idxInCtxTokens + 1);
		while (iter.hasNext() && toRemove > 0) {
			Token t = iter.next();
			if (t.getType() == parser.getVws() && t instanceof ExtendToken extendToken) {
				int newlineCount = (int) t.getText().chars().filter(c -> c == '\n').count();

				if (toRemove >= newlineCount) {
					iter.remove();
				} else {
					extendToken.setText(StringUtils.repeat(System.lineSeparator(), newlineCount - toRemove));
				}
				toRemove -= newlineCount;
			}
		}
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
