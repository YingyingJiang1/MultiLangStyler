package org.example.style;

import org.example.Configuration;
import org.example.Controller;
import org.example.StylerContainer;
import org.example.myException.ExtractException;
import org.example.utils.FileCollection;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

public class SelfStyle {
    private static ProgramStyle programStyle = null;

    public static void extractStyle(Path filePath) {
        try {
            FileCollection fileCollection = new FileCollection();
            fileCollection.add(filePath);
            Configuration conf = new Configuration();
            conf.extractionCollection = fileCollection;

            Controller controller = new Controller(conf);
            programStyle = controller.extractStyle(fileCollection);
            programStyle = new ProgramStyle();
        } catch (ExtractException e) {
            LoggerFactory.getLogger(SelfStyle.class).warn("Failed to extract style for the program undergoing style transformation!");
        }
    }

    public static Style getStyle(Class<? extends Style> stylerClass) {
        return programStyle.getStyle(stylerClass);
    }
}
