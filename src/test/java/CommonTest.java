import org.antlr.v4.runtime.tree.ParseTree;
import org.example.Configuration;
import org.example.StylerContainer;
import org.example.controller.Controller;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.MyParserFactory;
import org.example.style.Style;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.structure.EquivalentStructureManager;
import org.example.styler.structure.StructureStyler;
import org.example.utils.FileCollection;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonTest {
    String srcsDir = "src/test/sources";

    @Test
    void test() throws IOException {
//        EquivalentStructureManager manager = EquivalentStructureManager.getInstance();
//        manager.loadConfFile();
//        manager.writeJsonData("D:\\jyy\\科研\\style\\transformer\\src\\main\\resources\\equivalencesConf.json");
        String src = "D:\\jyy\\科研\\style\\style-transformation\\dataset\\data\\codes\\L131\\human-lil_toeturtle.java";
        String target = "D:\\jyy\\科研\\style\\style-transformation\\dataset\\data\\codes\\L015\\deepseek-coder.java";
        transform(Paths.get(src),
                Paths.get(target));

    }

    protected static void transform(Path sourcePath, Path targetPath) {
        Configuration conf = new Configuration();
        conf.extractionCollection = new FileCollection();
        conf.extractionCollection.add(targetPath);
        conf.applicationCollection = new FileCollection();
        conf.applicationCollection.add(sourcePath);
        conf.styleFileSavedPath = targetPath.getParent().toString() + "\\style.xml";
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
            LoggerFactory.getLogger(CommonTest.class).error(e.getMessage(), e);
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
            LoggerFactory.getLogger(CommonTest.class).error(e.getMessage(), e);
        }
        return null;
    }

}
