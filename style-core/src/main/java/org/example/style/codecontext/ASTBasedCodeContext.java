package org.example.style.codecontext;

import org.example.antlr.common.context.ExtendContext;

public class ASTBasedCodeContext extends CodeContext {
	ExtendContext ctx;

	public ASTBasedCodeContext(ExtendContext ctx) {
		this.ctx = ctx;
		if (ctx.getStart() == null || ctx.getStop() == null) {
			this.startLoc = new int[]{-1, -1};
			this.endLoc = new int[]{-1, -1};
		} else {
			this.startLoc = new int[]{ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()};
			this.endLoc = new int[]{ctx.getStop().getLine(), ctx.getStop().getCharPositionInLine() + ctx.getStop().getText().length()};
		}
	}

	public ExtendContext getCtx() {
		return ctx;
	}
}
