package org.example.styler.body.optionalbrace;

import org.example.TestBase;
import org.example.styler.optionalbrace.OptionalBraceStyler;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class OptionalBraceStylerTest extends TestBase {

	@Test
	void test() {
		String dir = "src/test/sources/brace";
		String[] srcFiles = {
				"f1.java",
		};

		String[] targetFiles = {
				"style1.xml",
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("f%s-gt.java", i + 1));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(OptionalBraceStyler.class));
			if (true) {
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