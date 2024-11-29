package org.example.debug;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.java.MyJavaParser;
import org.example.parser.java.antlr.JavaParser;

public class TreePrinter {
    public static final Parser JAVA_PARSER = new JavaParser(null);
    public static void printTree(ParseTree t, MyParser parser) {
        if (parser instanceof MyJavaParser) {
            System.out.println(t.toStringTree(JAVA_PARSER));
        }
    }
}
