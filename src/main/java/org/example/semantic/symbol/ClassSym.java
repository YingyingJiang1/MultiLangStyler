package org.example.semantic.symbol;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

import java.util.ArrayList;
import java.util.List;

public class ClassSym extends Symbol{
    String path;
    List<ClassSym> parents = new ArrayList<ClassSym>();
    List<VarSym> vars = new ArrayList<VarSym>();
    List<FunctionSym> methods = new ArrayList<FunctionSym>();
    List<ClassSym> innerClasses = new ArrayList<ClassSym>();

    public static ClassSym createSym(ExtendContext declarationNode, MyParser parser) {
        ExtendContext declarationHead = getTypeDeclarationHead(declarationNode, parser);
        ClassSym classSym = new ClassSym(declarationNode,
                parseIdentifier(declarationHead, parser),
                parseModifierKeywords(declarationNode, parser));
        classSym.parents = parseParents(classSym.declarationNode, parser);
        classSym.path = parsePath(parser);
        return classSym;
    }


    private ClassSym(ExtendContext declarationNode, TerminalNode terminalNode, List<String> modifierKeywords) {
        super(declarationNode, terminalNode, modifierKeywords);
    }

    public void addSymbol(Symbol symbol) {
        if (symbol instanceof VarSym) {
            vars.add((VarSym) symbol);
        } else if (symbol instanceof FunctionSym) {
            methods.add((FunctionSym) symbol);
        } else if (symbol instanceof ClassSym) {
            innerClasses.add((ClassSym) symbol);
        } else {
            throw new IllegalArgumentException("Unknown symbol type: " + symbol.getClass().getName());
        }
    }


    public String getPath() {
        return path;
    }

    public void addVar(VarSym symbol) {
        vars.add(symbol);
    }

    public void addMethod(FunctionSym symbol) {
        methods.add(symbol);
    }

    public void addInnerClass(ClassSym symbol) {
        innerClasses.add(symbol);
    }

    private static List<ClassSym> parseParents(ExtendContext declarationNode, MyParser parser) {
        System.out.println("to do: implement ClassSym@paseParents");
        return null;
    }

    private static String parsePath(MyParser parser) {
        System.out.println("to do: implement ClassSym@parsePath");
        return null;
    }

    private static ExtendContext getTypeDeclarationHead(ExtendContext declarationNode, MyParser parser) {
        return (ExtendContext) declarationNode.getChild(1);
    }
}
