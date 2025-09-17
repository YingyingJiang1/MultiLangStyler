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
	 * @param args [placeholder name, min_stmt_num,  max_stmt_num, (permitted statement types...)]
	 *             (permitted statement types...) is optional.
	 *             Permitted statement types: SINGLE_STMT
	 *             min_stmt_num and max_stmt_num are inclusive.
	 * @param parser
	 * @return
	 */
	@Override
	protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
		int index = 0;
		String holderName = args.get(index++);
		int minStmtNum = Integer.parseInt(args.get(index++));
		int maxStmtNum = Integer.parseInt(args.get(index++));
		List<PermittedStmtType> permittedStmtTypes = new ArrayList<>();
		if (args.size() > index) {
			for (int i = index; i < args.size(); i++) {
				permittedStmtTypes.add(PermittedStmtType.valueOf(args.get(i)));
			}
		}

		List<ParseTree> realTrees = structure.getVNode(holderName).matchedTrees;
		if (realTrees.size() > maxStmtNum || realTrees.size() < minStmtNum) {
			return false;
		}
		if (!permittedStmtTypes.isEmpty()) {
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
