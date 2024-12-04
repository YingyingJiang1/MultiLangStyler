package org.example.semantic.symbol;

import java.util.List;

public class ClassSym extends Symbol{
    String path;
    List<ClassSym> parents;

    public String getPath() {
        return path;
    }
}
