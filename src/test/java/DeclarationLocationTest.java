import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DeclarationLocationTest extends IntegrationTest {
    private static String subDirName = "declaration_location";
    @Test
    public void test() {
        batchTest(1, subDirName);
    }

}