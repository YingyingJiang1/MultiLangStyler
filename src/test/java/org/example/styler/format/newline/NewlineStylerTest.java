package org.example.styler.format.newline;

import org.example.TestBase;
import org.example.style.Style;
import org.example.styler.Styler;
import org.example.styler.format.body.braceformat.BraceFormatStyler;
import org.example.styler.format.indention.IndentionStyler;
import org.example.styler.format.indention.style.IndentionStyle;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NewlineStylerTest extends TestBase {

	@Test
	void extractStyle() {
	}

	@Test
	void applyStyle() {
		List<Class<? extends Object>> stylerClasses = List.of(BraceFormatStyler.class, IndentionStyler.class);
		// test newline around braces
		String dir = "src/test/sources/format/newline";
		Path f1 = Paths.get(dir, "f1.java");
		Path f2 = Paths.get(dir, "f2.java");

		String code1 = apply(f1, f2, stylerClasses);
		testCodeEqual(code1, Paths.get(dir, "gt1.java"));
	}
}