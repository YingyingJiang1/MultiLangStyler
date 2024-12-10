package org.example.semantic;

import org.example.semantic.intf.Resolver;

public class ResolverFactory {
    public static Resolver createResolver(String language) {
        return switch (language) {
            case "java" -> new ResolverImpl();
            default -> throw new IllegalArgumentException("Unsupported language: " + language);
        };
    }
}
