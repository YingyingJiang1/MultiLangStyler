package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

import java.util.List;

public class IdentifierExpChecker extends Checker{
    public IdentifierExpChecker(String[][] argsList) {
        super(argsList);
    }

    /**
     * argsList: [[index of writing, holderName1, holderName2, ...]]
     */
    @Override
    public boolean check(EquivalentStructure structure, int index, MyParser parser) {
        Checker checker = new NotIdentifierExpChecker(argsList);
        return !checker.check(structure, index, parser);
    }
}

