package org.example.styler.format.body.style;

import org.example.parser.common.MyParser;

import java.util.*;

public enum TypeEnum {
    BODY_BLOCK, // Body of type declaration or method declaration.
    MULTI_BLOCK_STMT, // if-else, try-catch-finally
    DO_WHILE_BLOCK,
    INITIALIZER_BLOCK, // initializer of type declaration
    ARRAY_INITIALIZER_BLOCK, // array initializer
    NORMAL_BLOCK, // Except for the above blocks.
    ;

    private static Map<TypeEnum, Set<Integer>> map = null;
    private static Class<MyParser> parserClass = null;

    public static TypeEnum getBlockType(int rule, MyParser parser) {
        init(parser);
        for (Map.Entry<TypeEnum, Set<Integer>> entry : map.entrySet()) {
            if (entry.getValue().contains(rule)) {
                return entry.getKey();
            }
        }
        return TypeEnum.NORMAL_BLOCK;
    }

    private static void init(MyParser parser) {
        if (parserClass == null || parserClass != parser.getClass()) {
            map = new HashMap<>();
            map.put(BODY_BLOCK, new HashSet<>(List.of(
                parser.getRuleConstructorDeclaration(),
                parser.getRuleMethodDeclaration(),
                parser.getRuleTypeDeclaration()
            )));
            map.put(MULTI_BLOCK_STMT, new HashSet<>(List.of(
                    parser.getRuleIfElseStmt(),
                    parser.getRuleTryCatchStmt()
            )));
            map.put(ARRAY_INITIALIZER_BLOCK, new HashSet<>(List.of(
                    parser.getRuleInitializer(),
                    parser.getRuleArrayInitializer(),
                    parser.getRuleElementValueArrayInitializer()
            )));
        }
    }
}
