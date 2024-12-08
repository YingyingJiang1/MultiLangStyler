package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class NotIdentifierExpChecker extends Checker{
    /**
     * args: [[index of writing, holderName1, holderName2, ...]]
     */
    @Override
    public boolean check(EquivalentStructure structure, int index, MyParser parser) {
        for (String[] args : argsList) {
            if (args.length < 2) {
                logger.error("Arguments of NotIdentifierExpChecker error: length < 2");
                continue;
            }

            int indexToCheck = Integer.parseInt(args[0]);
            if (indexToCheck == index) {
                for (int i = 1; i < args.length; i++) {
                    String holderName = args[i];
                    List<ParseTree> realTrees = structure.getVNode(holderName).matchedTrees;
                    for (ParseTree realTree : realTrees) {
                        if (realTree instanceof ExtendContext ctx && parser.getRuleExpression() == ctx.getRuleIndex()) {
                            if (ctx.getChildCount() == 1 && parser.isIdentifier( ctx.getChild(0))) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
