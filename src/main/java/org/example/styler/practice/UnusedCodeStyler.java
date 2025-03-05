package org.example.styler.practice;

import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.symbol.Symbol;
import org.example.styler.Styler;
import org.example.styler.naming.SymbolTableManager;
import org.example.styler.naming.SymbolType;
import org.example.styler.practice.style.UnusedCodeContext;
import org.example.styler.practice.style.UnusedCodeProperty;
import org.example.utils.searcher.intf.ArgumentsSearcher;
import org.example.utils.searcher.intf.FunctionDecSearcher;

import java.util.ArrayList;
import java.util.List;

public class UnusedCodeStyler extends Styler {

    public UnusedCodeStyler() {
        style.setStyleName("unused_code");
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        List<Symbol> unusedSymbols = getUnusedSymbols(parser);
        boolean hasUnusedSymbols = !unusedSymbols.isEmpty();
        if (hasUnusedSymbols) {
            for (Symbol symbol : unusedSymbols) {
                style.addRule(new UnusedCodeContext(symbol.getSymbolType()), new UnusedCodeProperty(true));
            }
        } else {
            style.addRule(new UnusedCodeContext(SymbolType.ALL_SYMBOLS), new UnusedCodeProperty(hasUnusedSymbols));
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        List<Symbol> unusedSymbols = getUnusedSymbols(parser);
        for (Symbol symbol : unusedSymbols) {
            // Allow unused code to exist.
            if (style.getProperty(new UnusedCodeContext(symbol.getSymbolType())) != null) {
                continue;
            }
            removeUnusedCode(symbol, parser);
        }
        return ctx;
    }


    @Override
    public void doFinalize() {
        if (style.getProperty(null) == null) {
            style.addRule(null, new UnusedCodeProperty(false));
        }
    }

    private List<Symbol> getUnusedSymbols(MyParser parser) {
        List<Symbol> result = new ArrayList<>();
        List<Symbol> symbols = SymbolTableManager.getAllSymbols(parser);
        if (symbols == null) {
            return result;
        }
        symbols.forEach(symbol -> {
            if (symbol.getReferences().isEmpty()) {
                result.add(symbol);
            }
        });
        return result;
    }


    private void removeUnusedCode(Symbol symbol, MyParser parser) {
        int parentType = switch (symbol.getSymbolType()) {
            case FIELD,LOCAL_VARIABLE -> parser.getRuleStmt();
            case METHOD -> parser.getRuleMethodDeclaration();
            case CONSTRUCTOR -> parser.getRuleConstructorDeclaration();
            case PARAMETER -> parser.getRuleFormalParameter();
            case TYPE -> parser.getRuleTypeDeclaration();
            default -> -1;
        };

        if (parentType == -1) {
            return;
        }

        ExtendContext unusedNode = symbol.getDecIdentifierNode().findFirstParentIf(parent -> parent.getRuleIndex() == parentType);
        if (unusedNode.parent instanceof ExtendContext parent) {
            boolean isRemovable = true;
            List<ExtendContext> argsToBeRemoved = new ArrayList<>();
            // Find arguments for the parameter to be removed.
            if (symbol.getSymbolType() == SymbolType.PARAMETER) {
                ExtendContext functionDec = symbol.getDecIdentifierNode()
                        .findFirstParentIf(p1 -> p1.getRuleIndex() == parser.getRuleMethodDeclaration() || p1.getRuleIndex() == parser.getRuleConstructorDeclaration());
                FunctionDecSearcher searcher = parser.getFunctionDecSearcher();
                int parameterIndex = searcher.indexOfParameter(functionDec, unusedNode, parser);

                ExtendContext identifierNode = searcher.searchFunctionName(functionDec, parser);
                List<ExtendContext> refs = GlobalInfo.getResolver().resolve(identifierNode, parser).getReferences();
                ArgumentsSearcher argsSearcher = parser.getArgumentsSearcher();
                for (ExtendContext ref : refs) {
                    ExtendContext callSite = ref.findFirstParentIf(p -> p.getRuleIndex() == parser.getRuleExpression());
                    ExtendContext args = callSite.getContextRecIf(ctx -> ctx.getRuleIndex() == parser.getRuleArguments());
                    ExtendContext arg = argsSearcher.getArgument(args, parameterIndex, parser);
                    if (arg != null) {
                        argsToBeRemoved.add(arg);
                    } else {
                        isRemovable = false;
                        break;
                    }
                }
            }

            if (isRemovable) {
                argsToBeRemoved.forEach(arg -> ((ExtendContext) arg.parent).removeChildIf(child -> child == arg));
                parent.removeChildIf(child -> child == unusedNode);
            }
        }

    }
}
