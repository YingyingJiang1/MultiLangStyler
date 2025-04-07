package org.example.styler.method.utils;

import cognitivecalculator.analizers.FileManager;
import cognitivecalculator.resultdatastr.MethodResult;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.utils.searcher.intf.MethodSearcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CognitiveComplexityCalculator {
	public static Logger logger = LoggerFactory.getLogger(CognitiveComplexityCalculator.class);

	private static Map<String, FileMethodResult> methodResultMap = new HashMap<>();

	private static CognitiveComplexityCalculator calculator = new CognitiveComplexityCalculator();

	private CognitiveComplexityCalculator() {
	}

	public static CognitiveComplexityCalculator getInstance() {
		return calculator;
	}


	public int calCognitiveComplexity(ExtendContext methodDeclaration, MyParser parser) {
		if (!methodResultMap.containsKey(parser.getSourceFile())) {
			FileMethodResult fileResult = getFileMethodResult(parser.getSourceFile());
			if (fileResult != null) {
				methodResultMap.put(parser.getSourceFile(), fileResult);
			}
		}

		FileMethodResult fileResult = methodResultMap.get(parser.getSourceFile());
		if (fileResult == null){
			return -1;
		}


		MethodSearcher searcher = GlobalInfo.getConf().getLanguageConfig().getNodeSearcherFactory().createMethodDecSearcher();
		MethodResult methodResult = fileResult.getMethodResult(searcher.searchMethodBody(methodDeclaration, parser));
		return methodResult.getFinalCognitiveComplexity();
	}


	protected FileMethodResult getFileMethodResult(String filename) {
		try {
			List<MethodResult> results = new FileManager().computeCognitiveComplexityForFile(new File(filename));
			FileMethodResult fileResult = new FileMethodResult();
			fileResult.addMethodResults(results);
			return fileResult;
		} catch (Exception e) {
			logger.error("computeCognitiveComplexityForFile error", e);
		}

		return null;
	}




	static class FileMethodResult {
		private Map<Integer, MethodResult> methodResultMap = new HashMap<>(); // key: start-line number of method

		public FileMethodResult() {}


		public void addMethodResults(List<MethodResult> results) {
			for (MethodResult result : results) {
				methodResultMap.put(result.getPosition(), result);
			}
		}

		public MethodResult getMethodResult(ExtendContext methodBody) {
			return methodResultMap.get(methodBody.getStart().getLine());
		}
	}
}
