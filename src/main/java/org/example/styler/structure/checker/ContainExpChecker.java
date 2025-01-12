package org.example.styler.structure.checker;

import org.example.parser.common.MyParser;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class ContainExpChecker extends Checker{
    public ContainExpChecker(String[][] argsList) {
        super(argsList);
    }

    @Override
    protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
        return super.doCheck(structure, args, parser);
    }
}
