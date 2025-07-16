package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;
import java.util.function.Predicate;

public class ContinuePreferenceChecker extends Checker{

    public ContinuePreferenceChecker(String[][] argsList) {
        super(argsList);
    }

    @Override
    protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
        for (String holderName : args) {
            List<ParseTree> realTrees = structure.getVNode(holderName).matchedTrees;
            if (realTrees.isEmpty()) {
                return false;
            }

            ExtendContext startNode = (ExtendContext) realTrees.get(realTrees.size() - 1);
            // Check loop ends with a statement with the `startNode` as the root.
            boolean checkResult = checkLoopEnd(startNode, parser);
            if (checkResult) {
                continue;
            }

            // Check loop ends with an if/if-else statement.
            ParseTree ifStmt = startNode.getParent().getParent();
            checkResult = checkLoopEnd((ExtendContext) ifStmt.getParent(), parser);
            if (!checkResult) {
                return false;
            }

        }
        return true;
    }

    private boolean checkLoopEnd(ExtendContext stmt, MyParser parser) {
        if (stmt == null || stmt.getParent() == null) {
            return false;
        }

        ExtendContext loop = (ExtendContext) stmt.getParent();
        // Body of loop has no {}: loop <-- `stmt`
        if (parser.belongToLoop(loop.getRuleIndex())) {
            return true;
        }

        // Body of loop has a {}: loop <-- stmt <-- block <-- `stmt`
        if (loop.getParent() == null || loop.getParent().getParent() == null) {
            return false;
        }
        return loop.getRuleIndex() == parser.getRuleBlock()
                && loop.getLastCtxChildIf(parser::isStatement) == stmt
                && parser.belongToLoop(loop.getParent().getParent().getRuleIndex());
    }



}
