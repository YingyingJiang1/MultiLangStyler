package org.example.styler.structure.handler;

import org.example.parser.common.MyParser;
import org.example.styler.structure.EquivalentStructure;

public class ReplaceExpHandler extends Handler{
    public ReplaceExpHandler(String[][] argsList) {
        super(argsList);
    }

    @Override
    public void handle(EquivalentStructure structure, int from, int to, MyParser parser) {
        super.handle(structure, from, to, parser);
    }
}
