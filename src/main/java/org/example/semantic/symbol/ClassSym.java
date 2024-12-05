package org.example.semantic.symbol;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassSym extends Symbol{
    String path;
    List<ClassSym> parents = new ArrayList<ClassSym>();
    List<VarSym> vars = new ArrayList<VarSym>();
    List<MethodSym> methods = new ArrayList<MethodSym>();
    List<ClassSym> innerClasses = new ArrayList<ClassSym>();

    public ClassSym(ExtendContext declarationNode, List<String> modifiers) {
        super(declarationNode, modifiers);
    }

    public static ClassSym createSym(ExtendContext declarationNode, MyParser parser) {
        ClassSym classSym = new ClassSym(declarationNode, getModifierKeywords(declarationNode, parser));
        System.out.println("to do: 解析父类");
        return classSym;
    }

    public void addSymbol(Symbol symbol) {
        if (symbol instanceof VarSym) {
            vars.add((VarSym) symbol);
        } else if (symbol instanceof MethodSym) {
            methods.add((MethodSym) symbol);
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

    public void addMethod(MethodSym symbol) {
        methods.add(symbol);
    }

    public void addInnerClass(ClassSym symbol) {
        innerClasses.add(symbol);
    }

}
