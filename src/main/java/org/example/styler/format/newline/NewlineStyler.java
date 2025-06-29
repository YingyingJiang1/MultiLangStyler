package org.example.styler.format.newline;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.style.rule.StyleProperty;
import org.example.styler.Styler;
import org.example.styler.format.newline.style.NewlineContext;
import org.example.styler.format.newline.style.NewlineProperty;
import org.example.styler.format.newline.style.NewlineStyle;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewlineStyler extends Styler {
	static int verticalPathLength = 5, horizontalPathLength = 4;
	static double similarityThreshold = 0.8;

	public NewlineStyler() {
		style = new NewlineStyle();
	}

	@Override
	public void extractStyle(ExtendContext ctx, MyParser parser) {
		for (int i = 0; i < ctx.getChildCount() - 1; i++) {
			NewlineProperty property = extractProperty(ctx, i, parser);
			NewlineContext context = extractContext(ctx, i, parser);
			style.addRule(context, property);
		}
	}

	@Override
	public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
		for (int i = 0; i < ctx.getChildCount() - 1; i++) {
			NewlineProperty property = extractProperty(ctx, i, parser);
			NewlineContext context = extractContext(ctx, i, parser);

			if (style instanceof NewlineStyle newlineStyle) {
				NewlineProperty targetProperty = newlineStyle.getProperty(context, similarityThreshold, getWeights(ctx, parser));
				if (targetProperty == null) {
					continue;
				}

				int diff = targetProperty.newlines - property.newlines;
				if (diff > 0) {
					NewlineApplicator.addNewline(ctx.getChild(i), diff, parser);
				} else if (diff < 0) {
					NewlineApplicator.removeNewline(ctx.getChild(i), Math.abs(diff), parser);
				}
			}

		}
		return ctx;
	}

	private List<Double> getWeights(ExtendContext ctx, MyParser parser) {
		return List.of(0.5, 0.5);
	}

	private NewlineContext extractContext(ExtendContext ctx, int index, MyParser parser) {
		ParseTree curNode = ctx.getChild(index);
		Map<String, Integer> verticalVector = new HashMap<>();
		Map<String, Integer> horizontalVector = new HashMap<>();

		ParseTree node = curNode;
		for (int i = 0; i < verticalPathLength; i++) {
			String nodeName = node.getClass().getSimpleName();
			verticalVector.put(nodeName, verticalVector.getOrDefault(nodeName, 0) + 1);

			String lengthKey = String.format("Length:%s", nodeName);
			verticalVector.put(lengthKey, verticalVector.getOrDefault(lengthKey, 0) + node.getText().length());

			node = curNode.getParent();
			if (node == null) {
				break;
			}
		}

		// Add nodes left of `curNode` as horizontal vector
		horizontalVector.put(curNode.getClass().getSimpleName(), 1);
		int count = horizontalPathLength - 1;
		for (int i = 1; count > 0; i++) {
			if (index - i < 0) {
				break;
			}
			String nodeName = ctx.getChild(index - i).getClass().getSimpleName();
			horizontalVector.put(nodeName, horizontalVector.getOrDefault(nodeName, 0) + 1);
			String lengthKey = String.format("Length:%s", nodeName);
			horizontalVector.put(lengthKey, horizontalVector.getOrDefault(lengthKey, 0) + ctx.getChild(index - i).getText().length());
			--count;
		}
		// Add nodes right of `curNode` as horizontal vector
		for (int i = 1; count > 0; i++) {
			if (index + i >= ctx.getChildCount()) {
				break;
			}
			String nodeName = ctx.getChild(index + i).getClass().getSimpleName();
			horizontalVector.put(nodeName, horizontalVector.getOrDefault(nodeName, 0) + 1);
			String lengthKey = String.format("Length:%s", nodeName);
			horizontalVector.put(lengthKey, horizontalVector.getOrDefault(lengthKey, 0) + ctx.getChild(index + i).getText().length());
			--count;
		}


		return new NewlineContext(verticalVector, horizontalVector);
	}

	private NewlineProperty extractProperty(ExtendContext ctx, int index, MyParser parser) {
		ParseTree curNode = ctx.getChild(index);
		ExtendToken curToken = null;
		if (curNode instanceof ExtendContext extCtx) {
			curToken = (ExtendToken) extCtx.getStop();
		} else if (curNode instanceof TerminalNode tNode) {
			curToken = (ExtendToken) tNode.getSymbol();
		}

		ExtendToken nextToken = null;
		if (ctx.getChild(index + 1) instanceof ExtendContext extCtx) {
			nextToken = (ExtendToken) extCtx.getStop();
		} else if (ctx.getChild(index + 1) instanceof TerminalNode tNode) {
			nextToken = (ExtendToken) tNode.getSymbol();
		}

		int numAfterCurToken = curToken == null ? 0 :
				curToken.getContextTokens()
				.subList(curToken.indexInContextTokens() + 1, curToken.getContextTokens().size())
				.stream().mapToInt(t -> t.getType() == parser.getVws() ? (int) t.getText().chars().filter(c -> c == '\n').count() : 0)
				.sum();
		int numBeforeNextToken = nextToken == null ? 0 :
				nextToken.getContextTokens()
				.subList(0, nextToken.indexInContextTokens())
				.stream().mapToInt(t -> t.getType() == parser.getVws() ? (int) t.getText().chars().filter(c -> c == '\n').count() : 0)
				.sum();

		if (curToken != null && curToken.getTrailingCommentIndex(parser) >= 0) {
			numAfterCurToken += 1;
		}
		return new NewlineProperty(numAfterCurToken + numBeforeNextToken);
	}
}
