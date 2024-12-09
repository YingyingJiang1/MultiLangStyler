package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class RedundantCodeChecker extends Checker {

    public RedundantCodeChecker(String[][] argsList) {
        super(argsList);
    }

    /**
     * argsList: [[index of writing, holderName1, holderName2, ...]]
     * Check the real trees matched by the holder names not ending with return or continue statement.
     */
    @Override
    public boolean check(EquivalentStructure structure, int index, MyParser parser) {
        for (String[] args : argsList) {
            if (args.length < 2) {
                logger.error("Arguments of RedundantCodeChecker error: length < 2");
                continue;
            }

            int indexToCheck = Integer.parseInt(args[0]);
            if (indexToCheck == index) {
                for (int i = 1; i < args.length; i++) {
                    String holderName = args[i];
                    List<ParseTree> realTrees = structure.getVNode(holderName).matchedTrees;
                    if (!realTrees.isEmpty()) {
                        ParseTree lastTree = realTrees.get(realTrees.size() - 1);
                        if (parser.isReturnStmt(lastTree) || parser.isContinueStmt(lastTree)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
