package org.example.parser.common;

import org.antlr.v4.runtime.tree.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/13 12:35
 */
public class MyParseTreeWalker extends ParseTreeWalker {
	@Override
	public void walk(ParseTreeListener listener, ParseTree t) {
		if (t instanceof ErrorNode) {
			listener.visitErrorNode((ErrorNode)t);
		} else if (t instanceof TerminalNode) {
			listener.visitTerminal((TerminalNode)t);
		} else {
			RuleNode r = (RuleNode)t;
			this.enterRule(listener, r);

			for(int i = 0; i < r.getChildCount(); ++i) {
				this.walk(listener, r.getChild(i));
			}

			this.exitRule(listener, r);
		}
	}

}
