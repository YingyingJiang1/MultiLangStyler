package org.example.styler.exp.updatevar;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.exp.ExpType;
import org.example.styler.exp.updatevar.style.UpdateVarContext;
import org.example.styler.exp.updatevar.style.UpdateVarProperty;

import java.util.ArrayList;
import java.util.List;

public class UpdateVarStyler extends Styler {
    public UpdateVarStyler() {
        style.setStyleName("update_variable");
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        ExpType expType = null;
        List<ExtendContext> targetExpressions = new ArrayList<ExtendContext>();
        if (ctx.getParent() instanceof ExtendContext parentCtx && parentCtx.getRuleIndex() == parser.getRuleParExpression()) {
            expType = ExpType.CONDITIONAL_EXP;
            targetExpressions.add(ctx);
        } else {
            expType = ExpType.RVALUE_EXP;
            int assignOpIndex = ctx.indexOfFirstChild(child -> child instanceof TerminalNode ter
                    && (ter.getText().equals("=") || parser.getCompoundAssign().contains(ter.getSymbol().getType())));
            if (assignOpIndex >= 0) {
                for (int i = assignOpIndex; i < ctx.getChildCount(); i++) {
                    ParseTree child = ctx.getChild(i);
                    if (child instanceof ExtendContext childCtx && childCtx.getRuleIndex() == parser.getRuleExpression()) {
                        targetExpressions.add(childCtx);
                    }
                }
            }
        }

        for (ExtendContext targetExpression : targetExpressions) {
            List<TerminalNode> updateVarOp = targetExpression.getAllTerminalsRecIf(child -> child.getText().equals("=")
                    || child.getText().equals("++") || child.getText().equals("--")
            || parser.getCompoundAssign().contains(child.getSymbol().getType()));
            if (!updateVarOp.isEmpty()) {
                style.addRule(new UpdateVarContext(expType), new UpdateVarProperty(true));

            }
        }
    }

    @Override
    public void doFinalize() {
        UpdateVarContext context = new UpdateVarContext(ExpType.CONDITIONAL_EXP);
        if (style.getProperty(context) == null) {
            style.addRule(context, new UpdateVarProperty(false));
        }
        context = new UpdateVarContext(ExpType.RVALUE_EXP);
        if (style.getProperty(context) == null) {
            style.addRule(context, new UpdateVarProperty(false));
        }
        super.doFinalize();
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        int ruleIndex = ctx.getRuleIndex();
        return ruleIndex == parser.getRuleExpression();
    }
}
