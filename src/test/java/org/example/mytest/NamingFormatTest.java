package org.example.mytest;

import org.junit.jupiter.api.Test;

public class NamingFormatTest extends IntegrationTest {
    private static final String dirName = "naming";

    @Test
    public void test() {
        batchTest(2, dirName, "");
    }
}
