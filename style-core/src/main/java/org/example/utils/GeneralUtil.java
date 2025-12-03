package org.example.utils;

import java.util.Set;

public class GeneralUtil {
	private static Set<String> validCppExts = Set.of(
			// 源文件
			".cpp", ".cc", ".cxx", ".c++", ".c",
			// 头文件
			".h", ".hpp", ".hh", ".hxx", ".h++",
			// 模板头文件
			".ipp", ".tpp"
	);

	public static boolean checkFileExtension(String fileName, String lang) {
		if (fileName == null || !fileName.contains(".")) return false;

		String fileExt = fileName.substring(fileName.lastIndexOf(".")).toLowerCase(); // 包含点更安全


		return switch (lang.toLowerCase()) {
			case "java" -> fileExt.equals(".java");
			case "cpp" -> validCppExts.contains(fileExt);
			case "python" -> fileExt.equals(".py") || fileExt.equals(".pyw");
			default -> false;
		};
	}
}
