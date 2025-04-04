import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class IfElseBodyOrderTest extends IntegrationTest {
    String dir = "src/test/sources/ifelse";

    @Test
    public  void test() {
        transformSingleFile(Paths.get(dir, "pair1", "Test.java"), Paths.get(dir, "pair1", "target.java"));
    }
}
