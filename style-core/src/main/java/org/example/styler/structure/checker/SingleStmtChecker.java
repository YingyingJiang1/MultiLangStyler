package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class SingleStmtChecker extends Checker{
	public SingleStmtChecker(String[][] argsList) {
		super(argsList);
	}


	/**
	 * 检查所有语句是否为single statement，如果为block结构，则检查其中所有的子语句是否为single statement。
	 * args: [placeholder1, placeholder2, ...]
	 */
	@Override
	protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
		for (String arg : args) {
			List<ParseTree> nodes = structure.getVNode(arg).matchedTrees;
			for (ParseTree node : nodes) {
				if (node instanceof ExtendContext ctx) {
					if (parser.getSpecificStmtType(ctx) == parser.getRuleBlock()) {
						List<ParseTree> subStmts = parser.getSpecificStmt(ctx).children;
						for (ParseTree subStmt : subStmts) {
							if (subStmt instanceof ExtendContext && !isSingleStmt((ExtendContext) subStmt, parser)) {
								return false;
							}
						}
					} else if (!isSingleStmt(ctx, parser)) {
						return false;
					}
				}
			}
		}

		return true;
	}

	private boolean isSingleStmt(ExtendContext node, MyParser parser) {
		return parser.belongToSingleStmt(parser.getSpecificStmt(node));
	}
}
