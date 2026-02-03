package org.example.stylekit;

import org.apache.commons.lang3.StringUtils;
import org.example.lang.LangAdapterCreator;
import org.example.style.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
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

            if (taskOptions.getOutPath() != null) {
                StyleFileIO.write(targetStyleProfile, taskOptions.getOutPath(), taskOptions.getLanguage());
            }

            Map<String, String> results = Applicator.applyStyle(taskOptions.getSrc(), taskOptions.getLanguage(), container);

            // Don't save results.
            if (!taskOptions.isOverrideSource() && taskOptions.getResOutPath() == null) {
                return results;
            }

            // Save transformed results
            File outPathOption = new File(taskOptions.getResOutPath());
            for (Map.Entry<String, String> entry : results.entrySet()) {
                String originPath = entry.getKey();
                String outPath = originPath;
                if (!taskOptions.isOverrideSource()) {
                    if (outPathOption.isFile()) {
                        outPath = outPathOption.getPath();
                    } else if (outPathOption.isDirectory()) {
                        String fileName = Paths.get(entry.getKey()).getFileName().toString();
                        outPath = Paths.get(outPathOption.getPath(), fileName).toString();
                    }
                }

                File dir = new File(outPath).getParentFile();
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outPath)))) {
                    writer.write(entry.getValue());
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

        if (taskOptions.getOutPath() != null) {
            StyleFileIO.write(targetStyleProfile, taskOptions.getOutPath(), taskOptions.getLanguage());
        }
    }

    public void analyzeInconsistency(TaskOptions taskOptions) {

        StylerContainer container = LangAdapterCreator.createStylerContainer(taskOptions.getLanguage());
        StyleProfile targetStyleProfile = Extractor.extractStyle(taskOptions.getTarget(), taskOptions.getLanguage(), container);

        Map<String, List<InconsistencyInfo>> infosMap = Analyzer.anayzeInconsistency(taskOptions.getTarget(), taskOptions.getLanguage(), container);

        if (taskOptions.getOutPath() != null) {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(taskOptions.getOutPath())))) {
                for (Map.Entry<String, List<InconsistencyInfo>> entry : infosMap.entrySet()) {
                    // Write header
                    writer.write(StringUtils.repeat('=', 60) + "\n");
                    writer.write("File: " + entry.getKey() + "\n");
                    writer.write("Total Inconsistencies: " + entry.getValue().size() + "\n");
                    writer.write(StringUtils.repeat('=', 60) + "\n");
                    // Write inconsistency infos
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        writer.write(String.format("[%d] %s\n", i+1, entry.getValue().get(i).toString()));
                    }
                }
            } catch (IOException e) {
                logger.error("Failed to write inconsistency analysis results to file: {}", taskOptions.getOutPath(), e);
            }
        }
        
    }
}
