package org.example.styler.helper.handler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.ParseTreeFactory;
import org.example.styler.helper.EquivalentStructure;

import java.util.ArrayList;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/11 20:15
 */
public class ReplicationHandler extends Handler{
	/**
	 *
	 * @param argsList [toIndex, holder1, holder2,...]
	 */
	public ReplicationHandler(String[][] argsList) {
		this.argsList = argsList;
	}
	@Override
	public void handle(EquivalentStructure structure, int from, int to) {
		for(String[] args : argsList) {
			int checkTo = Integer.parseInt(args[0]);
			if (checkTo != to) {
				continue;
			}
			List<ParseTree> matchedNodes = new ArrayList<>(0);
			// Find the first not empty matchedNodes.
			for (int i = 1; i < args.length; i++) {
				String holderName = args[i];
				matchedNodes = structure.getVNode(holderName).matchedNodes;
				if (!matchedNodes.isEmpty()) {
					break;
				}
			}
			// Do replication.
			if (!matchedNodes.isEmpty()) {
				for (int i = 1; i < args.length; i++) {
					String holderName = args[i];
					EquivalentStructure.VirtualNode vNode = structure.getVNode(holderName);
					if(vNode.matchedNodes.isEmpty()) {
						vNode.matchedNodes = doReplication(matchedNodes);
					}
				}
			}
		}
	}

	private List<ParseTree> doReplication(List<ParseTree> trees) {
		List<ParseTree> ret = new ArrayList<>(trees.size());
		for (ParseTree tree : trees) {
			ret.add(ParseTreeFactory.getInstance().copyFrom(tree, null, false));
		}
		return ret;
	}
}
