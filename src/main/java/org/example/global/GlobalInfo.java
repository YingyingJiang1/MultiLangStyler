package org.example.global;

import org.example.global.specialclass.JavaSpecialClass;
import org.example.global.specialclass.SpecialClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalInfo {
    public static Logger logger = LoggerFactory.getLogger(GlobalInfo.class);

    private static String language = "";
    private static String pathSeparator;
    private static SpecialClass specialClass;

    public static void setLanguage(String language) {
        GlobalInfo.language = language;
        if (language.equals("java")) {
            pathSeparator = ".";
            specialClass = new JavaSpecialClass();
        } else {
            logger.error("Unsupported language: " + language);
        }
    }

    public static String getPathSeparator() {
        return pathSeparator;
    }

    public static SpecialClass getSpecialClass() {
        return specialClass;
    }
}
