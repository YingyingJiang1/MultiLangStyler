package org.example;

import org.example.config.IConfig;
import org.example.config.MyConfiguration;
import org.example.controller.Controller;
import org.example.controller.StylerContainer;
import org.example.antlr.common.context.ExtendContext;
import org.example.controller.TaskOptions;
import org.example.lang.LangAdapterCreator;
import org.example.antlr.common.token.ExtendToken;
import org.example.style.ProgramStyle;
import org.example.style.Style;
import org.example.style.StyleFileIO;
import org.example.styler.Styler;
import org.example.utils.FileCollection;
import org.example.utils.FileCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestBase {

	protected static String javaTestCasesDir = "src/test/sources";
	protected static String cppTestCasesDir = "src/test/cpp-sources";;
	protected static String pythonTestCasesDir = "src/test/python-sources";

	public Logger logger = LoggerFactory.getLogger(TestBase.class);
	@Autowired
	MyConfiguration conf;
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
//		Controller controller = new Controller();
//
//		StylerContainer container = new StylerContainer();
//		for (Styler styler : container.getStylers()) {
//			if (!classes.contains(styler.getClass())) {
//				styler.disable();
//			}
//		}
//
//
//		FileCollection targetCollection = FileCollector.getFileCollection(List.of(targetPath.toString()));
//
//		ProgramStyle sytle = null;
//		if (targetCollection.size() == 1 && targetCollection.getFilePath(0).endsWith("xml")) {
//			sytle = StyleFileIO.read(targetCollection.getFilePath(0));
//			controller.setTargetProgramStyle(sytle);
//
//		} else {
//			sytle = controller.extractStyle(targetCollection);
//		}
//		StyleFileIO.write(sytle, Paths.get(srcPath.getParent().toString(), "style.xml").toString(), LangAdapterCreator.createParser("java"));
//		return controller.applyStyle(srcPath);
		return null;
	}

	protected String apply(Path srcPath, Path targetPath, String lang, List<Class<?>> classes) {
		conf.SetEnabledStylers(lang, classes);

		TaskOptions taskOptions = new TaskOptions();
		taskOptions.setLanguage(lang);
		taskOptions.setSrc(srcPath.toString());
		taskOptions.setTarget(targetPath.toString());
		taskOptions.setStyleOutPath(Paths.get(targetPath.getParent().toString(), "style.xml").toString());

		Controller controller = new Controller();
		Map<String, String> results = controller.execute(conf, taskOptions);
		for (Map.Entry<String, String> entry : results.entrySet()) {
			return entry.getValue();
		}
		return null;
	}



//	protected String apply(Path srcPath, Path targetPath) {
//		MyConfiguration conf = new MyConfiguration();
//		Controller controller = new Controller(conf);
//
//		StylerContainer container = new StylerContainer();
//		controller.setStylers(container);
//
//		FileCollection targetCollection = FileCollector.getFileCollection(List.of(targetPath.toString()));
//
//
//		ProgramStyle sytle = null;
//		if (targetCollection.size() == 1 && targetCollection.getFilePath(0).endsWith("xml")) {
//			sytle = StyleFileIO.read(targetCollection.getFilePath(0));
//			controller.setTargetProgramStyle(sytle);
//
//		} else {
//			sytle = controller.extractStyle(targetCollection);
//		}
//		StyleFileIO.write(sytle, Paths.get(srcPath.getParent().toString(), "style.xml").toString(), LangAdapterCreator.createParser("java"));
//		return controller.applyStyle(srcPath);
//	}

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
