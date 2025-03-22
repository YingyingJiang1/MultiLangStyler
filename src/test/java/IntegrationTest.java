import org.example.Configuration;
import org.example.controller.Controller;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.MyParserFactory;
import org.example.style.Style;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.utils.FileCollection;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {
    public static final String codesDir = "src/test/sources";

    @Test
    public void test() throws IOException {
//        EquivalentStructureManager manager = EquivalentStructureManager.getInstance();
//        manager.loadConfFile();
//        manager.writeJsonData("D:\\jyy\\科研\\style\\transformer\\src\\main\\resources\\equivalencesConf.json");
        String dir = "C:\\Users\\dell\\jyy\\科研\\code-style-transformation\\experiment\\result\\forsee_analysis\\weakness\\claude35sonnet\\001";
        Path src = Paths.get(dir, "src.java");
        Path target = Paths.get(dir, "target.java");
        transform(src, target);

    }

    public static void batchTest(int pairNumber, String subDir) {
        for (int i = 1; i <= pairNumber; i++) {
            String strNumber = String.format("%03d", i);
            Path src = Paths.get(codesDir, subDir, strNumber, "src.java");
            Path target = Paths.get(codesDir, subDir, strNumber, "target.java");
            if (!src.toFile().exists()) {
                System.out.println(src.toString() + " not exists...skip!");
                continue;
            }
            transform(src, target);

            // Get ground truth and transform result
            File dir = new File(Paths.get(codesDir, subDir, String.format("%03d", i)).toString());
            File[] files = dir.listFiles();
            File groundTruthFile = null, resultFile = null;
            if (files != null) {
                for (File file : files) {
                    if (file.getName().equals("ground_truth.java")) {
                        groundTruthFile = file;
                    } else if (file.getName().equals("result.java")) {
                        resultFile = file;
                    }
                }
            }

            // Compare the ground truth and transform result.
            if (groundTruthFile != null && resultFile != null) {
                System.out.printf("Test %s/%s...", subDir, strNumber);
                try {
                    String groundTruth = Files.readString(groundTruthFile.toPath());
                    String result = Files.readString(resultFile.toPath());
                    assertEquals(groundTruth, result);
                    System.out.println("OK!");
                } catch (IOException e) {
                    System.err.print("Test failed: failed to read file!");
                }
            } else {
                System.out.println("ground_truth.java or result.java not exists...skip comparation!");
            }
        }
    }




    protected static void transform(Path sourcePath, Path targetPath) {
        Configuration conf = new Configuration();
        conf.extractionCollection = new FileCollection();
        conf.extractionCollection.add(targetPath);
        conf.applicationCollection = new FileCollection();
        conf.applicationCollection.add(sourcePath);
        conf.setResOutFile(sourcePath.getParent() + File.separator + "result.java");
        conf.setStyleOutPath(targetPath.getParent().toString() + "\\style.xml");
        Controller controller = new Controller(conf);
        controller.execute();
    }

    protected static Style extractFromString(String code, Styler styler, String language) {
        MyParser parser = MyParserFactory.createParser(language);
        ExtendContext t = (ExtendContext) parser.parseFromString(code);
        parser.walkTree(Stage.EXTRACT, List.of(styler));
        styler.extractStyle(t, parser);
        styler.doFinalize();
        return styler.getStyle();
    }


    protected static Style extractFromSrcFile(Path srcPath, Styler styler, String language) {
        try {
            MyParser parser = MyParserFactory.createParser(language);
            ExtendContext t = (ExtendContext) parser.parse(srcPath);
            parser.walkTree(Stage.EXTRACT, List.of(styler));
            styler.extractStyle(t, parser);
            styler.doFinalize();
            return styler.getStyle();
        } catch (IOException e) {
            LoggerFactory.getLogger(IntegrationTest.class).error(e.getMessage(), e);
        }
        return null;
    }

    protected static ExtendContext apply2String(String code, Styler styler, String language) {
        MyParser parser = MyParserFactory.createParser(language);
        ExtendContext t1 = (ExtendContext) parser.parseFromString(code);
        parser.walkTree(Stage.APPLY, List.of(styler));
        return styler.applyStyle(t1, parser);
    }

    protected static ExtendContext apply2srcFile(Path srcPath, Styler styler, String language) {
        try {
            MyParser parser = MyParserFactory.createParser(language);
            ExtendContext t1 = (ExtendContext) parser.parse(srcPath);
            parser.walkTree(Stage.APPLY, List.of(styler));
            return styler.applyStyle(t1, parser);
        } catch (IOException e) {
            LoggerFactory.getLogger(IntegrationTest.class).error(e.getMessage(), e);
        }
        return null;
    }

}
