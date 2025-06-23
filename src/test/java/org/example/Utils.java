package org.example;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;

import java.util.List;

public class Utils {

	public static void generateTokens(ParseTree root, List<Token> tokens, MyParser parser) {
		if (root instanceof TerminalNode) {
			ExtendToken token = (ExtendToken) (((TerminalNode) root).getSymbol());
			// There are some tokens add around the `token` after style transformations.
			List<Token> contextTokens = token.getContextTokens();
			token.resetContextTokens();
			tokens.addAll(contextTokens);
		} else {
			ExtendContext ctx = (ExtendContext) root;
			for (ParseTree child : ctx.children) {
				generateTokens(child, tokens, parser);
			}
		}
	}
}
