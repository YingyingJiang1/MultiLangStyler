import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FormatTest extends  IntegrationTest{
    private static final Path curCodesPath = Paths.get(codesDir, "format");

    @Test
    public void test() {
        batchTest(1, "format");
    }
}
