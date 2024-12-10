package org.example.semantic.intf.symbol;

import java.util.ArrayList;
import java.util.List;

public class ClassSym extends Symbol{
    List<String> parents; // qualified name of parents
    String path;
    List<VarSym> typeParameters = new ArrayList<>();
    Symbol outterClass;

}
