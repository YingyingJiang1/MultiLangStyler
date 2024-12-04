package org.example.semantic.symbol;

import java.lang.reflect.Method;
import java.util.List;

public class ClassSym extends Symbol{
    String path;
    List<ClassSym> parents;
    List<VarSym> vars;
    List<MethodSym> methods;
    List<ClassSym> innerClasses;

    public String getPath() {
        return path;
    }
}
