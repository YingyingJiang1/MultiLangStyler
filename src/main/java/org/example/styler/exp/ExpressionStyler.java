package org.example.styler.exp;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.exp.style.ExpressionContext;
import org.example.styler.exp.style.ExpressionProperty;

import javax.script.ScriptContext;

public class ExpressionStyler extends Styler {
    public ExpressionStyler() {
        style.setStyleName("most_complex_expression");
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        ExtendContext expression = ctx.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleExpression());
        if (expression == null) {
            return;
        }

        ExpType expType = null;
        if (ctx.getRuleIndex() == parser.getRuleExpStmt()) {
            expType = expression.getAllTerminalsIf(ter -> ter.getText().equals("?") || ter.getText().equals(":")).size() == 2
                    ? ExpType.TERNARY_EXP
                    : ExpType.EXP_OF_EXP_STMT;
        } else if (ctx.getRuleIndex() == parser.getRuleParExpression()) {
            expType = ExpType.CONDITIONAL_EXP;
        }

        int length = expression.getText().length();
        int subExpNum = ctx.getAllContextsByTypeRec(parser.getRuleExpression()).size();
        if (expType != null) {
            StyleContext context = new ExpressionContext(expType);
            StyleProperty property = style.getProperty(context);
            if (property == null) {
                style.addRule(context, new ExpressionProperty(length, subExpNum));
            } else if (property instanceof ExpressionProperty expProperty){
                if (expProperty.maxExpressionLength < length) {
                    expProperty.maxExpressionLength = length;
                }
                if (expProperty.maxSubExpNum < subExpNum) {
                    expProperty.maxSubExpNum = subExpNum;
                }
            }
        }
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        return ctx.getRuleIndex() == parser.getRuleExpStmt() || ctx.getRuleIndex() == parser.getRuleParExpression();
    }
}
