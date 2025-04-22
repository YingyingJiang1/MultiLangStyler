package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class HasSameEndingStmtChecker extends Checker{
	public HasSameEndingStmtChecker(String[][] argsList) {
		super(argsList);
	}

	/**
	 * Check if the code of `placeholder1` ends with codes of the given placeholders in the given order.
	 * @param structure
	 * @param args [placeholder1, placeholder2, ...]
	 * @param parser
	 * @return
	 */
	@Override
	protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
		if (args.size() < 2) {
			System.out.printf("Arguments length error in %s : lack placeholders%n", this.getClass().getName());
			return false;
		}

		List<ParseTree> stmtList = structure.getVNode(args.get(0)).matchedTrees;
		List<ParseTree> stmtList1 = structure.getVNode(args.get(1)).matchedTrees;

		int sameEndingCount = 0;
		for (int i = stmtList.size() - 1, j = stmtList1.size() - 1; i >= 0 && j >= 0; i--, j--) {
			if (stmtList.get(i).getText().equals(stmtList1.get(j).getText())) {
				sameEndingCount++;
			}
		}
		return sameEndingCount >= 1;
	}
}
