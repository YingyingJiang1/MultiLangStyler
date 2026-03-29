package org.example;

import org.example.config.MyConfiguration;
import org.example.lang.LangAdapterCreator;
import org.example.style.StylerContainer;
import org.example.stylekit.*;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.common.token.ExtendToken;
import org.example.style.StyleProfile;
import org.example.style.Style;
import org.example.style.StyleFileIO;
import org.example.styler.structure.StructureStyler;
import org.example.styler.structure.style.StructPreferenceContext;
import org.example.styler.structure.style.StructPreferenceProperty;
import org.example.styler.structure.style.StructureStyle;
import org.opentest4j.AssertionFailedError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
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

	protected void testCpp(String dir, String[] srcFiles, String[] targetFiles, List<Class<?>> classes) {
		String fileExt = ".cpp";

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("%sto%s" + fileExt, srcFiles[i].split("[.]")[0], targetFiles[i].split("[.]")[0]));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), "cpp", classes);
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
				logger.error("Pair `{}` test failed%n", i + 1, e);
			}
//			break;
		}
	}

	protected void testCppStructureStyle(String dir, String[] srcFiles, StructureStyle style, boolean saveStyle) {
		String fileExt = ".cpp";
		String language = "cpp";

		MyEnvironment.setConf(conf);
		StructPreferenceProperty property = (StructPreferenceProperty) style.getRules().get(0).getStyleProperty();
		StructPreferenceContext context = (StructPreferenceContext) style.getRules().get(0).getStyleContext();
		int id = context.getStructID();
		int index = property.getPreferenceIndex();
		for (int i = 0; i < srcFiles.length; i++) {

			Path gtPath = Paths.get(dir, String.format("%s-%d-%d-gt" + fileExt,srcFiles[i].split("[.]")[0],  id, index));

			if (saveStyle) {
				conf.getProjectConfig().setEnabledStylers("cpp", List.of(StructureStyler.class));

				String srcPath = Paths.get(dir, srcFiles[i]).toString();
				StyleProfile selfStyle = Extractor.extractStyle(srcPath, language, LangAdapterCreator.createStylerContainer(language));
				StyleFileIO.write(selfStyle, srcPath.replace(fileExt, ".xml"), "cpp");
			}


			StyleProfile styleProfile = new StyleProfile();
			styleProfile.add(style);
			StylerContainer container = LangAdapterCreator.createStylerContainer(language);
			container.fillStyle(styleProfile);
			Map<String, String> resultMap = Applicator.applyStyle(Paths.get(dir, srcFiles[i]).toString(), language, container);
			String actual = resultMap.entrySet().stream().toList().get(0).getValue();
			if (!new File(gtPath.toString()).exists()) {
				try{
					Files.writeString(gtPath, actual);
				}	catch (Exception e) {
					e.printStackTrace();
				}
			}

			try {
				testCodeEqualIgnoreWS(actual, gtPath);
			} catch (AssertionFailedError e) {
				logger.error("Pair `{}` test failed", i + 1, e);
			}
//			break;
		}
	}

	protected StructureStyle createStructureStyle(int id, int index) {
		StructureStyle style = new StructureStyle();
		style.getRuleSet().addRule(new StructPreferenceContext(id), new StructPreferenceProperty(index));
		return style;
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
		String lang = "java";
		return apply(srcPath, targetPath, lang, classes);
	}

	/**
	 * Runs {@link Coordinator#analyzeInconsistency(TaskOptions)} for each (src, target) pair
	 * and asserts the report equals the golden {@code <src>-inc.txt} beside the source file.
	 */
	protected void assertAnalyzeInconsistencyMatchesGolden(
			String dir,
			String[] srcFiles,
			String[] targetFiles,
			List<Class<?>> enabledStylers) {
		assertAnalyzeInconsistencyMatchesGolden(dir, srcFiles, targetFiles, enabledStylers, "java");
	}

	protected void assertAnalyzeInconsistencyMatchesGolden(
			String dir,
			String[] srcFiles,
			String[] targetFiles,
			List<Class<?>> enabledStylers,
			String lang) {
		if (srcFiles.length != targetFiles.length) {
			fail("srcFiles and targetFiles must have the same length");
		}
		MyEnvironment.setConf(conf);
		conf.getProjectConfig().setEnabledStylers(lang, enabledStylers);
		Coordinator coordinator = new Coordinator();
		for (int i = 0; i < srcFiles.length; i++) {
			Path srcPath = Paths.get(dir, srcFiles[i]);
			Path targetPath = Paths.get(dir, targetFiles[i]);
			Path tmpInc = Paths.get(srcPath.toString().replace("." + lang, "-inc-tmp.txt"));
			Path goldenPath = Paths.get(srcPath.toString().replace("." + lang, "-inc.txt"));
			assertTrue(Files.exists(goldenPath), "Missing inconsistency oracle: " + goldenPath);
			TaskOptions taskOptions = new TaskOptions();
			taskOptions.setSrc(srcPath.toString());
			taskOptions.setTarget(targetPath.toString());
			taskOptions.setResOutPath(tmpInc.toString());
			taskOptions.setLanguage(lang);
			coordinator.analyzeInconsistency(taskOptions);
			try {
				String actual = Files.readString(tmpInc).replace("\r\n", "\n");
				String expected = Files.readString(goldenPath).replace("\r\n", "\n");
				assertEquals(expected, actual);
			} catch (IOException e) {
				throw new AssertionError(e);
			} finally {
				try {
					Files.deleteIfExists(tmpInc);
				} catch (IOException e) {
					logger.warn("Failed to delete temp {}", tmpInc, e);
				}
			}
		}
	}

	protected String apply(Path srcPath, Path targetPath, String lang, List<Class<?>> classes) {
		conf.getProjectConfig().setEnabledStylers(lang, classes);
		MyEnvironment.setConf(conf);

		TaskOptions taskOptions = new TaskOptions();
		taskOptions.setLanguage(lang);
		taskOptions.setSrc(srcPath.toString());
		taskOptions.setTarget(targetPath.toString());
		taskOptions.setStyleOutPath(Paths.get(targetPath.getParent().toString(), "style.xml").toString());
//		taskOptions.setOut2console(true);

		Coordinator coordinator = new Coordinator();
		Map<String, String> results = coordinator.transferStyle(taskOptions);
		for (Map.Entry<String, String> entry : results.entrySet()) {
			return entry.getValue();
		}
		return null;
	}


	private Map<String, String> transferStyle(TaskOptions taskOptions) {
		StylerContainer container = LangAdapterCreator.createStylerContainer(taskOptions.getLanguage());
		Coordinator	coordinator = new Coordinator();
		StyleProfile targetStyleProfile = Extractor.extractStyle(taskOptions.getTarget(), taskOptions.getLanguage(), container);

		if (taskOptions.getStyleOutPath() != null) {
			StyleFileIO.write(targetStyleProfile, taskOptions.getStyleOutPath(), taskOptions.getLanguage());
		}

		Map<String, String> results = Applicator.applyStyle(taskOptions.getSrc(), taskOptions.getLanguage(), container);
		return results;
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

	protected void testCodeEqualIgnoreWS(String actual, Path gtPath) {
		logger.info("Compare `{}`...", gtPath);
		File gtFile = new File(gtPath.toString());
		if (!gtFile.exists()) {
			System.out.println("Warning: invalid test! Ground truth is not found!");
		}
		try {
			String expected = Files.readString(gtPath).replaceAll("[ \t\r\n]", "");
			assertEquals(expected, actual.replaceAll("[ \t\r\n]", ""));
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
