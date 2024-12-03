import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.MyParserFactory;
import org.example.styler.Styler;
import org.example.styler.structure.EquivalentStructureManager;
import org.example.styler.structure.StructureStyler;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StructurePreferenceTest extends CommonTest {
    String language = "java";
    @Test
    void test() throws IOException {
        EquivalentStructureManager manager = EquivalentStructureManager.getInstance();
        manager.loadEquivalences();
        manager.writeJsonData("confUpdate.json");
        EquivalentStructureManager.getInstance().loadEquivalences();
//        testA();

    }



    @Test
    void testA() {

        String source = "if (a == b) { return 1;}else return 0;";
        String target = "return a==b?1:0;";

    }
}
