package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class UnreachableCauseChecker extends Checker{
    private List<Integer> jumpStmts = null;

    public UnreachableCauseChecker(String[][] argsList) {
        super(argsList);
    }

    /**
     *
     * @param structure
     * @param args [placeholders...]
     * @param parser
     * @return
     */
    @Override
    protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
        if (jumpStmts == null) {
            initJumpStmts(parser);
        }
       int index = 0;
        while (index < args.size()) {
            String holderName = args.get(index);
            List<ParseTree> realTrees = structure.getVNode(holderName).matchedTrees;
            for (ParseTree tree : realTrees) {
                if (tree instanceof ExtendContext ctx && jumpStmts.contains(parser.getSpecificStmtType(ctx))) {
                    return false; // Found a statement in the given stmt types.
                }
            }
            ++index;
        }
        return true;
    }

    private void initJumpStmts(MyParser parser) {
        jumpStmts = List.of(
                parser.getRuleContinueStmt(),
                parser.getRuleBreakStmt(),
                parser.getRuleReturnStmt(),
                parser.getRuleThrowStmt()
        );
    }
}
