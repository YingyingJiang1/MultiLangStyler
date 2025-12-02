package org.example.controller;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.config.IConfig;
import org.example.config.MyConfiguration;
import org.example.MyEnvironment;
import org.example.lang.LangAdapterCreator;
import org.example.lang.intf.MyParser;
import org.example.style.*;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.utils.FileCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/13 20:59
 */
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    /**
     * Execute style extraction and application based on task options.
     * @param taskOptions
     */
    public Map<String, String> execute(MyConfiguration config, TaskOptions taskOptions) {
        MyEnvironment.setConf(config);

        try {
            Extractor extractor = new Extractor(taskOptions.getLanguage());
            ProgramStyle targetProgramStyle = extractor.extractStyle(taskOptions.getTarget());

            if (taskOptions.getStyleOutPath() != null) {
                StyleFileIO.write(targetProgramStyle, taskOptions.getStyleOutPath(), taskOptions.getLanguage());
            }

            Applicator applicator = new Applicator(taskOptions.getLanguage(), targetProgramStyle);
            Map<String, String> results = applicator.applyStyle(taskOptions.getSrc());

            // Don't save results.
            if (!taskOptions.isOverrideSource() && taskOptions.getResOutPath() == null) {
                return results;
            }

            // Save transformed results
            for (Map.Entry<String, String> entry : results.entrySet()) {
                String outPath = entry.getKey();
                if (!taskOptions.isOverrideSource()) {
                    File outFileSet = new File(taskOptions.getResOutPath());
                    if (outFileSet.isFile()) {
                        outPath = outFileSet.getPath();
                    } else if (outFileSet.isDirectory()) {
                        String fileName = Paths.get(entry.getKey()).getFileName().toString();
                        outPath = Paths.get(outFileSet.getPath(), fileName).toString();
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


}
