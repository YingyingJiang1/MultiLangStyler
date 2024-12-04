package org.example.styler.declaration;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.Stage;
import org.example.styler.Styler;

public class DeclarationNumberStyler extends Styler {
    public DeclarationNumberStyler() {
        style.setStyleName("declaration-number");
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        super.extractStyle(ctx, parser);
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        int ruleIndex = ctx.getRuleIndex();
        return parser.belongToVarDeclarations(ruleIndex);
    }
}
