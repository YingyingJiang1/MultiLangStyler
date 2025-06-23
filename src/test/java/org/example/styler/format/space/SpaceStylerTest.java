package org.example.styler.format.space;

import org.example.TestBase;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpaceStylerTest extends TestBase {

	@Test
	void applyStyle() {
		String[] srcFiles = {
				"src/test/sources/format/space/f1.java",
				"src/test/sources/format/space/f2.java"
		};

		String[] targetFiles = {
				"src/test/sources/format/space/f2.java",
				"src/test/sources/format/space/f1.java"
		};


		for (int i = 0; i < srcFiles.length; i++) {
			String actual = apply(Paths.get(srcFiles[i]), Paths.get(targetFiles[i]), List.of(SpaceStyler.class));
			Path gtPath = Paths.get("src/test/sources/format/space", String.format("gt%s.java", i + 1));
			testCodeEqual(actual, gtPath);
		}
	}
}