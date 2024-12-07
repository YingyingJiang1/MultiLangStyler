package org.example.semantic;

import org.example.semantic.intf.Resolver;
import org.example.semantic.javaimpl.JavaResolver;

public class ResolverFactory {
    public static Resolver createResolver(String language) {
        if ("java".equals(language)) {
            return new JavaResolver();
        } else {
            throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }
}
