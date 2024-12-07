/**
 * Data from "https://github.com/abbrcode/abbreviations-in-code"
 */

package org.example.styler.naming;

import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class AbbreviationLibrary {
    private static AbbreviationLibrary  instance = new AbbreviationLibrary();
    // 缩写词库存储：word -> abbr
    private static Map<String, String> abbreviationMap = null;

    public static AbbreviationLibrary getInstance() {
        if (abbreviationMap == null) {
            try {
                loadAbbreviationLibrary("src/main/resources/abbr.yaml");
            } catch (IOException e) {
                LoggerFactory.getLogger(AbbreviationLibrary.class).error("Failed to load abbreviation library", e);
            }
        }
        return instance;
    }

    private AbbreviationLibrary() {
    }


    public static void loadAbbreviationLibrary(String yamlFile) throws IOException {
        Yaml yaml = new Yaml();
        // 解析 YAML 文件
        FileReader reader = new FileReader(yamlFile);
        List<Map<String, Object>> data = yaml.load(reader);

        // 解析数据并填充缩写词库
        for (Map<String, Object> entry : data) {
            String word = (String) entry.get("word");
            List<Map<String, String>> abbrs = (List<Map<String, String>>) entry.get("abbrs");
            if (!abbrs.isEmpty()) {
                abbreviationMap.put(word, abbrs.get(0).get("abbr"));
            }
        }
    }

    public String lookUpAbbreviation(String word) {
        return abbreviationMap.get(word);
    }

}
