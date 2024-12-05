package org.example.styler.declaration;

import org.example.debug.TreePrinter;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.style.rule.StyleProperty;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.declaration.style.DeclarationNumberContext;
import org.example.styler.declaration.style.DeclarationNumberProperty;
import org.example.styler.declaration.style.DeclarationNumberStyle;

public class DeclarationNumberStyler extends Styler {
    public DeclarationNumberStyler() {
        style = new DeclarationNumberStyle();
        style.setStyleName("declaration-number");
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        int count = ctx.countChildIf(parser::isVariableDeclarator);
        boolean hasComment = hasComment(ctx, parser);
        if (count > 1) {
            style.addRule(new DeclarationNumberContext(hasComment), new DeclarationNumberProperty(count));
        } else {
            // Declare one variable in a declaration statement, we need to further check the next adjacent declaration
            // statement declares one variable of the same type.
            if (ctx.parent instanceof ExtendContext parentCtx) {
                int next = parentCtx.children.indexOf(ctx) + 1;
                if (next < parentCtx.getChildCount()) {
                    ExtendContext nextCtx = (ExtendContext) parentCtx.children.get(next);
                    if (hasSameType(ctx, nextCtx, parser) && nextCtx.countChildIf(parser::isVariableDeclarator) == 1
                    && hasComment(nextCtx, parser) == hasComment) {
                        style.addRule(new DeclarationNumberContext(hasComment), new DeclarationNumberProperty(1));
                    }
                }
            }
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        int count = ctx.countChildIf(parser::isVariableDeclarator);
        boolean hasComment = hasComment(ctx, parser);
        if (count > 1) {
            style.addRule(new DeclarationNumberContext(hasComment), new DeclarationNumberProperty(count));
        } else {
            // Declare one variable in a declaration statement, we need to further check the next adjacent declaration
            // statement declares one variable of the same type.
            if (ctx.parent instanceof ExtendContext parentCtx) {
                int next = parentCtx.children.indexOf(ctx) + 1;
                if (next < parentCtx.getChildCount()) {
                    ExtendContext nextCtx = (ExtendContext) parentCtx.children.get(next);
                    if (hasSameType(ctx, nextCtx, parser) && nextCtx.countChildIf(parser::isVariableDeclarator) == 1
                            && hasComment(nextCtx, parser) == hasComment) {
                        style.addRule(new DeclarationNumberContext(hasComment), new DeclarationNumberProperty(1));
                    }
                }
            }
        }
        return ctx;
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        int ruleIndex = ctx.getRuleIndex();
        return parser.belongToVarDeclarations(ruleIndex);
    }


    private boolean hasComment(ExtendContext ctx, MyParser parser) {
        ExtendToken extStart = (ExtendToken) ctx.start;
        ExtendToken extStop = (ExtendToken) ctx.stop;
        boolean hasComment = extStart.hasContextTokens(parser::belongToComment) || extStop.hasContextTokens(parser::belongToComment);
        return hasComment;
    }

    private boolean hasSameType(ExtendContext declaration1, ExtendContext declaration2, MyParser parser) {
        ExtendContext type1 = declaration1.getFirstCtxChildIf(parser::isTypeType);
        ExtendContext type2 = declaration2.getFirstCtxChildIf(parser::isTypeType);
        return type1.getText().equals(type2.getText());
    }

}
