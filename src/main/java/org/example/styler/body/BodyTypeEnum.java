package org.example.styler.body;

public enum BodyTypeEnum {
    DEC_BODY, // Body of type declaration or method declaration.
    MULTI_BLOCK_STMT_BODY, // if-else, try-catch-finally
    ARRAY_INITIALIZER_BODY, // array initializer
    DO_WHILE_BODY,
    NORMAL_BODY, // Except for the above types.
    ANY_BODY, // Match any types.
    ;
}
