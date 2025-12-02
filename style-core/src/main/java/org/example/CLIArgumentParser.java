package org.example;

import org.apache.commons.cli.*;
import org.example.config.MyConfiguration;
import org.example.controller.TaskOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pascal.taie.ir.exp.BinaryExp;

import java.io.File;

public class CLIArgumentParser {
    public static Logger logger = LoggerFactory.getLogger(CLIArgumentParser.class);
    
    public static TaskOptions parseArgs(String[] args) {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        Options options = getOptions();

        try {
            cmd = parser.parse(options, args);
            TaskOptions taskOptions = new TaskOptions();

            // 获取并设置参数
            String src = cmd.getOptionValue("src");
            String target = cmd.getOptionValue("target");
            taskOptions.setSrc(src);
            taskOptions.setTarget(target);

            String outputFile = cmd.getOptionValue("f");
            String outputDir = cmd.getOptionValue("d");

            if (outputFile != null) {
                taskOptions.setResOutPath(outputFile);
            }

            if (outputDir != null) {
                taskOptions.setResOutPath(outputDir);
            }
            if (outputFile == null && outputDir == null) {
                taskOptions.setOverrideSource(true);
            }

            String styleOut = cmd.getOptionValue("so");
            if (styleOut != null) {
                taskOptions.setStyleOutPath(styleOut);
            }

            taskOptions.setDoCheck(cmd.hasOption("check"));

            taskOptions.setLanguage(cmd.getOptionValue("lang", "java"));

            // 参数验证
            if (validateParameters(taskOptions)) {
                return taskOptions;
            }

        } catch (ParseException e) {
            // 打印帮助信息并退出
            logger.error("Error parsing command line arguments: " + e.getMessage(), e);
            printHelp(options);
        }
        return null;
    }

    private static boolean validateParameters(TaskOptions taskOptions) {
        String src = taskOptions.getSrc();
        String target = taskOptions.getTarget();
        String styleOutPath = taskOptions.getStyleOutPath();

        if (target == null || (src == null &&  styleOutPath == null)) {
            logger.error("Wrong usage.\n Correct argument usage:\n -src <arg> -target <arg> \n or \n -target <arg> -so <arg>");
            return false;
        }

        return true;
    }

    private static void printHelp(Options options) {
        // 创建帮助生成器
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("\n-src <arg> -target <arg> [-f/-d <arg>] [-so <arg>] [-c/--check]\n-target <arg> -so <arg> [-c/--check]\n\n", options);
    }

    private static Options getOptions() {
        Options options = new Options();

        Option srcOption = new Option("src", true, "Source file or directory path");
        Option targetOption = new Option("target", true, "File or directory path of target codes, or path of target style file");
        Option outputFileOption = new Option("f", true, "Output file path of transformed codes.");
        Option outputDirOption = new Option("d", true, "Output directory path of transformed codes, file name is the same as the original file name");
        Option styleOutOption = new Option("so", "style-out", true, "Output path for the style file (optional)");
        Option doCheckOption = new Option("c", "check", false, "Execute style check only");
        Option langOption = new Option("lang", true, "Programming language (default: java)");

        targetOption.setRequired(true);

        options.addOption(srcOption);
        options.addOption(targetOption);
        options.addOption(outputFileOption);
        options.addOption(outputDirOption);
        options.addOption(styleOutOption);
        options.addOption(doCheckOption);
        options.addOption(langOption);

        return options;
    }
}
