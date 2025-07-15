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
		String dir = "src/test/sources/format/newline/";
		String[] srcFiles = {
				"f1.java",
				"f3.java",
				"f1.java",
				"f5.java",
				"f7.java"
		};
		
		String[] targetFiles = {
				"f2.java",
				"f1.java",
				"f4.java",
				"f4.java",
				"f7.java"
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("gt%s.txt", i + 1));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(NewlineStyler.class, IndentionStyler.class));
			if (false) {
							try{
				Files.writeString(gtPath, actual);
			}	catch (Exception e) {
				e.printStackTrace();
			}
			}


			testCodeEqual(actual, gtPath);
//			break;
		}
	}
}