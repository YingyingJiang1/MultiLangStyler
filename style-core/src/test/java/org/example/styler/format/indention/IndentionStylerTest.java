package org.example.styler.format.indention;

import org.example.TestBase;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.format.newline.bodylayout.BodyLayoutStyler;
import org.example.styler.format.newline.inter.InterNewlineStyler;
import org.example.styler.format.newline.intra.IntraNewlineStyler;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IndentionStylerTest extends TestBase {
	@Test
	void test() {
		String dir = "src/test/sources/format/indention/";
		String[] srcFiles = {
				"f1.java",
				"f2.java",
				"f3.java",
				"f4.java",
		};

		String[] targetFiles = {
				"f1.java",
				"f2.java",
				"style1.java",
				"style2",
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(IndentionStyler.class));
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