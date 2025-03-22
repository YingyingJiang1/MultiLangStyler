package org.example.global;

import org.example.global.specialclass.JavaSpecialClass;
import org.example.global.specialclass.SpecialClass;
import org.example.semantic.ReferenceResolverFactory;
import org.example.semantic.ResolverFactory;
import org.example.semantic.intf.ReferenceResolver;
import org.example.semantic.intf.Resolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalInfo {
    public static Logger logger = LoggerFactory.getLogger(GlobalInfo.class);

    private static String language = "";
    private static String pathSeparator;
    private static SpecialClass specialClass;
    private static Resolver resolver;
    private static ReferenceResolver referenceResolver;


    public static void setLanguage(String language) {
        GlobalInfo.language = language;
        if (language.equals("java")) {
            pathSeparator = ".";
            specialClass = new JavaSpecialClass();
            resolver = ResolverFactory.createResolver(language);
            referenceResolver = ReferenceResolverFactory.createReferenceResolver(language);
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

    public static String getLanguage() {
        return language;
    }

    public static Resolver getResolver() {
        return resolver;
    }

    public static ReferenceResolver getReferenceResolver() {
        return referenceResolver;
    }
}
