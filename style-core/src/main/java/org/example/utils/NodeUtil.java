package org.example.utils;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;

import java.util.ArrayList;
import java.util.List;

public class NodeUtil {

	/**
	 * @param node
	 * @return the original code in the source file.
	 */
	public static String getOriginText(ExtendContext node, MyParser parser) {
		List<String> codeLines = new ArrayList<>(List.of(parser.getInputCode().split("\n")));

		int startLine = node.getStart().getLine();
		int endLine = node.getStop().getLine();
		return String.join("\n", codeLines.subList(startLine - 1, endLine));
	}

	public static ExtendToken getStopToken(ParseTree node) {
		ExtendToken token = null;
		if (node instanceof ExtendContext extCtx) {
			token = (ExtendToken) extCtx.getStop();
		} else if (node instanceof TerminalNode tNode) {
			token = (ExtendToken) tNode.getSymbol();
		}
		return token;
	}

	public static ExtendToken getStartToken(ParseTree node) {
		ExtendToken token = null;
		if (node instanceof ExtendContext extCtx) {
			token = (ExtendToken) extCtx.getStart();
		} else if (node instanceof TerminalNode tNode) {
			token = (ExtendToken) tNode.getSymbol();
		}
		return token;
	}

	public static int countNewlineBetween(ExtendToken stop, ExtendToken start, MyParser parser) {
		long newline1 = stop.getContextTokens().subList(stop.getContextTokens().indexOf(stop) + 1, stop.getContextTokens().size())
				.stream().filter(t -> parser.getVws() == t.getType())
				.mapToLong(t -> t.getText().chars().filter(c -> c == '\n').count())
				.sum();
		long newline2 = start.getContextTokens().subList(0, start.getContextTokens().indexOf(start))
				.stream().filter(t -> parser.getVws() == t.getType())
				.mapToLong(t -> t.getText().chars().filter(c -> c == '\n').count())
				.sum();
		return (int) newline1 + (int) newline2;
	}

	public static int countCommentLineBetween(ExtendToken stop, ExtendToken start, MyParser parser) {
		long commentLines = 0;
		commentLines += stop.getContextTokens().subList(stop.getContextTokens().indexOf(stop) + 1, stop.getContextTokens().size())
				.stream().filter(t -> parser.belongToComment(t.getType()))
				.mapToLong(t -> t.getText().chars().filter(c -> c == '\n').count())
				.sum();
		commentLines += start.getContextTokens().subList(0, start.getContextTokens().indexOf(start))
				.stream().filter(t -> parser.belongToComment(t.getType()))
				.mapToLong(t -> t.getText().chars().filter(c -> c == '\n').count())
				.sum();
		return (int) commentLines;
	}
}
