package org.example.mytest;

import org.junit.jupiter.api.Test;

public class OptionalBraceTest extends IntegrationTest{
    private static final String subDirName = "optional_brace";

    @Test
    public void test() {
        batchTest(1, subDirName, "");
    }
}
