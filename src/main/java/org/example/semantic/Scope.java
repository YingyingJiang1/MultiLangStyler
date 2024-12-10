package org.example.semantic;

public enum Scope {
    GLOBAL,
    LOCAL,
    CLASS,
    CLASS_TREE,
    PACKAGE, // CLASS_TREE + same parent directory
}
