package org.example.styler.structure.checker;

import org.example.lang.intf.MyParser;
import org.example.styler.structure.EquivalentStructure;

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

