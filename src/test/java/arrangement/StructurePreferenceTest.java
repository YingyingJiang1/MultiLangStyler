package arrangement;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.parser.common.factory.MyParserFactory;
import org.example.parser.common.factory.ParseTreeFactory;
import org.example.parser.java.MyJavaParser;
import org.example.parser.java.antlr.JavaParser;
import org.example.styler.structure.EquivalentStructureManager;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class StructurePreferenceTest {
    @Test

    void test() throws IOException {
        EquivalentStructureManager manager = EquivalentStructureManager.getInstance();
        manager.loadConfFile();
        manager.writeJsonData("equivalence_conf.json");

    }

    void testIncDec() {
        String code1 = "++i;";
        String code2 = "i += 1;";

        MyParserFactory.createParser("java").parse(code1);
    }
}
