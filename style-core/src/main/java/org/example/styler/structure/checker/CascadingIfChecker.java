package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class CascadingIfChecker extends Checker{
	public CascadingIfChecker(String[][] argsList) {
		super(argsList);
	}


	/**
	 * 检查所有语句是否为single statement，如果为block结构，则检查其中所有的子语句是否为single statement。
	 * 排除lambda表达式，因为lambda表达式中可能携带复杂的函数逻辑
	 * args: [placeholder1, placeholder2, ...]
	 */
	@Override
	protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
		for (String arg : args) {
			List<ParseTree> nodes = structure.getVNode(arg).matchedTrees;
			if (!isSimpleStmt(nodes, parser)) {
				return false;
			}

			if (!hasJumpStmts(nodes, parser)) {
				return false;
			}
		}

		return true;
	}

	private boolean isSimpleStmt(List<ParseTree> nodes, MyParser parser) {
		for (ParseTree node : nodes) {
			if (node instanceof ExtendContext ctx) {
				if (parser.getSpecificStmtType(ctx) == parser.getRuleBlock()) {
					List<ParseTree> subStmts = parser.getSpecificStmt(ctx).children;
					for (ParseTree subStmt : subStmts) {
						if (subStmt instanceof ExtendContext && !checkComplexity((ExtendContext) subStmt, parser)) {
							return false;
						}
					}
				} else if (!checkComplexity(ctx, parser)) {
					return false;
				}

			}
		}


		return true;
	}

	protected boolean hasJumpStmts(List<ParseTree> nodes, MyParser parser) {
		List<Integer> jumpStmts = List.of(
				parser.getRuleContinueStmt(), parser.getRuleBreakStmt(),
				parser.getRuleReturnStmt(), parser.getRuleThrowStmt()
		);

		boolean hasJumpStmt = false;
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

		return hasJumpStmt;
	}

	private boolean checkComplexity(ExtendContext node, MyParser parser) {
		return !parser.isLambdaExpression(node) && parser.belongToSingleStmt(parser.getSpecificStmt(node));
	}
}
