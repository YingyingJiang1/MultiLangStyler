package arrangement;


import org.example.Configuration;
import org.example.Controller;
import org.example.style.ProgramStyle;
import org.example.styler.body.BodyTypeEnum;
import org.example.styler.body.BodyContext;
import org.example.styler.body.BodyNumType;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Paths;
import java.util.Objects;


public class ArrangementTest {
    @Test
    public void executeTest() {
//        test1();
    }

    @Test
    public void test1() {
        Configuration conf = new Configuration();
        String dir = "src/test/sources/arrangement1";
        conf.extractionCollection.clear();
        conf.extractionCollection.add(Paths.get(dir + File.separator + "2022trhacknon-AccessibilityEventCompat-target.java"));
        conf.applicationCollection.clear();
        conf.styleFileSavedPath = dir + File.separator + "sample-style.xml";
        Controller controller = new Controller(conf);
        ProgramStyle programStyle = controller.execute();

    }

}
