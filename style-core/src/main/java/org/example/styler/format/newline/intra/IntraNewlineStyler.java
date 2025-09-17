package org.example.styler.format.newline.intra;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
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
import org.example.utils.MathUtil;
import org.example.utils.NodeUtil;
import org.example.utils.TokenStreamUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
		// 获取最大行号
		if (parser.getRoot() == ctx) {
			CharStream cs = parser.getTokenStream().getTokenSource().getInputStream();
			int maxLen = Arrays.stream(cs.getText(Interval.of(0, cs.size())).split("\n")).mapToInt(String::length).max().orElseGet(() -> -1);
			style.addRule(new IntraNewlineContext(maxLen), null);
		} else {
			// 获取换行策略
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
				style.addRule(null, property);
			}
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
					doApply(targetNode, (int) targetProperty.length, targetProperty, 0, parser, List.of(parser.getRuleFormalParameter()));
				} else {
					doApply(targetNode, (int) targetProperty.length, targetProperty, 0, parser, List.of(parser.getRuleExpression()));
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
		int targetLen = (int) (context.length * targetProperty.length);
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

	private int doApply(ExtendContext node, int targetLineLen, IntraNewlineProperty targetProperty,
						int succeedLineNum, MyParser parser, List<Integer> breakNodeTypes) {
		IntraNewlineContext curContext = extractContext(node, parser);
		// 当前长度不足，不用换行
		if (curContext.length <= targetLineLen) {
			return 0;
		}

		// 寻找当前节点的行拆分点
		int breakIndex = 0;
		while (breakIndex < node.getChildCount()) {
			if (node.getChild(breakIndex) instanceof ExtendContext ctx) {
				IntraNewlineContext context = extractContext(ctx, parser);
				if (context.length >= targetProperty.minLen && breakNodeTypes.contains(ctx.getRuleIndex())) {
					break;
				}
			}
			++breakIndex;
		}

		int curLineNum = succeedLineNum;
		// 递归处理breakIndex以及前面的子节点
		for (int i = 0; i <= breakIndex; i++) {
			if (node.getChild(i) instanceof ExtendContext child) {
				curLineNum += doApply(child, targetLineLen, targetProperty, curLineNum, parser, breakNodeTypes);
			}
		}

		// 拆分当前节点，禁止在当前节点最后一个子节点后面拆分
		if (breakIndex + 1 < node.getChildCount()) {
			ParseTree nextNode = node.getChild(breakIndex + 1);
			ExtendToken breakToken = null, nextStartToken = null;
			if (nextNode instanceof TerminalNode terminalNode && targetProperty.isBreakAfter(terminalNode.getText())
					&& breakIndex + 2 < node.getChildCount()) {
				breakToken = (ExtendToken) terminalNode.getSymbol();
				nextStartToken = NodeUtil.getStartToken(node.getChild(breakIndex + 2));
			} else {
				breakToken = NodeUtil.getStopToken(node.getChild(breakIndex));
				nextStartToken = NodeUtil.getStartToken(node.getChild(breakIndex + 1));
			}

			NewlineApplicator.addNewline(breakToken, targetProperty.newlines, parser);
			curLineNum += 1;
			nextStartToken.setExtraIndention(targetProperty.getRelativeIndention(curLineNum));
		}

		// 递归处理breakIndex后面的子节点
		for (int i = breakIndex + 1; i < node.getChildCount(); i++) {
			if (node.getChild(i) instanceof ExtendContext child) {
				curLineNum += doApply(child, targetLineLen, targetProperty, curLineNum, parser, breakNodeTypes);
			}
		}

		return curLineNum;
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
		List<Token> tokensBefore = getSameLineTokensBefore(ctx, parser);
		if (!tokensBefore.isEmpty()) {
			len += tokensBefore.subList(1, tokensBefore.size()).stream().mapToInt(t -> t.getText().length()).sum();
			// 长度不包含缩进，因为不同程序的缩进风格可能不一致
			if (tokensBefore.get(0).getType() != parser.getHws()) {
				len += tokensBefore.get(0).getText().length();
			}
		}

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
		List<Double> lens = new ArrayList<>(); // 每行长度占总长度的百分比
		for (int i = 1; i < tokens.size() - 1; i++) {
			Token token = tokens.get(i);
			boolean isIndention = token.getType() == parser.getHws() && tokens.get(i - 1).getText().endsWith("\n");
			if (!isIndention) {
				cumulativeLength += token.getText().length();
			}

			// 碰到换行
			if (tokens.get(i).getType() == parser.getVws()) {
				// 计算长度百分比
//				double ratio = (double) cumulativeLength / totalLength;
				lens.add((double) cumulativeLength);

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

		if (!lens.isEmpty()) {
			double medianLen = MathUtil.median(lens);;
			property.relativeIndention = relativeIndention;
			property.length = medianLen;
			property.minLen = lens.stream().min(Double::compareTo).get();
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
					result.add(0, cur);
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
		boolean isRelevantNode = parser.getRuleformalParameterList() == rule
				|| rule == parser.getRuleLocalVarDeclaration()
				|| rule == parser.getRuleParExpression()
				|| parser.belongToSingleStmt(ctx)
				|| parser.getRuleAnnotationList() == rule;
		return stage == Stage.EXTRACT && ctx == parser.getRoot() || isRelevantNode;
	}
}
