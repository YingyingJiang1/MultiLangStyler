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
    public void test() throws IOException {
//        EquivalentStructureManager manager = EquivalentStructureManager.getInstance();
//        manager.loadEquivalences(MyJavaParser.class);
//        manager.writeJsonData("confUpdate.json");
//        EquivalentStructureManager.getInstance().loadEquivalences(MyJavaParser.class);

        transform(Paths.get(dir, "L016\\claude35sonnet.java"), Paths.get(dir, "L016\\claude35sonnet.java"));
    }

    @Test
    public void testExpressionStmt() {
        batchTest(1, "expression_stmt", null);
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
        String target = null;
        Style style = null;
        int id = 32;
//        target = "void test() {if (a > 0) a++; b += 3;}";
//        style = extractFromString(target, new StructureStyler(), "java");
//        resultOfTest(style, id, 0);

        target = "void test() {if (a > 0) { a++; b += 3;} else {b+=3;}}";
        style = extractFromString(target, new StructureStyler(), "java");
        resultOfTest(style, id, 1);
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

    @Test
    void testReturn() {
        int id = 23;
        String target = "if (cond) {int ret = test(); return ret;}";
        Style style = extractFromString(target, new StructureStyler(), "java");
        resultOfTest(style, id, 0);

        target = "if (cond) {return test();}";
        style = extractFromString(target, new StructureStyler(), "java");
        resultOfTest(style, id, 1);

        id = 24;
        target = "if (cond) {return (a+b);}";
        style = extractFromString(target, new StructureStyler(), "java");
        resultOfTest(style, id, 0);
    }

    @Test
    void testArrayDec() {
        int id = 25;
        String target = "String[] a;";
        Style style = extractFromString(target, new StructureStyler(), "java");
        resultOfTest(style, id, 0);
    }

    @Test
    void testCheckThenAssign() {
        int id = 16;
        String target = "void test() {int a = 1; if (b > 0) { a = b; }}";
        Style style = extractFromString(target, new StructureStyler(), "java");
        resultOfTest(style, id, 0);
        target = "void test() {int a = b > 0 ? b : 1;}";
        style = extractFromString(target, new StructureStyler(), "java");
        resultOfTest(style, id, 1);

        id =17;
        target = "void test() {if (b > 0) a = b; else a = 1;}";
        style = extractFromString(target, new StructureStyler(), "java");
        resultOfTest(style, id, 1);

    }

}
