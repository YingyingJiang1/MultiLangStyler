package org.example.controller;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.SemanticContext;
import org.example.myException.ApplyException;
import org.example.parser.common.MyParser;
import org.example.style.InconsistencyInfo;
import org.example.style.Style;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.utils.ParseTreeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Analyzer {
	public static List<InconsistencyInfo> analyzeInconsistency(MyParser parser, StylerContainer container) {
		// Analyze on ast.
		parser.walkTree(Stage.ANALYZE, container.getFirstRoundStylers());
		parser.walkTree(Stage.ANALYZE, container.getSecondRoundStylers());
		List<InconsistencyInfo> infos = new ArrayList<>();
		List<InconsistencyInfo> ret = parser.getListener().getInconsistencyInfos();
		if (ret != null) {
			infos.addAll(ret);
		}

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

}
