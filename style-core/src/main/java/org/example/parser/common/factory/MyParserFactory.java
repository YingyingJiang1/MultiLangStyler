package org.example.parser.common.factory;

import org.apache.commons.logging.Log;
import org.example.parser.common.MyParser;
import org.example.parser.java.MyJavaParser;
import org.slf4j.LoggerFactory;

public class MyParserFactory {
    public static MyParser createParser(String language) {
        String languageName = language.toLowerCase();
        MyParser parser =  switch (languageName) {
            case "java" -> new MyJavaParser();
            default -> null;
        };
        if (parser == null) {
            LoggerFactory.getLogger(MyParserFactory.class).info("Unsupported language: " + language + ".");
            System.exit(0);
        }
        return parser;
    }

    public static MyParser createParser(Class<? extends MyParser> parserClass) {
        MyParser parser =  switch (parserClass.getSimpleName()) {
            case "MyJavaParser" -> new MyJavaParser();
            default -> null;
        };
        if (parser == null) {
            LoggerFactory.getLogger(MyParserFactory.class).info("Unsupported parser class: " + parserClass.getSimpleName() + ".");
            System.exit(0);
        }
        return parser;
    }
}
