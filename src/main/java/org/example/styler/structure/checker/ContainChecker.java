package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class ContainChecker extends Checker{
    public ContainChecker(String[][] argsList) {
        super(argsList);
    }

    /**
     * Check whether the tree matched by "container holder name" contains the tree matched by "contained holder name".
     * @param structure
     * @param args [[container holder name, contained holder name1 , contained holder name2, ...]]
     * @param parser
     * @return
     */
    @Override
    protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
        if (args.size() < 2) {
            logger.error("Arguments error in {}.doCheck: at least 2 arguments required.", this.getClass().getName());
            return false;
        }

        List<ParseTree> containerTrees = structure.getVNode(args.get(0)).matchedTrees;
        for (ParseTree t : containerTrees) {
            for (int i = 1; i < args.size(); i++) {
                List<ParseTree> containedTrees = structure.getVNode(args.get(i)).matchedTrees;
                for (ParseTree t1 : containedTrees) {
                    if (!doCheckContain(t, t1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean doCheckContain(ParseTree container, ParseTree contained) {
        if (container.getClass().equals(contained.getClass()) && container.getText().equals(contained.getText())) {
            return true;
        }
        for (int i = 0; i < container.getChildCount(); i++) {
            if (doCheckContain(container.getChild(i), contained)) {
                return true;
            }
        }
        return false;
    }
}
