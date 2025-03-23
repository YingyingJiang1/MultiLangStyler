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
        batchTest(2, subDirName, "002");
    }

}