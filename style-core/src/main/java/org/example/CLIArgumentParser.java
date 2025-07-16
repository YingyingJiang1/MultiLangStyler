package org.example;

import org.apache.commons.cli.*;
import org.checkerframework.checker.nullness.Opt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;

public class CLIArgumentParser {
    public static Logger logger = LoggerFactory.getLogger(CLIArgumentParser.class);
    
    public static Configuration parseArgs(String[] args) {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        Options options = getOptions();

        try {
            cmd = parser.parse(options, args);
            Configuration config = new Configuration();

            // 获取并设置参数
            String src = cmd.getOptionValue("src");
            String target = cmd.getOptionValue("target");
            config.setSrc(src);
            config.setTarget(target);

            String outputFile = cmd.getOptionValue("f");
            String outputDir = cmd.getOptionValue("d");
            config.setResOutFile(outputFile);
            config.setResOutDir(outputDir);
            if (outputFile == null && outputDir == null) {
               config.setOverrideSource(true);
            }

            String styleOut = cmd.getOptionValue("so");
            if (styleOut != null) {
                config.setStyleOutPath(styleOut);
            }

            config.styleCheckOnly = cmd.hasOption("check");

            // 参数验证
            if (validateParameters(config)) {
                return config;
            }

        } catch (ParseException e) {
            // 打印帮助信息并退出
            logger.error("Error parsing command line arguments: " + e.getMessage(), e);
            printHelp(options);
        }
        return null;
    }

    private static boolean validateParameters(Configuration config) {
        String src = config.getSrc();
        String target = config.getTarget();
        String styleOutPath = config.getStyleOutPath();

        if (target == null || (src == null &&  styleOutPath == null)) {
            logger.error("Wrong usage.\n Correct argument usage:\n -src <arg> -target <arg> \n or \n -target <arg> -so <arg>");
            return false;
        }

        // 检查 -src 和 -target 是否符合规则
        if (src != null) {
            File srcFile = new File(src);
            String resOutFile = config.getResOutFile();
            String resOutDir = config.getResOutDir();

            if (srcFile.isFile() && resOutDir != null) {
                logger.error("Error: If -src is a file, use -f to specify the output file.");
                return false;
            } else if (srcFile.isDirectory() && resOutFile != null) {
                logger.error("Error: If -src is a directory, use -d to specify the output directory.");
                return false;
            }
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

        targetOption.setRequired(true);

        options.addOption(srcOption);
        options.addOption(targetOption);
        options.addOption(outputFileOption);
        options.addOption(outputDirOption);
        options.addOption(styleOutOption);
        options.addOption(doCheckOption);

        return options;
    }
}
