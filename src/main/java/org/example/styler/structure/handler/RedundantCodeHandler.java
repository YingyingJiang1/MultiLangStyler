package org.example.styler.structure.handler;

import com.zaxxer.sparsebits.SparseBitSet;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.styler.structure.EquivalentStructure;

import java.util.ArrayList;
import java.util.List;

public class RedundantCodeHandler extends Handler{
	public RedundantCodeHandler(String[][] argsList) {
		super(argsList);
	}


	/**
	 * @apiNote Remove redundant code from `placeholders` and move redundant code to `target placeholder`
	 * @param structure
	 * @param args [placeholders..., target placeholders]
	 * @param parser
	 */
	@Override
	protected void doHandle(EquivalentStructure structure, List<String> args, MyParser parser) {
		if (args.size() < 2) {
			System.out.printf("Arguments length error in %s : lack placeholders%n", this.getClass().getName());
			return;
		}

		List<ParseTree> firstTree = structure.getVNode(args.get(0)).matchedTrees;
		List<List<ParseTree>> treesList = new ArrayList<>();
		for (int i = 1; i < args.size() - 1; i++) {
			treesList.add(structure.getVNode(args.get(i)).matchedTrees);
		}

		// Get redundant code trees
		int off = 0;
		for (int i = firstTree.size() - 1; i >= 0; i--,off++) {
			ParseTree tree = firstTree.get(i);
			String code = tree.getText();
			boolean flag = true;
			for (int j = 0; j < treesList.size(); j++) {
				ParseTree tree1 = treesList.get(j).get(treesList.get(j).size() - 1 - off);
				if (!code.equals(tree1.getText())) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				break;
			}
		}

		if (off > 0) {
			List<ParseTree> redundantTrees = firstTree.subList(firstTree.size() - off, firstTree.size());
			structure.getVNode(args.get(args.size() - 1)).matchedTrees.addAll(redundantTrees);
			firstTree.removeAll(redundantTrees);
			for (int i = 0; i < treesList.size(); i++) {
				List<ParseTree> trees = treesList.get(i);
				trees.removeAll(trees.subList(trees.size() - off, trees.size()));
			}
		}
	}
}
