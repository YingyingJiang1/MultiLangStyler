package org.example.semantic;

import org.example.semantic.intf.ReferenceResolver;
import org.example.semantic.intf.Resolver;

public class ReferenceResolverFactory {
    public static ReferenceResolver createReferenceResolver(String language) {
        return switch (language) {
            case "java" -> new ReferenceResolverImpl();
            default -> throw new IllegalArgumentException("Unsupported language: " + language);
        };
    }
}
