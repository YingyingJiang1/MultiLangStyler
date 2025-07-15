package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.styler.structure.EquivalentStructure;
import org.example.styler.structure.vtree.VirtualNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/13 17:16
 */
public class NotIntegerChecker extends Checker{

	public NotIntegerChecker(String[][] argsList) {
		super(argsList);
	}

	/**
	 *
	 * @param structure
	 * @param args [index of writing, digit1, digit2,..., holderName1, holderName2,...]
	 * @param parser
	 * @return
	 */
	@Override
	protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
		Set<String> integers = new HashSet<>();
		int integerEnd = 0;
		for (; integerEnd < args.size(); ++integerEnd) {
			if(args.get(integerEnd).matches("\\d+")) {
				integers.add(args.get(integerEnd));
			} else {
				break;
			}
		}

		for(int i = integerEnd; i < args.size(); ++i) {
			VirtualNode vNode = structure.getVNode(args.get(i));
			if (vNode != null && !vNode.matchedTrees.isEmpty()) {
				for(ParseTree t : vNode.matchedTrees) {
					if(integers.contains(t.getText())) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
