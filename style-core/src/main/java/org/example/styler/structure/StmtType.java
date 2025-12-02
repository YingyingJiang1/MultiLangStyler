package org.example.styler.structure;

import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;

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
