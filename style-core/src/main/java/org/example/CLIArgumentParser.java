package org.example;

import org.apache.commons.cli.*;
import org.example.stylekit.TaskOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.InvalidParameterException;

public class CLIArgumentParser {
    public static Logger logger = LoggerFactory.getLogger(CLIArgumentParser.class);
    
    public static TaskOptions parseArgs(String[] args) {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        Options options = getOptions();

        try {
            cmd = parser.parse(options, args);
            TaskOptions taskOptions = new TaskOptions();

            String src = cmd.getOptionValue("src");
            String target = cmd.getOptionValue("target");
            taskOptions.setSrc(src);
            taskOptions.setTarget(target);

            if (cmd.hasOption("f")) {
                taskOptions.setResOutPath(cmd.getOptionValue("f"));
                taskOptions.setOut2file( true);
            } else if (cmd.hasOption("d")) {
                taskOptions.setResOutPath(cmd.getOptionValue("d"));
                taskOptions.setOut2file(false);
            }
            String styleOut = cmd.getOptionValue("so");
            taskOptions.setStyleOutPath(styleOut);
            taskOptions.setOverrideSource(cmd.hasOption("override"));


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

        } catch (ParseException|InvalidParameterException e) {
            // 打印帮助信息并退出
            logger.error("Error parsing command line arguments: " + e.getMessage(), e);
            printHelp(options);
        }
        return null;
    }

    private static boolean validateParameters(TaskOptions taskOptions) throws InvalidParameterException {

        if (taskOptions.getLanguage() == null) {
            throw new InvalidParameterException("arg -lang should be set.");
        }
        if (taskOptions.getTarget() == null) {
            throw new InvalidParameterException("arg -target should be set.");
        }

        return true;
    }

    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        String header = "\nUsage examples:\n" +
                "  Transfer style:    -src <path1;path2;...> -target <arg> [-f <output_file> | -d <output_directory>] -so <style_output_file> -lang <language>\n" +
                "  Extract style:     -e -target <path1;path2;...> -so <style_output_file> -lang <language>\n" +
                "  Analyze style:     -a -src <path1;path2;...> -target <arg> [-f <output_file> | -d <output_directory>] -lang <language>\n\n";

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

        Option srcOption = new Option("src", true, "Source file or directory path, multiple paths are seperated by ';'.");
        Option targetOption = new Option("target", true,
                "Source file or directory path of reference code, or path of a target style file. Multiple paths are seperated by ';'.");
        Option resOutFileOption = new Option("f","file", true,
                "Output file path for style-transferred code and analysis results.");
        Option resOutDirOption = new Option("d", "directory", true,
                "Output directory for style-transferred code and analysis results.");
        Option styleOutOption = new Option("so", "style-output", true,
                "Output file for style profile extracted from reference code.");
        Option langOption = new Option("lang", true, "Programming language: java, python, cpp.");
        Option doExtractOption = new Option("e", "extract", false, "Execute style extraction only");
        Option doCheckOption = new Option("a", "analyze", false, "Execute style inconsistencies analysis only");
        Option overrideOption = new Option("override", false, "Override source code with style-transferred code.");

        targetOption.setRequired(true);

        options.addOption(srcOption);
        options.addOption(targetOption);
        options.addOption(styleOutOption);
        options.addOption(resOutFileOption);
        options.addOption(resOutDirOption);
        options.addOption(langOption);
        options.addOption(doExtractOption);
        options.addOption(doCheckOption);
        options.addOption(overrideOption);

        return options;
    }
}
