package org.example.styler.ifelse.bodyorder;

import org.example.MyEnvironment;
import org.example.RunStatistic;
import org.example.lang.LangAdapterCreator;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.style.InconsistencyInfo;
import org.example.style.codecontext.ASTBasedCodeContext;
import org.example.style.codecontext.CodeContext;
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
    protected StyleProperty extractStyleProperty(CodeContext codeContext, MyParser parser) {
        if (codeContext instanceof ASTBasedCodeContext astBasedCodeContext) {
            ExtendContext ctx = astBasedCodeContext.getCtx();
            ExtendContext firstBodyCtx = (ExtendContext) ctx.getChild(ctx.getChildCount() - 3);
            ExtendContext secondBodyCtx = (ExtendContext) ctx.getChild(ctx.getChildCount() - 1);
            int firstBodyLines = firstBodyCtx.stop.getLine() - firstBodyCtx.start.getLine() + 1;
            int secondBodyLines = secondBodyCtx.stop.getLine() - secondBodyCtx.start.getLine() + 1;
            // Two branches require evident difference in line count.
            if (Double.max(firstBodyLines, secondBodyLines) / Double.min(firstBodyLines, secondBodyLines) >= 1) {
                return null;
            }
            if (firstBodyLines < secondBodyLines) {
                return new IfElseBodyOrderProperty(true);
            } else if (firstBodyLines > secondBodyLines)  {
                return new IfElseBodyOrderProperty(false);
            }
        }
        return null;
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
                ExtendContext negatedExp = LangAdapterCreator.createASTRewriter(parser.getLanguage())
                        .negateExpressionSmart((ExtendContext) conditionCtx.getChild(1), parser);
                conditionCtx.replaceChild(conditionCtx.getChild(1), negatedExp);

                RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
            }
        }
        return ctx;

    }

    @Override
    protected boolean isInconsistent(StyleProperty currentProperty, StyleProperty targetProperty, MyParser parser) {
        if (currentProperty instanceof IfElseBodyOrderProperty current
                && targetProperty instanceof IfElseBodyOrderProperty target) {
            return current.shortBodyComesFirst != target.shortBodyComesFirst;
        }
        return false;
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        if (ctx.getRuleIndex() == parser.getRuleIfElseStmt()) {
            int subSubStmtType = parser.getSpecificStmtType(ctx.getLastCtxChildIf(parser::isStatement));
            return subSubStmtType != parser.getRuleIfStmt() && subSubStmtType != parser.getRuleIfElseStmt(); // Binary branch
        }
        return false;
    }
}
