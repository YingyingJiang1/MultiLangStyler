package org.example.styler.structure.checker;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;
import org.example.utils.searcher.NodeSearcherFactory;

import java.util.ArrayList;
import java.util.List;

public class VarUpdateStmtChecker extends Checker{
	public VarUpdateStmtChecker(String[][] argsList) {
		super(argsList);
	}


	/**
	 * @param structure
	 * @param args [node1, ...]
	 *             检查第一个节点是否更新了 后面的节点更新或者定义的变量，如果仅含有一个节点，那么只检查该节点是否更新了变量
	 * @param parser
	 * @return
	 */
	@Override
	protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
		List<ExtendContext> updateAny = new ArrayList<>();
		for (int i = 1; i < args.size(); i++) {
			List<ParseTree> nodes = structure.getVNode(args.get(i)).matchedTrees;
			for (ParseTree node : nodes) {
				if (node instanceof ExtendContext extendContext) {
					int rule = parser.getSpecificStmtType(extendContext);
					if (parser.getRuleLocalVarDeclarationStmt() == rule || parser.getRuleLocalVarDeclaration() == rule) {
						List<ExtendContext> decIds = NodeSearcherFactory.getInstance().createVarDeclarationSearcher().searchIdentifiers(parser.getSpecificStmt(extendContext), parser);
						updateAny.addAll(decIds);
					} else {
						updateAny.addAll(getUpdatedVars(extendContext, parser));
					}
				}
			}
		}

		List<String> targetVars = new ArrayList<>();
		updateAny.forEach(e -> targetVars.add(e.getText()));
		List<ParseTree> toCheck = structure.getVNode(args.get(0)).matchedTrees;
		for (ParseTree node : toCheck) {
			if (node instanceof ExtendContext extendContext) {
				List<ExtendContext> updatedVars = getUpdatedVars(extendContext, parser);
				if (updatedVars.isEmpty()) {
					return false;
				}

				// 非空，至少需要更新一个目标变量
				boolean updated = targetVars.isEmpty();
				for (ExtendContext updatedVar : updatedVars) {
					if (targetVars.contains(updatedVar.getText())) {
						updated = true;
						break;
					}
				}
				if (!updated) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean updateVariable(ExtendContext node) {
		node.getAllTerminalsRecIf(t -> true);
		List<Token> tokens = node.getAllTokensRec();
		for (Token t : tokens) {
			if (t.getText().equals("++") || t.getText().equals("--") || t.getText().endsWith("=")) {
				return true;
			}
		}
		return false;
	}

	private List<ExtendContext> getUpdatedVars(ExtendContext node, MyParser parser) {
		List<TerminalNode> terminals = node.getAllTerminalsRecIf(t -> true);
		List<ExtendContext> updatedVars = new ArrayList<ExtendContext>();

		for (int i = 0; i < terminals.size(); i++) {
			TerminalNode term = terminals.get(i);
			String text = term.getText();

			// ++i 或 --i (前缀形式)
			if (text.equals("++") || text.equals("--")) {
				if (i + 1 < terminals.size() && parser.isIdentifier(terminals.get(i + 1).getParent())) {
					updatedVars.add((ExtendContext) terminals.get(i + 1).getParent());
				}
				if (i > 0 && parser.isIdentifier(terminals.get(i - 1).getParent())) { // i++ 或 i-- (后缀形式)
					updatedVars.add((ExtendContext) terminals.get(i - 1).getParent());
				}
			}

			// 赋值更新（=, +=, -=, *=, /= 等）
			if (text.endsWith("=") && parser.isIdentifier(terminals.get(i - 1).getParent())) {
				updatedVars.add((ExtendContext) terminals.get(i - 1).getParent());
			}
		}

		return updatedVars;
	}

}
