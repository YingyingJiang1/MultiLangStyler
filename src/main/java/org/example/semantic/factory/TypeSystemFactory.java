package org.example.semantic.factory;

import org.example.semantic.TypeResolverImpl;
import org.example.semantic.intf.TypeResolver;

public class TypeSystemFactory {
	public static TypeResolver createTypeSystem(String language) {
		return switch (language) {
			case "java" -> new TypeResolverImpl();
			default -> throw new IllegalArgumentException("Unsupported language: " + language);
		};
	}
}
