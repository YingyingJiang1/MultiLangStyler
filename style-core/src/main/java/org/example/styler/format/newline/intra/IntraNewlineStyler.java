package org.example.styler.format.newline.intra;

import org.antlr.v4.runtime.Token;
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

/**
 * 专注于单个语法树节点内部的换行符使用习惯
 */
public class IntraNewlineStyler extends Styler {
	public IntraNewlineStyler() {
		executeWhenExit = false;
		style = new IntraNewlineStyle();
	}

	@Override
	public void extractStyle(ExtendContext ctx, MyParser parser) {
		IntraNewlineContext newlineContext = new IntraNewlineContext(ctx.getText().length());
		IntraNewlineProperty property = extractProperty(ctx, parser);
		if (property.newlines > 0) {
			style.addRule(newlineContext, property);
		}
	}

	@Override
	public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
		IntraNewlineContext context =  new IntraNewlineContext(ctx.getText().length());
		IntraNewlineProperty property = extractProperty(ctx, parser);
		IntraNewlineProperty targetProperty = (IntraNewlineProperty) style.getProperty(context);

		if (property.newlines != targetProperty.newlines) {
			List<Token> tokens = ctx.getAllTokensRec();

			// 确保移除原来的所有换行
			for (Token token : tokens) {
				NewlineApplicator.removeNewline(token, 100, parser);
			}

			// 按照新的策略添加换行
			int lastBreakTokenIndex = -1;
			int cumulativeLength = 0;
			int succeedLineNumber = 0;
			int targetLen = (int) (context.length * targetProperty.lineLengthRatio);
			if (targetProperty.newlines == 1) {
				for (int i = 0; i < tokens.size(); i++) {
					ExtendToken token = (ExtendToken) tokens.get(i);
					cumulativeLength += token.getText().length();

					// 如果是可换行位置，记录为最近的换行点
					if (isBreakASTNode(token.astRule, parser) && targetProperty.isBreakLoc(token.getText())) {
						lastBreakTokenIndex = i;
					}

					// 当累计长度超过目标长度，并且找到可换行点
					if (cumulativeLength >= targetLen && lastBreakTokenIndex >= 0) {
						int lineEndTokenIndex = lastBreakTokenIndex;
						if (!targetProperty.isBreakAfter(token.getText())) {
							--lineEndTokenIndex;
						}

						NewlineApplicator.addNewline(tokens.get(lineEndTokenIndex), targetProperty.newlines, parser);
						++succeedLineNumber;

						// 记录后继行的相对缩进
						String relativeIndention = targetProperty.getRelativeIndention(succeedLineNumber);
						if (tokens.get(lineEndTokenIndex + 1) instanceof ExtendToken extendToken) {
							extendToken.setExtraIndention(relativeIndention);
						}

						// 重置累计长度，继续处理剩余 token
						cumulativeLength = 0;
						lastBreakTokenIndex = -1;
					}
				}
			}
		}
		return ctx;
	}

	private boolean isBreakASTNode(int rule, MyParser parser) {
		return rule == parser.getRuleExpression() || rule == parser.getRuleformalParameterList();
	}



	private IntraNewlineProperty extractProperty(ExtendContext ctx, MyParser parser) {
		IntraNewlineProperty noNewlineProperty = new IntraNewlineProperty(0);
		Token start = ctx.getStart(), stop = ctx.getStop();
		boolean inSameLine = NodeUtil.countNewlineBetween((ExtendToken) stop, (ExtendToken) start, parser) == 0;
		if (inSameLine) {
			return noNewlineProperty;
		}

		ExtendContext parent = (ExtendContext) ctx.getParent();
		while (parent != null && parent.getStart() == start) {
			parent = (ExtendContext) parent.getParent();
		}
		if (parent == null) {
			return noNewlineProperty;
		}

		List<Token> tokens = parent.getAllExpandedTokensRec();

		// 获取第一行的缩进
		int startIndex = tokens.indexOf(start);
		Token indentionToken = null;
		for (int i = startIndex - 1; i >= 0; i--) {
			Token cur = tokens.get(i);
			int newlineCount = NodeUtil.countNewlineBetween((ExtendToken) cur, (ExtendToken) start, parser);
			if (newlineCount > 0) {
				break;
			}
			if (cur.getType() == parser.getHws() && tokens.get(i - 1).getText().endsWith("\n")) {
				indentionToken = cur;
			}
		}

		String indentionStr = "";
		if (indentionToken != null) {
			indentionStr = indentionToken.getText();
		}

		IntraNewlineProperty property = new IntraNewlineProperty(1);
		int cumulativeLength = 0;
		int totalLength = ctx.getText().length();
		List<String> relativeIndention = new ArrayList<>();
		List<Double> ratios = new ArrayList<>(); // 每行长度占总长度的百分比
		for (int i = startIndex + 1; tokens.get(i) != stop; i++) {
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
				property.updateBreakLoc(left.getText(), true);
				property.updateBreakLoc(right.getText(), false);

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


	@Override
	public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
		int rule = ctx.getRuleIndex();
		boolean isTopExpression = rule == parser.getRuleExpression() && ctx.getParent() != null && ctx.getParent().getParent() != null && parser.isStatement(ctx.getParent().getParent());
		return parser.getRuleformalParameterList() == rule || isTopExpression || rule == parser.getRuleLocalVarDeclaration() || rule == parser.getRuleParExpression();
	}
}
