package org.example.styler.structure.handler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.MyParser;
import org.example.utils.ParseTreeUtil;
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
		super(argsList);
	}

	@Override
	protected void doHandle(EquivalentStructure structure, List<String> args, MyParser parser) {
		for (String holderName : args) {
			List<ParseTree> matchedTrees = structure.getVNode(holderName).matchedTrees;
			for (int j = 0; j < matchedTrees.size(); j++) {
				ParseTree t = matchedTrees.get(j);
				if (t instanceof JavaParser.ExpressionContext ctx) {
					if (containsLogicalOp(ctx)) {
						matchedTrees.set(j, ParseTreeUtil.getInstance().encapsulateExpWithParen(ctx, parser));
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
