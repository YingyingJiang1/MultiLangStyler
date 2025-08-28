package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class NotLiteralExpChecker extends Checker{
	public NotLiteralExpChecker(String[][] argsList) {
		super(argsList);
	}

	/**
	 * args: [$E1, $E2, ...]
	 * @param structure
	 * @param args
	 * @param parser
	 * @return
	 */
	@Override
	protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
		for (String arg : args) {
			List<ParseTree> nodes = structure.getVNode(arg).matchedTrees;
			if (nodes.isEmpty()) {
				continue;
			}

			List<ExtendContext> subExps = ((ExtendContext) nodes.get(0)).getAllCtxsRecIf(parser::isExpression);
			if (isAllLiteral(subExps, parser)) {
				return false;
			}
		}
		return true;
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
