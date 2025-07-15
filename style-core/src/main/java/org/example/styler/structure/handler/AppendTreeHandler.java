package org.example.styler.structure.handler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.utils.ParseTreeUtil;
import org.example.styler.structure.EquivalentStructure;
import org.example.styler.structure.vtree.VirtualNode;

import java.util.List;

public class AppendTreeHandler extends Handler{
	public AppendTreeHandler(String[][] argsList) {
		super(argsList);
	}


	/**
	 * Append codes of the given placeholders in the given order to the code of `placeholder1`.
	 * @param structure
	 * @param args [placeholder1, placeholder2, ...]
	 * @param parser
	 * @return
	 */
	@Override
	protected void doHandle(EquivalentStructure structure, List<String> args, MyParser parser) {
		if (args.size() < 2) {
			System.out.printf("Arguments length error in %s : lack placeholders%n", this.getClass().getName());
			return;
		}

		VirtualNode vnode = structure.getVNode(args.get(0));
		for (String arg : args.subList(1, args.size())) {
			for (ParseTree tree : structure.getVNode(arg).matchedTrees) {
				ParseTree cp = ParseTreeUtil.getInstance().copyTree(tree, false);
				vnode.addMatchedTree(cp);
			}
		}
	}
}
