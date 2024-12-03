import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.Styler;
import org.example.styler.format.linestmt.LineStmtStyler;
import org.example.styler.format.linestmt.style.LineStmtContext;
import org.example.styler.format.newline.style.NewlineProperty;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineStmtCommonTest extends CommonTest {
    public static final String dir = "src/test/sources/linestmt";

    @Test
    void test() {
        LineStmtStyler styler = new LineStmtStyler();
        extractFromSrcFile(Paths.get(dir, "multiStmtInLine.java"), styler, "java");

        StyleRule[] expected = {
                new StyleRule(new LineStmtContext(61), new NewlineProperty(0)),
                new StyleRule(new LineStmtContext(0), new NewlineProperty(1))
        };

        StyleRule[] actual = styler.getStyle().getRules().toArray(new StyleRule[0]);
        assertArrayEquals(expected, actual);
    }
}
