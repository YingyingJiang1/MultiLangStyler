package org.example.styler.format.newline;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.poi.poifs.property.Parent;
import org.example.controller.Controller;
import org.example.controller.Extractor;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.MyParserFactory;
import org.example.parser.common.token.ExtendToken;
import org.example.style.InconsistencyInfo;
import org.example.style.ProgramStyle;
import org.example.style.SelfStyleManager;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.format.indention.IndentionStyler;
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


import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class NewlineStyler extends Styler {
	static int verticalPathLength = 0, horizontalPathLength = 5;
	static double similarityThreshold = 0.7;
	private String newline = "\n";

	// newline styles for different granularity.
	private List<NewlineStyle> newlineStyles;
//	private MutablePair<String, IndentionStyle> styleCache = null; // cache of original indention style.

//	private IndentionStyler indentionStyler = new IndentionStyler(); // styler for target style files.


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
		NodeEditorFactory.createASTEditor(parser.getLanguage()).updateHierarchy(parser, ctx);

		for (int i = 0; i < ctx.getChildCount() - 1; i++) {
			NewlineProperty property = extractProperty(ctx, i, parser);
			NewlineContext context = extractContext(ctx, i, parser);

			if (style instanceof NewlineStyle newlineStyle) {
				NewlineProperty targetProperty = newlineStyle.getProperty(context, similarityThreshold);
				if (targetProperty == null) {
					continue;
				}

				int diff = targetProperty.newlines - property.newlines;
				if (diff > 0) {
					NewlineApplicator.addNewline(ctx.getChild(i), diff, newline, parser);
				} else if (diff < 0) {
					NewlineApplicator.removeNewline(ctx.getChild(i), Math.abs(diff), parser);
				}
			}

		}
		return ctx;
	}

	@Override
	public List<InconsistencyInfo> analyzeInconsistency(ExtendContext ctx, MyParser parser) {
		List<InconsistencyInfo> infos = null;

		for (int i = 0; i < ctx.getChildCount() - 1; i++) {
			NewlineProperty property = extractProperty(ctx, i, parser);
			NewlineContext context = extractContext(ctx, i, parser);

			if (style instanceof NewlineStyle newlineStyle) {
				NewlineProperty targetProperty = newlineStyle.getProperty(context, similarityThreshold);
				if (targetProperty == null || Objects.equals(property, targetProperty)) {
					continue;
				}

				if (infos == null) {
					infos = new ArrayList<>();
				}


				int diff = targetProperty.newlines - property.newlines;
				if (diff > 0) {
					infos.add(NewlineAnalyzer.analyzeWhenAdding(ctx.getChild(i), diff, parser));
				} else if (diff < 0) {
					infos.add(NewlineAnalyzer.analyzeWhenRemoving(ctx.getChild(i), Math.abs(diff), parser));
				}
			}

		}
		return infos;
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

		// Generates indention string( hierarchy indention is excluded).
		String hwsStr = "";
		for (int i = 0; i < formatTokens.size() - 1; i++) {
			// vws hws
			if (formatTokens.get(i).getType() == parser.getVws() && formatTokens.get(i + 1).getType() == parser.getHws()) {
				hwsStr = formatTokens.get(i + 1).getText();
			}
		}
		int hierarchy = 0;
		ParseTree parent = curNode.getParent();
		while (parent != null) {
			if (parent instanceof ExtendContext extCtx) {
				hierarchy = extCtx.hierarchy;
				break;
			}
			parent = parent.getParent();
		}

		Token vwsToken = formatTokens.stream().filter(t -> t.getType() == parser.getVws())
				.findAny().orElse(null);
		if (vwsToken != null) {
			newline = vwsToken.getText().contains("\r\n") ? "\r\n" : "\n";
		}
		return new NewlineProperty(newlineNum, hwsStr, hierarchy);
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

//	private String createExtraIndentionStr(ParseTree node, String fullIndentionStr, MyParser parser) {
//		if (fullIndentionStr.isEmpty()) {
//			return "";
//		}
//
//		int hierarchy = 0;
//		ParseTree parent = node.getParent();
//		ExtendToken token = null;
//		if (node instanceof ExtendContext extCtx && extCtx.getStop() != null) {
//			token = (ExtendToken) extCtx.getStop();
//		} else if(node instanceof TerminalNode ter){
//			token = (ExtendToken) ter.getSymbol();
//		}
//
//		if (token == null) {
//			return "";
//		}
//
//
//		// Extract indention style
//		IndentionProperty property = null;
//		try {
//			if (styleCache == null || !styleCache.left.equals(parser.getSourceFile())) {
//				IndentionStyler styler = new IndentionStyler();
//				Extractor.extractOnTS(parser, List.of(styler));
//				styler.extractFinalize();
//
//				styleCache = new MutablePair<>(parser.getSourceFile(), (IndentionStyle) styler.getStyle());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//
//		if (token != null) {
//			hierarchy = token.getHierarchy();
//		}
//		property = (IndentionProperty) styleCache.right.getProperty(null);
//
//		return fullIndentionStr.replaceFirst(property.getIndentionStr(hierarchy), "");
//	}

}
