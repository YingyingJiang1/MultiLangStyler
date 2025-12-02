package org.example.styler.format.newline;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.styler.NewlinePatchStyler;
import org.example.styler.Stage;

public class AnnotationNewlinePatchStyler extends NewlinePatchStyler {
	public AnnotationNewlinePatchStyler() {
		executeWhenExit = true;
	}

	@Override
	public void extractStyle(ExtendContext ctx, MyParser parser) {}

	@Override
	public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
		ParserRuleContext parent = ctx.getParent();
		int index = parent.children.indexOf(ctx);
//		StyleRule styleRule = extractStyleRule((ExtendContext) parent, index, parser);
		// ctx为modifier list或者annotation list, 去除ctx和其下一个节点的换行
		NewlineApplicator.removeNewline(ctx, 1, parser);

		// 处理annotation list和modifier list内部
		for (int i = 0; i < ctx.getChildCount(); i++) {
			ParseTree cur = ctx.getChild(i);
			if (parser.isAnnotation(cur)) {
				int newlineCount = countNewlineBetween(cur, getNextNode(cur), parser);
				if (newlineCount == 0) {
					NewlineApplicator.addNewline(ctx.getChild(i), 1, parser);
				}
			}
		}
		return ctx;
	}

	@Override
	public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
		int rule = ctx.getRuleIndex();
		return stage == Stage.APPLY && (
				rule == parser.getRuleAnnotationList() || rule == parser.getRuleModifierList()
				);
	}
}
