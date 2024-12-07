import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class NamingFormatTest extends CommonTest{
    String dir = "src/test/sources/namingformat";

    @Test
    void testPair1() {
        transform(Paths.get(dir, "pair1", "src.java"), Paths.get(dir, "pair1", "target.java"));
    }
}
