package org.example.style.codecontext;

import jakarta.el.ELContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.antlr.common.context.ExtendContext;
import org.example.utils.NodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: CodeContext implementation based on a list of AST nodes which have the same parent.
 */
public class ListASTBasedCodeContext extends CodeContext {
	List<? extends ParseTree> nodes;
	List<Integer> indices;

	public ListASTBasedCodeContext(List<? extends ParseTree> nodes) {
		if (nodes == null || nodes.isEmpty()) {
			return;
		}

		this.nodes = nodes;
		if (nodes.get(0).getParent() != null) {
			ExtendContext parent = (ExtendContext) nodes.get(0).getParent();
			indices = new ArrayList<>();
			for (ParseTree node : nodes) {
				indices.add(parent.children.indexOf(node));
			}
		}
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
				NodeUtil.getStopToken(nodes.get(nodes.size() - 1)).getText().length() - 1;
	}

	public List<? extends ParseTree> getNodes() {
		return nodes;
	}

	public int size() {
		return nodes.size();
	}

	public ParseTree getNode(int index) {
		return nodes.get(index);
	}
}
