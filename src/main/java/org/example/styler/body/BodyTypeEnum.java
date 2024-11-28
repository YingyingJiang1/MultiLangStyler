package org.example.styler.body;

import org.example.parser.common.MyParser;

import java.util.*;

public enum BodyTypeEnum {
    DEC_BODY, // Body of type declaration or method declaration.
    MULTI_BLOCK_STMT_BODY, // if-else, try-catch-finally
    DO_WHILE_BODY,
    INITIALIZER_BODY, // initializer of type declaration
    ARRAY_INITIALIZER_BODY, // array initializer
    NORMAL_BODY, // Except for the above blocks.
    ;

    private static Map<BodyTypeEnum, Set<Integer>> map = null;
    private static Class<MyParser> parserClass = null;

    public static BodyTypeEnum getBlockType(int rule, MyParser parser) {
        init(parser);
        for (Map.Entry<BodyTypeEnum, Set<Integer>> entry : map.entrySet()) {
            if (entry.getValue().contains(rule)) {
                return entry.getKey();
            }
        }
        return BodyTypeEnum.NORMAL_BODY;
    }

    private static void init(MyParser parser) {
        if (parserClass == null || parserClass != parser.getClass()) {
            map = new HashMap<>();
            map.put(DEC_BODY, new HashSet<>(List.of(
                parser.getRuleConstructorDeclaration(),
                parser.getRuleMethodDeclaration(),
                parser.getRuleTypeDeclaration()
            )));
            map.put(MULTI_BLOCK_STMT_BODY, new HashSet<>(List.of(
                    parser.getRuleIfElseStmt(),
                    parser.getRuleTryCatchStmt()
            )));
            map.put(ARRAY_INITIALIZER_BODY, new HashSet<>(List.of(
                    parser.getRuleInitializer(),
                    parser.getRuleArrayInitializer(),
                    parser.getRuleElementValueArrayInitializer()
            )));
        }
    }
}
