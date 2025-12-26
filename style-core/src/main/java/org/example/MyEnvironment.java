package org.example;

import org.example.config.MyConfiguration;
import org.example.config.IConfig;
import org.example.lang.intf.symbol.ReferenceResolver;
import org.example.lang.intf.symbol.Resolver;
import org.example.lang.intf.symbol.TypeResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyEnvironment {
    private static IConfig config;
    public static Logger logger = LoggerFactory.getLogger(MyEnvironment.class);

    private static String language = "";
    private static String pathSeparator;
    private static Resolver resolver;
    private static ReferenceResolver referenceResolver;
    private static TypeResolver typeResolver;


    public static void setLanguage(String language) {
        MyEnvironment.language = language;

        if (language.equals("java")) {
            pathSeparator = ".";
        }
    }

    public static String getPathSeparator() {
        return pathSeparator;
    }

    public static String getLanguage() {
        return language;
    }

    public static Resolver getResolver() {
        return resolver;
    }

    public static TypeResolver getTypeResolver() {
        return typeResolver;
    }

    public static void setConf(MyConfiguration conf) {
        MyEnvironment.config = conf;
    }

    public static ReferenceResolver getReferenceResolver() {
        return referenceResolver;
    }

    public static IConfig getIConfig() {
        return config;
    }

}
