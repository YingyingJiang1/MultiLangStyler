package org.example.styler.format.newline;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.lang3.StringUtils;
import org.example.controller.Applicator;
import org.example.parser.common.MyParser;
import org.example.parser.common.token.ExtendToken;
import org.example.style.InconsistencyInfo;
import org.example.styler.format.newline.style.NewlineInconsistencyInfo;
import org.example.utils.NodeUtil;

import java.util.ArrayList;
import java.util.List;

public class NewlineAnalyzer {
	public static InconsistencyInfo analyzeWhenAdding(ParseTree node, int num, MyParser parser) {
		ExtendToken token = NodeUtil.getStopToken(node);
		if (token != null) {
			// vws should be inserted after trailing comment or before non-trailing comment.
			int i = token.getTrailingCommentIndex(parser);
			if (i < 0) {
				for (i = 0; i < token.getContextTokens().size(); i++) {
					if (parser.belongToComment(token.getContextTokens().get(i).getType())) {
						break;
					}
				}
			}

			if (i < token.getContextTokens().size()) {
				token = (ExtendToken) token.getContextTokens().get(i);
			}

			int[] loc = {token.getLine(), token.getCharPositionInLine()};
			return new NewlineInconsistencyInfo(loc, loc, "Too few line breaks");
		}

		return null;
	}

	public static InconsistencyInfo analyzeWhenRemoving(ParseTree node, int num, MyParser parser) {
		ExtendToken token = NodeUtil.getStopToken(node);
		if (token == null) {
			return null;
		}
		List<Token> ctxTokens = token.getContextTokens();
		int idxInCtxTokens = token.indexInContextTokens();

		int toRemove = num;
		List<Token> removeList = new ArrayList<>();
		for (int i = idxInCtxTokens + 1; i < ctxTokens.size(); i++) {
			Token t = ctxTokens.get(i);
			if (t.getType() == parser.getVws() && t instanceof ExtendToken extendToken) {
				int newlineCount = (int) t.getText().chars().filter(c -> c == '\n').count();

				if (toRemove >= newlineCount) {
					// Hws after the removed Vws should also be removed.
					if (i + 1 < ctxTokens.size() && ctxTokens.get(i + 1).getType() == parser.getHws()) {
						removeList.add(ctxTokens.get(i + 1));
						i++;
					}
				}
				removeList.add(t);
				toRemove -= newlineCount;
			}
		}

		if (removeList.isEmpty()) {
			return null;
		}
		int[] startLoc = {removeList.get(0).getLine(), removeList.get(0).getCharPositionInLine()};
		int[] endLoc = {removeList.get(removeList.size() - 1).getLine(), removeList.get(removeList.size() - 1).getCharPositionInLine()};
		return new NewlineInconsistencyInfo(startLoc, endLoc, "Too many line breaks");
	}
}
