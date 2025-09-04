package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class NoSubExpChecker extends Checker{
	public NoSubExpChecker(String[][] argsList) {
		super(argsList);
	}


	/**
	 *
	 * @param structure
	 * @param args [sub_exp_placeholder, exp_placeholder1, ...]
	 *             检查从`exp_placeholder1`开始的表达式中是否包含子表达式`sub_exp_placeholder`
	 * @param parser
	 * @return
	 */
	@Override
	protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
		List<ParseTree> targetSubExps = structure.getVNode(args.get(0)).matchedTrees;
		if (targetSubExps.isEmpty()) {
			return true;
		}


		for (int i = 1; i < args.size(); i++) {
			List<ParseTree> exps = structure.getVNode(args.get(i)).matchedTrees;
			for (ParseTree exp : exps) {
				if (exp instanceof ExtendContext ctx) {
					List<ExtendContext> subExps = ctx.getAllCtxsRecIf(parser::isExpression).stream().toList();
					for (ExtendContext subExp : subExps) {
						if (hasAnySubExp(subExp, targetSubExps, parser)) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	private boolean hasAnySubExp(ExtendContext exp, List<ParseTree> targets, MyParser parser) {
		for (ParseTree target : targets) {
			if(target instanceof ExtendContext subExp) {
				if (exp.getText().equals(subExp.getText())) {
					return true;
				}
			}
		}
		return false;
	}
}
