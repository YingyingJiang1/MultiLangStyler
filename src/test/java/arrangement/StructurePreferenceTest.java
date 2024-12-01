package arrangement;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.debug.TreePrinter;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.MyParserFactory;
import org.example.parser.common.factory.ParseTreeFactory;
import org.example.parser.java.MyJavaParser;
import org.example.parser.java.antlr.JavaParser;
import org.example.styler.Styler;
import org.example.styler.structure.EquivalentStructureManager;
import org.example.styler.structure.StructureStyler;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StructurePreferenceTest {
    String language = "java";
    @Test
    void test() throws IOException {
        EquivalentStructureManager manager = EquivalentStructureManager.getInstance();
        manager.loadEquivalences();
        manager.writeJsonData("confUpdate.json");
        EquivalentStructureManager.getInstance().loadEquivalences();
//        testA();

    }

    void transform(String source, String target) {

        Styler styler = new StructureStyler();

        MyParser parser = MyParserFactory.createParser(language);
        ExtendContext t = (ExtendContext) parser.parseFromString(target);
        styler.extractStyle(t, parser);

        ExtendContext t1 = (ExtendContext) parser.parseFromString(source);
        ExtendContext newTree = styler.applyStyle(t1, parser);
        assertEquals(t.getText(), newTree.getText());
    }

    @Test
    void testA() {

        String source = "if (a == b) { return 1;}else return 0;";
        String target = "return a==b?1:0;";
        transform(source, target);
    }
}
