package org.example.mytest;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class ModifierOrderTest extends IntegrationTest {

    String dir = "src/test/sources/modifierorder";
    @Test
    public void testPair1() {
        transformSingleFile(Paths.get(dir, "pair1", "Test.java"),
                Paths.get(dir, "pair1", "target.java")
        );
    }
}
