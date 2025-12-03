package org.example.styler.format.indention;

import org.example.Main;
import org.example.TestBase;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.format.newline.bodylayout.BodyLayoutStyler;
import org.example.styler.format.newline.inter.InterNewlineStyler;
import org.example.styler.format.newline.intra.IntraNewlineStyler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Main.class)
class IndentionStylerTest extends TestBase {
	@Test
	void testJava() {
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
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), "java", List.of(IndentionStyler.class));
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

	@Test
	void testCpp() {
		String dir = "src/test/cpp-sources/indention/";
		String[] srcFiles = {
				"f1.cpp",
				"f2.cpp",
				"f3.cpp",
				"f3.cpp"
		};

		String[] targetFiles = {
				"f2.cpp",
				"f1.cpp",
				"f1.cpp",
				"f2.cpp"
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("%sto%sgt.cpp", srcFiles[i].replace(".cpp", ""), targetFiles[i].replace(".cpp", "")));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), "cpp", List.of(IndentionStyler.class));
			if (false) {
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