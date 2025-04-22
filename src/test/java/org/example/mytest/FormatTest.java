package org.example.mytest;

import org.junit.jupiter.api.Test;

public class FormatTest extends  IntegrationTest{
    private static String subDirName = "format";
    @Test
    public void test() {
        batchTest(3, subDirName, "003");
    }

    /**
     * 003: Test add space between << and >>
     */
}
