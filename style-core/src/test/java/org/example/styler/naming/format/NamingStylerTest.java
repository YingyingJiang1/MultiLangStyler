package org.example.styler.naming.format;

import org.example.TestBase;
import org.example.styler.structure.StructureStyler;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class NamingStylerTest extends TestBase {
  @Test
	void test() {
	  String dir = "src/test/sources/naming/";
	  String[] srcFiles = {
			  "f1.java",
			  "f2.java"
	  };

	  String[] targetFiles = {
			  "f2.java",
			  "f1.java"
	  };

	  for (int i = 0; i < srcFiles.length; i++) {
		  Path gtPath = Paths.get(dir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
		  String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(NamingStyler.class));
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