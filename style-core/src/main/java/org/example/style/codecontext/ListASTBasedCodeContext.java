package org.example.style.codecontext;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.utils.NodeUtil;

import java.util.List;

/**
 * @description: CodeContext implementation based on a list of AST nodes which have the same parent.
 */
public class ListASTBasedCodeContext extends CodeContext {
	List<ParseTree> nodes;
	List<Integer> indices;

	public ListASTBasedCodeContext(List<ParseTree> nodes, List<Integer> indices) {
		this.nodes = nodes;
		this.indices = indices;
	}

	@Override
	public int getStartRow() {
		if (nodes.isEmpty()) {
			return -1;
		}
		return NodeUtil.getStartToken(nodes.get(0)).getLine();
	}

	@Override
	public int getStartColumn() {
		if (nodes.isEmpty()) {
			return -1;
		}
		return NodeUtil.getStartToken(nodes.get(0)).getCharPositionInLine();
	}

	@Override
	public int getEndRow() {
		if (nodes.isEmpty()) {
			return -1;
		}
		return NodeUtil.getStopToken(nodes.get(nodes.size() - 1)).getLine();
	}

	@Override
	public int getEndColumn() {
		if (nodes.isEmpty()) {
			return -1;
		}
		return NodeUtil.getStopToken(nodes.get(nodes.size() - 1)).getCharPositionInLine() +
				NodeUtil.getStopToken(nodes.get(nodes.size() - 1)).getText().length();
	}

	public List<ParseTree> getNodes() {
		return nodes;
	}

	public int size() {
		return nodes.size();
	}

	public ParseTree getNode(int index) {
		return nodes.get(index);
	}
}
