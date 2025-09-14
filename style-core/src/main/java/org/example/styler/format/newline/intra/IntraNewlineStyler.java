package org.example.styler.format.newline.intra;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.format.newline.NewlineApplicator;
import org.example.styler.format.newline.intra.style.IntraNewlineContext;
import org.example.styler.format.newline.intra.style.IntraNewlineProperty;
import org.example.styler.format.newline.intra.style.IntraNewlineStyle;
import org.example.utils.NodeUtil;
import org.example.utils.TokenStreamUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * 专注于单个语法树节点内部的换行符使用习惯
 */
public class IntraNewlineStyler extends Styler {
	public IntraNewlineStyler() {
//		executeWhenExit = false;
		style = new IntraNewlineStyle();
	}

	@Override
	public void extractStyle(ExtendContext ctx, MyParser parser) {
		ExtendContext targetNode = ctx;
		if (parser.belongToSingleStmt(ctx) || parser.getRuleParExpression() == ctx.getRuleIndex()) {
			targetNode = ctx.getFirstCtxChildIf(parser::isExpression);
		}
		if (targetNode == null) {
			return;
		}
		IntraNewlineContext newlineContext = extractContext(targetNode, parser);
		IntraNewlineProperty property = extractProperty(targetNode, parser, newlineContext);
		if (property.newlines > 0) {
			style.addRule(newlineContext, property);
		}
	}

	@Override
	public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
		ExtendContext targetNode = ctx;
		if (parser.belongToSingleStmt(ctx) || parser.getRuleParExpression() == ctx.getRuleIndex()) {
			targetNode = ctx.getFirstCtxChildIf(parser::isExpression);
		}
		if (targetNode == null) {
			return ctx;
		}

		IntraNewlineContext context =  extractContext(targetNode, parser);
		IntraNewlineProperty property = extractProperty(targetNode, parser, context);
		IntraNewlineProperty targetProperty = (IntraNewlineProperty) style.getProperty(context);

		if (!property.equals(targetProperty)) {
			List<TerminalNode> terminalNodes = targetNode.getAllTerminalsRecIf(e -> true);

			// 确保移除原来的所有换行
			for (TerminalNode terminalNode : terminalNodes) {
				NewlineApplicator.removeNewline(terminalNode.getSymbol(), 100, parser);
			}

			if (targetProperty.newlines == 1) {
				// 按照新的策略添加换行
				if (targetNode.getRuleIndex() == parser.getRuleformalParameterList()) {
					applyOnFormalParameterList(terminalNodes, context, targetProperty, parser);
				} else {
					applyOnExpression(terminalNodes, context, targetProperty, parser);
				}
			}
		}
		return ctx;
	}

	private boolean isBreakASTNode(int rule, MyParser parser) {
		return rule == parser.getRuleExpression() || rule == parser.getRuleformalParameterList();
	}

	private void applyOnFormalParameterList(List<TerminalNode> terminalNodes, IntraNewlineContext context, IntraNewlineProperty targetProperty, MyParser parser) {
		List<Integer> breakLoc = List.of(parser.getComma());
		int targetLen = (int) (context.length * targetProperty.lineLengthRatio);
		int cumulativeLength = 0, succeedLineNumber = 0;
		for (int i = 0; i < terminalNodes.size(); i++) {
			TerminalNode terminalNode = terminalNodes.get(i);
			cumulativeLength += terminalNode.getText().length();
			if (cumulativeLength >= targetLen && breakLoc.contains(terminalNode.getSymbol().getType())) {
				++succeedLineNumber;
				addNewline(terminalNodes, i, targetProperty, succeedLineNumber, parser);
				cumulativeLength = 0;
			}
		}

	}

	private void applyOnExpression(List<TerminalNode> terminalNodes, IntraNewlineContext context, IntraNewlineProperty targetProperty, MyParser parser) {
		List<String> breakTokens = List.of("&&", "||", "?", ":");
		// 表达式能够由break token划分为多个独立的子表达式。例如：如果 &&出现在函数参数计算时，就是不满足条件的
		BiPredicate<TerminalNode, MyParser> inCompoundExp = new BiPredicate<TerminalNode, MyParser>() {
			@Override
			public boolean test(TerminalNode terminalNode, MyParser parser) {
				ParseTree parent = terminalNode.getParent();
				while (parent instanceof ExtendContext ctx) {
					if (parser.getRuleExpression() != ctx.getRuleIndex()) {
						break;
					}
					for (ParseTree child : ctx.children) {
						if (child instanceof TerminalNode terNode && !breakTokens.contains(terNode.getText())) {
							return false;
						}
					}
					parent = parent.getParent();
				}

				return true;
			}
		};

		int targetLen = (int) (context.length * targetProperty.lineLengthRatio);
		int cumulativeLength = 0, succeedLineNumber = 0;
		int lastHighPriorityBreak = -1; // 高优先级 break 点
		int lastLowPriorityBreak = -1;  // 普通表达式 break 点

		for (int i = 0; i < terminalNodes.size(); i++) {
			TerminalNode terminalNode = terminalNodes.get(i);
			cumulativeLength += terminalNode.getText().length();

			if (breakTokens.contains(terminalNode.getText()) && inCompoundExp.test(terminalNode, parser)) {
				lastHighPriorityBreak = i;
			}

			ExtendContext expParent = ((ExtendContext) terminalNode.getParent()).findFirstParentIf(parser::isExpression);
			boolean isExpressionStop = expParent != null && expParent.getChildCount() > 1 && expParent.getStop() == terminalNode.getSymbol();
			if (isExpressionStop) {
				lastLowPriorityBreak = i;
			}


			if (cumulativeLength >= targetLen) {
				int breakPos = -1;
				if (lastHighPriorityBreak >= 0) {
					breakPos = lastHighPriorityBreak - 1;
				} else {
					breakPos = lastLowPriorityBreak;
				}

				if (breakPos >= 0) {
					succeedLineNumber++;
					addNewline(terminalNodes, breakPos, targetProperty, succeedLineNumber, parser);

					cumulativeLength = 0;
					lastHighPriorityBreak = -1;
					lastLowPriorityBreak = -1;
				}
			}
		}
	}

//	if (breakTokens.contains(terminalNode.getText())) {
//		++succeedLineNumber;
//		// add newline before break tokens.
//		addNewline(terminalNodes, i - 1, targetProperty, succeedLineNumber, parser);
//		cumulativeLength = 0;
//	} else {
//		boolean isExpressionStop = parser.isExpression(terminalNode.getParent()) && terminalNode;
//
//		cumulativeLength = 0;
//	}

	private void addNewline(List<TerminalNode> terminalNodes, int i, IntraNewlineProperty targetProperty, int succeedLineNumber, MyParser parser) {
		TerminalNode terminalNode = terminalNodes.get(i);
		// 添加换行
		NewlineApplicator.addNewline(terminalNode.getSymbol(), targetProperty.newlines, parser);
		// 记录后继行的相对缩进
		String relativeIndention = targetProperty.getRelativeIndention(succeedLineNumber);
		if (terminalNodes.get(i + 1).getSymbol() instanceof ExtendToken extendToken) {
			extendToken.setExtraIndention(relativeIndention);
		}
	}

	private IntraNewlineContext extractContext(ExtendContext ctx, MyParser parser) {
		int len = ctx.getText().length();
		return new IntraNewlineContext(len);
	}

	private IntraNewlineProperty extractProperty(ExtendContext ctx, MyParser parser, IntraNewlineContext context) {
		IntraNewlineProperty noNewlineProperty = new IntraNewlineProperty(0);
		List<Token> tokens = ctx.getAllExpandedTokensRec();
		long newlineCount = tokens.stream().filter(t -> t.getType() == parser.getVws())
				.mapToLong(t -> t.getType() == parser.getVws() ? t.getText().chars().filter(ch -> ch == '\n').count() : 0)
				.sum();

		boolean inSameLine = newlineCount == 0;
		if (inSameLine) {
			return noNewlineProperty;
		}

		// 获取首行缩进
		List<Token> sameLineTokensBefore = getSameLineTokensBefore(ctx, parser);
		String indentionStr = "";
		if (!sameLineTokensBefore.isEmpty() && sameLineTokensBefore.get(0).getType() == parser.getHws()) {
			indentionStr = sameLineTokensBefore.get(0).getText();
		}

		Token indentionToken = null;
		IntraNewlineProperty property = new IntraNewlineProperty(1);
		int cumulativeLength = 0;
		int totalLength = (int) context.length;
		List<String> relativeIndention = new ArrayList<>();
		List<Double> ratios = new ArrayList<>(); // 每行长度占总长度的百分比
		for (int i = 1; i < tokens.size() - 1; i++) {
			Token token = tokens.get(i);
			cumulativeLength += token.getText().length();
			// 碰到换行
			if (tokens.get(i).getType() == parser.getVws()) {
				// 计算长度百分比
				double ratio = (double) cumulativeLength / totalLength;
				ratios.add(ratio);

				// 计算相对缩进
				String relativeStr = "";
				indentionToken = tokens.get(i + 1);
				if (indentionToken.getType() == parser.getHws()) {
					relativeStr = indentionToken.getText().replaceFirst(indentionStr, "");
					relativeIndention.add(relativeStr);
					indentionStr = indentionToken.getText();
				}
				cumulativeLength = 0;

				// 计算换行位置
				Token left = TokenStreamUtil.findFirstNonWSonLeft(tokens, i, parser);
				Token right = TokenStreamUtil.findFirstNonWSonRight(tokens, i, parser);
//				property.updateBreakLoc(left.getText(), true);
//				property.updateBreakLoc(right.getText(), false);

				// !! 存储相对缩进，防止后续缩进对齐导致的缩进丢失
				if (right instanceof ExtendToken extendToken) {
					extendToken.setExtraIndention(relativeStr);
				}
			}
		}

		if (!ratios.isEmpty()) {
			double ratio = Math.round(ratios.stream().mapToDouble(Double::doubleValue).average().getAsDouble() * 10.0) / 10.0;
			property.relativeIndention = relativeIndention;
			property.lineLengthRatio = ratio;
			return property;
		}
		return noNewlineProperty;
	}

	private List<Token> getSameLineTokensBefore(ExtendContext ctx, MyParser parser) {
		Token start = ctx.getStart();
		ParseTree node = ctx;
		ParserRuleContext parent = ctx.getParent();
		List<Token> result = new ArrayList<>();
		// 向上遍历祖先：在每一层检查 node 的前面兄弟节点
		while (parent != null) {
			// 没有前置兄弟，向上一层继续
			if (parent.getChildCount() == 1 || parent.children.indexOf(node) <= 0) {
				node = parent;
				parent = parent.getParent();
				continue;
			}

			// 获取 parent 的 tokens（父节点内的线性 token 列表）
			int nodeIndex = parent.children.indexOf(node);
			for (int i = nodeIndex - 1; i >= 0; i--) {
				List<Token> tokens = null;
				if (parent.getChild(i) instanceof TerminalNode terminalNode) {
					tokens = ((ExtendToken) terminalNode.getSymbol()).getContextTokens();
				} else if (parent.getChild(i) instanceof ExtendContext extendContext) {
					tokens = extendContext.getAllExpandedTokensRec();
				}

				for (int j = tokens.size() - 1; j >= 0; j--) {
					Token cur = tokens.get(j);

					if (cur.getText().endsWith("\n")) {
						return result;
					}
					result.add(cur);
				}

			}

			// 这一层的所有前兄弟都扫描完毕，仍未找到换行，向上一层继续
			node = parent;
			parent = parent.getParent();
		}

		// 没有找到
		return result;
	}


	@Override
	public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
		int rule = ctx.getRuleIndex();
//		boolean isTopExpression = rule == parser.getRuleExpression() && ctx.getParent() != null && ctx.getParent().getParent() != null && parser.isStatement(ctx.getParent().getParent());
		return parser.getRuleformalParameterList() == rule || rule == parser.getRuleLocalVarDeclaration() || rule == parser.getRuleParExpression() || parser.belongToSingleStmt(ctx);
	}
}
