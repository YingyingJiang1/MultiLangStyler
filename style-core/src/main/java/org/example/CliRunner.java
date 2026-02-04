package org.example;

import org.example.stylekit.Coordinator;
import org.example.stylekit.TaskOptions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("cli")
public class CliRunner implements CommandLineRunner {

    private final Coordinator coordinator = new Coordinator();

    @Override
    public void run(String... args) {
        TaskOptions taskOptions = CLIArgumentParser.parseArgs(args);

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
        }
    }
}

