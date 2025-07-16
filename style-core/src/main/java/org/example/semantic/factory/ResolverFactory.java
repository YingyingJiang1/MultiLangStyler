package org.example.semantic.factory;

import org.example.semantic.intf.Resolver;
import org.example.semantic.java.JavaResolver;

public class ResolverFactory {
    public static Resolver createResolver(String language) {
        return switch (language) {
            case "java" -> new JavaResolver();
            default -> throw new IllegalArgumentException("Unsupported language: " + language);
        };
    }
}
