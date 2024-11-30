package org.example.parser.common.factory;

import org.apache.commons.logging.Log;
import org.example.parser.common.MyParser;
import org.example.parser.java.MyJavaParser;
import org.slf4j.LoggerFactory;

public class MyParserFactory {
    public static MyParser createParser(String language) {
        MyParser parser =  switch (language) {
            case "java" -> new MyJavaParser();
            default -> null;
        };
        if (parser == null) {
            LoggerFactory.getLogger(MyParserFactory.class).info("Unsupported language: " + language + ".");
            System.exit(0);
        }
        return parser;
    }
}
