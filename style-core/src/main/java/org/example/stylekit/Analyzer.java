package org.example.stylekit;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.lang.LangAdapterCreator;
import org.example.lang.MyParseTreeWalker;
import org.example.lang.intf.MyParser;
import org.example.style.InconsistencyInfo;
import org.example.style.StylerContainer;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.utils.FileCollection;
import org.example.utils.FileCollector;
import org.example.utils.GeneralUtil;
import org.example.utils.ParseTreeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Analyzer {
	private static final Logger logger = LoggerFactory.getLogger(Analyzer.class);
//	private String language;
//	private StylerContainer container;
//
//	public Analyzer(String language, StyleProfile targetStyleProfile) {
//		this.language = language;
//		this.container = MyEnvironment.getIConfig().creasteStylerContainer(language);
//		this.container.fillStyle(targetStyleProfile);
//	}
//
//	public Analyzer(String language, StylerContainer container) {
//		this.language = language;
//		this.container = container;
//	}

	/**
	 * Analyze inconsistent style in program files.
	 * @param path program file or directory paths separated by semicolon.
	 * @return list of inconsistency info
	 */
	public static Map<String, List<InconsistencyInfo>> anayzeInconsistency(String path, String language, StylerContainer container) {
		FileCollection fileCollection = FileCollector.getFileCollection(List.of(path.split(";")));
		Map<String, List<InconsistencyInfo>> allInfos = new HashMap<>();
		for (int i = 0; i < fileCollection.size(); i++) {
			try {
				Path curPath = Paths.get(fileCollection.getFilePath(i));
				if (GeneralUtil.checkFileExtension(curPath.getFileName().toString(), language)) {
					MyParser parser = LangAdapterCreator.createParser(language);
					ParseTree tree = parser.parse(curPath);
					if (tree == null) {
						logger.info("Failed to analyze inconsistent style for '{}' because of compilation error.", curPath.toString());
						continue;
					}

					allInfos.put(fileCollection.getFilePath(i), doAnalyze(parser, container));
				}

			} catch (Exception e) {
				logger.error("Failed to analyze inconsistent style for file: {}", fileCollection.getFilePath(i));
				logger.error("Exception details:", e);
			}
		}
		return allInfos;
	}

	private static List<InconsistencyInfo> doAnalyze(MyParser parser, StylerContainer container) {
		// Analyze on ast.
		MyParseTreeWalker walker = new MyParseTreeWalker(parser, container.getFirstRoundStylers());
		walker.walkTree(Stage.ANALYZE);
		List<InconsistencyInfo> infos = new ArrayList<>(walker.getInconsistencyInfos());

		walker = new MyParseTreeWalker(parser, container.getSecondRoundStylers());
		walker.walkTree(Stage.ANALYZE);
		infos.addAll(walker.getInconsistencyInfos());

		List<Token> tokens = new ArrayList<>();
		ParseTreeUtil.generateTokens(parser.getRoot(), tokens, parser);
		infos.addAll(analyzeOnTS(tokens, parser, container));

		return infos;
	}

	private static List<InconsistencyInfo> analyzeOnTS(List<Token> tokens, MyParser parser, StylerContainer container) {
		List<Styler> stylers = container.getTsStylers();
		List<InconsistencyInfo> infos = new ArrayList<>();
		for (int i = 0; i < tokens.size(); i++) {
			for (Styler styler : stylers) {
				if (styler.isRelevant(tokens, i, Stage.ANALYZE, parser)) {
					List<InconsistencyInfo> ret = styler.analyzeInconsistency(tokens, i, parser);
					if (ret != null) {
						infos.addAll(ret);
					}
				}
			}
		}
		return infos;
	}
//
//	public List<InconsistencyInfo> checkStyle(FileCollection files) {
//		targetProgramStyle = extractStyle(taskOptions.extractionCollection);
//		fillStylers(targetProgramStyle);
//		String code = null;
//		for (int i = 0; i < files.size(); i++) {
//			try {
//				curPath = Paths.get(files.getFilePath(i));
//				String language = curPath.getFileName().toString().split("\\.")[1].toLowerCase();
//				MyEnvironment.setLanguage(language);
//				parser = LangAdapterCreator.createParser(language);
//				ParseTree tree = parser.parse(curPath);
//				if (tree == null) {
//					logger.info("Failed to check inconsistent style on file '{}' because of compilation error.", curPath.toString());
//					continue;
//				}
//
//				List<InconsistencyInfo> infos = Analyzer.analyzeInconsistency(parser, container);
//				return infos;
//			} catch (Exception e) {
//				logger.error("Failed to check inconsistent style on file: {}", files.getFilePath(i));
//				logger.error("Exception details:", e);
//			}
//		}
//		return null;
//	}


}
