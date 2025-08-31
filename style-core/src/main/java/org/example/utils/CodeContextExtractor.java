package org.example.utils;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

public class CodeContextExtractor {
	public static String extractMethodContext(ExtendContext node, MyParser parser) {
		ExtendContext functionDec = node.findFirstParentIf(t -> parser.belongToMethodDec(t.getRuleIndex()));
		if (functionDec != null) {
			return functionDec.getFormattedText(parser);
		}
		return "";
	}


	public static String extractCodeContext(ExtendContext node, MyParser parser) {
		ExtendContext context = node.findFirstParentIf(t -> parser.belongToCompoundStmt(t) || parser.belongToMethodDec(t.getRuleIndex()));
		if (context != null) {
			return context.getFormattedText(parser);
		}
		return "";
	}
}
