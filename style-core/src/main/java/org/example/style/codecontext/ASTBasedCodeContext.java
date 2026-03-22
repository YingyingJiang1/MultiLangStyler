package org.example.style.codecontext;

import org.example.antlr.common.context.ExtendContext;

public class ASTBasedCodeContext extends CodeContext {
	ExtendContext contextNode;
	ExtendContext sourceNode; // where the code context is derived from

	public ASTBasedCodeContext(ExtendContext ctx) {
		this.contextNode = ctx;
		this.sourceNode = ctx;
		initLocation();
	}

	public ASTBasedCodeContext(ExtendContext ctx, ExtendContext source) {
		this.contextNode = ctx;
		this.sourceNode = source;
		initLocation();
	}

	private void initLocation() {
		if (contextNode.getStart() == null || contextNode.getStop() == null) {
			this.startLoc = new int[]{-1, -1};
			this.endLoc = new int[]{-1, -1};
		} else {
			this.startLoc = new int[]{contextNode.getStart().getLine(), contextNode.getStart().getCharPositionInLine()};
			this.endLoc = new int[]{contextNode.getStop().getLine(), contextNode.getStop().getCharPositionInLine() + contextNode.getStop().getText().length()};
		}
	}

	public ExtendContext getContextNode() {
		return contextNode;
	}

	public ExtendContext getSourceNode() {
		return sourceNode;
	}
}
