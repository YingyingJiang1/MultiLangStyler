package org.example.styler;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.token.ExtendToken;
import org.example.utils.NodeUtil;

public class NewlinePatchStyler extends Styler {
	protected int countNewlineBetween(ParseTree curNode, ParseTree nextNode, MyParser parser) {
		ExtendToken stop = NodeUtil.getStopToken(curNode);
		ExtendToken start = NodeUtil.getStartToken(nextNode);

		if (start == null || stop == null) {
			return -1;
		}

		int newlineCount = NodeUtil.countNewlineBetween(stop, start, parser);
		return newlineCount;
	}

	protected ParseTree getNextNode(ParseTree cur) {
		if (cur.getParent() == null) {
			return null;
		}

		ParserRuleContext parent = (ParserRuleContext) cur.getParent();
		int idx = parent.children.indexOf(cur);
		if (idx + 1 < parent.getChildCount()) {
			return parent.getChild(idx + 1);
		}

		// 遍历祖先节点
		ParseTree node = cur;
		while (parent != null && parent.getChild(parent.getChildCount() - 1) == node) {
			node = parent;
			parent = parent.getParent();
		}
		return parent == null ? null : parent.getChild(parent.children.indexOf(node) + 1);
	}
}
