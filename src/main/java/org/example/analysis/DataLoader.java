package org.example.analysis;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class DataLoader {
    // 加载数据
    public static List<ExperimentUnit> loadData(String filePath) {
        List<ExperimentUnit> data = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                ExperimentUnit expUnit = new ExperimentUnit();
                JsonNode jsonObj = objectMapper.readTree(line);
                expUnit.fillWith(jsonObj);
                data.add(expUnit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}

class Solution {
    String problemId;
    String authorName;
    String fileName;
    boolean correct;
    String authorType;

    public Solution(JsonNode item, String authorType) {
        // 获取 problemId
        this.problemId = item.has("id") ? item.get("id").asText() : item.get("problem_id").asText();
        this.authorName = item.get("author_name").asText();
        this.fileName = this.authorName + ".java";

        // 获取 correct 属性
        if (item.has("correct")) {
            this.correct = item.get("correct").asBoolean();
        } else {
            this.correct = item.has("submission_status") && item.get("submission_status").asText().equals("Accepted") || item.has("is_passed") && item.get("is_passed").asBoolean();
        }

        // 设置 authorType
        this.authorType = authorType;
    }
}

class ExperimentUnit {
    Solution src;
    Solution target;
    Solution result;

    public ExperimentUnit() {
        this.src = null;
        this.target = null;
        this.result = null;
    }

    // 填充 ExperimentUnit 对象
    public void fillWith(JsonNode jsonObj) {
        this.src = new Solution(jsonObj.get("src"), jsonObj.get("src").get("author_type").asText());
        this.target = new Solution(jsonObj.get("target"), jsonObj.get("target").get("author_type").asText());
        this.result = jsonObj.has("result") && !jsonObj.get("result").isNull()
                ? new Solution(jsonObj.get("result"), jsonObj.get("result").get("author_type").asText())
                : null;
    }
}

