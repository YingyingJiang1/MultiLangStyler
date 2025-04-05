package org.example.styler.structure.handler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.utils.ParseTreeUtil;
import org.example.styler.structure.EquivalentStructure;
import org.example.styler.structure.vtree.VirtualNode;

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
		super(argsList);
	}
	@Override
	public void handle(EquivalentStructure structure, int from, int to, MyParser parser) {
		for(String[] args : argsList) {
			int checkTo = Integer.parseInt(args[0]);
			if (checkTo != to) {
				continue;
			}
			List<ParseTree> matchedNodes = new ArrayList<>(0);
			// Find the first not empty matchedNodes.
			for (int i = 1; i < args.length; i++) {
				String holderName = args[i];
				matchedNodes = structure.getVNode(holderName).matchedTrees;
				if (!matchedNodes.isEmpty()) {
					break;
				}
			}
			// Do replication.
			if (!matchedNodes.isEmpty()) {
				for (int i = 1; i < args.length; i++) {
					String holderName = args[i];
					VirtualNode vNode = structure.getVNode(holderName);
					if(vNode.matchedTrees.isEmpty()) {
						vNode.matchedTrees = doReplication(matchedNodes);
					}
				}
			}
		}
	}

	private List<ParseTree> doReplication(List<ParseTree> trees) {
		List<ParseTree> ret = new ArrayList<>(trees.size());
		for (ParseTree tree : trees) {
			ret.add(ParseTreeUtil.getInstance().copyTree(tree, false));
		}
		return ret;
	}
}
