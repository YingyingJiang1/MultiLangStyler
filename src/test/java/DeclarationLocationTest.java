import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DeclarationLocationTest extends IntegrationTest {
    private static String subDirName = "declaration_location";

    /**
     * Bug: 002 pair的debug结果和run结果不一致！
     */
    @Test
    public void test() {
        batchTest(3, subDirName, "003");
    }

    /**
     * 003: Test when there is a function call in the initializer, forbid to move.
     */

}