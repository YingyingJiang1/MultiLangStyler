package org.example.styler.structure.handler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.lang.LangAdapterCreator;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;
import org.example.utils.ParseTreeUtil;

import java.util.List;

public class BraceWrapHandler extends Handler{
	public BraceWrapHandler(String[][] argsList) {
		super(argsList);
	}

	/**
	 *
	 * @param structure
	 * @param args [holderName, n]
	 * 为`holderName`所代表的树的根节点的第n个compound语句祖先节点添加brace
	 * @param parser
	 */
	@Override
	protected void doHandle(EquivalentStructure structure, List<String> args, MyParser parser) {
		if (args.size() < 2) {
			logger.error("Arguments length error in {} : need 2 but get {}", this.getClass().getSimpleName(), args.size());
		}

		List<ParseTree> matchedTrees = structure.getVNode(args.get(0)).matchedTrees;
		int n = Integer.parseInt(args.get(1));
		int count = 0;
		if (!matchedTrees.isEmpty()) {
			ParseTree cur = matchedTrees.get(0).getParent();
			while (cur != null) {
				if (cur instanceof ExtendContext ctx) {
					if (parser.belongToCompoundStmt(ctx)) {
						++count;
					}

					if (count == n) {
						// If no {}, then add {}.
						ExtendContext subStmt = ctx.getFirstCtxChildIf(parser::belongToStmt);
						if (!parser.isBlock(parser.getSpecificStmt(subStmt))) {
							LangAdapterCreator.createASTRewriter(parser.getLanguage()).encapsulateStmtWithBrace(subStmt, parser);
						}
						break;
					}

				}
				cur = cur.getParent();
			}
		}
	}


}
