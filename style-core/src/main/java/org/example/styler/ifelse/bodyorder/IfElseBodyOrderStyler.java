package org.example.styler.ifelse.bodyorder;


import org.example.lang.LangAdapterCreator;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.style.InconsistencyInfo;
import org.example.style.InconsistencyType;
import org.example.style.codecontext.ASTBasedCodeContext;
import org.example.style.codecontext.CodeContext;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.ifelse.bodyorder.style.IfElseBodyOrderProperty;
import org.example.styler.ifelse.bodyorder.style.IfElseBodyOrderStyle;

/**
 * This implementation rely on the assumptions:
 * - if branch is the third last child of the if-else statement node, and else branch is the last child.
 *
 *
 */
public class IfElseBodyOrderStyler extends Styler {
    public IfElseBodyOrderStyler() {
        style = new IfElseBodyOrderStyle();
    }


    @Override
    protected StyleProperty extractStyleProperty(CodeContext codeContext, MyParser parser) {
        if (codeContext instanceof ASTBasedCodeContext astBasedCodeContext) {
            ExtendContext ctx = astBasedCodeContext.getContextNode();
            ExtendContext firstBodyCtx = (ExtendContext) ctx.getChild(ctx.getChildCount() - 3);
            ExtendContext secondBodyCtx = (ExtendContext) ctx.getChild(ctx.getChildCount() - 1);
            int firstBodyLines = firstBodyCtx.stop.getLine() - firstBodyCtx.start.getLine() + 1;
            int secondBodyLines = secondBodyCtx.stop.getLine() - secondBodyCtx.start.getLine() + 1;
            double diff = (double) Math.max(firstBodyLines, secondBodyLines)
                    / Math.min(firstBodyLines, secondBodyLines);
            // The difference is not significant enough for human to notice.
            if (diff < 1.3) {
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
    protected InconsistencyInfo generateInconsistencyInfo(CodeContext codeContext, StyleContext styleContext, StyleProperty currentProperty,
                                                          StyleProperty targetProperty, MyParser parser) {
        if (codeContext instanceof ASTBasedCodeContext nodeContext
        && targetProperty instanceof IfElseBodyOrderProperty target) {
            InconsistencyInfo.Location location = new InconsistencyInfo.Location(nodeContext);
            String message = target.shortBodyComesFirst ?
                    "branches should be ordered by line count in ascending order."
                    : "branches should be ordered by line count in descending order.";
            if (target.shortBodyComesFirst) {
                return new InconsistencyInfo(
                        InconsistencyType.IF_ELSE_ORDER,
                        "shorter branch first", "longer branch first",
                        message,
                        location
                );

            } else {
                return new InconsistencyInfo(
                        InconsistencyType.IF_ELSE_ORDER,
                        "longer branch first", "shorter branch first",
                        message,
                        location
                );

            }
        }
        return null;
    }

    @Override
    protected ExtendContext doApply(CodeContext codeContext, StyleProperty currentProperty,
                                    StyleProperty targetProperty, MyParser parser) {
        if (codeContext instanceof ASTBasedCodeContext nodeContext) {
            ExtendContext ctx = nodeContext.getContextNode();
            int firstBodyIndex = ctx.getChildCount() - 3;
            int secondBodyIndex = ctx.getChildCount() - 1;
            ExtendContext firstBodyCtx = (ExtendContext) ctx.getChild(firstBodyIndex);
            ExtendContext secondBodyCtx = (ExtendContext) ctx.getChild(secondBodyIndex);

            // Swap two branches
            ctx.children.set(firstBodyIndex, secondBodyCtx);
            ctx.children.set(secondBodyIndex, firstBodyCtx);
            ctx.updateStopToken();

            // negate condition
            ExtendContext conditionCtx = (ExtendContext) ctx.getChild(1);
            ExtendContext negatedExp = LangAdapterCreator.createASTRewriter(parser.getLanguage())
                    .negateExpressionSmart((ExtendContext) conditionCtx.getChild(1), parser);
            conditionCtx.replaceChild(conditionCtx.getChild(1), negatedExp);
        }
        return null;
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
