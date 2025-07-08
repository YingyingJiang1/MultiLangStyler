package org.example.styler.format.newline;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.poi.poifs.property.Parent;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.style.SelfStyleManager;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.format.indention.style.IndentionProperty;
import org.example.styler.format.indention.style.IndentionStyle;
import org.example.styler.format.newline.style.BlockLevelNewlineStyle;
import org.example.styler.format.newline.style.NewlineContext;
import org.example.styler.format.newline.style.NewlineProperty;
import org.example.styler.format.newline.style.NewlineStyle;
import org.example.utils.NodeUtil;
import org.example.utils.ParseTreeUtil;
import org.example.utils.editor.NodeEditor;
import org.example.utils.editor.NodeEditorFactory;


import java.util.ArrayList;
import java.util.List;

public class NewlineStyler extends Styler {
	static int verticalPathLength = 0, horizontalPathLength = 5;
	static double similarityThreshold = 0.7;

	// newline styles for different granularity.
	private List<NewlineStyle> newlineStyles;


	public NewlineStyler() {
		style = new NewlineStyle();

		newlineStyles = List.of(
				new BlockLevelNewlineStyle((NewlineStyle) style)
		);
	}

	@Override
	public void extractStyle(ExtendContext ctx, MyParser parser) {
		NodeEditorFactory.createASTEditor(parser.getLanguage()).updateHierarchy(parser, ctx);

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

			// newline is found, add indention string virtually
			if (property.newlines > 0) {
				Token token = null;
				if (ctx.getChild(i) instanceof ExtendContext extendContext) {
					token = extendContext.getStop();
				} else if (ctx.getChild(i) instanceof TerminalNode ter) {
					token = ter.getSymbol();
				}

				if (token instanceof ExtendToken extendToken) {
					extendToken.getContextTokens().forEach(t -> {
						if (t.getType() == parser.getVws() && t instanceof ExtendToken vwsExt) {
							vwsExt.indention = property.hwsStr;
						}
					});
				}
			}

			for (NewlineStyle specificStyle : newlineStyles) {
				NewlineProperty targetProperty = specificStyle.getProperty(context, similarityThreshold);
				if (targetProperty == null) {
					continue;
				}

				int diff = targetProperty.newlines - property.newlines;
				if (diff > 0) {
					NewlineApplicator.addNewline(ctx.getChild(i), diff, targetProperty.hwsStr, parser);
				} else if (diff < 0) {
					NewlineApplicator.removeNewline(ctx.getChild(i), Math.abs(diff), parser);
				}
			}

		}
		return ctx;
	}


	private NewlineContext extractContext(ExtendContext ctx, int index, MyParser parser) {
		ParseTree curNode = ctx.getChild(index);
		List<String> verticalVector = new ArrayList<>();
		List<String> horizontalVector = new ArrayList<>();
		List<Integer> verticalLengthVector = new ArrayList<>();
		List<Integer> horizontalLengthVector = new ArrayList<>();

		String spNodeName = getNodeName(curNode, parser);
		int spLen = getApproxLen(curNode.getText());

		if (verticalPathLength > 0) {
			addVerticalContext(verticalVector, verticalLengthVector, curNode, parser);
		}
		if (horizontalPathLength > 0) {
			addHorizontalContext(horizontalVector, horizontalLengthVector, ctx, index, parser);
		}

		int verticalSP = verticalVector.indexOf(spNodeName);
		int horizontalSP = horizontalVector.indexOf(spNodeName);

		return new NewlineContext(verticalVector, horizontalVector, verticalLengthVector, horizontalLengthVector,
				verticalSP, horizontalSP);
	}

	private void addHorizontalContext(List<String> horizontalVector, List<Integer> horizontalLengthVector,
									  ExtendContext ctx, int index, MyParser parser) {
		ParseTree curNode = ctx.getChild(index);
		String spNodeName = getNodeName(curNode, parser);
		int spLen = getApproxLen(curNode.getText());
		horizontalVector.add(spNodeName);
		horizontalLengthVector.add(spLen);
		int horizontalCount = horizontalPathLength - 1;

		for (int offset = 1; horizontalCount > 0; offset++) {
			boolean extended = false;

			// 向左
			if (index - offset >= 0) {
				ParseTree left = ctx.getChild(index - offset);
				String name = getNodeName(left, parser);
				horizontalVector.add(0, name); // 插到最前面
				horizontalLengthVector.add(0, getApproxLen(left.getText()));
				horizontalCount--;
				extended = true;
			}

			// 向右
			if (index + offset < ctx.getChildCount() && horizontalCount > 0) {
				ParseTree right = ctx.getChild(index + offset);
				String name = getNodeName(right, parser);
				horizontalVector.add(name); // 插到末尾
				horizontalLengthVector.add(getApproxLen(right.getText()));
				horizontalCount--;
				extended = true;
			}

			if (!extended) break;
		}
	}

	private NewlineProperty extractProperty(ExtendContext ctx, int index, MyParser parser, Stage stage) {
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


		List<Token> formatTokens = new ArrayList<>(curToken == null ? new ArrayList<>() :
				curToken.getContextTokens()
						.subList(curToken.indexInContextTokens() + 1, curToken.getContextTokens().size())
						.stream()
						.filter(t -> t.getType() == parser.getVws() || t.getType() == parser.getHws())
						.toList());

		formatTokens.addAll(
				nextToken == null ? new ArrayList<>() :
						nextToken.getContextTokens().subList(0, nextToken.indexInContextTokens())
								.stream()
								.filter(t -> t.getType() == parser.getVws() || t.getType() == parser.getHws())
								.toList()
		);

		int newlineNum = formatTokens.stream()
				.mapToInt(t -> t.getType() == parser.getVws() ? (int) t.getText().chars().filter(c -> c == '\n').count() : 0)
				.sum();

		if (curToken != null && curToken.getTrailingCommentIndex(parser) >= 0) {
			newlineNum += 1;
		}

		String hwsStr = "";
		for (int i = 0; i < formatTokens.size() - 1; i++) {
			// vws hws
			if (formatTokens.get(i).getType() == parser.getVws() && formatTokens.get(i + 1).getType() == parser.getHws()) {
				hwsStr = formatTokens.get(i + 1).getText();
			}
		}
//
//		int hierarchy = 0;
//		ParseTree parent = curNode.getParent();
//		while (parent != null) {
//			if (parent instanceof ExtendContext extCtx) {
//				hierarchy = extCtx.hierarchy;
//				break;
//			}
//			parent = parent.getParent();
//		}



		return new NewlineProperty(newlineNum, hwsStr);
	}

	private void addVerticalContext(List<String> verticalVector, List<Integer> verticalLengthVector,
									ParseTree curNode, MyParser parser) {
		String spNodeName = getNodeName(curNode, parser);
		int spLen = getApproxLen(curNode.getText());
		verticalVector.add(spNodeName);
		verticalLengthVector.add(spLen);
		int verticalCount = verticalPathLength - 1;
		ParseTree node = curNode;
		for (int offset = 1; verticalCount > 0; offset++) {
			boolean extended = false;

			// 向上 parent
			ParseTree parent = node.getParent();
			if (parent != null) {
				String name = getNodeName(parent,parser);
				verticalVector.add(0, name); // 插到最前面
				verticalLengthVector.add(0, getApproxLen(parent.getText()));
				verticalCount--;
				extended = true;
				node = parent; // 向上继续
			}

			// 向下：尝试获取 child 节点（选第一个 child）
//			if (verticalCount > 0 && curNode.getChildCount() >= offset) {
//				ParseTree child = curNode.getChild(offset - 1);
//				if (child != null) {
//					String name = getNodeName(child, parser);
//					verticalVector.add(name); // 插到末尾
//					verticalLengthVector.add(getApproxLen(child.getText()));
//					verticalCount--;
//					extended = true;
//				}
//			}

			if (!extended) break;
		}
	}


	private String getNodeName(ParseTree node, MyParser parser) {
		if (node instanceof TerminalNode ter) {
			return parser.getTokenName(ter.getSymbol().getType());
		} else {
			return node.getClass().getSimpleName();
		}
	}

	private int getApproxLen(String text) {
		int len = text.length();
		int mod = len % 10;
		if (mod >= 5) {
			return len + (10 - mod); // 向上凑
		} else {
			return len - mod;        // 向下凑
		}
	}

}
