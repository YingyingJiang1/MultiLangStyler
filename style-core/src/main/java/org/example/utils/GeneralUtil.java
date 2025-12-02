package org.example.utils;

public class GeneralUtil {
	public static boolean checkFileExtension(String fileName, String extension) {
		if (fileName.toLowerCase().endsWith("." + extension.toLowerCase())) {
			return true;
		}
		// C++ file
		String lowerFileName = fileName.toLowerCase();
		if (lowerFileName.endsWith(".cpp") || lowerFileName.endsWith(".c++")
				|| lowerFileName.endsWith(".cc") || lowerFileName.endsWith(".c")) {
			return true;
		}
		return false;
	}
}
