import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class IfElseBodyOrderTest extends IntegrationTest {
    String dir = "src/test/sources/ifelse";

    @Test
    void test() {
        transform(Paths.get(dir, "pair1", "src.java"), Paths.get(dir, "pair1", "target.java"));
    }
}
