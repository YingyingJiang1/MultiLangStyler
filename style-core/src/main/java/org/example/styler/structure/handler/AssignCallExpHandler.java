package org.example.styler.structure.handler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class AssignCallExpHandler extends Handler{
    public AssignCallExpHandler(String[][] argsList) {
        super(argsList);
    }

    /**
     *
     * @param structure
     * @param args args:[[holderName1,holderName2,...]]
     * @param parser
     */
    @Override
    protected void doHandle(EquivalentStructure structure, List<String> args, MyParser parser) {
        for (int i = 0; i < args.size(); i++) {
            String holderName = args.get(i);
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
