package org.example.styler.structure.handler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class RemoveCommonSuffixHandler extends Handler{
	public RemoveCommonSuffixHandler(String[][] argsList) {
		super(argsList);
	}

	/**
	 * 移除 placeholdern尾部的与 to_be_removed_tree代码一致的代码
	 * @param structure
	 * @param args [placeholder1, placeholder2, ..., to_be_removed_tree]
	 * @param parser
	 * @return
	 */
	@Override
	protected void doHandle(EquivalentStructure structure, List<String> args, MyParser parser) {
		if (args.size() < 2) {
			System.out.printf("Arguments length error in %s : lack placeholders%n", this.getClass().getName());
			return;
		}

		List<ParseTree> toBeRemovedNodes = structure.getVNode(args.get(args.size() - 1)).matchedTrees;
		for (String arg : args.subList(0, args.size() - 1)) {
			List<ParseTree> nodes = structure.getVNode(arg).matchedTrees;
			if (nodes == null || nodes.isEmpty()) {
				continue;
			}

			int suffixLen = getCommonSuffixLength(nodes, toBeRemovedNodes, parser);
			structure.getVNode(arg).matchedTrees = nodes.subList(0, nodes.size() - suffixLen);
		}
	}

	private int getCommonSuffixLength(List<ParseTree> a, List<ParseTree> b, MyParser parser) {
		int len = 0;
		int i = a.size() - 1;
		int j = b.size() - 1;

		while (i >= 0 && j >= 0) {

			if (!a.get(i).getText().equals(b.get(j).getText())) {
				break;
			}

			len++;
			i--;
			j--;
		}

		return len;
	}
}
