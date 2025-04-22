package org.example.utils;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

import java.util.ArrayList;
import java.util.List;

public class NodeUtil {

	/**
	 * @param node
	 * @return the original code in the source file.
	 */
	public static String getOriginText(ExtendContext node, MyParser parser) {
		List<String> codeLines = new ArrayList<>(List.of(parser.getInputCode().split("\n")));

		int startLine = node.getStart().getLine();
		int endLine = node.getStop().getLine();
		return String.join("\n", codeLines.subList(startLine - 1, endLine));
	}

}
