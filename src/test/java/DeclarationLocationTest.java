import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DeclarationLocationTest extends IntegrationTest {
    private static final Path curCodesPath = Paths.get(codesDir, "declaration_location");

    @Test
    public void test() {
        batchTest(1, "declaration_location");
    }
}