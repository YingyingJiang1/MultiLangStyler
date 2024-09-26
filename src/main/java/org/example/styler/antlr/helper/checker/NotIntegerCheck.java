package org.example.styler.antlr.helper.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.styler.antlr.helper.EquivalentStructure;

import java.util.HashSet;
import java.util.Set;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/13 17:16
 */
public class NotIntegerCheck extends Checker{
	public NotIntegerCheck(String[][] argsList) {
		this.argsList = argsList;
	}

	/**
	 * args:[digit1, digit2,..., holderName1, holderName2,...]
	 * @param structure
	 * @param index
	 * @return
	 */
	@Override
	public boolean check(EquivalentStructure structure, int index) {
		Set<String> integers = new HashSet<>();
		for(String[] args : argsList) {
			int integerEnd = 0;
			for (; integerEnd < args.length; ++integerEnd) {
				if(args[integerEnd].matches("\\d+")) {
					integers.add(args[integerEnd]);
				}
			}

			for(int i = integerEnd;i < args.length; ++i) {
				EquivalentStructure.VirtualNode vNode = structure.getVNode(args[i]);
				if (vNode != null && !vNode.matchedNodes.isEmpty()) {
					for(ParseTree t : vNode.matchedNodes) {
						if(integers.contains(t.getText())) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
