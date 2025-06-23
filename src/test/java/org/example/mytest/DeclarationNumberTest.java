package org.example.mytest;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class DeclarationNumberTest extends IntegrationTest {
    String dir = "src/test/sources/declarationNumber";
    @Test
    void testPair1() {
//        transform(Paths.get(dir, "pair1", "Test.java"), Paths.get(dir, "pair1", "f3.java"));
        transformSingleFile(Paths.get(dir, "pair1", "f3.java"), Paths.get(dir, "pair1", "Test.java"));
    }
}
