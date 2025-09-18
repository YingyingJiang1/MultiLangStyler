package org.example.styler.arrangement.modifier;

import org.example.TestBase;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class ModifierOrderStylerTest extends TestBase {

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
}