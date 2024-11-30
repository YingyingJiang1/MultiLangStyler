package arrangement;


import org.example.Configuration;
import org.example.controller.Controller;
import org.example.style.ProgramStyle;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Paths;


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
        conf.applicationCollection.add(Paths.get(dir + File.separator + "2022hungnguyennaz-TranslationRegistry-source.java"));
        conf.styleFileSavedPath = dir + File.separator + "sample-style.xml";
        Controller controller = new Controller(conf);
        ProgramStyle programStyle = controller.execute();

    }

}
