package org.example;

import org.example.controller.Controller;
import org.example.controller.StylerContainer;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.MyParserFactory;
import org.example.parser.common.token.ExtendToken;
import org.example.parser.java.antlr.JavaParser;
import org.example.style.ProgramStyle;
import org.example.style.Style;
import org.example.style.StyleFileIO;
import org.example.styler.Styler;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.structure.StructureStyler;
import org.example.utils.FileCollection;
import org.example.utils.FileCollector;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.support.SimpleTriggerContext;
import pascal.taie.analysis.pta.core.heap.Obj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestBase {


	Logger logger = LoggerFactory.getLogger(TestBase.class);
	protected Style extract(String path) {
		return null;
	}


	/**
	 * Framework of applystyle test
	 */
//	@Test
//	void applyStyle() {
//	String dir = "src/test/sources/structure/redundant_code/";
//	String[] srcFiles = {
//			"f1.java",
//			"f1.java"
//	};
//
//	String[] targetFiles = {
//			"f2.java",
//			"style2.xml"
//	};
//
//		for (int i = 0; i < srcFiles.length; i++) {
//		Path gtPath = Paths.get(dir, String.format("gt%s.java", i + 1));
//		String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(StructureStyler.class));
////			try{
////				Files.writeString(gtPath, actual);
////			}	catch (Exception e) {
////				e.printStackTrace();
////			}
//
//		testCodeEqual(actual, gtPath);
//	}
//	}

	/**
	 *
	 * @param srcPath Path of file to be transformed.
	 * @param targetPath Path of target style file.
	 * @param classes Stylers to be tested.
	 * @return the transformed code
	 */
	protected String apply(Path srcPath, Path targetPath, List<Class<? extends Object>> classes) {
		Configuration conf = new Configuration();
		Controller controller = new Controller(conf);

		StylerContainer container = new StylerContainer();
		for (Styler styler : container.getStylers()) {
			if (!classes.contains(styler.getClass())) {
				styler.disable();
			}
		}
		controller.setStylers(container);

		FileCollection targetCollection = FileCollector.getJavaFileCollection(List.of(targetPath.toString()));

		ProgramStyle sytle = null;
		if (targetCollection.size() == 1 && targetCollection.getFilePath(0).endsWith("xml")) {
			sytle = StyleFileIO.read(targetCollection.getFilePath(0), MyParserFactory.createParser("java"));
			controller.setTargetProgramStyle(sytle);

		} else {
			sytle = controller.extractStyle(targetCollection);
		}
		StyleFileIO.write(sytle, Paths.get(srcPath.getParent().toString(), "style.xml").toString(), MyParserFactory.createParser("java"));
		return controller.applyStyle(srcPath);
	}


	protected String apply(Path srcPath, Path targetPath) {
		Configuration conf = new Configuration();
		Controller controller = new Controller(conf);

		StylerContainer container = new StylerContainer();
		controller.setStylers(container);

		FileCollection targetCollection = FileCollector.getJavaFileCollection(List.of(targetPath.toString()));


		ProgramStyle sytle = null;
		if (targetCollection.size() == 1 && targetCollection.getFilePath(0).endsWith("xml")) {
			sytle = StyleFileIO.read(targetCollection.getFilePath(0), MyParserFactory.createParser("java"));
			controller.setTargetProgramStyle(sytle);

		} else {
			sytle = controller.extractStyle(targetCollection);
		}
		StyleFileIO.write(sytle, Paths.get(srcPath.getParent().toString(), "style.xml").toString(), MyParserFactory.createParser("java"));
		return controller.applyStyle(srcPath);
	}

	protected void testCodeEqual(String actual, Path gtPath) {
		logger.info("Compare `{}`...", gtPath);
		File gtFile = new File(gtPath.toString());
		if (!gtFile.exists()) {
			System.out.println("Warning: invalid test! Ground truth is not found!");
		}
		try {
			String expected = Files.readString(gtPath).replace("\r\n", "\n");
			assertEquals(expected, actual.replace("\r\n", "\n"));
		} catch (Exception e)  {
			logger.error("Test `{}` failed!", gtPath, e);
		}
		logger.info("Compare `{}`...OK", gtPath);
	}

	protected String getFormattedText(ExtendContext ctx) {
		StringBuilder result = new StringBuilder();
		ctx.getAllTokensRec().forEach(
				t -> {
					if (t instanceof ExtendToken extendToken) {
						extendToken.getContextTokens().forEach(t1 -> result.append(t1.getText()));
					}
				}
		);
		return result.toString();
	}

}
