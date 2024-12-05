package org.example.styler.structure.handler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.MyParser;
import org.example.parser.common.factory.ParseTreeUtil;
import org.example.parser.java.antlr.JavaParser;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

/*
 * @description Encapsulate expression with parentheses when the expression contains && or ||.
 * @author       Yingying Jiang
 * @create       2024/4/12 10:46
 */
public class WrapCondHandler extends Handler{
	public WrapCondHandler(String[][] argsList) {
		this.argsList = argsList;
	}

	@Override
	public void handle(EquivalentStructure structure, int from, int to, MyParser parser) {
		for(String[] args : argsList) {
			int configuredForm = Integer.parseInt(args[0]), configuredTo = Integer.parseInt(args[1]);
			if(configuredForm == from && configuredTo == to) {
				for (int i = 2; i < args.length; i++) {
					String holderName = args[i];
					List<ParseTree> matchedTrees = structure.getVNode(holderName).matchedTrees;
					for (int j = 0; j < matchedTrees.size(); j++) {
						ParseTree t = matchedTrees.get(j);
						if (t instanceof JavaParser.ExpressionContext ctx) {
							if(containsLogicalOp(ctx)) {
								matchedTrees.set(j, ParseTreeUtil.getInstance().encapsulateExpWithParen(ctx, parser));
							}
						}
					}
				}
			}
		}
	}

	private boolean containsLogicalOp(ExtendContext ctx) {
		for(ParseTree child : ctx.children) {
			if(child instanceof TerminalNode && (child.getText().equals("&&") || child.getText().equals("||"))) {
				return true;
			}
		}
		return false;
	}

}
