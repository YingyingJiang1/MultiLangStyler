package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class ExpComplexityComparisonChecker extends Checker{
	public ExpComplexityComparisonChecker(String[][] argsList) {
		super(argsList);
	}

	/**
	 * 比较表达式的复杂度：
	 * `comparison_result`结果可以是（-1， 0， 1）， 分别代表`$E1`的复杂度（低于，等于，高于）`$E2`
	 * argsList:[[$E1, $E2, comparison_result]]
	 *
	 * @param structure
	 * @param args
	 * @param parser
	 * @return
	 */
	@Override
	protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
		List<ParseTree> trees1 = structure.getVNode(args.get(0)).matchedTrees;
		List<ParseTree> trees2 = structure.getVNode(args.get(1)).matchedTrees;

		if (trees1.isEmpty() || trees2.isEmpty()) {
			return true;
		}

		int expectedResult = Integer.parseInt(args.get(2));
		return compare((ExtendContext) trees1.get(0), (ExtendContext) trees2.get(0), parser) == expectedResult;
	}

	private int compare(ExtendContext exp1, ExtendContext exp2, MyParser parser) {
		List<ExtendContext> subExps1 = exp1.getAllCtxsRecIf(parser::isExpression);
		List<ExtendContext> subExps2 = exp2.getAllCtxsRecIf(parser::isExpression);

		// 检查是否有全为literal组成的表达式，有的话则默认复杂度最低
		boolean isLiteralExp1 = isAllLiteral(subExps1, parser);
		boolean isLiteralExp2 = isAllLiteral(subExps2, parser);
		if (isLiteralExp1 && isLiteralExp2) {
			return 0;
		} else if (isLiteralExp1) {
			return -1;
		} else if (isLiteralExp2) {
			return 1;
		}

		int count1 = subExps1.size();
		int count2 = subExps2.size();
		if (count1 != count2) {
			return count1 - count2 > 0 ? 1 : -1;
		}

		// 子表达式数量相等，以长度决定
		int len1 = exp1.getText().length();
		int len2 = exp2.getText().length();
		if (len1 == len2) {
			return 0;
		}
		return len1 > len2 ? 1 : -1;
	}

	private boolean isAllLiteral(List<ExtendContext> subExps, MyParser parser) {
		for (ExtendContext subExp : subExps) {
			if (subExp.getChildCount() == 1 && subExp.getChild(0) instanceof ExtendContext ctx &&
					parser.belongToLiteral(ctx.getRuleIndex())) {
				continue;
			}
			return false;
		}
		return true;
	}
}
