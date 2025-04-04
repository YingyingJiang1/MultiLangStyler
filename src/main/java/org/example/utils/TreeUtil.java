package org.example.utils;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.context.ExtendContext;

public class TreeUtil {
	public static int getTreeDepth(ParseTree root) {
		if (root == null) {
			return 0;
		}
		if (root.getChildCount() == 0) {
			return 1;
		}

		int maxDepth = 0;
		if (root instanceof ExtendContext ctx) {
			for (ParseTree child : ctx.children) {
				int childDepth = getTreeDepth(child);
				maxDepth = Math.max(maxDepth, childDepth + 1);
			}
			return maxDepth;
		}
		return maxDepth;
	}
}
