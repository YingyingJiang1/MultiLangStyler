package org.example.styler.exp;

import org.antlr.v4.runtime.Token;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.style.rule.StyleProperty;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.exp.style.ComplexBoolExpProperty;

import java.util.List;

public class ComplexBoolExpStyler extends Styler {
    public ComplexBoolExpStyler() {
        style.setStyleName("most_complex_bool_expression");
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        ExtendContext boolExpression = null;
        if (ctx.getRuleIndex() == parser.getRuleExpression()) {
            int questionIndex = ctx.indexOfIf(child -> child.getText().equals("?"));
            if (questionIndex > 0) {
                boolExpression = (ExtendContext) ctx.getChild(0);
            }
        } else if (ctx.getRuleIndex() == parser.getRuleParExpression()) {
            boolExpression = ctx.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleExpression());
        }

        if (boolExpression != null) {
            int length = ctx.getText().length();
            List<Token> logicalOps = ctx.getAllTokensRecIf(token ->
                    token.getText().equals("&&") || token.getText().equals("||") || token.getText().equals("!"));
            int predicateNum = logicalOps.size() + 1;
            if (logicalOps.size() == 1 && logicalOps.get(0).getText().equals("!")){
                --predicateNum;
            }

            List<StyleProperty> properties = style.getProperties(null);
            if (properties == null) {
                style.addRule(null, new ComplexBoolExpProperty(length, predicateNum));
            } else {
                ComplexBoolExpProperty property = (ComplexBoolExpProperty) properties.get(0);
                if (length > property.maxExpressionLength) {
                    property.maxExpressionLength = length;
                }
                if (predicateNum > property.maxLogicalOpNum) {
                    property.maxLogicalOpNum = predicateNum;
                }
            }
        }
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        return ctx.getRuleIndex() == parser.getRuleExpression() || ctx.getRuleIndex() == parser.getRuleParExpression();
    }
}
