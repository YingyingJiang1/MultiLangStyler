package org.example.mytest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StructurePreferenceTest extends IntegrationTest {
    String language = "java";
    String dir = "D:\\jyy\\科研\\style\\style-transformation\\dataset\\data\\codes";

    @Test
    public void testAll() {
        testExpressionStmt();
        testConditionalStmt();
        testConditionalStmt();
    }


    @Test
    public void testExpressionStmt() {
        batchTest(3, "structure/expression_stmt", "");
    }

    @Test
    public void testConditionalStmt() {
        batchTest(3, "structure/conditional_branch", "");
    }

    @Test
    public void testContinueBranchStmt() {
        batchTest(3, "structure/continue_branch", "");
    }


}
