package org.example.styler.brace.style;

public enum TypeEnum {
    BODY_BLOCK, // Body of type declaration or method declaration.
    MULTI_BLOCK_STMT, // if-else, try-catch-finally
    DO_WHILE_BLOCK,
    INITIALIZER_BLOCK, // initializer of type declaration
    ARRAY_INITIALIZER_BLOCK, // array initializer
    NORMAL_BLOCK, // Except for the above blocks.
}
