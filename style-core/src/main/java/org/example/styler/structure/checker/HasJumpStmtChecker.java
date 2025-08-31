package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class HasJumpStmtChecker extends Checker{
	public HasJumpStmtChecker(String[][] argsList) {
		super(argsList);
	}

	/**
	 * 检查各个placeholder匹配到的语法树中是否包含jump语句, 非递归检查
	 * args: [placeholder1, placeholder2, ...]
	 */
	@Override
	protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
		List<Integer> jumpStmts = List.of(
				parser.getRuleContinueStmt(), parser.getRuleBreakStmt(),
				parser.getRuleReturnStmt(), parser.getRuleThrowStmt()
		);

		for (String arg : args) {
			boolean hasJumpStmt = false;
			List<ParseTree> nodes = structure.getVNode(arg).matchedTrees;
			for (ParseTree node : nodes) {
				if (node instanceof ExtendContext ctx) {
					int ruleIndex = parser.getSpecificStmtType(ctx);
					// 检查子语句
					if ( ruleIndex == parser.getRuleBlock()) {
						List<ParseTree> subStmts = parser.getSpecificStmt(ctx).children;
						for (ParseTree subStmt : subStmts) {
							if (subStmt instanceof ExtendContext && jumpStmts.contains(parser.getSpecificStmtType((ExtendContext) subStmt))) {
								hasJumpStmt = true;
								break;
							}
						}
					} else if (jumpStmts.contains(ruleIndex)) {
						hasJumpStmt = true;
						break;
					}
				}
			}

			if (!hasJumpStmt) {
				return false;
			}
		}
		return true;
	}


}
