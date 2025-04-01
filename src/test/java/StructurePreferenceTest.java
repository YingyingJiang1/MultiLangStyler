import org.example.style.Style;
import org.example.styler.structure.StructureStyler;
import org.example.styler.structure.style.StructPreferenceContext;
import org.example.styler.structure.style.StructPreferenceProperty;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StructurePreferenceTest extends IntegrationTest {
    String language = "java";
    String dir = "D:\\jyy\\科研\\style\\style-transformation\\dataset\\data\\codes";

    @Test
    public void testAll() {
        testExpressionStmt();
        testConditionalStmt();
        testConditionalStmt();
    }


    @Test
    public void testExpressionStmt() {
        batchTest(3, "structure/expression_stmt", "");
    }

    @Test
    public void testConditionalStmt() {
        batchTest(3, "structure/conditional_branch", "");
    }

    @Test
    public void testContinueBranchStmt() {
        batchTest(3, "structure/continue_branch", "");
    }


}
