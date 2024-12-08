package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;
import java.util.function.Predicate;

public class ContinuePreferenceChecker extends Checker{

    /**
     * args: [[index of writing, holderName]]
     * This checker is defined for "continue preferences".
     * The implementation of this method is based on the configuration of the "continue preferences" in the configuration file.
     */
    @Override
    public boolean check(EquivalentStructure structure, int index, MyParser parser) {
        for (String[] args : argsList) {
            if (args.length < 2) {
                logger.error("Arguments of LoopEndChecker error: length < 2");
                continue;
            }
            int configuredIndex = Integer.parseInt(args[0]);
            if (configuredIndex != index) {
                continue;
            }

            String holderName = args[1];
            List<ParseTree> realTrees = structure.getVNode(holderName).matchedTrees;
            if (realTrees.isEmpty()) {
                return false;
            }

            ExtendContext startNode = (ExtendContext) realTrees.get(realTrees.size() - 1);
            // loop ends with a if/if-else statement.
            ExtendContext ifStmt = findFirstAncestorIf(startNode,
                    node -> node.getRuleIndex() == parser.getRuleIfStmt() || node.getRuleIndex() == parser.getRuleIfElseStmt());
            ExtendContext parent = (ExtendContext) ifStmt.getParent().getParent();
            if (parent == null) {
                return false;
            }

            // Body of loop has no {}: loop <-- stmt <-- ifStmt
            if (parser.belongToLoop(parent.getRuleIndex())) {
                return true;
            }
            // Body of loop has a {}: loop <-- stmt <-- block <-- ifStmt
            if (parent.getRuleIndex() == parser.getRuleBlock()
                    && parent.getChild(parent.getChildCount() - 1) == ifStmt
            && parser.belongToLoop(parent.getParent().getParent().getRuleIndex())) {
                return true;
            }
        }
        return true;
    }

    private ExtendContext findFirstAncestorIf(ExtendContext start, Predicate<ExtendContext> predicate) {
        ExtendContext current = start;
        while (current != null) {
            if (predicate.test(current)) {
                return current;
            }
            current = (ExtendContext) current.parent;
        }
        return null;
    }
}
