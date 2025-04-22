package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.styler.structure.EquivalentStructure;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

public class StmtComplexityChecker extends  Checker{
	public StmtComplexityChecker(String[][] argsList) {
		super(argsList);
	}


	/**
	 *
	 * @param structure
	 * @param args [placeholder name, The max number of statements, (permitted statement types...)]
	 *             (permitted statement types...) is optional.
	 *             Permitted statement types: SINGLE_STMT
	 * @param parser
	 * @return
	 */
	@Override
	protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
		String holderName = args.get(0);
		int maxStmtNum = Integer.parseInt(args.get(1));
		List<PermittedStmtType> permittedStmtTypes = new ArrayList<>();
		if (args.size() > 2) {
			for (int i = 2; i < args.size(); i++) {
				permittedStmtTypes.add(PermittedStmtType.valueOf(args.get(i)));
			}
		}

		List<ParseTree> realTrees = structure.getVNode(holderName).matchedTrees;
		if (realTrees.size() > maxStmtNum) {
			return false;
		}
		for (ParseTree tree : realTrees) {
			boolean permitted = false;
			for (PermittedStmtType type : permittedStmtTypes) {
				if (type.isType(tree, parser)) {
					permitted = true;
					break;
				}
			}
			if (!permitted) {
				return false;
			}
		}
		return true;
	}

	private static enum PermittedStmtType {
		SINGLE_STMT
		;

		public boolean isType(ParseTree node, MyParser parser) {
			switch (this) {
				case SINGLE_STMT:
					return parser.belongToSingleStmt(node);
				default:
					return false;
			}
		}
	}
}
