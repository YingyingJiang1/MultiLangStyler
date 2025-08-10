package org.example.styler.structure.checker;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;
import org.w3c.dom.Node;

import java.util.List;

public class VarUpdateStmtChecker extends Checker{
	public VarUpdateStmtChecker(String[][] argsList) {
		super(argsList);
	}


	/**
	 * Check all statements matched by virtual nodes to see whether they update a variable.
	 * @param structure
	 * @param args [placeholder1, placeholder2,...]
	 * @param parser
	 * @return
	 */
	@Override
	protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
		for (String arg : args) {
			List<ParseTree> nodes = structure.getVNode(arg).matchedTrees;
			for (ParseTree node : nodes) {
				if (node instanceof ExtendContext extendContext && parser.getRuleExpressionStmt() == parser.getSpecificStmtType(extendContext)
				&& updateVariable(extendContext)) {

				} else {
					return false;
				}
			}
		}
		return true;
	}

	private boolean updateVariable(ExtendContext node) {
		List<Token> tokens = node.getAllTokensRec();
		for (Token t : tokens) {
			if (t.getText().equals("++") || t.getText().equals("--") || t.getText().endsWith("=")) {
				return true;
			}
		}
		return false;
	}

}
