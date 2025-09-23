package org.example.styler.exp.complexity;

import org.example.TestBase;
import org.example.styler.format.space.SpaceStyler;
import org.example.styler.structure.StructureStyler;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionStylerTest extends TestBase {

	@Test
	void testSplit() {
		String dir = "src/test/sources/expression_complexity";
		String[] srcFiles = {
				"f1.java",
		};

		String[] targetFiles = {
				"style1.xml",
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(
					ExpressionStyler.class
			));
			if (true) {
				try {
					Files.writeString(gtPath, actual);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


			testCodeEqual(actual, gtPath);
		}
	}

}