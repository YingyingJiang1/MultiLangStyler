package org.example.styler.exp.complexity;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.exp.ExpType;
import org.example.styler.exp.complexity.style.ExpressionContext;
import org.example.styler.exp.complexity.style.ExpressionProperty;

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

        ExpressionContext styleContext = extractStyleContext(ctx, parser);
        ExpressionProperty styleProperty = extractStyleProperty(ctx, parser);
        if (styleContext != null) {
            StyleProperty targetProperty = style.getProperty(styleContext);
            if (targetProperty == null) {
                style.addRule(styleContext, styleProperty);
            } else if (targetProperty instanceof ExpressionProperty expProperty){
                if (expProperty.maxExpressionLength < styleProperty.maxExpressionLength) {
                    expProperty.maxExpressionLength = styleProperty.maxExpressionLength;
                }
                if (expProperty.maxSubExpNum < styleProperty.maxSubExpNum) {
                    expProperty.maxSubExpNum = styleProperty.maxSubExpNum;
                }
            }
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {

    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        return ctx.getRuleIndex() == parser.getRuleExpStmt() || ctx.getRuleIndex() == parser.getRuleParExpression();
    }

    private ExpressionContext extractStyleContext(ExtendContext ctx, MyParser parser) {
        ExtendContext expression = ctx.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleExpression());
        ExpType expType = null;
        if (ctx.getRuleIndex() == parser.getRuleExpStmt()) {
            expType = expression.getAllTerminalsIf(ter -> ter.getText().equals("?") || ter.getText().equals(":")).size() == 2
                    ? ExpType.TERNARY_EXP
                    : ExpType.TOP_EXP;
        } else if (ctx.getRuleIndex() == parser.getRuleParExpression()) {
            expType = ExpType.CONDITIONAL_EXP;
        }
        return expType == null ? null : new ExpressionContext(expType);
    }

    private ExpressionProperty extractStyleProperty(ExtendContext ctx, MyParser parser) {
        ExtendContext expression = ctx.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleExpression());
        int length = expression.getText().length();
        int subExpNum = ctx.getAllContextsByTypeRec(parser.getRuleExpression()).size();
        return new ExpressionProperty(length, subExpNum);
    }
}
