package org.example;

import org.example.Configuration;
import org.example.controller.Controller;
import org.example.parser.common.factory.MyParserFactory;
import org.example.settings.AppSettings;
import org.example.style.ProgramStyle;
import org.example.style.StyleFileIO;
import org.example.utils.FileCollection;
import org.example.utils.FileCollector;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

public class CodeStyleManger {
	static ProgramStyle programStyle = null;
	private static AppSettings.StyleSource cachedStyleSource = null;


	public static ProgramStyle getStyle() {
		// TODO: 利用缓存提高效率
		AppSettings.State state = AppSettings.getInstance().getState();
		if (isStyleSourceChanged(state.styleSource)) {
			programStyle = extractStyle(state);
			cachedStyleSource = state.styleSource;
		}
		return programStyle;
	}

	public static ProgramStyle extractStyle(AppSettings.State state) {
		FileCollection fileCollection = collectStyleExamples(state.styleSource);
		if (fileCollection == null) {
			return null;
		}

		Configuration conf = new Configuration();
		Controller controller = new Controller(conf);
		ProgramStyle programStyle1 = controller.extractStyle(fileCollection);
		if (!fileCollection.isEmpty()) {
			// 风格文件保存在同目录下
			String dir = new File(fileCollection.getFilePath(0)).getParentFile().getParent();
			StyleFileIO.write(programStyle1, Paths.get(dir, "style.xml").toString(), MyParserFactory.createParser(state.language.name()));
		}
		return programStyle1;
	}

	private static FileCollection collectStyleExamples(AppSettings.StyleSource styleSource) {
		AppSettings.StyleSourceType type = styleSource.getStyleSourceType();
		switch (type) {
			case MOST_COMMON_AUTHOR:
				String authorName = Utils.getMostCommonAuthorInProject();
				return collectFilesByAuthor(authorName);
			case SPECIFIC_AUTHOR:
				return collectFilesByAuthor(styleSource.getParameter());
			case STYLE_CONFIG_FILE:
				return collectFiles(List.of(styleSource.getParameter()));
			case SPECIFIC_DIRECTORY:
				return collectFiles(styleSource.getSplitParameters());
		}
		return null;
	}

	private static FileCollection collectFilesByAuthor(String authorName) {
		FileCollection fileCollection = new FileCollection();
		return fileCollection;
	}

	private static FileCollection collectFiles(List<String> files) {
		AppSettings.Language language = AppSettings.getInstance().getState().language;
		switch (language) {
			case JAVA -> {
				return FileCollector.getJavaFileCollection(files);
			}
		}
		return null;
	}

	private static boolean isStyleSourceChanged(AppSettings.StyleSource styleSource) {
		return cachedStyleSource == null || !cachedStyleSource.equals(styleSource);
	}

}
