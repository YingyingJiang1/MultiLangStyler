package org.example.utils;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

public class CodeContextExtractor {
	public static String extractMethodContext(ExtendContext node, MyParser parser) {
		ExtendContext functionDec = node.findFirstParentIf(t -> parser.belongToFunctionDec(t.getRuleIndex()));
		if (functionDec != null) {
			return functionDec.getFormattedText();
		}
		return "";
	}

	public static String extractBlockContext(ExtendContext node, MyParser parser) {
		ExtendContext block = node.findFirstParentIf(parser::belongToCompoundStmt);
		if (block != null) {
			return block.getFormattedText();
		}
		return extractMethodContext(node, parser);
	}

	public static String extractCodeContext(ExtendContext node, MyParser parser) {
		ExtendContext context = node.findFirstParentIf(t -> parser.belongToCompoundStmt(t) || parser.belongToFunctionDec(t.getRuleIndex()));
		if (context != null) {
			return context.getFormattedText();
		}
		return "";
	}
}
