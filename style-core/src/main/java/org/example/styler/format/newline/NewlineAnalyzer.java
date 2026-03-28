package org.example.styler.format.newline;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.common.factory.ExtendTokenFactory;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.token.ExtendToken;
import org.example.style.InconsistencyInfo;
import org.example.style.NewlineInconsistencyInfo;
import org.example.utils.NodeUtil;

import java.util.ArrayList;
import java.util.List;

public class NewlineAnalyzer {
	public static InconsistencyInfo analyzeWhenAdding(ParseTree node, int num, MyParser parser) {
		ExtendToken token = getStopToken(node);
		if (token != null) {
			Token vws = ExtendTokenFactory.DEFAULT.create(parser.getVws(), StringUtils.repeat("\n", num));

			// vws should be inserted after trailing comment or before non-trailing comment.
			int i = token.getTrailingCommentIndex(parser);
			if (i >= 0) {
				return new NewlineInconsistencyInfo(token.getContextTokens().get(i), num);
			} else {
				for (i = token.getContextTokens().size() - 1; i >= 0; i--) {
					int tokenType = token.getContextTokens().get(i).getType();
					boolean isSyntaxRelevant = tokenType != parser.getHws() && tokenType != parser.getVws() && !parser.isComment(tokenType);
					if (isSyntaxRelevant) {
						return new NewlineInconsistencyInfo(token.getContextTokens().get(i), num);
					}
				}
			}
		}
		return null;
	}

	public static InconsistencyInfo analyzeWhenAdding(Token token, int num, MyParser parser) {
		if (token instanceof ExtendToken extendToken) {
			Token vws = ExtendTokenFactory.DEFAULT.create(parser.getVws(), StringUtils.repeat("\n", num));

			// vws should be inserted after trailing comment or before non-trailing comment.
			int i = extendToken.getTrailingCommentIndex(parser);
			if (i >= 0) {
				return new NewlineInconsistencyInfo(extendToken.getContextTokens().get(i), num);
			} else {
				for (i = extendToken.getContextTokens().size() - 1; i >= 0; i--) {
					int tokenType = extendToken.getContextTokens().get(i).getType();
					boolean isSyntaxRelevant = tokenType != parser.getHws() && tokenType != parser.getVws() && !parser.isComment(tokenType);
					if (isSyntaxRelevant) {
						return new NewlineInconsistencyInfo(extendToken.getContextTokens().get(i), num);
					}
				}
			}
		}
		return null;
	}


	public static InconsistencyInfo analyzeWhenRemoving(ParseTree node, int num, MyParser parser) {
		ExtendToken token = getStopToken(node);
		if (token == null) {
			return null;
		}
		return new NewlineInconsistencyInfo(token, -num);
	}

	public static InconsistencyInfo analyzeWhenRemoving(Token token, int num, MyParser parser) {
		return new NewlineInconsistencyInfo(token, -num);
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
