package org.example.utils;

public final class CodeWrapperFactory {
	private CodeWrapperFactory() {
	}

	public static CodeWrapper createWrapper(String language) {
		return new CodeWrapperBase();
	}
}

