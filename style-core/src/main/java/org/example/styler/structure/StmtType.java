package org.example.styler.structure;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

public enum StmtType {
	LOOP

	;

	public static StmtType getType(ExtendContext node, MyParser parser) {
		if (parser.belongToLoop(node.getRuleIndex())) {
			return LOOP;
		}
		return null;
	}
}
