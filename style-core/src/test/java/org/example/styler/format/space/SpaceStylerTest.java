package org.example.styler.format.space;

import org.example.TestBase;
import org.example.styler.format.indention.IndentionStyler;
import org.example.styler.format.newline.NewlineStyler;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpaceStylerTest extends TestBase {

	@Test
	void applyStyle() {
		String dir = "src/test/sources/format/space/";
		String[] srcFiles = {
				"f1.java",
				"f2.java",
		};

		String[] targetFiles = {
				"f2.java",
				"f1.java",
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("gt%s.java", i + 1));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(SpaceStyler.class));
			if (false) {
				try{
					Files.writeString(gtPath, actual);
				}	catch (Exception e) {
					e.printStackTrace();
				}
			}

			try {
				testCodeEqual(actual, gtPath);
			} catch (AssertionFailedError e) {
				System.out.printf("Pair %d test failed%n", i + 1);
			}
//			break;
		}
	}
}