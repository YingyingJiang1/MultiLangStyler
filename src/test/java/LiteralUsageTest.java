import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class LiteralUsageTest extends CommonTest{
    String dir =  "src/test/sources/literalusage";
    @Test
    void testPair1() {
        Path dirPath = Paths.get(dir, "pair1");
        transform(Paths.get(dirPath.toString(), "src.java"), Paths.get(dirPath.toString(), "target.java"));
    }
}
