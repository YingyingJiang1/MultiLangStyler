package org.example.styler.format.newline;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.RunStatistic;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.style.InconsistencyInfo;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.format.newline.inter.InterNewlineStyler;
import org.example.styler.format.newline.inter.style.InterNewlineContext;
import org.example.styler.format.newline.intra.IntraNewlineStyler;
import org.example.styler.format.newline.style.BlockLevelNewlineStyle;
import org.example.styler.format.newline.style.NewlineContext;
import org.example.styler.format.newline.style.NewlineProperty;
import org.example.styler.format.newline.style.NewlineStyle;
import org.example.utils.editor.NodeEditorFactory;

public class NewlineStyler extends Styler {
    static int verticalPathLength = 0;
    static int horizontalPathLength = 2;
    static double similarityThreshold = 0.7;
    private String newline = "\n";
	private int LINE_TOLERANCE = 1;
	private int TEXT_LEN_TOLERANCE = 20;


	// 补充的newline stylers， 处理更加细节的换行
	List<Styler> stylers = List.of(
//			new IntraNewlineStyler(),
//			new InterNewlineStyler()
	);


	public NewlineStyler() {
		style = new NewlineStyle();

	}

	@Override
	public void extractStyle(ExtendContext ctx, MyParser parser) {
		NodeEditorFactory.createASTEditor(parser.getLanguage()).updateHierarchy(parser, ctx);

		for (int i = 0; i < ctx.getChildCount() - 1; i++) {
			NewlineProperty property = extractProperty(ctx, i, parser);
			NewlineContext context = extractContext(ctx, i, parser);
			style.addRule(context, property);
		}

		for (Styler styler : stylers) {
			if (styler.isRelevant(ctx, Stage.EXTRACT, parser)) {
				styler.extractStyle(ctx, parser);
			}
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
					RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
				} else if (diff < 0) {
					NewlineApplicator.removeNewline(ctx.getChild(i), Math.abs(diff), parser);
					RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
				}
			}

		}

		for (Styler styler : stylers) {
			if (styler.isRelevant(ctx, Stage.APPLY, parser)) {
				styler.applyStyle(ctx, parser);
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
		int spLen = getApproxLen(curNode, parser);

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
		int spLen = getApproxLen(curNode, parser);
		horizontalVector.add(spNodeName);
		horizontalLengthVector.add(spLen);
		int horizontalCount = horizontalPathLength - 1;

		for (int offset = 1; horizontalCount > 0; offset++) {
			boolean extended = false;

			// 向右
			if (index + offset < ctx.getChildCount() && horizontalCount > 0) {
				ParseTree right = ctx.getChild(index + offset);
				String name = getNodeName(right, parser);
				horizontalVector.add(name); // 插到末尾
				horizontalLengthVector.add(getApproxLen(right, parser));
				horizontalCount--;
				extended = true;
			}

			// 向左
			if (index - offset >= 0) {
				ParseTree left = ctx.getChild(index - offset);
				String name = getNodeName(left, parser);
				horizontalVector.add(0, name); // 插到最前面
				horizontalLengthVector.add(0, getApproxLen(left, parser));
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
		int spLen = getApproxLen(curNode, parser);
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
				verticalLengthVector.add(0, getApproxLen(parent, parser));
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
			int rule = ((ExtendContext) node).getRuleIndex();
			if (parser.isStatement(node)) {
				rule = parser.getSpecificStmtType((ExtendContext) node);
			}
			if (rule == parser.getRuleIfStmt() || rule == parser.getRuleIfElseStmt() || rule == parser.getRuleSwitchStmt()) {
				return "BRANCH_STMT";
			} else if (rule == parser.getRuleForStmt() || rule == parser.getRuleWhileStmt() || rule == parser.getRuleDoWhileStmt()) {
				return "LOOP_STMT";
			} else if (parser.belongToSingleStmt(node) && rule != parser.getRuleLocalVarDeclarationStmt()) {
				return "SINGLE_STMT";
			}
			return parser.getRuleName(rule);
		}
	}

	private int getApproxLen(ParseTree node, MyParser parser) {

		int n = TEXT_LEN_TOLERANCE;
		if (parser.isStatement(node)) {
			n = LINE_TOLERANCE;
		}

		int textLength = node.getText().length();
		int lower = (textLength / n) * n;         // 向下取最近的倍数
		int upper = lower + n;                    // 向上取最近的倍数

		// 判断哪个更近
		if (textLength - lower <= upper - textLength) {
			return lower;
		} else {
			return upper;
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
