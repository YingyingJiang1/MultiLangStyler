package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.logging.LogFactory;
import org.example.styler.Styler;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RunStatistic implements Serializable {
	public static Map<Key, Map<String, Integer>> stat = new HashMap<>();

	public void addTriggeredStyle(String filePath, String className) {
		Key key = Key.create(filePath);
		Map<String, Integer> freq = stat.computeIfAbsent(key, k -> new HashMap<>());
		freq.put(className, freq.getOrDefault(className, 0) + 1);
	}

	public static void save(String filepath) {
		File dir = new File(Paths.get(filepath).toString());
		if (!dir.exists()) {
			dir.mkdirs();
		}

		ObjectMapper mapper = new ObjectMapper();

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
			for (Map.Entry<Key, Map<String, Integer>> entry : stat.entrySet()) {
				Key key = entry.getKey();
				Map<String, Integer> freq = entry.getValue();

				ObjectNode jsonObject = mapper.valueToTree(key);
				jsonObject.set("triggeredStyles", mapper.valueToTree(freq));

				writer.write(mapper.writeValueAsString(jsonObject));
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getDefaultOutputPath(String srcPath, String resultPath) {
		return Paths.get(
				Paths.get(resultPath).getParent().getParent().getParent().toString(),
				"run-statistic",
				Paths.get(srcPath).getFileName() + ".jsonl"
		).toString();
	}

	public static class Key implements Serializable {
		public String srcAuthor, targetAuthor;
		public String srcFileID;

		public Key(String srcAuthor, String targetAuthor, String srcFileID) {
			this.srcAuthor = srcAuthor;
			this.targetAuthor = targetAuthor;
			this.srcFileID = srcFileID;
		}

		public static Key create(String filePath) {
			Path path = Paths.get(filePath);
			String[] authors = path.getParent().toString().split("-");
			return new Key(authors[0], authors[1], path.getFileName().toString().replace(".java", ""));
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Key key = (Key) o;
			return Objects.equals(srcAuthor, key.srcAuthor) && Objects.equals(targetAuthor, key.targetAuthor) && Objects.equals(srcFileID, key.srcFileID);
		}

		@Override
		public int hashCode() {
			return Objects.hash(srcAuthor, targetAuthor, srcFileID);
		}
	}
}
