package org.example.mytest;

import org.junit.jupiter.api.Test;


public class ArrangementTest extends IntegrationTest {
    @Test
    public void executeTest() {
//        test1();
    }

    @Test
    public void test() {
        IntegrationTest.batchTest(1, "arrangement", null);
    }

}
