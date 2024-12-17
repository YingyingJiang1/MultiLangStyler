package org.example.styler.naming.usage;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.symbol.Symbol;
import org.example.styler.Styler;
import org.example.styler.naming.SymbolTableManager;

import java.util.List;

public class UnusedVarStyler extends Styler {

    public UnusedVarStyler() {
        style.setStyleName("unused_variable");
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        List<Symbol> symbols = SymbolTableManager.getAllSymbols(parser);
        if (symbols == null) {
            return;
        }

        boolean hasUnusedVar = false;
        for (Symbol symbol : symbols) {
            if (symbol.getReferences().isEmpty()) {
                hasUnusedVar = true;
                break;
            }
        }

        style.addRule(null, new UnusedVarProperty(hasUnusedVar));
    }
}
