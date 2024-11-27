package org.example.debug;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.ExtendContext;
import org.example.parser.java.antlr.JavaParser;

public class TreePrinter {
    public static final Parser JAVA_PARSER = new JavaParser(null);
    public static void printTree(ExtendContext ctx, Parser parser) {
        System.out.println(ctx.toStringTree(parser));
    }
}
