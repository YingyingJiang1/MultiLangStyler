package org.example.controller;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.MyEnvironment;
import org.example.lang.LangAdapterCreator;
import org.example.lang.MyParseTreeWalker;
import org.example.lang.intf.MyParser;
import org.example.style.InconsistencyInfo;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.utils.FileCollection;
import org.example.utils.ParseTreeUtil;

import java.nio.file.Paths;
import java.util.*;

public class Analyzer {
	public static List<InconsistencyInfo> analyzeInconsistency(MyParser parser, StylerContainer container) {
		// Analyze on ast.

		MyParseTreeWalker walker = new MyParseTreeWalker(parser, container.getFirstRoundStylers());
		walker.walkTree(Stage.ANALYZE);
		List<InconsistencyInfo> infos = new ArrayList<>(walker.getInconsistencyInfos());

		walker = new MyParseTreeWalker(parser, container.getSecondRoundStylers());
		walker.walkTree(Stage.ANALYZE);
		infos.addAll(walker.getInconsistencyInfos());

		List<Token> tokens = new LinkedList<>();
		ParseTreeUtil.generateTokens(parser.getRoot(), tokens, parser);
		infos.addAll(analyzeOnTS(tokens, parser, container.getTsStylers()));

		return infos;
	}

	public static List<InconsistencyInfo> analyzeOnTS(List<Token> tokens, MyParser parser, List<Styler> stylers) {
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
