package org.example.plugin;

import org.example.Configuration;
import org.example.controller.Controller;
import org.example.plugin.settings.AppSettings;
import org.example.style.ProgramStyle;
import org.example.utils.FileCollection;
import org.example.utils.FileCollector;

import java.util.List;

public class CodeStyleManger {
	static ProgramStyle programStyle = null;


	public static ProgramStyle getStyle() {
		AppSettings.State state = AppSettings.getInstance().getState();
		programStyle = extractStyle(state.styleSource);
		return programStyle;
	}

	public static ProgramStyle extractStyle(AppSettings.StyleSource styleSource) {
		FileCollection fileCollection = collectStyleExamples(styleSource);
		if (fileCollection == null) {
			return null;
		}

		Configuration conf = new Configuration();
		Controller controller = new Controller(conf);
		return controller.extractStyle(fileCollection);
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

}
