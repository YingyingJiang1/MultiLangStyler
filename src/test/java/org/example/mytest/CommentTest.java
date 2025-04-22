package org.example.mytest;

import org.junit.jupiter.api.Test;

public class CommentTest extends IntegrationTest{
    private static final String dirName = "comment";

    @Test
    public void test() {
        batchTest(3, dirName, "003");
    }
}
