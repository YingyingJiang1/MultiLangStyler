package org.example;

import org.apache.commons.cli.*;
import org.example.stylekit.TaskOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

            String styleOut = cmd.getOptionValue("o");
            if (styleOut != null) {
                taskOptions.setOutPath(styleOut);
            }

            if (cmd.hasOption("extract")) {
                taskOptions.setOpId(TaskOptions.EXTRACT);
            } else if (cmd.hasOption("analyze")) {
                taskOptions.setOpId(TaskOptions.ANALYZE);
            } else {
                taskOptions.setOpId(TaskOptions.APPLY);
            }

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
        String styleOutPath = taskOptions.getOutPath();

        if (target == null || (src == null &&  styleOutPath == null)) {
            logger.error("Wrong usage.\n Correct argument usage:\n -src <arg> -target <arg> \n or \n -target <arg> -o <arg>");
            return false;
        }

        return true;
    }

    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        String header = "\nUsage examples:\n" +
                "  Transfer style:    " +
                "   Single file or directory: -src <src_path> -target <arg> [-f <output_file> | -d <output_dir>] -lang <language>\n" +
                "   Batch file or directories: -src <path1;path2;...> -target <arg> -lang <language>" +
                "  Extract style:     -e -target <path1;path2;...> -o <output_file> -lang <language>\n" +
                "  Analyze style:     -c -src <path1;path2;...> -target <arg> -o <output_file> -lang <language>\n\n";

        String footer = "\nOptions:";

        formatter.printHelp(
                "java -jar <path of jar package>", // 命令行程序名
                header,
                options,
                footer,
                true // 自动对齐
        );
    }

    private static Options getOptions() {
        Options options = new Options();

        Option srcOption = new Option("src", true, "Source file or directory path seperated by semicolon.");
        Option targetOption = new Option("target", true,
                "File or directory path of target codes, or path of a target style file");
        Option outputFileOption = new Option("f", true,
                "1) One or more target code paths separated by ';'\n" +
                        "2) A single style file (XML) for applying style");
        Option outputDirOption = new Option("d", true,
                "Output directory path of transformed codes, file name is the same as the original file name");
        Option styleOutOption = new Option("o", "output", true,
                "Output path for result, such as extracted style file or analysis report.");
        Option langOption = new Option("lang", true, "Programming language (default: java): java, python, cpp.");
        Option doExtractOption = new Option("e", "extract", false, "Execute style extraction only");
        Option doCheckOption = new Option("a", "analyze", false, "Execute style inconsistencies analysis only");

        targetOption.setRequired(true);

        options.addOption(srcOption);
        options.addOption(targetOption);
        options.addOption(outputFileOption);
        options.addOption(outputDirOption);
        options.addOption(styleOutOption);
        options.addOption(langOption);
        options.addOption(doExtractOption);
        options.addOption(doCheckOption);

        return options;
    }
}
