import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class LiteralUsageTest extends IntegrationTest {
    String dir =  "src/test/sources/literalusage";
    @Test
    void testPair1() {
        Path dirPath = Paths.get(dir, "pair1");
        transformSingleFile(Paths.get(dirPath.toString(), "src.java"), Paths.get(dirPath.toString(), "target.java"));
    }
}
