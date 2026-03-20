package org.example.stylekit;

import org.apache.commons.lang3.StringUtils;
import org.example.lang.LangAdapterCreator;
import org.example.style.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/13 20:59
 */
public class Coordinator {
    private static final Logger logger = LoggerFactory.getLogger(Coordinator.class);

    /**
     * Extract style and apply to source files based on task options.
     * @param taskOptions
     * @return Map<file path, result code>
     */
    public Map<String, String> transferStyle(TaskOptions taskOptions) {
        try {
            StylerContainer container = LangAdapterCreator.createStylerContainer(taskOptions.getLanguage());
            StyleProfile targetStyleProfile = Extractor.extractStyle(taskOptions.getTarget(), taskOptions.getLanguage(), container);

            if (taskOptions.getStyleOutPath() != null) {
                StyleFileIO.write(targetStyleProfile, taskOptions.getStyleOutPath(), taskOptions.getLanguage());
            }

            Map<String, String> results = Applicator.applyStyle(taskOptions.getSrc(), taskOptions.getLanguage(), container);

            // Write result
            if (taskOptions.isOverrideSource()) {
                // Override original  source
                for (Map.Entry<String, String> entry : results.entrySet()) {
                    Files.write(Paths.get(entry.getKey()), entry.getValue().getBytes());
                }
            } else if (taskOptions.getResOutPath() != null) {
                // Write all results to the same file
                File resOutFile = new File(taskOptions.getResOutPath());
                if (taskOptions.isOut2file()) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry<String, String> entry : results.entrySet()) {
                        sb.append(entry.getValue());
                    }
                    Files.writeString(resOutFile.toPath(), sb.toString());
                } else {
                    // Write all results to the same directory
                    if (!resOutFile.exists()) {
                        resOutFile.mkdirs();
                    }
                    for (Map.Entry<String, String> entry : results.entrySet()) {
                        Path srcPath = Paths.get(entry.getKey());
                        Path targetPath = Paths.get(taskOptions.getResOutPath(), srcPath.getFileName().toString());
                        Files.writeString(targetPath,entry.getValue());
                    }

                }
            } else if (taskOptions.isOut2console()) {
                // output to  console
                for (Map.Entry<String, String> entry : results.entrySet()) {
                    System.out.println(entry.getKey());
                    System.out.println(entry.getValue());
                }
            }
            return results;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }


    /**
     * Extract style and save to XML style file if specified.
     */
    public void extractStyle(TaskOptions taskOptions) {
        StylerContainer container = LangAdapterCreator.createStylerContainer(taskOptions.getLanguage());
        StyleProfile targetStyleProfile = Extractor.extractStyle(taskOptions.getTarget(), taskOptions.getLanguage(), container);

        if (taskOptions.getStyleOutPath() != null) {
            StyleFileIO.write(targetStyleProfile, taskOptions.getStyleOutPath(), taskOptions.getLanguage());
        }
    }

    public Map<String, List<InconsistencyInfo>> analyzeInconsistency(TaskOptions taskOptions) {

        StylerContainer container = LangAdapterCreator.createStylerContainer(taskOptions.getLanguage());
        StyleProfile targetStyleProfile = Extractor.extractStyle(taskOptions.getTarget(), taskOptions.getLanguage(), container);

        Map<String, List<InconsistencyInfo>> infosMap = Analyzer.anayzeInconsistency(taskOptions.getSrc(), taskOptions.getLanguage(), container);

        if (taskOptions.getResOutPath() != null || taskOptions.isOut2console()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, List<InconsistencyInfo>> entry : infosMap.entrySet()) {
                // header
                sb.append(StringUtils.repeat('=', 60)).append("\n");
                sb.append("File: ").append(entry.getKey()).append("\n");
                sb.append("Total Inconsistencies: ").append(entry.getValue().size()).append("\n");
                sb.append(StringUtils.repeat('=', 60)).append("\n");
                // inconsistency infos
                for (int i = 0; i < entry.getValue().size(); i++) {
                    sb.append(String.format("[%d] %s\n", i+1, entry.getValue().get(i).toString()));
                }
            }

            if (taskOptions.isOut2console()) {
                System.out.println(sb);
            }

            if (taskOptions.getResOutPath() != null) {
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(taskOptions.getResOutPath())))) {
                    writer.write(sb.toString());
                } catch (IOException e) {
                    logger.error("Failed to write inconsistency analysis results to file: {}", taskOptions.getResOutPath(), e);
                }
            }
        }
        return infosMap;
    }
}
