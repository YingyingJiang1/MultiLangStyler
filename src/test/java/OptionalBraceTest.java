import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class OptionalBraceTest extends IntegrationTest{
    private static final String subDirName = "optional_brace";

    @Test
    public void test() {
        batchTest(1, subDirName);
    }
}
