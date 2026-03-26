package org.example.utils;

public class WrapResult {
	public final String wrappedCode;
	public final String prefix;
	public final String suffix;

	public WrapResult(String wrappedCode, String prefix, String suffix) {
		this.wrappedCode = wrappedCode;
		this.prefix = prefix;
		this.suffix = suffix;
	}
}
