package org.example.experiment;

import org.antlr.v4.runtime.misc.Pair;

import java.util.Collections;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/22 3:00
 */
public class LeetcodeInputGenerator extends InputGenerator{
	/**
	 * 生成一对具有相同文件名的文件路径
	 *
	 * @param sourceFiles 源文件列表
	 * @param targetFiles 目标文件列表
	 * @return 包含相同文件名的若干对文件（sources, targets）
	 */
	protected Pair<String[], String[]> generateSameNamePairs(List<String> sourceFiles,
	                                                               List<String> targetFiles, int pairSize) {
		List<String> files1 = null, files2 = null;
		if(sourceFiles.size() > targetFiles.size()) {
			files1 = targetFiles;
			files2 = sourceFiles;
		} else {
			files1 = sourceFiles;
			files2 = targetFiles;
		}
		Pair<String[], String[]> filePairs = new Pair<>(new String[pairSize], new String[pairSize]);
		Collections.shuffle(files1);
		int count = 0;
		for (String file : files1) {
			if(files2.contains(file)) {
				filePairs.a[count] = file;
				filePairs.b[count] = file;
				++count;
			}
			if (count == pairSize) {
				break;
			}
		}
		if (count != pairSize) {
			System.out.println("wrong");
		}
		return count == pairSize ? filePairs : null;
	}

	@Override
	protected InputPair.Round generateRound(String sourceDataset, String targetDataset, int pairSize) {
		List<String> sourceFiles = getFileList(sourceDataset);
		List<String> targetFiles = getFileList(targetDataset);
		Pair<String[], String[]> filePairs = generateSameNamePairs(
				sourceFiles, targetFiles, pairSize);
		if (filePairs == null) {
			return null;
		}
		InputPair.Round round = new InputPair.Round();
		round.sources = filePairs.a;
		round.targets = filePairs.b;
		round.results = new String[0];
		return round;
	}

}
