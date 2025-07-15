/**
 * Data from "https://github.com/abbrcode/abbreviations-in-code"
 */

package org.example.styler.naming.format;

import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class AbbreviationLibrary {
    private static AbbreviationLibrary  instance = new AbbreviationLibrary();
    // 缩写词库存储：word -> abbr
    private static Map<String, String> abbreviationMap = null;

    public static AbbreviationLibrary getInstance() {
        return instance;
    }

    private AbbreviationLibrary() {
    }


    public void loadAbbreviationLibrary(String yamlFile) throws IOException {
        Yaml yaml = new Yaml();
        // 解析 YAML 文件
//        FileReader reader = new FileReader(yamlFile);
        InputStream is = getClass().getResourceAsStream(yamlFile);
        List<Map<String, Object>> data = yaml.load(is);

        // 解析数据并填充缩写词库
        abbreviationMap = new HashMap<>();
        for (Map<String, Object> entry : data) {
            String word = (String) entry.get("word");
            List<Map<String, String>> abbrs = (List<Map<String, String>>) entry.get("abbrs");
            if (!abbrs.isEmpty()) {
                abbreviationMap.put(word, abbrs.get(0).get("abbr"));
            }
        }
    }

    public String lookUpAbbreviation(String word) {
        if (abbreviationMap == null) {
            try {
                loadAbbreviationLibrary("/abbr.yml");
            } catch (IOException e) {
                LoggerFactory.getLogger(AbbreviationLibrary.class).error("Failed to load abbreviation library", e);
            }
        }
        return abbreviationMap.get(word);
    }

    public String getAbbreviation(String name, int maxLength) {
        if (name.length() <= maxLength) {
            return name;
        }

        String[] words = name.split("(?<=\\D)(?=\\p{Upper})|_");
        AbbreviationLibrary  abbreviationLibrary = AbbreviationLibrary.getInstance();
        int curLen = name.length();
        int i = 0;
        while (curLen > maxLength && i < words.length) {
            String word = words[i];
            String abbreviation = abbreviationLibrary.lookUpAbbreviation(words[0]);
            if (abbreviation != null) {
                name = name.replace(words[0], abbreviation);
                curLen -= words[0].length() - abbreviation.length();
            }
            i++;
        }

        return name;
    }

}
