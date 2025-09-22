package org.example.styler.format.newline;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.RunStatistic;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.style.InconsistencyInfo;
import org.example.style.rule.StyleRule;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.format.newline.style.NewlineContext;
import org.example.styler.format.newline.style.NewlineProperty;
import org.example.styler.format.newline.style.NewlineStyle;
import org.example.utils.NodeUtil;
import org.example.utils.ParseTreeUtil;

public class NewlineStyler extends Styler {
    static int verticalPathLength = 0;
    static int horizontalPathLength = 2;
    static double similarityThreshold = 0.7;
    private String newline = "\n";
	private int LINE_TOLERANCE = 1;
	private int TEXT_LEN_TOLERANCE = 1;


	// 补充的newline stylers， 处理更加细节的换行
//	List<Styler> stylers = List.of(
//			new IntraNewlineStyler(),
//			new InterNewlineStyler(),
//			new BodyLayoutStyler()
//	);

	List<Styler> pathchStyler = List.of(
			new AnnotationNewlinePatchStyler()
	);


	public NewlineStyler() {
		executeWhenExit = false;
		style = new NewlineStyle();

	}

	@Override
	public void extractStyle(ExtendContext ctx, MyParser parser) {
		for (Styler styler : pathchStyler) {
			if (styler.isRelevant(ctx, Stage.EXTRACT, parser)) {
				styler.extractStyle(ctx, parser);
				return;
			}
		}

		for (int i = 0; i < ctx.getChildCount() - 1; i++) {
			StyleRule rule = extractStyleRule(ctx, i, parser);
			if (rule != null) {
				style.addRule(rule.getStyleContext(), rule.getStyleProperty());
			}
		}

//		for (Styler styler : stylers) {
//			if (styler.isRelevant(ctx, Stage.EXTRACT, parser)) {
//				styler.extractStyle(ctx, parser);
//			}
//		}

	}

	@Override
	public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
		for (Styler styler : pathchStyler) {
			if (styler.isRelevant(ctx, Stage.APPLY, parser)) {
				styler.applyStyle(ctx, parser);
				return ctx;
			}
		}

		for (int i = 0; i < ctx.getChildCount() - 1; i++) {
			StyleRule rule = extractStyleRule(ctx, i, parser);
			if (rule == null) {
				continue;
			}

			NewlineContext context = (NewlineContext) rule.getStyleContext();
			NewlineProperty property = (NewlineProperty) rule.getStyleProperty();


			if (style.getProperty(context) instanceof NewlineProperty targetProperty) {
				int diff = targetProperty.newlines - property.newlines;
				if (diff > 0) {
					NewlineApplicator.addNewline(ctx.getChild(i), diff, parser);
					RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
				} else if (diff < 0) {
					NewlineApplicator.removeNewline(ctx.getChild(i), Math.abs(diff), parser);
					RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
				}
			}

		}

//		for (Styler styler : stylers) {
//			if (styler.isRelevant(ctx, Stage.APPLY, parser)) {
//				styler.applyStyle(ctx, parser);
//			}
//		}

		return ctx;
	}

	@Override
	public List<InconsistencyInfo> analyzeInconsistency(ExtendContext ctx, MyParser parser) {
		List<InconsistencyInfo> infos = null;

		for (int i = 0; i < ctx.getChildCount() - 1; i++) {
			StyleRule rule = extractStyleRule(ctx, i, parser);
			if (rule == null) {
				continue;
			}

			NewlineContext context = (NewlineContext) rule.getStyleContext();
			NewlineProperty property = (NewlineProperty) rule.getStyleProperty();


			if (style instanceof NewlineStyle newlineStyle) {
				if (newlineStyle.getProperty(context) instanceof NewlineProperty targetProperty && !Objects.equals(property, targetProperty)) {
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

		}
		return infos;
	}

	protected StyleRule extractStyleRule(ExtendContext ctx, int index, MyParser parser) {
		List<NewlineContext.NodeType> nodeTypes = new ArrayList<>();
		ParseTree curNode = ctx.getChild(index);
		ParseTree nextNode = getNextAdjacentNode(curNode);
		if (nextNode == null) {
			return null;
		}

		nodeTypes.add(getNodeType(curNode, parser));
		nodeTypes.add(getNodeType(nextNode, parser));
		int breakIndex = 1;
		double totalTextLen = getApproxLen(curNode, parser) + getApproxLen(nextNode, parser);

		int count = horizontalPathLength - 2;

		boolean notReachRightNewline = true, notReachLeftNewline = true;
		for (int leftIndex = index - 1, rightIndex = index + 2; count > 0 && (rightIndex < ctx.getChildCount() || leftIndex >= 0); --leftIndex, ++rightIndex) {
			boolean extended = false;

			// 向右
			if (rightIndex < ctx.getChildCount() && count > 0) {
				ParseTree right = ctx.getChild(rightIndex);
				ExtendToken stop = NodeUtil.getStopToken(ctx.getChild(rightIndex - 1));
				ExtendToken start = NodeUtil.getStartToken(right);

				boolean notInSameLine = stop == null || start == null || NodeUtil.countNewlineBetween(stop, start, parser) > 0;
				if (notInSameLine) {
					notReachRightNewline = false;
				}

				if (notReachRightNewline) {
					nodeTypes.add( getNodeType(right, parser));
					count--;
					totalTextLen += getApproxLen(right, parser);
				}
			}

			// 向左
			if (leftIndex >= 0 && count > 0) {
				ParseTree left = ctx.getChild(leftIndex);
				ExtendToken stop = NodeUtil.getStopToken(left);
				ExtendToken start = NodeUtil.getStartToken(ctx.getChild(leftIndex + 1));

				boolean notInSameLine = stop == null || start == null || NodeUtil.countNewlineBetween(stop, start, parser) > 0;
				if (notInSameLine) {
					notReachLeftNewline = false;
				}

				if (notReachLeftNewline) {
					nodeTypes.add(0, getNodeType(left, parser));
					++breakIndex;
					count--;
					totalTextLen += getApproxLen(left, parser);
				}
			}
		}

		ExtendToken stop = NodeUtil.getStopToken(curNode);
		ExtendToken start = NodeUtil.getStartToken(nextNode);

		if (start == null || stop == null) {
			return null;
		}

		int newlineCount = NodeUtil.countNewlineBetween(stop, start, parser);
		NewlineContext context = new NewlineContext(nodeTypes, List.of(totalTextLen));
		NewlineProperty property = new NewlineProperty(newlineCount, breakIndex);
		return new StyleRule(context, property);
	}


	private NewlineContext.NodeType getNodeType(ParseTree node, MyParser parser) {
		if (node instanceof TerminalNode ter) {
			String name = "";
			if (parser.belongToKeyword(ter.getSymbol())) {
				name = "KEYWORD";
			} else if (ter.getSymbol().getType() == parser.getIdentifier()) {
				name = "IDENTIFIER";
			} else {
				name = parser.getTokenName(ter.getSymbol().getType());
			}
			return new NewlineContext.NodeType(name, false);
		} else {
			int rule = ((ExtendContext) node).getRuleIndex();
			if (parser.isStatement(node)) {
				rule = parser.getSpecificStmtType((ExtendContext) node);
			}
			if (rule == parser.getRuleIfStmt() || rule == parser.getRuleIfElseStmt() || rule == parser.getRuleSwitchStmt()) {
				return new NewlineContext.NodeType("BRANCH_STMT");
			} else if (rule == parser.getRuleForStmt() || rule == parser.getRuleWhileStmt() || rule == parser.getRuleDoWhileStmt()) {
				return new NewlineContext.NodeType("LOOP_STMT");
			} else if (parser.isStatement(node) && node.getChild(0) instanceof TerminalNode) {
				return new NewlineContext.NodeType("EMPTY_STMT");
			} else if (parser.belongToSingleStmt(node) && rule != parser.getRuleLocalVarDeclarationStmt()) {
				return new NewlineContext.NodeType("SINGLE_STMT");
			}
			return new NewlineContext.NodeType(parser.getRuleName(rule));
		}
	}

	private int getApproxLen(ParseTree node, MyParser parser) {

		int n = TEXT_LEN_TOLERANCE;

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


	private ParseTree getNextAdjacentNode(ParseTree cur) {
		if (cur.getParent() == null) {
			return null;
		}

		ParserRuleContext parent = (ParserRuleContext) cur.getParent();
		int idx = parent.children.indexOf(cur);
		if (idx + 1 < parent.getChildCount()) {
			return parent.getChild(idx + 1);
		}
		return null;

		// 遍历祖先节点
//		ParseTree node = cur;
//		while (parent != null && parent.getChild(parent.getChildCount() - 1) == node) {
//			node = parent;
//			parent = parent.getParent();
//		}
//		return parent == null ? null : parent.getChild(parent.children.indexOf(node) + 1);
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
