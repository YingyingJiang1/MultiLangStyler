package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class EndsWithChecker extends Checker{

	public EndsWithChecker(String[][] argsList) {
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

		StringBuilder endingCodes = new StringBuilder();
		StringBuilder code = new StringBuilder();
		structure.getVNode(args.get(0)).matchedTrees.forEach(t -> code.append(t.getText()));
		for (String arg : args.subList(1, args.size())) {
			structure.getVNode(arg).matchedTrees.forEach(t -> endingCodes.append(t.getText()));
		}

		return code.toString().endsWith(endingCodes.toString());
	}
}


