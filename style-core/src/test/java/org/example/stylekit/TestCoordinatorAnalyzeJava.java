package org.example.stylekit;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FileUtils;
import static org.assertj.core.api.Assertions.assertThat;
import org.example.MyEnvironment;
import org.example.styler.arrangement.modifier.ModifierOrderStyler;
import org.example.styler.declaration.layout.DeclarationLayoutStyler;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.ifelse.bodyorder.IfElseBodyOrderStyler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestCoordinatorAnalyzeJava {
	private static final String LANG = "java";
	private static final String SOURCES = "src/test/sources";

	private Coordinator coordinatorUnderTest;

	@BeforeEach
	void setUp() {
		coordinatorUnderTest = new Coordinator();
	}

	@Test
	void testAnalyzeInconsistency_modifierOrder() {
		final String dir = Paths.get(SOURCES, "arrangement", "modifier").toString();
		String[] srcFiles = {"f1.java", "f1-gt.java"};
		String[] targetFiles = {"style1.xml", "style1.xml"};
		doAnalyze(dir, srcFiles, targetFiles, List.of(ModifierOrderStyler.class));
	}

	@Test
	void testAnalyzeInconsistency_declarationLayout() {
		final String dir = Paths.get(SOURCES, "declaration").toString();
		String[] srcFiles = {"f1.java", "f3.java", "f1-gt.java", "f3-gt.java"};
		String[] targetFiles = {"f2.java", "f4.java", "f2.java", "f4.java"};
		doAnalyze(dir, srcFiles, targetFiles, List.of(DeclarationLayoutStyler.class));
	}

	@Test
	void testAnalyzeInconsistency_ifElseBodyOrder() {
		final String dir = Paths.get(SOURCES, "if-else").toString();
		String[] srcFiles = {"f1.java", "f2.java", "f1-gt.java", "f2-gt.java"};
		String[] targetFiles = {"f2.java", "f1.java", "f2.java", "f1.java"};
		doAnalyze(dir, srcFiles, targetFiles, List.of(IfElseBodyOrderStyler.class));
	}


	@Test
	void testAnalyzeInconsistency_newline() {
		final String dir = Paths.get(SOURCES, "format", "newline").toString();
		String[] srcFiles = {"f1.java", };
		String[] targetFiles = {"f2.java",};

		doAnalyze(dir, srcFiles, targetFiles, List.of(NewlineStyler.class));
	}

	@Test
	void testAnalyzeInconsistency_indentation() {
		final String dir = Paths.get(SOURCES, "format", "indentation").toString();
		String[] srcFiles = {"f1.java", };
		String[] targetFiles = {"f2.java",};

		doAnalyze(dir, srcFiles, targetFiles, List.of());

	}

	TaskOptions createTaskOptions(String dir, String srcFile, String targetFile) {
		TaskOptions taskOptions = new TaskOptions();
		taskOptions.setSrc(Paths.get(dir, srcFile).toString());
		taskOptions.setTarget(Paths.get(dir, targetFile).toString());
		taskOptions.setResOutPath(taskOptions.getSrc().replace("."+LANG, "-inc.txt"));
		taskOptions.setLanguage(LANG);
		return taskOptions;
	}

	void doAnalyze(String dir, String[] srcFiles, String[] targetFiles, List<Class<?>> enabledClass) {
		MyEnvironment.getProjectConfig().setEnabledStylers(LANG, enabledClass);
		for (int i = 0; i < srcFiles.length; i++) {
			TaskOptions taskOptions = createTaskOptions(dir, srcFiles[i], targetFiles[i]);
			File gtFile = new File(taskOptions.getResOutPath());
			String tmpPath = Paths.get(taskOptions.getSrc().replace("."+LANG, "-inc-tmp.txt")).toString();
			if (!gtFile.exists()) {
				coordinatorUnderTest.analyzeInconsistency(taskOptions);
			} else {
				taskOptions.setResOutPath(tmpPath);
				coordinatorUnderTest.analyzeInconsistency(taskOptions);
			}

			// 读取两个文件内容并比较
			try {
				String result = FileUtils.readFileToString(new File(tmpPath), "UTF-8");
				String expectedResult = FileUtils.readFileToString(gtFile, "UTF-8");
				assertThat(result).isEqualTo(expectedResult);
				FileUtils.deleteQuietly(new File(tmpPath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
