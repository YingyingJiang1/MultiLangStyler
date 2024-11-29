package org.example.parser.common.factory;

import org.example.parser.common.MyParser;
import org.example.parser.java.MyJavaParser;

public class MyParserFactory {
    public static MyParser createParser(String filename) {
        String fileType = filename.substring(filename.lastIndexOf('.') + 1);
        return switch (fileType) {
            case "java" -> MyJavaParser.getInstance();
            default -> throw new IllegalArgumentException("Unsupported file type: " + fileType + ".");
        };
    }
}
