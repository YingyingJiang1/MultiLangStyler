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

		List<List<ParseTree>> treesList = new ArrayList<>();
		for (int i = 0; i < args.size() - 1; i++) {
			treesList.add(structure.getVNode(args.get(i)).matchedTrees);
		}
		int commonSuffixLength = getCommonSuffixLength(treesList);

		if (commonSuffixLength > 0) {
			// Add common codes to target tree.
			List<ParseTree> firstTree = treesList.get(0);
			List<ParseTree> redundantTrees = firstTree.subList(firstTree.size() - commonSuffixLength, firstTree.size());
			structure.getVNode(args.get(args.size() - 1)).matchedTrees.addAll(redundantTrees);

			treesList.forEach(t -> t.removeAll(t.subList(t.size() - commonSuffixLength, t.size())));
		}
	}

	private int getCommonSuffixLength(List<List<ParseTree>> treesList) {
		// Find the minimum length, avoid index out of bounds.
		int minLength = treesList.stream()
				.mapToInt(List::size)
				.min()
				.orElse(0);

		int commonSuffixLength = 0;
		// Comparation from end to start
		for (int i = 1; i <= minLength; i++) {
			String expected = treesList.get(0).get(treesList.get(0).size() - i).getText();
			boolean allMatch = true;

			for (int j = 1; j < treesList.size(); j++) {
				String current = treesList.get(j).get(treesList.get(j).size() - i).getText();
				if (!expected.equals(current)) {
					allMatch = false;
					break;
				}
			}

			if (allMatch) {
				commonSuffixLength++;
			} else {
				break;
			}
		}
		return commonSuffixLength;
	}
}
