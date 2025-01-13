package org.example;

import org.apache.commons.cli.*;

import java.io.File;

public class CLIArgumentParser {
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

            // 参数验证
            validateParameters(config);

            return config;

        } catch (ParseException e) {
            // 打印帮助信息并退出
            System.err.println("Error parsing command line arguments: " + e.getMessage());
            printHelp(options);
            System.exit(1);
        }
        return null;
    }

    private static void validateParameters(Configuration config) {
        String src = config.getSrc();
        String target = config.getTarget();
        String styleOutPath = config.getStyleOutPath();

        if (target == null || (src == null &&  styleOutPath == null)) {
            System.err.println("Wrong usage.\n Correct argument usage:\n -src <path> -target <path> \n or \n -target <path> -so <path>");
            System.exit(1);
        }

        // 检查 -src 和 -target 是否符合规则
        File srcFile = new File(src);
        String resOutFile = config.getResOutFile();
        String resOutDir = config.getResOutDir();

        if (resOutFile != null && resOutDir != null) {
            System.err.println("Error: -f and -d cannot be specified at the same time.");
            System.exit(1);
        }

        if (resOutFile != null && !new File((resOutFile)).isFile()) {
            System.err.println("Error: -f must be a file.");
            System.exit(1);
        } else if (resOutDir != null && !new File(resOutDir).isDirectory()) {
            System.err.println("Error: -d must be a directory.");
            System.exit(1);
        }

        if (srcFile.isFile() && resOutDir != null) {
            System.err.println("Error: If -src is a file, use -f to specify the output file.");
            System.exit(1);
        } else if (srcFile.isDirectory() && resOutFile != null) {
            System.err.println("Error: If -src is a directory, use -d to specify the output directory.");
            System.exit(1);
        }

    }

    private static void printHelp(Options options) {
        // 创建帮助生成器
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Transformer arguments:", options);
    }

    private static Options getOptions() {
        Options options = new Options();

        Option srcOption = new Option("src", true, "Source file or directory path");
        Option targetOption = new Option("target", true, "File or directory path of target codes, or path of target style file");
        Option outputFileOption = new Option("f", true, "Output file path of transformed codes.");
        Option outputDirOption = new Option("d", true, "Output directory path of transformed codes, file name is the same as the original file name");
        Option styleOutOption = new Option("so", "style-out", true, "Output path for the style file (optional)");

        srcOption.setRequired(true);
        targetOption.setRequired(true);

        options.addOption(srcOption);
        options.addOption(targetOption);
        options.addOption(outputFileOption);
        options.addOption(outputDirOption);
        options.addOption(styleOutOption);

        return options;
    }
}
