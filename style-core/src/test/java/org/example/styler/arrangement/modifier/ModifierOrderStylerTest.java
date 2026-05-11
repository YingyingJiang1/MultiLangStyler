package org.example.styler.arrangement.modifier;

import org.example.MyEnvironment;
import org.example.TestBase;
import org.example.config.MyConfiguration;
import org.example.lang.LangAdapterCreator;
import org.example.style.Style;
import org.example.style.StyleProfile;
import org.example.style.StylerContainer;
import org.example.stylekit.Extractor;
import org.example.styler.arrangement.modifier.style.ModifierOrderProperty;
import org.example.styler.arrangement.modifier.style.ModifierOrderStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ModifierOrderStylerTest extends TestBase {

	@Autowired
	MyConfiguration myConfiguration;

	@Test
	void analyzeInconsistency_matchesGolden() {
		String dir = Paths.get(javaTestCasesDir, "arrangement", "modifier").toString();
		assertAnalyzeInconsistencyMatchesGolden(dir,
				new String[] {"f1.java", "f1-gt.java", "f2.java", "f2-gt.java"},
				new String[] {"style1.xml", "style1.xml", "style2.xml", "style2.xml"},
				List.of(ModifierOrderStyler.class));
	}

	@Test
	void test() {
		String dir = "src/test/sources/arrangement/modifier/";
		String[] srcFiles = {
				"f1.java",
		};

		String[] targetFiles = {
				"style1.xml",
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("f%s-gt.java", i + 1));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(ModifierOrderStyler.class));
			if (false) {
				try{
					Files.writeString(gtPath, actual);
				}	catch (Exception e) {
					e.printStackTrace();
				}
			}

			testCodeEqual(actual, gtPath);
		}
	}

	/**
	 * Nested {@code @FunctionalInterface} with several annotations before keywords and {@code @Deprecated}
	 * between access control and {@code strictfp}. Annotations are omitted from {@link ModifierOrderProperty}
	 * extraction and left in place during apply (only non-annotation modifiers are reordered).
	 */
	@Test
	void functionalInterface_withAnnotationsAtStartAndBetweenModifiers() {
		String dir = Paths.get(javaTestCasesDir, "arrangement", "modifier").toString();
		String actual = apply(Paths.get(dir, "f2.java"), Paths.get(dir, "style2.xml"), List.of(ModifierOrderStyler.class));
		testCodeEqual(actual, Paths.get(dir, "f2-gt.java"));
	}
}