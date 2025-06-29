package org.example.styler.format.newline;

import org.example.TestBase;
import org.example.styler.format.indention.IndentionStyler;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class NewlineStylerTest extends TestBase {

	@Test
	void applyStyle() {
		String[] srcFiles = {
				"src/test/sources/format/newline/f1.java",
				"src/test/sources/format/newline/f3.java",
		};
		
		String[] targetFiles = {
				"src/test/sources/format/newline/f2.java",
				"src/test/sources/format/newline/f1.java",
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get("src/test/sources/format/newline", String.format("gt%s.txt", i + 1));
			String actual = apply(Paths.get(srcFiles[i]), Paths.get(targetFiles[i]), List.of(NewlineStyler.class, IndentionStyler.class));
//			try{
//				Files.writeString(gtPath, actual);
//			}	catch (Exception e) {
//				e.printStackTrace();
//			}

			testCodeEqual(actual, gtPath);
//			break;
		}
	}
}