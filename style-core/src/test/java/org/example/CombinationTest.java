//package org.example;
//
//import org.example.styler.format.indention.IndentionStyler;
//import org.example.styler.format.newline.NewlineStyler;
//import org.example.styler.format.newline.bodylayout.BodyLayoutStyler;
//import org.junit.jupiter.api.Test;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//
//public class CombinationTest extends TestBase {
//	@Test
//	public void test1() {
//		String styleCodesDir = "src/test/codes/test1/style-codes";
//		String srcCodesDir = "src/test/codes/test1/srcs";
//		String[] srcFiles = {
////				"f1.java",
////				"f2.java",
//		};
//
//		for (int i = 0; i < srcFiles.length; i++) {
//			Path gtPath = Paths.get(srcCodesDir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
//			String actual = apply(Paths.get(srcCodesDir, srcFiles[i]), Paths.get(styleCodesDir));
//			if (false) {
//				try{
//					Files.writeString(gtPath, actual);
//				}	catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//
//			testCodeEqual(actual, gtPath);
//		}
//	}
//
//
//	@Test
//	public void test2() {
//		String styleCodesDir = "src/test/codes/test4/style-codes";
//		String srcCodesDir = "src/test/codes/test4/srcs";
//		String[] srcFiles = {
////				"f1.java",
//		};
//
//		for (int i = 0; i < srcFiles.length; i++) {
//			Path gtPath = Paths.get(srcCodesDir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
//			String actual = apply(Paths.get(srcCodesDir, srcFiles[i]), Paths.get(styleCodesDir));
//			if (false) {
//				try{
//					Files.writeString(gtPath, actual);
//				}	catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//
//			testCodeEqual(actual, gtPath);
//		}
//	}
//
//	@Test
//	void test3() {
//		String dir = "src/test/sources/combination-test/test2";
//		String[] srcFiles = {
////				"f1.java",
//				"f2.java"
//		};
//
//		String[] targetFiles = {
////				"style1",
//				"style1",
//		};
//
//		for (int i = 0; i < srcFiles.length; i++) {
//			Path gtPath = Paths.get(dir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
//			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]));
//			if (false) {
//				try{
//					Files.writeString(gtPath, actual);
//				}	catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//			testCodeEqual(actual, gtPath);
////			break;
//		}
//	}
//
//
//	@Test
//	void test4() {
//		String dir = "src/test/sources/combination-test/test4";
//		String[] srcFiles = {
////				"f1.java",
//		};
//
//		String[] targetFiles = {
//				"style1.java",
//		};
//
//		for (int i = 0; i < srcFiles.length; i++) {
//			Path gtPath = Paths.get(dir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
//			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]));
//			if (false) {
//				try{
//					Files.writeString(gtPath, actual);
//				}	catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//			testCodeEqual(actual, gtPath);
////			break;
//		}
//	}
//
//	@Test
//	void test5() {
//		String dir = "src/test/sources/combination-test";
//		String[] srcFiles = {
//				"f1.java",
//		};
//
//		String[] targetFiles = {
//				"f2.java",
//		};
//
//		for (int i = 0; i < srcFiles.length; i++) {
//			Path gtPath = Paths.get(dir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
//			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]));
//			if (false) {
//				try{
//					Files.writeString(gtPath, actual);
//				}	catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//			testCodeEqual(actual, gtPath);
////			break;
//		}
//	}
//
//
//	@Test
//	public void test6() {
//		String styleCodesDir = "src/test/codes/test3/style-codes";
//		String srcCodesDir = "src/test/codes/test3/srcs";
//		String[] srcFiles = {
//				"f1.java",
//		};
//
//		for (int i = 0; i < srcFiles.length; i++) {
//			Path gtPath = Paths.get(srcCodesDir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
//			String actual = apply(Paths.get(srcCodesDir, srcFiles[i]), Paths.get(styleCodesDir));
//			if (false) {
//				try{
//					Files.writeString(gtPath, actual);
//				}	catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//
//			testCodeEqual(actual, gtPath);
//		}
//	}
//
//	// 结构变换 + 命名变换
//	@Test
//	void test7() {
//		String dir = "src/test/sources/combination-test/test7";
//		String[] srcFiles = {
//				"f1.java",
//		};
//
//		String[] targetFiles = {
//				"style1.xml",
//		};
//
//		for (int i = 0; i < srcFiles.length; i++) {
//			Path gtPath = Paths.get(dir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
//			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]));
//			if (false) {
//				try{
//					Files.writeString(gtPath, actual);
//				}	catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//			testCodeEqual(actual, gtPath);
////			break;
//		}
//	}
//
//}
