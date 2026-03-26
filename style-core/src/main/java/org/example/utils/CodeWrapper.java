package org.example.utils;

/**
 * Wrap/unwrap code snippets so they can be parsed and formatted as complete units.
 */
public interface CodeWrapper {
	/**
	 * Result of wrapping a snippet.
	 *
	 * @param wrappedCode full code string used for parsing/formatting
	 * @param prefix      text inserted before the original code
	 * @param suffix      text inserted after the original code
	 */
	record WrapResult(String wrappedCode, String prefix, String suffix) {
	}

	CodeWrapResult wrap(String code);

	/**
	 * Unwrap formatted wrapped code back to the original snippet.
	 */
	String unwrap(CodeWrapResult wrapResult);
}