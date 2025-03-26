import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CommentTest extends IntegrationTest{
    private static final String dirName = "comment";

    @Test
    public void test() {
        batchTest(2, dirName, "");
    }
}
