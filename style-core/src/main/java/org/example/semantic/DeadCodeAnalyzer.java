package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import pascal.taie.Main;
import pascal.taie.WorldBuilder;
import pascal.taie.analysis.deadcode.DeadCodeDetection;
import pascal.taie.config.AnalysisConfig;


import java.util.Set;

public class DeadCodeAnalyzer extends StaticAnalyzer{
	@Override
	public StaticAnalysisResult analyze(ParseTree tree) {
		DeadCodeDetection dcd = new DeadCodeDetection(AnalysisConfig.of("dead-code"));

		return null;

	}
}
