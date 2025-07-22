package org.example.styler.ifelse.bodyorder;

import org.example.RunStatistic;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.utils.ParseTreeUtil;
import org.example.style.rule.StyleProperty;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.ifelse.bodyorder.style.IfElseBodyOrderProperty;
import org.example.styler.ifelse.bodyorder.style.IfElseBodyOrderStyle;

public class IfElseBodyOrderStyler extends Styler {
    public IfElseBodyOrderStyler() {
        style = new IfElseBodyOrderStyle();
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        ExtendContext firstBodyCtx = (ExtendContext) ctx.getChild(ctx.getChildCount() - 3);
        ExtendContext secondBodyCtx = (ExtendContext) ctx.getChild(ctx.getChildCount() - 1);
        int firstBodyLines = firstBodyCtx.stop.getLine() - firstBodyCtx.start.getLine() + 1;
        int secondBodyLines = secondBodyCtx.stop.getLine() - secondBodyCtx.start.getLine() + 1;
        if (firstBodyLines < secondBodyLines) {
            style.addRule(null, new IfElseBodyOrderProperty(true));
        } else if (firstBodyLines > secondBodyLines)  {
            style.addRule(null, new IfElseBodyOrderProperty(false));
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        int firstBodyIndex = ctx.getChildCount() - 3;
        int secondBodyIndex = ctx.getChildCount() - 1;
        ExtendContext firstBodyCtx = (ExtendContext) ctx.getChild(firstBodyIndex);
        ExtendContext secondBodyCtx = (ExtendContext) ctx.getChild(secondBodyIndex);
        int firstBodyLines = firstBodyCtx.stop.getLine() - firstBodyCtx.start.getLine() + 1;
        int secondBodyLines = secondBodyCtx.stop.getLine() - secondBodyCtx.start.getLine() + 1;

        if (firstBodyLines != secondBodyLines) {
            StyleProperty  styleProperty = style.getProperty(null);

            if (styleProperty instanceof IfElseBodyOrderProperty property
            && (property.shortBodyComesFirst && firstBodyLines > secondBodyLines
            || !property.shortBodyComesFirst && firstBodyLines < secondBodyLines)) {
                ctx.children.set(firstBodyIndex, secondBodyCtx);
                ctx.children.set(secondBodyIndex, firstBodyCtx);
                ctx.updateStopToken();

                // negate condition
                ExtendContext conditionCtx = (ExtendContext) ctx.getChild(1);
                ExtendContext negatedExp = ParseTreeUtil.getInstance()
                        .negateExpressionSmart((ExtendContext) conditionCtx.getChild(1), parser);
                conditionCtx.replaceChild(conditionCtx.getChild(1), negatedExp);

                RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
            }
        }
        return ctx;

    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        return ctx.getRuleIndex() == parser.getRuleIfElseStmt();
    }
}
