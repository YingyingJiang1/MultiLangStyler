package org.example.experiment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Configuration;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.java.MyJavaParser;
import org.example.styler.method.complexity.style.MethodComplexity;
import org.example.styler.method.utils.MethodComplexityCalculator;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STAlgType;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MethodComplexityAnalyzer {
	public static void main(String[] args) throws IOException {
		String dir = "C:\\Users\\dell\\jyy\\科研\\code-style-transformation\\experiment\\result\\forsee_analysis\\compare";
		calculate(dir, "claude35sonnet_result");
		calculate(dir, "deepseekcoder_result");
		calculate(dir, "target");

	}

	public static void test() throws IOException {
		MyParser parser = new MyJavaParser();
		parser.parse(Paths.get("C:\\Users\\dell\\jyy\\科研\\transformer\\src\\test\\sources\\naming\\001\\src.java"));
		Configuration conf = new Configuration();
		GlobalInfo.setConf(conf);
		ExtendContext cu = (ExtendContext)parser.getRoot();
		List<ExtendContext> methods = cu.getAllCtxsRecIf(node -> node.getRuleIndex() == parser.getRuleMethodDeclaration());
		for (ExtendContext method : methods) {
			MethodComplexity complexity = MethodComplexityCalculator.getInstance().calculateComplexity(method, parser);
			System.out.println(complexity.toReadableString());
		}
	}

	private static void calculate(String dir, String filePrefix) {
		File dirFile = new File(dir);
		List<FileResult> results = new ArrayList<>();
		for (File subDir : dirFile.listFiles()) {
			File[] targetFile = subDir.listFiles(f -> {
				return f.getName().equals(filePrefix + ".java");
			});
			if (targetFile != null) {
				List<MethodComplexity> complexityList = calFileComplexity(targetFile[0].getAbsolutePath());
				results.add(new FileResult(subDir.getName(), complexityList));
			} else {
				System.err.println("targetFile in " + subDir.getName() + "is null!");
			}
		}

		// TODO：将 results写入jsonl文件
		ObjectMapper mapper = new ObjectMapper();
		String output_file = dirFile.getParent() + File.separator + filePrefix + ".jsonl";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(output_file))) {
			for (FileResult result : results) {
				String jsonLine = mapper.writeValueAsString(result);
				writer.write(jsonLine);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	private static List<MethodComplexity> calFileComplexity(String file) {
		try {
			Files.write(Paths.get(file), Files.readString(Paths.get(file)).replaceAll("\r\r\n", "\r\n\r\n").getBytes());

			MyParser parser = new MyJavaParser();
			ExtendContext cu = (ExtendContext) parser.parse(Paths.get(file));
			Configuration conf = new Configuration();
			GlobalInfo.setConf(conf);
			List<ExtendContext> methods = cu.getAllCtxsRecIf(node -> node.getRuleIndex() == parser.getRuleMethodDeclaration());
			List<MethodComplexity> complexityList = new ArrayList<>();
			for (ExtendContext method : methods) {
				MethodComplexity complexity = MethodComplexityCalculator.getInstance().calculateComplexity(method, parser);
				complexityList.add(complexity);
			}

			return complexityList;
		} catch (Exception e) {
			LoggerFactory.getLogger(MethodComplexityAnalyzer.class).error("Fail to calculate method complexity for file {}\n", file, e);
		}
		return null;
	}

	static class FileResult implements Serializable {
		public String dirName;
		public List<MethodComplexity> complexityList;

		public FileResult(String name, List<MethodComplexity> complexityList) {
			this.dirName = name;
			this.complexityList = complexityList;
		}
	}
}
