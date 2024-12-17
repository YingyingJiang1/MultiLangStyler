import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.MyParserFactory;
import org.example.parser.java.MyJavaParser;
import org.example.parser.java.antlr.JavaParser;
import org.example.style.Style;
import org.example.styler.Styler;
import org.example.styler.structure.EquivalentStructureManager;
import org.example.styler.structure.StructureStyler;
import org.example.styler.structure.style.StructPreferenceContext;
import org.example.styler.structure.style.StructPreferenceProperty;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StructurePreferenceTest extends CommonTest {
    String language = "java";
    String dir = "D:\\jyy\\科研\\style\\style-transformation\\dataset\\data\\codes";
    @Test
    void test() throws IOException {
//        EquivalentStructureManager manager = EquivalentStructureManager.getInstance();
//        manager.loadEquivalences(MyJavaParser.class);
//        manager.writeJsonData("confUpdate.json");
//        EquivalentStructureManager.getInstance().loadEquivalences(MyJavaParser.class);

        transform(Paths.get(dir, "L016\\claude35sonnet.java"), Paths.get(dir, "L016\\claude35sonnet.java"));
    }


    void resultOfTest(Style style, int targetId, int targetIndex) {
        StructPreferenceProperty property = (StructPreferenceProperty) style.getProperty(new StructPreferenceContext("", targetId));
        assertEquals(targetIndex, property.getPreferenceIndex());
    }

    @Test
    void testInc() {
        int id = 1;
        String target = "i+=1;";
        Style style = extractFromString(target, new StructureStyler(), "java");
        resultOfTest(style, id, 2);

        target = "i=i+1;";
        style = extractFromString(target, new StructureStyler(), "java");
        resultOfTest(style, id, 3);
    }

    @Test
    void testAssign() {
        int id = 3;
        String target = "id +=5;";
        Style style = extractFromString(target, new StructureStyler(), "java");
        resultOfTest(style, id, 1);

        target = "id = id + 4;";
        style = extractFromString(target, new StructureStyler(), "java");
        resultOfTest(style, id, 0);
    }

    @Test
    void testNestingIf() {
        int id = 4;

    }

    @Test
    void testOpPrefer() {
        int id = 18;
        String target = "a < b";
        Style style = extractFromString(target, new StructureStyler(), "java");
        resultOfTest(style, id, 0);
    }

    @Test
    void testLiteralPosition() {
        int id = 22;
        String target = "x == 1";
        Style style = extractFromString(target, new StructureStyler(), "java");
        resultOfTest(style, id, 1);
    }

    @Test
    void testRedudantCode() {
        int id = 32;
        String target = "void test() {if (a > 0) a++; b += 3;}";
        Style style = extractFromString(target, new StructureStyler(), "java");
        resultOfTest(style, id, 0);
    }

    @Test
    void testContinue() {
        int id = 30;
        String target = "void test() {while(true){if (a > 0) continue; c--; b += 3;}}";
        Style style = extractFromString(target, new StructureStyler(), "java");
        resultOfTest(style, id, 0);
    }


    @Test
    void testCascadingIf() {
        int id = 5;
        String target = "if (a || b) return c;";
        Style style = extractFromString(target, new StructureStyler(), "java");
        resultOfTest(style, id, 0);
    }

}
