package org.example.styler.array;

import org.example.debug.TreePrinter;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.Styler;

public class ArrayDeclarationStyler extends Styler {
    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        TreePrinter.printTree(ctx, parser);
    }
}
