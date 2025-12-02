package org.example.styler.structure.handler;

import org.example.lang.intf.MyParser;
import org.example.styler.structure.EquivalentStructure;

public class ReplaceHandler extends Handler{
    public ReplaceHandler(String[][] argsList) {
        super(argsList);
    }

    @Override
    public void handle(EquivalentStructure structure, int from, int to, MyParser parser) {
        super.handle(structure, from, to, parser);
    }
}
