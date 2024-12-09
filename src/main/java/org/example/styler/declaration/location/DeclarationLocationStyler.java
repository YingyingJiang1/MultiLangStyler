package org.example.styler.declaration.location;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.declaration.location.style.DeclarationLocationProperty;

public class DeclarationLocationStyler extends Styler {
    public DeclarationLocationStyler() {
        style.setStyleName("declaration_location");
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        int i = 0;
        int blockStartCount = 0;
        int nearUseCount = 0;
        for (; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof ExtendContext stmt) {
                if (!parser.belongToVarDeclarationStmt(stmt.getRuleIndex())) {
                    break;
                }
            }
        }

        blockStartCount = i;

        if (i + 1 < ctx.getChildCount()) {
            nearUseCount = (int) ctx.children.subList(i + 1, ctx.getChildCount()).stream()
                    .filter(child -> child instanceof ExtendContext stmt && parser.belongToVarDeclarationStmt(stmt.getRuleIndex()))
                    .count();

        }

        Location location = null;
        if (blockStartCount > nearUseCount) {
            location = Location.BLOCK_START;
        } else if (blockStartCount < nearUseCount) {
            location = Location.NEAR_USE;
        }
        if (location != null) {
            style.addRule(null, new DeclarationLocationProperty(location));
        }
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        return ctx.getRuleIndex() == parser.getRuleBlock();
    }
}
