package org.example.semantic.factory;

import org.example.semantic.ReferenceResolverImpl;
import org.example.semantic.TypeSystemImpl;
import org.example.semantic.intf.ReferenceResolver;
import org.example.semantic.intf.TypeSystem;

public class TypeSystemFactory {
	public static TypeSystem createTypeSystem(String language) {
		return switch (language) {
			case "java" -> new TypeSystemImpl();
			default -> throw new IllegalArgumentException("Unsupported language: " + language);
		};
	}
}
