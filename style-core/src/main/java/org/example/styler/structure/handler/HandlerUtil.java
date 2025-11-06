package org.example.styler.structure.handler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

import java.util.List;

public class HandlerUtil {
	public static boolean containExpContent(List<ParseTree> nodes, String content, MyParser parser) {
		for (ParseTree node : nodes) {
			if (node instanceof ExtendContext ctx) {
				// 检查根节点
				if (parser.getRuleExpression() == ctx.getRuleIndex() && ctx.getText().equals(content)) {
					return true;
				}
				// 检查后代节点
				List<ExtendContext> descents = ctx.getAllCtxsRecIf(parser::isExpression);
				for (ExtendContext exp : descents) {
					if (exp.getText().equals(content)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
