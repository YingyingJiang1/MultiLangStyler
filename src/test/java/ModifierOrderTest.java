import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class ModifierOrderTest extends IntegrationTest {

    String dir = "src/test/sources/modifierorder";
    @Test
    public void testPair1() {
        transform(Paths.get(dir, "pair1", "src.java"),
                Paths.get(dir, "pair1", "target.java")
        );
    }
}
