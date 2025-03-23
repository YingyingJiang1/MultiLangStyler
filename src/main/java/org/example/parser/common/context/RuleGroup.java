package org.example.parser.common.context;

import java.util.Arrays;
import java.util.List;

public enum RuleGroup {
    DECLARATION_STMT,
    EXPRESSION_STMT,
    CONDITIONAL_STMT,
    LOOP_STMT,
    EXCEPTION_HANDLE_STMT,
    CONCURRENCY_CONTROL_STMT,
    SINGLE_STMT,
    COMPOUND_STMT,
    FUNCTION_DEC,
    TYPE_DEC,
    MEMBER_LIST,
    STANDALONE_BLOCK,
    FILE_HEAD_DEC,
    SELF_RULE,
    ;


    public static RuleGroup getSuperGroup(String type) {
       List<String> singleStmts = Arrays.asList(DECLARATION_STMT.name(), EXPRESSION_STMT.name(), SINGLE_STMT.name());
       List<String> compundStmts = Arrays.asList(CONDITIONAL_STMT.name(), LOOP_STMT.name(), EXCEPTION_HANDLE_STMT.name(), CONCURRENCY_CONTROL_STMT.name(), COMPOUND_STMT.name());

        if (singleStmts.contains(type)) {
            return SINGLE_STMT;
        } else if (compundStmts.contains(type)) {
            return COMPOUND_STMT;
        }
        return null;
    }

    public static boolean isSingleStmt(String typeName) {
        return typeName.equals(SINGLE_STMT.name()) || typeName.equals(DECLARATION_STMT.name()) || typeName.equals(EXPRESSION_STMT.name());
    }

    public static boolean isCompoundStmt(String typeName) {
        return typeName.equals(COMPOUND_STMT.name()) || typeName.equals(CONDITIONAL_STMT.name()) ||
                typeName.equals(LOOP_STMT.name()) || typeName.equals(EXCEPTION_HANDLE_STMT.name()) || typeName.equals(CONCURRENCY_CONTROL_STMT.name());
    }

}
