package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class NotIdentifierExpChecker extends Checker{

    public NotIdentifierExpChecker(String[][] argsList) {
        super(argsList);
    }

    @Override
    protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
        for (String holderName : args) {
            List<ParseTree> realTrees = structure.getVNode(holderName).matchedTrees;
            for (ParseTree realTree : realTrees) {
                if (realTree instanceof ExtendContext ctx && parser.getRuleExpression() == ctx.getRuleIndex()) {
                    if (ctx.getChildCount() == 1 && parser.isIdentifier( ctx.getChild(0))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
