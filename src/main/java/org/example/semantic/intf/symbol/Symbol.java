package org.example.semantic.intf.symbol;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.token.ExtendToken;
import org.example.styler.naming.SymbolType;

import java.util.ArrayList;
import java.util.List;

public abstract class Symbol {
    protected String name;
    protected TerminalNode astNode;
    protected List<TerminalNode> references = new ArrayList<>(0);
    protected List<String> modifiers = new ArrayList<>(0);
    protected SymbolType symbolType;

    public String getName() {
        return name;
    }

    public void modifyName(String name) {
        ExtendToken extendToken = (ExtendToken) astNode.getSymbol();
        extendToken.setText(name);
        for (TerminalNode reference : references) {
            extendToken = (ExtendToken) reference.getSymbol();
            extendToken.setText(name);
        }
    }

    public SymbolType getSymbolType() {
        return symbolType;
    }

    public void addReference(TerminalNode reference) {
        reference.add(reference);
    }


}
