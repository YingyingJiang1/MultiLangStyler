package org.example.style;

import org.example.Configuration;
import org.example.controller.Controller;
import org.example.utils.FileCollection;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

public class SelfStyle {
    private static ProgramStyle programStyle = null;

    public static void extractStyle(Path filePath) {
        FileCollection fileCollection = new FileCollection();
        fileCollection.add(filePath);
        Configuration conf = new Configuration();
        conf.extractionCollection = fileCollection;

        Controller controller = new Controller(conf);
        programStyle = controller.extractStyle(fileCollection);
    }

    public static Style getStyle(String styleName) {
        if (programStyle == null) {
            return null;
        }
        return programStyle.getStyle(styleName);
    }

    public static ProgramStyle getProgramStyle() {
        return programStyle;
    }
}
