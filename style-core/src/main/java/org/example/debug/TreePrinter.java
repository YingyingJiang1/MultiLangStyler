package org.example.debug;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.lang.intf.MyParser;
import org.example.lang.java.MyJavaParser;
import org.example.antlr.java.JavaParser;

public class TreePrinter {
    public static final Parser JAVA_PARSER = new JavaParser(null);
    public static void printTree(ParseTree t, MyParser parser) {
        if (parser instanceof MyJavaParser) {
            System.out.println(t.toStringTree(JAVA_PARSER));
        }
    }
}
