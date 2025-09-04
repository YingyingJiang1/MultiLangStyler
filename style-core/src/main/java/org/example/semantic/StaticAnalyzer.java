package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import pascal.taie.Main;
import pascal.taie.World;
import pascal.taie.config.AnalysisConfig;
import pascal.taie.language.classes.JClass;
import pascal.taie.language.classes.JClassBuilder;
import pascal.taie.language.classes.JClassLoader;

public abstract class StaticAnalyzer {
	abstract StaticAnalysisResult analyze(ParseTree tree);

}
