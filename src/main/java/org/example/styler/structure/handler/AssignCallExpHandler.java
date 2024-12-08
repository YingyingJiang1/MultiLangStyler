package org.example.styler.structure.handler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class AssignCallExpHandler extends Handler{
    /**
     * args:[[from, to, holderName1,holderName2,...]]
     */
    @Override
    public void handle(EquivalentStructure structure, int from, int to, MyParser parser) {
        for (String[] args : argsList) {
            if (args.length < 3) {
                logger.error("Arguments of AssignCallExpHandler error: length < 3");
                continue;
            }
            int index1 = Integer.parseInt(args[0]);
            int index2 = Integer.parseInt(args[1]);
            if (index1 == from && index2 == to) {
                for (int i = 2; i < args.length; i++) {
                    String holderName = args[i];
                    List<ParseTree> matchedTrees = structure.getVNode(holderName).matchedTrees;
                    for (ParseTree tree : matchedTrees) {
                        if (tree instanceof ExtendContext ctx && ctx.getRuleIndex() == parser.getRuleExpression()) {
                            if (ctx.getChild(1) instanceof TerminalNode terminalNode
                            && (terminalNode.getText().equals(".") || terminalNode.getText().equals("="))) {
                                ((ExtendContext) ctx.parent).replaceChild(ctx, ctx.getChild(0));
                            }
                        }
                    }
                }
            }
        }
    }
}
