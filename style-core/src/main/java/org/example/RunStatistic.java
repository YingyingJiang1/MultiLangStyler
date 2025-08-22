package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class RunStatistic implements Serializable {
	public static Map<Key, StyleTriggerStat> stat = new HashMap<>();

	public static void addTriggeredStyle(String filePath, String className) {
		Key key = Key.create(filePath);
		if (key == null) {
			return;
		}
		StyleTriggerStat styleStat = stat.computeIfAbsent(key, k -> new StyleTriggerStat());
		styleStat.addStyle(className);
	}

	public static void addTriggeredStructureID(String filePath, int structureID) {
		Key key = Key.create(filePath);
		if (key == null) {
			return;
		}
		StyleTriggerStat styleStat = stat.computeIfAbsent(key, k -> new StyleTriggerStat());
		styleStat.addStructure(structureID);
	}


	public static void save(String filepath) {
		File dir = new File(Paths.get(filepath).getParent().toString());
		if (!dir.exists()) {
			dir.mkdirs();
		}

		System.out.println(filepath);

		ObjectMapper mapper = new ObjectMapper();

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
			for (Map.Entry<Key, StyleTriggerStat> entry : stat.entrySet()) {
				Key key = entry.getKey();
				StyleTriggerStat info = entry.getValue();
				ObjectNode jsonObject = mapper.createObjectNode();
				jsonObject.set("key", mapper.valueToTree(key));
				jsonObject.set("statistic", mapper.valueToTree(info));


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

	public static class StyleTriggerStat implements Serializable{
		public Map<String, Integer> styleFreq = new HashMap<>();
		public Map<Integer, Integer> structureIdFreq = new HashMap<>();

		public void addStyle(String className) {
			styleFreq.put(className, styleFreq.getOrDefault(className, 0) + 1);
		}

		public void addStructure(int id) {
			structureIdFreq.put(id, structureIdFreq.getOrDefault(id, 0) + 1);
		}
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
			if (path.getParent() == null) {
				return null;
			}
			String[] authors = path.getParent().getFileName().toString().split("-");
			if (authors.length == 2) {
				return new Key(authors[0], authors[1], path.getFileName().toString().replace(".java", ""));
			}
			return null;
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
