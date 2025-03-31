import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class NamingFormatTest extends IntegrationTest {
    private static final String dirName = "naming";

    @Test
    public void test() {
        batchTest(2, dirName, "");
    }
}
