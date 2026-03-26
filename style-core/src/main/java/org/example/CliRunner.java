package org.example;

import org.example.stylekit.Coordinator;
import org.example.stylekit.TaskOptions;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Profile("cli")
public class CliRunner implements ApplicationRunner {

    private final Coordinator coordinator = new Coordinator();

    private static final Pattern ARG_TOKENIZER =
            Pattern.compile("\"([^\"]*)\"|'([^']*)'|(\\S+)");

    @Override
    public void run(ApplicationArguments args) throws IOException {
        TaskOptions initial = CLIArgumentParser.parseArgs(args.getNonOptionArgs().toArray(new String[0]));
        if (initial != null) {
            handleOnce(initial);
        } else if (!args.getNonOptionArgs().isEmpty()) {
            System.out.println("Invalid arguments.");
            CLIArgumentParser.printHelp();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("stylekit> ");
            String line = reader.readLine();
            if (line == null) {
                return;
            }

            String trimmed = line.trim();
            if (trimmed.isEmpty()) {
                continue;
            }
            if ("exit".equalsIgnoreCase(trimmed) || "quit".equalsIgnoreCase(trimmed)) {
                return;
            }

            String[] argv = tokenizeArgs(trimmed);
            TaskOptions taskOptions = CLIArgumentParser.parseArgs(argv);
            if (taskOptions == null) {
                System.out.println("Invalid arguments.");
                CLIArgumentParser.printHelp();
                continue;
            }

            handleOnce(taskOptions);
        }
    }

    protected void handleOnce(TaskOptions taskOptions) {
        switch (taskOptions.getOpId()) {
            case TaskOptions.APPLY:
                coordinator.transferStyle(taskOptions);
                break;
            case TaskOptions.EXTRACT:
                coordinator.extractStyle(taskOptions);
                break;
            case TaskOptions.ANALYZE:
                coordinator.analyzeInconsistency(taskOptions);
                break;
            default:
                System.out.println("Invalid arguments.");
                CLIArgumentParser.printHelp();
        }
    }

    private static String[] tokenizeArgs(String line) {
        List<String> args = new ArrayList<>();
        Matcher m = ARG_TOKENIZER.matcher(line);
        while (m.find()) {
            String token = m.group(1);
            if (token == null) token = m.group(2);
            if (token == null) token = m.group(3);
            if (token != null) {
                args.add(token);
            }
        }
        return args.toArray(new String[0]);
    }
}
