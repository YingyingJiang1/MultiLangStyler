package org.example.semantic.factory;

import org.example.semantic.ReferenceResolverImpl;
import org.example.semantic.intf.ReferenceResolver;

public class ReferenceResolverFactory {
    public static ReferenceResolver createReferenceResolver(String language) {
        return switch (language) {
            case "java" -> new ReferenceResolverImpl();
            default -> throw new IllegalArgumentException("Unsupported language: " + language);
        };
    }
}
