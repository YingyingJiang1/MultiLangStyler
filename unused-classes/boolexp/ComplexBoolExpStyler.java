package org.example.styler.exp;

import org.antlr.v4.runtime.Token;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.exp.style.ComplexBoolExpProperty;
import org.example.styler.exp.style.ComplexBoolExpStyle;

import java.util.List;

public class ComplexBoolExpStyler extends Styler {
    public ComplexBoolExpStyler() {
        style = new ComplexBoolExpStyle();
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
            int predicateNum = logicalOps.size();
            int logicalOpKind = 0;
            boolean hasAnd = false, hasOr = false, hasNot = false;
            for (Token logicalOp : logicalOps) {
                switch (logicalOp.getText()) {
                    case "&&":
                        hasAnd = true;
                        break;
                    case "||":
                        hasOr = true;
                        break;
                    case "!":
                        hasNot = true;
                        break;
                }
            }
            if (hasAnd || hasOr) {
                ++predicateNum;
            }
            if (hasAnd) {
                ++logicalOpKind;
            }
            if (hasOr) {
                ++logicalOpKind;
            }
            if (hasNot) {
                ++logicalOpKind;
            }


            style.addRule(null, new ComplexBoolExpProperty(length, predicateNum, logicalOpKind));
        }
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        return ctx.getRuleIndex() == parser.getRuleExpression() || ctx.getRuleIndex() == parser.getRuleParExpression();
    }
}
