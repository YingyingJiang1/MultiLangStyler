package org.example.styler.exp.updatevar;

import org.antlr.v4.runtime.Token;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.MyParserFactory;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.exp.ExpType;
import org.example.styler.exp.updatevar.style.UpdateVarContext;
import org.example.styler.exp.updatevar.style.UpdateVarProperty;
import org.example.styler.structure.EquivalentStructure;
import org.example.styler.structure.EquivalentStructureManager;

import java.util.ArrayList;
import java.util.List;

public class UpdateVarStyler extends Styler {
    private List<EquivalentStructure> structures;

    public UpdateVarStyler() {
        style.setStyleName("update_variable");
        structures = EquivalentStructureManager.getInstance().loadEquivalences(MyParserFactory.createParser(GlobalInfo.getLanguage()).getClass(), "/removedEquivalences.json");
    }


    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        UpdateVarContext styleContext = extractStyleContext(ctx, parser);

        UpdateVarProperty styleProperty = null;
        EquivalentStructure matchedStructure = null;
        for (EquivalentStructure structure : structures) {
            int matchedIndex = structure.match(ctx, parser);
            if (matchedIndex != -1) {
                styleProperty = new UpdateVarProperty(true);
                matchedStructure = structure;
                break;
            }
        }
        if (matchedStructure == null) {
            List<Token> ops = new ArrayList<>(ctx.getAllTokensRec().stream().filter(token -> !token.getText().equals(".") && parser.belongToOperator(token.getText())).toList());
            List<Token> updateOps = ops.stream().filter(op -> op.getText().equals("=") || op.getText().equals("++") || op.getText().equals("--") || parser.getCompoundAssign().contains(op.getType())).toList();
            ops.removeAll(updateOps);
            if (updateOps.size() > 1) {
                styleProperty = new UpdateVarProperty(false);
            }

        }

        if (styleProperty != null) {
            style.addRule(styleContext, styleProperty);
        }
    }

    @Override
    public void extractFinalize() {
        UpdateVarContext context = new UpdateVarContext(ExpType.CONDITIONAL_EXP);
        if (style.getProperty(context) == null) {
            style.addRule(context, new UpdateVarProperty(false));
        }
        context = new UpdateVarContext(ExpType.RVALUE_EXP);
        if (style.getProperty(context) == null) {
            style.addRule(context, new UpdateVarProperty(false));
        }
        super.extractFinalize();
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        int ruleIndex = ctx.getRuleIndex();
        return ruleIndex == parser.getRuleExpStmt();
    }

    private UpdateVarContext extractStyleContext(ExtendContext ctx, MyParser parser) {
        if (ctx.getRuleIndex() == parser.getRuleExpStmt()) {
            return new UpdateVarContext(ExpType.RVALUE_EXP);
        } else {
            return null;
        }
    }


}
