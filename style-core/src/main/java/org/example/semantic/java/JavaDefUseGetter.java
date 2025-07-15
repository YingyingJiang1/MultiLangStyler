package org.example.semantic.java;

import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.DefUseGetter;
import org.example.utils.searcher.intf.CompilationUnitSearcher;
import org.example.utils.searcher.intf.MethodSearcher;
import org.example.utils.searcher.intf.TypeDecSearcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pascal.taie.Main;
import pascal.taie.World;
import pascal.taie.analysis.defuse.DefUse;
import pascal.taie.analysis.misc.ResultProcessor;
import pascal.taie.language.classes.JMethod;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JavaDefUseGetter implements DefUseGetter {
	private static final Logger logger = LoggerFactory.getLogger(JavaDefUseGetter.class);
	private static MyParser oldParser = null;

	@Override
	public List<ExtendContext> getAllDefsBefore(ExtendContext identifier, MyParser parser) {
		JMethod containerMethod = getMethod(identifier, parser);
		if (containerMethod == null) {
			return null;
		}

		DefUse defUse = containerMethod.getIR().getResult("def-use");
		World.get().getResult(ResultProcessor.ID);

		return null;

	}

	@Override
	public ExtendContext getLastDefBefore(ExtendContext identifier, MyParser parser) {
		World world = null;
		if (oldParser != parser) {
			world = analysis(parser);
			oldParser = parser;
		}
		return null;
	}


	public World analysis(MyParser parser) {
		File srcFile = new File(parser.getSourceFile());
		Path filePath = null;
		Path dir = null;
		// Make sure the filename equals the name of main class.
		try {
			dir = Paths.get("taie_temp");
			filePath = dir;
			Files.createDirectories(dir);
			String mainClass = getMainClass(parser);
			String filename = mainClass == null ? srcFile.getName() : mainClass + ".java";
			filePath = Paths.get(dir.toString(), filename);
			Files.write(filePath, parser.getTokenStream().getText().getBytes());
			Main.main("-acp",dir.toString(), "-pp",
					"-a", "def-use=compute-uses=true");
			return World.get();
		} catch (Exception e) {
			logger.warn("Fail to write code to {} when executing static analysis.", filePath, e);
		}

		return null;
	}

	private String getContainerMethodSignature(ExtendContext identifier, MyParser parser) {
		ExtendContext functionHead = identifier.getFirstParentIf(node -> parser.belongToMethodHead(node.getRuleIndex()));
		if (functionHead == null) {
			return null;
		}

		MethodSearcher searcher = GlobalInfo.getConf().getLanguageConfig().getNodeSearcherFactory().createMethodDecSearcher();
		ExtendContext retType = searcher.searchRetType(functionHead, parser);
		ExtendContext functionName = searcher.searchMethodName(functionHead, parser);
		List<ExtendContext> paraTypes = searcher.searchParaTypes(functionHead, parser);

		String retTypeStr = retType == null ? "" : retType.getText();
		String paraTypeStr = String.join(",", paraTypes.stream().map(ExtendContext::getText).toList());
		return retType == null ? "" : retType.getText() + " " + functionName.getText() + "(" + paraTypeStr + ")";
	}

	private String getContainerClassQualifiedName(ExtendContext node, MyParser parser) {
		ExtendContext classDec = node.getFirstParentIf(parser::isTypeDeclaration);
		TypeDecSearcher searcher = GlobalInfo.getConf().getLanguageConfig().getNodeSearcherFactory().createTypeDecSearcher();
		ExtendContext className = searcher.searchName(classDec, parser);

		ExtendContext outerClass = classDec.getFirstParentIf(parser::isTypeDeclaration);
		List<String> outClasses = new ArrayList<>();
		while (outerClass != null) {
			outClasses.add(searcher.searchName(outerClass, parser).getText());
			outerClass = outerClass.getFirstParentIf(parser::isTypeDeclaration);
		}
		CompilationUnitSearcher cuSearcher = GlobalInfo.getConf().getLanguageConfig().getNodeSearcherFactory().createCompilationUnitSearcher();
		ExtendContext packageName = cuSearcher.searchPackageName((ExtendContext) parser.getRoot(), parser);

		StringBuilder nameBuilder = new StringBuilder();
		if (packageName != null) {
			nameBuilder.append(packageName.getText()).append(".");
		}
		for (String outerClassName : outClasses) {
			nameBuilder.append(outerClassName).append("$");
		}
		nameBuilder.append(className.getText());

		return nameBuilder.toString();
	}


	private String getMainClass(MyParser parser) {
		ExtendContext root = (ExtendContext) parser.getRoot();
		CompilationUnitSearcher cuSearcher = GlobalInfo.getConf().getLanguageConfig().getNodeSearcherFactory().createCompilationUnitSearcher();
		List<ExtendContext> typeDecs = cuSearcher.searchAllTypeDecs(root, parser);

		TypeDecSearcher typeDecSearcher = GlobalInfo.getConf().getLanguageConfig().getNodeSearcherFactory().createTypeDecSearcher();
		for (ExtendContext typeDec : typeDecs) {
			if (typeDecSearcher.searchPublicModifier(typeDec, parser) != null) {
				return typeDecSearcher.searchName(typeDec, parser).getText();
			}
		}
		return null;
	}

	private JMethod getMethod(ExtendContext identifier, MyParser parser) {
		World world = null;
		if (oldParser != parser) {
			world = analysis(parser);
			oldParser = parser;
		}
		if (world == null || world.getClassHierarchy() == null) {
			return null;
		}

		String qualifiedClassName = getContainerClassQualifiedName(identifier, parser);
		String methodSignature = getContainerMethodSignature(identifier, parser);

		String taieMethodSignature = qualifiedClassName + ": " + methodSignature;
		JMethod containerMethod = world.getClassHierarchy().getMethod(taieMethodSignature);
		return containerMethod;
	}



}
